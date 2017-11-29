package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     EQUAL_EXPR { WHITESPACE } { REST_EQUAL_EXPRS }
 * </pre>
 */
public class AndExpression extends CompositeLexeme {

    private EqualExpression equalExpression;
    private ZeroOrMore<RestEqualExpressions> restEqualExpressions;

    @Override
    protected Lexeme[] getLexemes() {
        equalExpression = new EqualExpression();
        restEqualExpressions = new ZeroOrMore<>(RestEqualExpressions::new);

        return new Lexeme[]{
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
