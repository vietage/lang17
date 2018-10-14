package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.expression.ExpressionStateFactory;
import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;
import com.vietage.lang17.parser.ast.statement.IfStatement;

import java.util.function.Consumer;

public class If extends TwoPhaseState implements PositionalElement {

    private final IfStatement ifStatement;
    private final Context parentContext;

    private boolean condition = false;

    public If(IfStatement ifStatement, Context parentContext) {
        this.ifStatement = ifStatement;
        this.parentContext = parentContext;
    }

    @Override
    protected void onInitialize(Runtime runtime) {
        // compute condition
        ExpressionStateFactory factory = new ExpressionStateFactory();
        Consumer<Result> resultConsumer = result -> this.setCondition(result.getBoolean());
        runtime.enterState(factory.get(ifStatement.getCondition(), parentContext, resultConsumer));
    }

    @Override
    protected void onReturn(Runtime runtime) {
        if (condition) {
            // execute true branch
            Context blockContext = new Context(parentContext);
            runtime.enterState(new Block(blockContext, ifStatement.getTrueStatements().iterator()));
        } else if (!ifStatement.getFalseStatements().isEmpty()) {
            // execute false branch
            Context blockContext = new Context(parentContext);
            runtime.enterState(new Block(blockContext, ifStatement.getFalseStatements().iterator()));
        }
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    @Override
    public Position getPosition() {
        return ifStatement.getPosition();
    }
}
