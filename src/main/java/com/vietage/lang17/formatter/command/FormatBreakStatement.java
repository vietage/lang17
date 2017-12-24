package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;

import java.util.Queue;

public class FormatBreakStatement extends FormatCommand {

    public FormatBreakStatement(int indent) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.println("break", indent);
    }
}
