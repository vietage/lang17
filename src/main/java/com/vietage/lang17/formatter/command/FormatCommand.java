package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;

import java.util.Deque;

public abstract class FormatCommand {

    protected final int indent;

    protected FormatCommand(int indent) {
        this.indent = indent;
    }

    public abstract void format(IndentPrintStream out, Deque<FormatCommand> commands);
}
