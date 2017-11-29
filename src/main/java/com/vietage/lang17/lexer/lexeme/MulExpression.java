package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     UNARY_EXPR { WHITESPACE } { REST_UNARY_EXPRS }
 * </pre>
 */
public class MulExpression extends CompositeLexeme {

    private UnaryExpression unaryExpression;
    private ZeroOrMore<RestUnaryExpressions> restUnaryExpressions;

    @Override
    protected Lexeme[] getLexemes() {
        unaryExpression = new UnaryExpression();
        restUnaryExpressions = new ZeroOrMore<>(RestUnaryExpressions::new);

        return new Lexeme[]{
                unaryExpression,
                new OptionalWhitespace(),
                restUnaryExpressions
        };
    }

    public UnaryExpression getUnaryExpression() {
        return unaryExpression;
    }

    public ZeroOrMore<RestUnaryExpressions> getRestUnaryExpressions() {
        return restUnaryExpressions;
    }
}
