package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.AndExpression;

import java.util.Queue;

public class FormatAndExpression extends FormatCommand {

    public FormatAndExpression(int indent, AndExpression andExpression) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
