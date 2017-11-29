package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     { WHITESPACE } FUNCTIONS
 * </pre>
 */
public class Root extends CompositeLexeme {

    private Functions functions;

    @Override
    protected Lexeme[] getLexemes() {
        functions = new Functions();

        return new Lexeme[]{
                new OptionalWhitespace(),
                functions
        };
    }

    public Functions getFunctions() {
        return functions;
    }
}
