package com.vietage.lang17.formatter.command;

import com.vietage.lang17.parser.ast.expression.AndExpression;
import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;

import java.util.Queue;

public class FormatAndExpression extends FormatOperatorExpression {

    private final AndExpression andExpression;

    public FormatAndExpression(int indent, AndExpression andExpression,
                               OperatorPrecedence parentOperatorPrecedence) {
        super(indent, parentOperatorPrecedence);
        this.andExpression = andExpression;
    }

    @Override
    protected Expression getExpression() {
        return andExpression;
    }

    @Override
    protected void addFormatCommands(Queue<FormatCommand> commandQueue) {
        boolean first = true;

        for (Expression expression : andExpression.getExpressions()) {

            if (!first) {
                commandQueue.add(new InsertText(indent, " && "));
            }
            first = false;

            commandQueue.add(new FormatExpression(
                    indent,
                    expression,
                    andExpression.getOperatorPrecedence()
            ));
        }
    }
}
