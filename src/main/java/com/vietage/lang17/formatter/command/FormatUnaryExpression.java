package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;
import com.vietage.lang17.parser.ast.expression.UnaryExpression;
import com.vietage.lang17.parser.ast.expression.UnaryOperator;

import java.util.Queue;

public class FormatUnaryExpression extends FormatOperatorExpression {

    private final UnaryExpression unaryExpression;

    public FormatUnaryExpression(int indent, UnaryExpression unaryExpression,
                                 OperatorPrecedence parentOperatorPrecedence) {
        super(indent, parentOperatorPrecedence);
        this.unaryExpression = unaryExpression;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        out.print(formatUnaryOperator(unaryExpression.getOperator()), indent);
        commandQueue.add(new FormatExpression(indent, unaryExpression.getExpression(), parentOperatorPrecedence));
    }

    private String formatUnaryOperator(UnaryOperator unaryOperator) {
        switch (unaryExpression.getOperator()) {
            case NOT:
                return "!";
            case MINUS:
                return "-";
        }
    }
}
