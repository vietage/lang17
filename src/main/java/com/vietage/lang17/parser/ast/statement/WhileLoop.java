package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class WhileLoop extends Statement {

    private Expression condition;
    private final List<Statement> statements = new ArrayList<>();

    public WhileLoop(Position position) {
        super(position);
    }

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
