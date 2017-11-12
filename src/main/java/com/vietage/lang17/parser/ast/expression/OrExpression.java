package com.vietage.lang17.parser.ast.expression;

import java.util.ArrayList;
import java.util.List;

public class OrExpression extends Expression {

    private final List<Expression> expressions = new ArrayList<>();

    public List<Expression> getExpressions() {
        return expressions;
    }
}
