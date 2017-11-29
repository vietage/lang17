package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     EXPRESSION { WHITESPACE } { REST_EXPRESSIONS }
 * </pre>
 */
public class Expressions extends CompositeLexeme {

    private Expression expression;
    private ZeroOrMore<RestExpressions> restExpressions;

    @Override
    protected Lexeme[] getLexemes() {
        expression = new Expression();
        restExpressions = new ZeroOrMore<>(RestExpressions::new);

        return new Lexeme[]{
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
