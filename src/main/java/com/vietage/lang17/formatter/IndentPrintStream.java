package com.vietage.lang17.formatter;

import java.io.PrintStream;

public class IndentPrintStream {

    private final PrintStream out;
    private boolean newLine = true;

    public IndentPrintStream(PrintStream out) {
        this.out = out;
    }

    public void println(String text, int indent) {
        if (newLine) {
            printIndent(indent);
            newLine = false;
        }
        out.println(text);
        newLine = true;
    }

    public void print(String text, int indent) {
        if (newLine) {
            printIndent(indent);
            newLine = false;
        }
        out.print(text);
    }

    private void printIndent(int indent) {
        for (int i = 0; i < indent; i++) {
            out.print(' ');
        }
    }
}
