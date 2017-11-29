package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     '||' { WHITESPACE } AND_EXPR { WHITESPACE }
 * </pre>
 */
public class RestAndExpressions extends CompositeLexeme {

    private AndExpression andExpression;

    @Override
    protected Lexeme[] getLexemes() {
        andExpression = new AndExpression();

        return new Lexeme[]{
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
