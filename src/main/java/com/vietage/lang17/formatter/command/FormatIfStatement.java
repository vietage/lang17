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
    public void format(IndentPrintStream out, Deque<FormatCommand> commandQueue) {
        out.print("if (", indent);

        commandQueue.add(new FormatExpression(indent, ifStatement.getCondition()));
        commandQueue.add(new InsertText(indent, ")"));
        commandQueue.add(new InsertLineFeed(indent));
        commandQueue.add(new InsertText(indent, "{"));
        commandQueue.add(new InsertLineFeed(indent));
        commandQueue.add(new FormatStatements(indent + 4, ifStatement.getTrueStatements()));
        commandQueue.add(new InsertText(indent, "}"));
        commandQueue.add(new InsertLineFeed(indent));

        if (ifStatement.getFalseStatements() != null) {
            commandQueue.add(new InsertText(indent, "else"));
            commandQueue.add(new InsertLineFeed(indent));
            commandQueue.add(new InsertText(indent, "{"));
            commandQueue.add(new FormatStatements(indent + 4, ifStatement.getFalseStatements()));
            commandQueue.add(new InsertText(indent, "}"));
            commandQueue.add(new InsertLineFeed(indent));
        }
    }
}
