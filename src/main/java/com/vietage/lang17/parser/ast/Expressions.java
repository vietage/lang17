package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     EXPRESSION { WHITESPACE } { REST_EXPRESSIONS }
 * </pre>
 */
public class Expressions extends CompositeElement {

    private Expression expression;
    private ZeroOrMore<RestExpressions> restExpressions;

    @Override
    protected Element[] getElements() {
        expression = new Expression();
        restExpressions = new ZeroOrMore<>(RestExpressions::new);

        return new Element[]{
                expression,
                new OptionalWhitespace(),
                restExpressions
        };
    }

    public Expression getExpression() {
        return expression;
    }

    public ZeroOrMore<RestExpressions> getRestExpressions() {
        return restExpressions;
    }
}
