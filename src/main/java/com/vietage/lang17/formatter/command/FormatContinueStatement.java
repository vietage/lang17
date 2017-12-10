package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.statement.ContinueStatement;

import java.util.Deque;

public class FormatContinueStatement extends FormatCommand {

    private final ContinueStatement continueStatement;

    public FormatContinueStatement(int indent, ContinueStatement continueStatement) {
        super(indent);
        this.continueStatement = continueStatement;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {

    }
}
