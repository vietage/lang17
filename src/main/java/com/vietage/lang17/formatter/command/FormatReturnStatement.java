package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.statement.ReturnStatement;

import java.util.Deque;

public class FormatReturnStatement extends FormatCommand {

    private final ReturnStatement returnStatement;

    protected FormatReturnStatement(int indent, ReturnStatement returnStatement) {
        super(indent);
        this.returnStatement = returnStatement;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {
        out.print("return ", indent);

        commands.push(new InsertLineFeed(indent));
        commands.push(new FormatExpression(indent, returnStatement.getExpression()));
    }
}
