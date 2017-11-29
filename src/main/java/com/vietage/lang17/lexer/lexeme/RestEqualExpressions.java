package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     '&&' { WHITESPACE } EQUAL_EXPR { WHITESPACE }
 * </pre>
 */
public class RestEqualExpressions extends CompositeLexeme {

    private EqualExpression equalExpression;

    @Override
    protected Lexeme[] getLexemes() {
        equalExpression = new EqualExpression();

        return new Lexeme[]{
                new Token("&&"),
                new OptionalWhitespace(),
                equalExpression,
                new OptionalWhitespace()
        };
    }

    public EqualExpression getEqualExpression() {
        return equalExpression;
    }
}
