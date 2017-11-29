package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     FUNCTION { WHITESPACE }
 * </pre>
 */
public class FunctionAndWhitespace extends CompositeLexeme {

    private Function function;

    @Override
    protected Lexeme[] getLexemes() {
        function = new Function();

        return new Lexeme[]{
                function,
                new OptionalWhitespace()
        };
    }

    public Function getFunction() {
        return function;
    }
}
