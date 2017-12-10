package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;

import java.util.Deque;

public class InsertCommaSeparator extends FormatCommand {

    public InsertCommaSeparator(int indent) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {
        out.print(", ", indent);
    }
}
