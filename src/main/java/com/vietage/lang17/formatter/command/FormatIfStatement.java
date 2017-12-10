package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.statement.IfStatement;

import java.util.Deque;

public class FormatIfStatement extends FormatCommand {

    private final IfStatement ifStatement;

    protected FormatIfStatement(int indent, IfStatement ifStatement) {
        super(indent);
        this.ifStatement = ifStatement;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {

    }
}
