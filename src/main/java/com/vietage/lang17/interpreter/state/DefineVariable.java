package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.expression.ExpressionStateFactory;
import com.vietage.lang17.parser.ast.ASTElement;
import com.vietage.lang17.parser.ast.statement.VariableDefinition;

import java.util.function.Consumer;

public class DefineVariable implements ASTElementState {

    private final VariableDefinition variableDefinition;
    private final Context context;

    public DefineVariable(VariableDefinition variableDefinition, Context context) {
        this.variableDefinition = variableDefinition;
        this.context = context;
    }

    @Override
    public void run(Runtime runtime) {
        runtime.exitState();

        ExpressionStateFactory factory = new ExpressionStateFactory();
        Consumer<Result> resultConsumer = result -> context.set(variableDefinition.getName(), result);
        runtime.enterState(factory.get(variableDefinition.getExpression(), context, resultConsumer));
    }

    @Override
    public ASTElement getAstElement() {
        return variableDefinition;
    }
}
