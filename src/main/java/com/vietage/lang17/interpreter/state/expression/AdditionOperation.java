package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.expression.AdditionExpression;

import java.util.function.Consumer;

public class AdditionOperation implements State {

    private final AdditionExpression additionExpression;
    private final Context context;
    private final Consumer<Result> resultConsumer;

    private boolean init = true;
    private Result leftOperand;
    private Result rightOperand;

    public AdditionOperation(AdditionExpression additionExpression, Context context, Consumer<Result> resultConsumer) {
        this.additionExpression = additionExpression;
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

            runtime.enterState(factory.get(additionExpression.getLeftExpression(), context, leftConsumer));
            runtime.enterState(factory.get(additionExpression.getRightExpression(), context, rightConsumer));
        } else {
            runtime.exitState();

            switch (additionExpression.getOperator()) {
                case ADDITION:
                    resultConsumer.accept(runtime.getArithmetic().add(leftOperand, rightOperand));
                    break;
                case SUBSTRACTION:
                    resultConsumer.accept(runtime.getArithmetic().subtract(leftOperand, rightOperand));
                    break;
            }
        }
    }
}
