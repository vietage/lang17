package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     { WHITESPACE } FUNCTIONS
 * </pre>
 */
public class Program extends CompositeElement {

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
