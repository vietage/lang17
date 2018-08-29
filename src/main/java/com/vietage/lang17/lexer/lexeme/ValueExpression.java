package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     BRACKETS_EXPR | CONST | CALL | VAR_ACCESS | NEW_ARRAY
 * </pre>
 */
public class ValueExpression extends Choice {

    private ValueExpressionLexeme[] valueExpressionElements;

    @Override
    protected Lexeme[] getLexemes() {
        valueExpressionElements = new ValueExpressionLexeme[]{
                new BracketsExpression(),
                new Constant(),
                new Call(),
                new VarAccess(),
                new NewArray()
        };
        return valueExpressionElements;
    }

    public ValueExpressionLexeme getValueExpressionElement() {
        return valueExpressionElements[getCurrentLexeme()];
    }
}
