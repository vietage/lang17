package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.expression.RelationalExpression;

import java.util.function.Consumer;

public class RelationalOperation implements State {

    private final RelationalExpression relationalExpression;
    private final Context context;
    private final Consumer<Result> resultConsumer;

    private boolean init = true;

    private Result leftOperand;
    private Result rightOperand;

    public RelationalOperation(RelationalExpression relationalExpression, Context context,
                               Consumer<Result> resultConsumer) {
        this.relationalExpression = relationalExpression;
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

            runtime.enterState(factory.get(relationalExpression.getLeftExpression(), context, leftConsumer));
            runtime.enterState(factory.get(relationalExpression.getRightExpression(), context, rightConsumer));
        } else {
            runtime.exitState();

            switch (relationalExpression.getOperator()) {
                case LESS_OR_EQUAL:
                    resultConsumer.accept(runtime.getNumberOperations().lessOrEqual(leftOperand, rightOperand));
                    break;
                case GREATER_OR_EQUAL:
                    resultConsumer.accept(runtime.getNumberOperations().greaterOrEqual(leftOperand, rightOperand));
                    break;
                case LESS:
                    resultConsumer.accept(runtime.getNumberOperations().less(leftOperand, rightOperand));
                    break;
                case GREATER:
                    resultConsumer.accept(runtime.getNumberOperations().greater(leftOperand, rightOperand));
                    break;
                default:
                    throw new RuntimeException("Unsupported relational operator: " +
                            relationalExpression.getOperator());

            }
        }
    }
}
