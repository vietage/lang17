package com.vietage.lang17.formatter.command;

import com.vietage.lang17.parser.ast.expression.OperatorPrecedence;

public abstract class FormatOperatorExpression extends FormatCommand {

    protected final OperatorPrecedence parentOperatorPrecedence;

    protected FormatOperatorExpression(int indent, OperatorPrecedence parentOperatorPrecedence) {
        super(indent);
        this.parentOperatorPrecedence = parentOperatorPrecedence;
    }

}
