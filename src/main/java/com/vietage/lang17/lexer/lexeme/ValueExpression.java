package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     BRACKETS_EXPR | CONST | VAR_ACCESS | NEW_ARRAY | CALL
 * </pre>
 */
public class ValueExpression extends Choice {

    private ValueExpressionLexeme[] valueExpressionElements;

    @Override
    protected Lexeme[] getLexemes() {
        valueExpressionElements = new ValueExpressionLexeme[]{
                new Call(),
                new VarAccess(),
                new BracketsExpression(),
                new Constant(),
                new NewArray()
        };
        return valueExpressionElements;
    }

    public ValueExpressionLexeme getValueExpressionElement() {
        return valueExpressionElements[getCurrentLexeme()];
    }
}
