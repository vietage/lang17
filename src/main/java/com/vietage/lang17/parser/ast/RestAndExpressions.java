package com.vietage.lang17.parser.ast;

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
