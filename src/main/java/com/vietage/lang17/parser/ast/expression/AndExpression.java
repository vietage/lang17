package com.vietage.lang17.parser.ast.expression;

import java.util.ArrayList;
import java.util.List;

public class AndExpression extends Expression {

    private List<Expression> expressions = new ArrayList<>();

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }
}
