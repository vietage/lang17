package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.IntegerResult;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.expression.IntegerConstant;

import java.util.function.Consumer;

public class ReturnInteger implements State {

    private final IntegerConstant integerConstant;
    private final Consumer<Result> resultConsumer;

    public ReturnInteger(IntegerConstant integerConstant, Consumer<Result> resultConsumer) {
        this.integerConstant = integerConstant;
        this.resultConsumer = resultConsumer;
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        resultConsumer.accept(new IntegerResult(integerConstant.getValue()));
    }
}
