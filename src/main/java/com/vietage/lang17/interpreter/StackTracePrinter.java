package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.interpreter.state.expression.Invoke;
import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.PositionalElement;

import java.io.OutputStream;
import java.io.PrintWriter;

public class StackTracePrinter {

    private final PrintWriter writer;

    public StackTracePrinter(OutputStream os) {
        this.writer = new PrintWriter(os);
    }

    public void print(Runtime runtime) {
        State state = null;
        Position position = null;

        while ((state = runtime.getState()) != null) {
            runtime.exitState();

            if (state instanceof Invoke && position != null) {
                Invoke invoke = (Invoke) state;
                writer.println(formatTraceLine(invoke.getFunctionCall().getName(), position));
            }

            position = getPosition(state, position);
        }
        writer.flush();
    }

    private Position getPosition(State state, Position position) {
        if (state instanceof PositionalElement) {
            position = ((PositionalElement) state).getPosition();
        }
        return position;
    }

    private String formatTraceLine(String functionName, Position position) {
        if (position != null) {
            return String.format("%s:%d", functionName, position.getLine() + 1);
        } else {
            return functionName;
        }
    }
}
