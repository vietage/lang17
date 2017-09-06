package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     'void' | TYPE
 * </pre>
 */
public class ReturnType extends Choice {

    private Type type;

    @Override
    protected Element[] getElements() {
        type = new Type();

        return new Element[]{
                new Token("void"),
                type
        };
    }

    public Type getType() {
        return type;
    }
}
