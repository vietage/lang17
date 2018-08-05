package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.expression.MultiplicationExpression;

import java.util.function.Consumer;

public class MultiplicationOperation implements State {

    private final MultiplicationExpression multiplicationExpression;
    private final Context context;
    private final Consumer<Result> resultConsumer;

    private boolean init = true;

    private Result leftOperand;
    private Result rightOperand;

    public MultiplicationOperation(MultiplicationExpression multiplicationExpression,
                                   Context context, Consumer<Result> resultConsumer) {
        this.multiplicationExpression = multiplicationExpression;
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

            runtime.enterState(factory.get(multiplicationExpression.getLeftExpression(), context, leftConsumer));
            runtime.enterState(factory.get(multiplicationExpression.getRightExpression(), context, rightConsumer));
        } else {
            runtime.exitState();

            switch (multiplicationExpression.getOperator()) {
                case MULTIPLICATION:
                    resultConsumer.accept(runtime.getNumberOperations().multiply(leftOperand, rightOperand));
                    break;
                case DIVISION:
                    resultConsumer.accept(runtime.getNumberOperations().divide(leftOperand, rightOperand));
                    break;
                case MODULO:
                    resultConsumer.accept(runtime.getNumberOperations().modulo(leftOperand, rightOperand));
                    break;
                default:
                    throw new RuntimeException("Unsupported multiplication operator: " +
                            multiplicationExpression.getOperator());
            }
        }
    }


}
