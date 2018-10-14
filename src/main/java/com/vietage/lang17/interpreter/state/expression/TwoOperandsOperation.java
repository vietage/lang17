package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.PositionalElement;
import com.vietage.lang17.parser.ast.expression.TwoOperandsExpression;

import java.util.function.Consumer;

public abstract class TwoOperandsOperation implements State, PositionalElement {

    private final Context context;
    private final Consumer<Result> resultConsumer;

    private boolean init = true;

    private Result leftOperand;
    private Result rightOperand;

    protected abstract Result getResult(Runtime runtime, Result leftOperand, Result rightOperand);

    protected abstract TwoOperandsExpression getTwoOperandsExpression();

    protected TwoOperandsOperation(Context context, Consumer<Result> resultConsumer) {
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

            runtime.enterState(factory.get(getTwoOperandsExpression().getLeftExpression(), context, leftConsumer));
            runtime.enterState(factory.get(getTwoOperandsExpression().getRightExpression(), context, rightConsumer));
        } else {
            runtime.exitState();

            resultConsumer.accept(getResult(runtime, leftOperand, rightOperand));
        }
    }
}
