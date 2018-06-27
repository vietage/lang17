package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.BooleanResult;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.parser.ast.expression.BooleanConstant;

import java.util.function.Consumer;

public class ReturnBoolean implements State {

    private final BooleanConstant booleanConstant;
    private final Consumer<Result> resultConsumer;

    public ReturnBoolean(BooleanConstant booleanConstant, Consumer<Result> resultConsumer) {
        this.booleanConstant = booleanConstant;
        this.resultConsumer = resultConsumer;
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        resultConsumer.accept(new BooleanResult(booleanConstant.isValue()));
    }
}
