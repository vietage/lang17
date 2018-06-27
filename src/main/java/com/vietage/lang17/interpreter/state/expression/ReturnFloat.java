package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.FloatResult;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.expression.FloatConstant;

import java.util.function.Consumer;

public class ReturnFloat implements State {

    private final FloatConstant floatConstant;
    private final Consumer<Result> resultConsumer;

    public ReturnFloat(FloatConstant floatConstant, Consumer<Result> resultConsumer) {
        this.floatConstant = floatConstant;
        this.resultConsumer = resultConsumer;
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        resultConsumer.accept(new FloatResult(floatConstant.getValue()));
    }
}
