package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.parser.ast.expression.Expression;

public class VariableAssignment implements Statement {

    private final String name;
    private Expression indexExpression;
    private Expression expression;

    public VariableAssignment(String name) {
        this.name = name;
    }

    @Override
    public void visit(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public Expression getIndexExpression() {
        return indexExpression;
    }

    public void setIndexExpression(Expression indexExpression) {
        this.indexExpression = indexExpression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
