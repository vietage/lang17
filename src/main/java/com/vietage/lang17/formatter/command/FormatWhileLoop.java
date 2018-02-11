package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.statement.WhileLoop;

import java.util.Queue;

public class FormatWhileLoop extends FormatCommand {

    private final WhileLoop whileLoop;

    public FormatWhileLoop(int indent, WhileLoop whileLoop) {
        super(indent);
        this.whileLoop = whileLoop;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.print("while (", indent);

        commandQueue.add(new FormatExpression(indent, whileLoop.getCondition()));
        commandQueue.add(new InsertText(indent, ")"));
        commandQueue.add(new InsertLineFeed(indent));
        commandQueue.add(new InsertText(indent, "{"));
        commandQueue.add(new InsertLineFeed(indent));
        commandQueue.add(new FormatStatements(indent + 4, whileLoop.getStatements()));
        commandQueue.add(new InsertText(indent, "}"));
        commandQueue.add(new InsertLineFeed(indent));
    }
}
