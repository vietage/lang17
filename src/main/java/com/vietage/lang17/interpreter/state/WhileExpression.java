package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.expression.ExpressionStateFactory;
import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;
import com.vietage.lang17.parser.ast.statement.WhileLoop;

import java.util.function.Consumer;

public class WhileExpression extends TwoPhaseState implements PositionalElement {

    private final WhileLoop whileLoop;
    private final Context parentContext;

    private boolean condition = false;

    public WhileExpression(WhileLoop whileLoop, Context parentContext) {
        this.whileLoop = whileLoop;
        this.parentContext = parentContext;
    }

    @Override
    void onInitialize(Runtime runtime) {
        // evaluate the condition
        ExpressionStateFactory factory = new ExpressionStateFactory();
        Consumer<Result> resultConsumer = result -> this.setCondition(result.getBoolean());
        runtime.enterState(factory.get(whileLoop.getCondition(), parentContext, resultConsumer));
    }

    @Override
    void onReturn(Runtime runtime) {
        // invoke block if condition == true
        if (condition) {
            runtime.enterState(new WhileBody(whileLoop, parentContext));
        }
    }

    @Override
    public Position getPosition() {
        return null;
    }

    public void setCondition(Boolean condition) {
        this.condition = condition;
    }
}
