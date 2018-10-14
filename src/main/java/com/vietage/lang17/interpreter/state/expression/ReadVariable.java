package com.vietage.lang17.interpreter.state.expression;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;
import com.vietage.lang17.parser.ast.expression.VariableRead;

import java.util.function.Consumer;

public class ReadVariable implements State, PositionalElement {

    private final VariableRead variableRead;
    private final Context context;
    private final Consumer<Result> resultConsumer;

    public ReadVariable(VariableRead variableRead, Context context, Consumer<Result> resultConsumer) {
        this.variableRead = variableRead;
        this.context = context;
        this.resultConsumer = resultConsumer;
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        resultConsumer.accept(context.get(variableRead.getName()));
    }

    @Override
    public Position getPosition() {
        return variableRead.getPosition();
    }
}
