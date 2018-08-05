package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.expression.EqualityExpression;

import java.util.function.Consumer;

public class EqualityOperation implements State {

    private final EqualityExpression equalityExpression;
    private final Context context;
    private final Consumer<Result> resultConsumer;

    private boolean init = true;

    private Result leftOperand;
    private Result rightOperand;

    public EqualityOperation(EqualityExpression equalityExpression, Context context, Consumer<Result> resultConsumer) {
        this.equalityExpression = equalityExpression;
        this.context = context;
        this.resultConsumer = resultConsumer;
    }

    @Override
    public void run(Runtime runtime) {
        if (init) {
            init = false;

            ExpressionStateFactory factory = new ExpressionStateFactory();

            Consumer<Result> leftConsumer = result -> leftOperand = result;
            Consumer<Result> rightConsumer = result -> rightOperand = result;

            runtime.enterState(factory.get(equalityExpression.getLeftExpression(), context, leftConsumer));
            runtime.enterState(factory.get(equalityExpression.getRightExpression(), context, rightConsumer));
        } else {
            runtime.exitState();

            switch (equalityExpression.getOperator()) {
                case EQUAL:
                    resultConsumer.accept(runtime.getEqualityChecker().equal(leftOperand, rightOperand));
                    break;
                case NOT_EQUAL:
                    resultConsumer.accept(runtime.getEqualityChecker().notEqual(leftOperand, rightOperand));
                    break;
                default:
                    throw new RuntimeException("Unsupported equality operator: " +
                            equalityExpression.getOperator());
            }
        }
    }
}
