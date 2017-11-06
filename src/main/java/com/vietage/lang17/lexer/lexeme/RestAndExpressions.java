package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     '||' { WHITESPACE } AND_EXPR { WHITESPACE }
 * </pre>
 */
public class RestAndExpressions extends CompositeElement {

    private AndExpression andExpression;

    @Override
    protected Element[] getElements() {
        andExpression = new AndExpression();

        return new Element[]{
                new Token("||"),
                new OptionalWhitespace(),
                andExpression,
                new OptionalWhitespace()
        };
    }

    public AndExpression getAndExpression() {
        return andExpression;
    }
}