package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.parser.ast.ASTElement;
import com.vietage.lang17.parser.ast.statement.ContinueStatement;

public class Continue implements ASTElementState {

    private final ContinueStatement continueStatement;

    public Continue(ContinueStatement continueStatement) {
        this.continueStatement = continueStatement;
    }

    @Override
    public void run(Runtime runtime) {
        while (runtime.hasState()) {
            State state = runtime.getState();

            if (state instanceof While) {
                return;
            } else {
                runtime.exitState();
            }
        }
    }

    @Override
    public ASTElement getAstElement() {
        return continueStatement;
    }
}
