package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.expression.Expression;

public class ReturnStatement extends Statement {

    private Expression expression;

    public ReturnStatement(Position position) {
        super(position);
    }

    public ReturnStatement(Expression expression) {
        super(null);
        this.expression = expression;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
