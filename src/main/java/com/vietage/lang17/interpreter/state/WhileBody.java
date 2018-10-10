package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.parser.ast.statement.WhileLoop;

public class WhileBody extends TwoPhaseState {

    private final WhileLoop whileLoop;
    private final Context parentContext;

    public WhileBody(WhileLoop whileLoop, Context parentContext) {
        this.whileLoop = whileLoop;
        this.parentContext = parentContext;
    }

    @Override
    void onInitialize(Runtime runtime) {
        // interpret while body statements
        Context blockContext = new Context(parentContext);
        runtime.enterState(new Block(blockContext, whileLoop.getStatements().iterator()));
    }

    @Override
    void onReturn(Runtime runtime) {
        // after finishing interpreting the while body re-evaluate the while condition
        runtime.enterState(new WhileExpression(whileLoop, parentContext));
    }
}
