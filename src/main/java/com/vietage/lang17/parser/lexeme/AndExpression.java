package com.vietage.lang17.parser.lexeme;

/**
 * EBNF:
 * <pre>
 *     EQUAL_EXPR { WHITESPACE } { REST_EQUAL_EXPRS }
 * </pre>
 */
public class AndExpression extends CompositeElement {

    private EqualExpression equalExpression;
    private ZeroOrMore<RestEqualExpressions> restEqualExpressions;

    @Override
    protected Element[] getElements() {
        equalExpression = new EqualExpression();
        restEqualExpressions = new ZeroOrMore<>(RestEqualExpressions::new);

        return new Element[]{
                equalExpression,
                new OptionalWhitespace(),
                restEqualExpressions
        };
    }

    public EqualExpression getEqualExpression() {
        return equalExpression;
    }

    public ZeroOrMore<RestEqualExpressions> getRestEqualExpressions() {
        return restEqualExpressions;
    }
}
