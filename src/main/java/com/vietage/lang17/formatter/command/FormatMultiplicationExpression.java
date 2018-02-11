package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
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
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        if (multiplicationExpression.getOperatorPrecedence().less(parentOperatorPrecedence)) {
            commandQueue.add(new InsertText(indent, "("));
            addFormatCommands(commandQueue);
            commandQueue.add(new InsertText(indent, ")"));
        } else {
            addFormatCommands(commandQueue);
        }
    }

    private void addFormatCommands(Queue<FormatCommand> commandQueue) {
        commandQueue.add(new FormatExpression(
                indent,
                multiplicationExpression.getLeftExpression(),
                parentOperatorPrecedence
        ));
        commandQueue.add(new InsertText(
                indent,
                formatMultiplicationOperator(multiplicationExpression.getOperator())
        ));
        commandQueue.add(new FormatExpression(
                indent,
                multiplicationExpression.getRightExpression(),
                parentOperatorPrecedence
        ));
    }

    private String formatMultiplicationOperator(MultiplicationOperator multiplicationOperator) {
        switch (multiplicationOperator) {
            case MULTIPLICATION:
                return " * ";
            case DIVISION:
                return " / ";
            case MODULO:
                return " % ";
        }
    }
}
