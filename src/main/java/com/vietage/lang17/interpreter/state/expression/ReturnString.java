package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.result.StringResult;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.expression.StringConstant;

import java.util.function.Consumer;

public class ReturnString implements State {

    private final StringConstant stringConstant;
    private final Consumer<Result> resultConsumer;

    public ReturnString(StringConstant stringConstant, Consumer<Result> resultConsumer) {
        this.stringConstant = stringConstant;
        this.resultConsumer = resultConsumer;
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        resultConsumer.accept(new StringResult(stringConstant.getValue()));
    }
}
