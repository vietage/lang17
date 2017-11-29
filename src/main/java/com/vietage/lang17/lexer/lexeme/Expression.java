package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     AND_EXPR { WHITESPACE } { REST_AND_EXPRS }
 * </pre>
 */
public class Expression extends CompositeLexeme {

    private AndExpression andExpression;
    private ZeroOrMore<RestAndExpressions> restAndExpressions;

    @Override
    protected Lexeme[] getLexemes() {
        andExpression = new AndExpression();
        restAndExpressions = new ZeroOrMore<>(RestAndExpressions::new);

        return new Lexeme[]{
                andExpression,
                new OptionalWhitespace(),
                restAndExpressions
        };
    }

    public AndExpression getAndExpression() {
        return andExpression;
    }

    public ZeroOrMore<RestAndExpressions> getRestAndExpressions() {
        return restAndExpressions;
    }
}
