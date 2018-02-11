package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;
import com.vietage.lang17.parser.ast.expression.RelationalExpression;

import java.util.Queue;

public class FormatRelationalExpression extends FormatOperatorExpression {

    public FormatRelationalExpression(int indent, RelationalExpression relationalExpression,
                                      OperatorPrecedence parentOperatorPrecedence) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
