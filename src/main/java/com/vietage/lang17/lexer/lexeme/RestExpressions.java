package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     ',' { WHITESPACE } EXPRESSION { WHITESPACE }
 * </pre>
 */
public class RestExpressions extends CompositeElement {

    private Expression expression;

    @Override
    protected Element[] getElements() {
        expression = new Expression();

        return new Element[]{
                new Token(","),
                new OptionalWhitespace(),
                expression,
                new OptionalWhitespace()
        };
    }

    public Expression getExpression() {
        return expression;
    }
}
