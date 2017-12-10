package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.statement.BreakStatement;

import java.util.Deque;

public class FormatBreakStatement extends FormatCommand {

    private final BreakStatement breakStatement;

    public FormatBreakStatement(int indent, BreakStatement breakStatement) {
        super(indent);
        this.breakStatement = breakStatement;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {

    }
}
