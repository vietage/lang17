package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.parser.ast.expression.Expression;

public class ReturnStatement extends Statement {

    private Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
