package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;

import java.util.Queue;

public class FormatContinueStatement extends FormatCommand {

    public FormatContinueStatement(int indent) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.println("continue", indent);
    }
}
