package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     TYPE { WHITESPACE } NAME
 * </pre>
 */
public class Argument extends CompositeElement {

    private Type type;
    private Name name;

    @Override
    protected Element[] getElements() {
        type = new Type();
        name = new Name();

        return new Element[]{
                type,
                new OptionalWhitespace(),
                name
        };
    }

    public Type getType() {
        return type;
    }

    public Name getName() {
        return name;
    }
}
