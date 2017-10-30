package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     FUNCTION { WHITESPACE }
 * </pre>
 */
public class FunctionAndWhitespace extends CompositeElement {

    private Function function;

    @Override
    protected Element[] getElements() {
        function = new Function();

        return new Element[]{
                function,
                new OptionalWhitespace()
        };
    }

    public Function getFunction() {
        return function;
    }
}
