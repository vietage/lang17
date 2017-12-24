package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.EqualityExpression;

import java.util.Queue;

public class FormatEqualityExpression extends FormatCommand {

    public FormatEqualityExpression(int indent, EqualityExpression equalityExpression) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
