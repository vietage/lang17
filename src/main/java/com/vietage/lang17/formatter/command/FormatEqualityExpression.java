package com.vietage.lang17.formatter.command;

import com.vietage.lang17.parser.ast.expression.EqualityExpression;
import com.vietage.lang17.parser.ast.expression.EqualityOperator;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;

import java.util.Queue;

public class FormatEqualityExpression extends FormatOperatorExpression {

    private final EqualityExpression equalityExpression;

    public FormatEqualityExpression(int indent, EqualityExpression equalityExpression,
                                    OperatorPrecedence parentOperatorPrecedence) {
        super(indent, parentOperatorPrecedence);
        this.equalityExpression = equalityExpression;
    }

    @Override
    protected Expression getExpression() {
        return equalityExpression;
    }

    @Override
    protected void addFormatCommands(Queue<FormatCommand> commandQueue) {
        commandQueue.add(new FormatExpression(
                indent,
                equalityExpression.getLeftExpression(),
                equalityExpression.getOperatorPrecedence()
        ));
        commandQueue.add(new InsertText(indent, formatEqualityOperator(equalityExpression.getOperator())));
        commandQueue.add(new FormatExpression(
                indent,
                equalityExpression.getRightExpression(),
                equalityExpression.getOperatorPrecedence()
        ));
    }

    private String formatEqualityOperator(EqualityOperator operator) {
        switch (operator) {
            case EQUAL:
                return " = ";
            case NOT_EQUAL:
                return " != ";
            default:
                throw new RuntimeException("Unsupported equality operator: " + operator);
        }
    }
}
