package com.vietage.lang17.parser.ast.statement;

import com.vietage.lang17.parser.ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class IfStatement implements Statement {

    private Expression condition;
    private final List<Statement> trueStatements = new ArrayList<>();
    private List<Statement> falseStatements;

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
