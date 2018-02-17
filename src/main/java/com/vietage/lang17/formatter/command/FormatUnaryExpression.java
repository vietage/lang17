package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.UnaryExpression;
import com.vietage.lang17.parser.ast.expression.UnaryOperator;

import java.util.Queue;

public class FormatUnaryExpression extends FormatCommand {

    private final UnaryExpression unaryExpression;

    public FormatUnaryExpression(int indent, UnaryExpression unaryExpression) {
        super(indent);
        this.unaryExpression = unaryExpression;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.print(formatUnaryOperator(unaryExpression.getOperator()), indent);

        commandQueue.add(new FormatExpression(
                indent,
                unaryExpression.getExpression(),
                unaryExpression.getOperatorPrecedence()
        ));
    }

    private String formatUnaryOperator(UnaryOperator operator) {
        switch (unaryExpression.getOperator()) {
            case NOT:
                return "!";
            case MINUS:
                return "-";
            default:
                throw new RuntimeException("Unsupported unary operator: " + operator);
        }
    }
}
