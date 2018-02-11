package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.AdditionExpression;
import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;

import java.util.Queue;

public class FormatAdditionExpression extends FormatOperatorExpression {

    public FormatAdditionExpression(int indent, AdditionExpression additionExpression,
                                    OperatorPrecedence parentOperatorPrecedence) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
