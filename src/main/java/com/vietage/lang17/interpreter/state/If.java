package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.interpreter.state.expression.ExpressionStateFactory;
import com.vietage.lang17.parser.ast.ASTElement;
import com.vietage.lang17.parser.ast.statement.IfStatement;

import java.util.function.Consumer;

public class If implements ASTElementState {

    private final IfStatement ifStatement;
    private final Context parentContext;

    private boolean init = true;
    private boolean condition = false;

    public If(IfStatement ifStatement, Context parentContext) {
        this.ifStatement = ifStatement;
        this.parentContext = parentContext;
    }

    @Override
    public void run(Runtime runtime) {
        if (init) {
            init = false;

            // compute condition
            ExpressionStateFactory factory = new ExpressionStateFactory();
            Consumer<Result> resultConsumer = result -> this.setCondition(result.getBoolean());
            runtime.enterState(factory.get(ifStatement.getCondition(), parentContext, resultConsumer));
        } else {
            runtime.exitState();

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
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    @Override
    public ASTElement getAstElement() {
        return ifStatement;
    }
}
