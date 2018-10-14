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
        State state;
        Position position = null;

        while ((state = runtime.getState()) != null) {
            runtime.exitState();

            if (state instanceof PositionalElement) {
                if (position == null) {
                    position = ((PositionalElement) state).getPosition();
                }
                if (state instanceof Invoke) {
                    Invoke invoke = (Invoke) state;
                    writer.println(formatTraceLine(invoke.getFunctionCall().getName(), position));
                    position = invoke.getPosition();
                }
            }
        }
        writer.flush();
    }

    private String formatTraceLine(String functionName, Position position) {
        if (position != null) {
            return String.format("%s:%d", functionName, position.getLine() + 1);
        } else {
            return functionName;
        }
    }
}
