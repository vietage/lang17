package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Context;
import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.interpreter.result.Result;
import com.vietage.lang17.parser.ast.statement.WhileLoop;

import java.util.function.Consumer;

public class While implements State {

    private final WhileLoop whileLoop;
    private final Context parentContext;

    private boolean init = true;
    private boolean condition = false;

    public While(WhileLoop whileLoop, Context parentContext) {
        this.whileLoop = whileLoop;
        this.parentContext = parentContext;
    }

    @Override
    public void run(Runtime runtime) {
        if (init) {
            init = false;

            // compute condition
            ExpressionStateFactory factory = new ExpressionStateFactory();
            Consumer<Result> resultConsumer = result -> this.setCondition(result.getBoolean());
            runtime.enterState(factory.get(whileLoop.getCondition(), parentContext, resultConsumer));
        } else if (condition) {
            init = true;

            // invoke block if condition == true
            Context blockContext = new Context(parentContext);
            runtime.enterState(new Block(blockContext, whileLoop.getStatements().iterator()));
        } else {
            runtime.exitState();
        }
    }

    public void setCondition(Boolean condition) {
        this.condition = condition;
    }
}
