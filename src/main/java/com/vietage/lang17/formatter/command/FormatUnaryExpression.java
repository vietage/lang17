package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.UnaryExpression;

import java.util.Queue;

public class FormatUnaryExpression extends FormatCommand {

    public FormatUnaryExpression(int indent, UnaryExpression unaryExpression) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
