package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;

import java.util.Deque;

public class FormatBreakStatement extends FormatCommand {

    public FormatBreakStatement(int indent) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commandQueue) {
        out.println("break", indent);
    }
}
