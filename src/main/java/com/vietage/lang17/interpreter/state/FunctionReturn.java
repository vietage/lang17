package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;

import java.util.function.Consumer;

public class FunctionReturn implements State {

    private final Consumer<Result> resultConsumer;

    private Result result;

    public FunctionReturn(Consumer<Result> resultConsumer) {
        this.resultConsumer = resultConsumer;
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        if (result != null && resultConsumer != null) {
            resultConsumer.accept(result);
        }
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
