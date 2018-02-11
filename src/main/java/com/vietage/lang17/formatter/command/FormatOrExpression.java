package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;
import com.vietage.lang17.parser.ast.expression.OrExpression;

import java.util.Queue;

public class FormatOrExpression extends FormatOperatorExpression {

    public FormatOrExpression(int indent, OrExpression orExpression, OperatorPrecedence parentOperatorPrecedence) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
