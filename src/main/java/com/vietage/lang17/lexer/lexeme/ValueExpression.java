package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     BRACKETS_EXPR | CONST | NEW_ARRAY | CALL | VAR_ACCESS
 * </pre>
 */
public class ValueExpression extends Choice {

    private ValueExpressionLexeme[] valueExpressionElements;

    @Override
    protected Lexeme[] getLexemes() {
        valueExpressionElements = new ValueExpressionLexeme[]{
                new BracketsExpression(),
                new Constant(),
                new NewArray(),
                new Call(),
                new VarAccess()
        };
        return valueExpressionElements;
    }

    public ValueExpressionLexeme getValueExpressionElement() {
        return valueExpressionElements[getCurrentLexeme()];
    }
}
