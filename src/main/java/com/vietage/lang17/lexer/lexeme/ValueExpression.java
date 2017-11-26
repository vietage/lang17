package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     BRACKETS_EXPR | CONST | VAR_ACCESS | NEW_ARRAY | CALL
 * </pre>
 */
public class ValueExpression extends Choice {

    private ValueExpressionElement[] valueExpressionElements;

    @Override
    protected Element[] getElements() {
        valueExpressionElements = new ValueExpressionElement[]{
                new BracketsExpression(),
                new Constant(),
                new VarAccess(),
                new NewArray(),
                new Call(),
        };
        return valueExpressionElements;
    }

    public ValueExpressionElement getValueExpressionElement() {
        return valueExpressionElements[getCurrentElement()];
    }
}
