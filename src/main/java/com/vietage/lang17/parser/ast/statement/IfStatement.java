package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.lexer.Position;
import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IfStatement extends Statement {

    private Expression condition;
    private final List<Statement> trueStatements = new ArrayList<>();
    private List<Statement> falseStatements = Collections.emptyList();

    public IfStatement(Position position) {
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

    public List<Statement> getTrueStatements() {
        return trueStatements;
    }

    public List<Statement> getFalseStatements() {
        return falseStatements;
    }

    public void setFalseStatements(List<Statement> falseStatements) {
        this.falseStatements = falseStatements;
    }
}
