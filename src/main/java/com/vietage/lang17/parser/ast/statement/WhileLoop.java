package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class WhileLoop implements Statement {

    private Expression condition;
    private final List<Statement> statements = new ArrayList<>();

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

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
