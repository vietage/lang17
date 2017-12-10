package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;

import java.util.Deque;

public class InsertEmptyLine extends FormatCommand {

    public InsertEmptyLine(int indent) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {
        out.println("", indent);
        out.println("", indent);
    }
}
