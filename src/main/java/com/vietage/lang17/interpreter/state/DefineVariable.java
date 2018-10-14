package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.expression.ExpressionStateFactory;
import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;
import com.vietage.lang17.parser.ast.statement.VariableDefinition;

import java.util.function.Consumer;

public class DefineVariable extends TwoPhaseState implements PositionalElement {

    private final VariableDefinition variableDefinition;
    private final Context context;

    public DefineVariable(VariableDefinition variableDefinition, Context context) {
        this.variableDefinition = variableDefinition;
        this.context = context;
    }

    @Override
    protected void onInitialize(Runtime runtime) {
        ExpressionStateFactory factory = new ExpressionStateFactory();
        Consumer<Result> resultConsumer = result -> context.set(variableDefinition.getName(), result);
        runtime.enterState(factory.get(variableDefinition.getExpression(), context, resultConsumer));
    }

    @Override
    protected void onReturn(Runtime runtime) {
        // do nothing
    }

    @Override
    public Position getPosition() {
        return variableDefinition.getPosition();
    }
}
