package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     ',' { WHITESPACE } EXPRESSION { WHITESPACE }
 * </pre>
 */
public class RestExpressions extends CompositeLexeme {

    private Expression expression;

    @Override
    protected Lexeme[] getLexemes() {
        expression = new Expression();

        return new Lexeme[]{
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
