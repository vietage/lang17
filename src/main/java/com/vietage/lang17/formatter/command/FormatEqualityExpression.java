package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.expression.EqualityExpression;
import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;

import java.util.Queue;

public class FormatEqualityExpression extends FormatOperatorExpression {

    public FormatEqualityExpression(int indent, EqualityExpression equalityExpression,
                                    OperatorPrecedence parentOperatorPrecedence) {
        super(indent);
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {

    }
}
