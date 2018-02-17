package com.vietage.lang17.formatter.command;

import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.MultiplicationExpression;
import com.vietage.lang17.parser.ast.expression.MultiplicationOperator;
import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;

import java.util.Queue;

public class FormatMultiplicationExpression extends FormatOperatorExpression {

    private final MultiplicationExpression multiplicationExpression;

    public FormatMultiplicationExpression(int indent, MultiplicationExpression multiplicationExpression,
                                          OperatorPrecedence parentOperatorPrecedence) {
        super(indent, parentOperatorPrecedence);
        this.multiplicationExpression = multiplicationExpression;
    }

    @Override
    protected Expression getExpression() {
        return multiplicationExpression;
    }

    @Override
    protected void addFormatCommands(Queue<FormatCommand> commandQueue) {
        commandQueue.add(new FormatExpression(
                indent,
                multiplicationExpression.getLeftExpression(),
                multiplicationExpression.getOperatorPrecedence()
        ));
        commandQueue.add(new InsertText(
                indent,
                formatMultiplicationOperator(multiplicationExpression.getOperator())
        ));
        commandQueue.add(new FormatExpression(
                indent,
                multiplicationExpression.getRightExpression(),
                multiplicationExpression.getOperatorPrecedence()
        ));
    }

    private String formatMultiplicationOperator(MultiplicationOperator operator) {
        switch (operator) {
            case MULTIPLICATION:
                return " * ";
            case DIVISION:
                return " / ";
            case MODULO:
                return " % ";
            default:
                throw new RuntimeException("Unsupported multiplication operator: " + operator);
        }
    }
}
