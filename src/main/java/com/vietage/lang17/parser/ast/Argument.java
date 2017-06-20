package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     TYPE { WHITESPACE } NAME
 * </pre>
 */
public class Argument extends CompositeElement {

    private final Type type = new Type();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final Name name = new Name();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                type,
                optionalWhitespace,
                name
        };
    }
}
