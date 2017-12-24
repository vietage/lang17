package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.MultiplicationExpression;

import java.util.Queue;

public class FormatMultiplicationExpression extends FormatCommand {

    public FormatMultiplicationExpression(int indent, MultiplicationExpression multiplicationExpression) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
