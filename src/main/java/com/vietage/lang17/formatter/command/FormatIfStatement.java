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
        out.print("if (", indent);

        if (ifStatement.getFalseStatements() != null) {
            commands.push(new InsertLineFeed(indent));
            commands.push(new InsertText(indent, "}"));
            commands.push(new FormatStatements(indent + 4, ifStatement.getFalseStatements()));
            commands.push(new InsertText(indent, "{"));
            commands.push(new InsertLineFeed(indent));
            commands.push(new InsertText(indent, "} else"));
        } else {
            commands.push(new InsertLineFeed(indent));
            commands.push(new InsertText(indent, "}"));
        }

        commands.push(new FormatStatements(indent + 4, ifStatement.getTrueStatements()));
        commands.push(new InsertLineFeed(indent));
        commands.push(new InsertText(indent, "{"));
        commands.push(new InsertLineFeed(indent));
        commands.push(new InsertText(indent, ")"));
        commands.push(new FormatExpression(indent, ifStatement.getCondition()));
    }
}
