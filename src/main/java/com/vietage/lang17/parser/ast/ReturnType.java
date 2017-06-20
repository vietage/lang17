package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     'void' | TYPE
 * </pre>
 */
public class ReturnType extends Choice {

    private final Token voidToken = new Token("void");
    private final Type type = new Type();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                voidToken,
                type
        };
    }
}
