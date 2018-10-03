package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.parser.ast.ASTElement;
import com.vietage.lang17.parser.ast.statement.BreakStatement;

public class Break implements ASTElementState {

    private final BreakStatement breakStatement;

    public Break(BreakStatement breakStatement) {
        this.breakStatement = breakStatement;
    }

    @Override
    public void run(Runtime runtime) {
        while (runtime.hasState()) {
            State state = runtime.getState();

            if (state instanceof While) {
                runtime.exitState();
                return;
            } else {
                runtime.exitState();
            }
        }
    }

    @Override
    public ASTElement getAstElement() {
        return breakStatement;
    }
}
