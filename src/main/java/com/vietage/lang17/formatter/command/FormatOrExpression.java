package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.OrExpression;

import java.util.Queue;

public class FormatOrExpression extends FormatCommand {

    public FormatOrExpression(int indent, OrExpression orExpression) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
