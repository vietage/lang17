package com.vietage.lang17.interpreter;

import com.vietage.lang17.interpreter.state.State;
import com.vietage.lang17.interpreter.state.expression.Invoke;

import java.io.OutputStream;
import java.io.PrintWriter;

public class StackTracePrinter {

    private final PrintWriter writer;

    public StackTracePrinter(OutputStream os) {
        this.writer = new PrintWriter(os);
    }

    public void print(Runtime runtime) {
        State state = null;

        while ((state = runtime.getState()) != null) {
            runtime.exitState();

            if (state instanceof Invoke) {
                Invoke invoke = (Invoke) state;
                writer.println(invoke.getFunctionCall().getName());
            }
        }
        writer.flush();
    }
}
