package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     { WHITESPACE } FUNCTIONS
 * </pre>
 */
public class Root extends CompositeElement {

    private Functions functions;

    @Override
    protected Element[] getElements() {
        functions = new Functions();

        return new Element[]{
                new OptionalWhitespace(),
                functions
        };
    }

    public Functions getFunctions() {
        return functions;
    }
}
