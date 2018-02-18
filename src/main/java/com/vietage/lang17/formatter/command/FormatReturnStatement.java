package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.statement.ReturnStatement;

import java.util.Queue;

public class FormatReturnStatement extends FormatCommand {

    private final ReturnStatement returnStatement;

    protected FormatReturnStatement(int indent, ReturnStatement returnStatement) {
        super(indent);
        this.returnStatement = returnStatement;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.print("return ", indent);

        commandQueue.add(new FormatExpression(indent, returnStatement.getExpression()));
    }
}
