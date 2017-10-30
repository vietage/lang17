package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     '(' { WHITESPACE } EXPRESSION ')'
 * </pre>
 */
public class BracketsExpression extends CompositeElement {

    private Expression expression;

    @Override
    protected Element[] getElements() {
        expression = new Expression();

        return new Element[]{
                new Token("("),
                new OptionalWhitespace(),
                expression,
                new Token(")")
        };
    }

    public Expression getExpression() {
        return expression;
    }
}
