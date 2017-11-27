package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.parser.ast.Type;
import com.vietage.lang17.parser.ast.expression.Expression;

public class VariableDefinition implements Statement {

    private final Type type;
    private final String name;
    private Expression expression;

    public VariableDefinition(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
