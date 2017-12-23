package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;

import java.util.Deque;

public class InsertLineFeed extends FormatCommand {

    public InsertLineFeed(int indent) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commandQueue) {
        out.println("", indent);
    }
}
