package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class WhileLoop extends Statement {

    private Expression condition;
    private final List<Statement> statements = new ArrayList<>();

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
