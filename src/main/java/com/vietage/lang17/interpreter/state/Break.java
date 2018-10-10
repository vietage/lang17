package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Runtime;
import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;
import com.vietage.lang17.parser.ast.statement.BreakStatement;

public class Break implements State, PositionalElement {

    private final BreakStatement breakStatement;

    public Break(BreakStatement breakStatement) {
        this.breakStatement = breakStatement;
    }

    @Override
    public void run(Runtime runtime) {
        while (runtime.hasState()) {
            State state = runtime.getState();

            if (state instanceof WhileBody) {
                runtime.exitState();
                return;
            } else {
                runtime.exitState();
            }
        }
    }

    @Override
    public Position getPosition() {
        return breakStatement.getPosition();
    }
}
