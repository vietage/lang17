package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.Queue;

public class FormatExpression extends FormatCommand {

    private final Expression expression;

    public FormatExpression(int indent, Expression expression) {
        super(indent);
        this.expression = expression;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
