package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     MUL_EXPR { WHITESPACE } { REST_MUL_EXPRS }
 * </pre>
 */
public class AddExpression extends CompositeElement {

    private MulExpression mulExpression;
    private ZeroOrMore<RestMulExpressions> restMulExpressions;

    @Override
    protected Element[] getElements() {
        mulExpression = new MulExpression();
        restMulExpressions = new ZeroOrMore<>(RestMulExpressions::new);

        return new Element[]{
                mulExpression,
                new OptionalWhitespace(),
                restMulExpressions
        };
    }

    public MulExpression getMulExpression() {
        return mulExpression;
    }

    public ZeroOrMore<RestMulExpressions> getRestMulExpressions() {
        return restMulExpressions;
    }
}
