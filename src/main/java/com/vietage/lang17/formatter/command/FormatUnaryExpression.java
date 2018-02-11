package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.UnaryExpression;

import java.util.Queue;

public class FormatUnaryExpression extends FormatCommand {

    private final UnaryExpression unaryExpression;

    public FormatUnaryExpression(int indent, UnaryExpression unaryExpression) {
        super(indent);
        this.unaryExpression = unaryExpression;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        switch (unaryExpression.getOperator()) {
            case NOT:
                out.print("!", indent);
                break;
            case MINUS:
                out.print("-", indent);
                break;
        }
        commandQueue.add(new FormatExpression(indent, unaryExpression.getExpression()));
    }
}
