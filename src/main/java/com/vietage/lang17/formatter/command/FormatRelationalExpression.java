package com.vietage.lang17.formatter.command;

import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;
import com.vietage.lang17.parser.ast.expression.RelationalExpression;
import com.vietage.lang17.parser.ast.expression.RelationalOperator;

import java.util.Queue;

public class FormatRelationalExpression extends FormatOperatorExpression {

    private final RelationalExpression relationalExpression;

    public FormatRelationalExpression(int indent, RelationalExpression relationalExpression,
                                      OperatorPrecedence parentOperatorPrecedence) {
        super(indent, parentOperatorPrecedence);
        this.relationalExpression = relationalExpression;
    }

    @Override
    protected Expression getExpression() {
        return relationalExpression;
    }

    @Override
    protected void addFormatCommands(Queue<FormatCommand> commandQueue) {
        commandQueue.add(new FormatExpression(
                indent,
                relationalExpression.getLeftExpression(),
                relationalExpression.getOperatorPrecedence()
        ));
        commandQueue.add(new InsertText(indent, formatRelationalOperator(relationalExpression.getOperator())));
        commandQueue.add(new FormatExpression(
                indent,
                relationalExpression.getRightExpression(),
                relationalExpression.getOperatorPrecedence()
        ));
    }

    private String formatRelationalOperator(RelationalOperator operator) {
        switch (operator) {
            case LESS:
                return " < ";
            case LESS_OR_EQUAL:
                return " <= ";
            case GREATER:
                return " > ";
            case GREATER_OR_EQUAL:
                return " >= ";
            default:
                throw new RuntimeException("Unsupported relational operator: " + operator);
        }
    }
}
