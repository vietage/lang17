package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     '[' { WHITESPACE } EXPRESSION ']'
 * </pre>
 */
public class IndexExpression extends CompositeLexeme {

    private Expression expression;

    @Override
    protected Lexeme[] getLexemes() {
        expression = new Expression();

        return new Lexeme[]{
                new Token("["),
                new OptionalWhitespace(),
                expression,
                new Token("]")
        };
    }

    public Expression getExpression() {
        return expression;
    }
}
