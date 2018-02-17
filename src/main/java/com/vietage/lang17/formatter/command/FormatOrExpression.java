package com.vietage.lang17.formatter.command;

import com.vietage.lang17.parser.ast.expression.Expression;
import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;
import com.vietage.lang17.parser.ast.expression.OrExpression;

import java.util.Queue;

public class FormatOrExpression extends FormatOperatorExpression {

    private final OrExpression orExpression;

    public FormatOrExpression(int indent, OrExpression orExpression, OperatorPrecedence parentOperatorPrecedence) {
        super(indent, parentOperatorPrecedence);
        this.orExpression = orExpression;
    }

    @Override
    protected Expression getExpression() {
        return orExpression;
    }

    @Override
    protected void addFormatCommands(Queue<FormatCommand> commandQueue) {
        boolean first = true;

        for (Expression expression : orExpression.getExpressions()) {

            if (!first) {
                commandQueue.add(new InsertText(indent, " || "));
            }
            first = false;

            commandQueue.add(new FormatExpression(
                    indent,
                    expression,
                    orExpression.getOperatorPrecedence()
            ));
        }
    }
}
