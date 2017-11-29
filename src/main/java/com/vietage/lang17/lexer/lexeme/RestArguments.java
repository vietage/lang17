package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     ',' { WHITESPACE } ARGUMENT { WHITESPACE }
 * </pre>
 */
public class RestArguments extends CompositeLexeme {

    private Argument argument;

    @Override
    protected Lexeme[] getLexemes() {
        argument = new Argument();

        return new Lexeme[]{
                new Token(","),
                new OptionalWhitespace(),
                argument,
                new OptionalWhitespace()
        };
    }

    public Argument getArgument() {
        return argument;
    }
}
