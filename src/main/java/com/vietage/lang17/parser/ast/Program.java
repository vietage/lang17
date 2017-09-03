package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     { WHITESPACE } FUNCTIONS
 * </pre>
 */
public class Program extends CompositeElement {

    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final Functions functions = new Functions();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                optionalWhitespace,
                functions
        };
    }
}
