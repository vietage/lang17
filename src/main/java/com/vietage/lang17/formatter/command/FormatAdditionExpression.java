package com.vietage.lang17.formatter.command;

import com.vietage.lang17.parser.ast.expression.AdditionExpression;
import com.vietage.lang17.parser.ast.expression.AdditionOperator;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;

import java.util.Queue;

public class FormatAdditionExpression extends FormatOperatorExpression {

    private final AdditionExpression additionExpression;

    public FormatAdditionExpression(int indent, AdditionExpression additionExpression,
                                    OperatorPrecedence parentOperatorPrecedence) {
        super(indent, parentOperatorPrecedence);
        this.additionExpression = additionExpression;
    }

    @Override
    protected Expression getExpression() {
        return additionExpression;
    }

    @Override
    protected void addFormatCommands(Queue<FormatCommand> commandQueue) {
        commandQueue.add(new FormatExpression(
                indent,
                additionExpression.getLeftExpression(),
                additionExpression.getOperatorPrecedence()
        ));
        commandQueue.add(new InsertText(indent, formatAdditionOperator(additionExpression.getOperator())));
        commandQueue.add(new FormatExpression(
                indent,
                additionExpression.getRightExpression(),
                additionExpression.getOperatorPrecedence()
        ));
    }

    private String formatAdditionOperator(AdditionOperator operator) {
        switch (operator) {
            case ADDITION:
                return " + ";
            case SUBTRACTION:
                return " - ";
            default:
                throw new RuntimeException("Unsupported addition operator: " + operator);
        }
    }
}
