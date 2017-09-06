package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     BASIC_TYPE [ '[]' ]
 * </pre>
 */
public class Type extends CompositeElement {

    private BasicType basicType;
    private ZeroOrOne<Token> arrayModifier;

    @Override
    protected Element[] getElements() {
        basicType = new BasicType();
        arrayModifier = new ZeroOrOne<>(new Token("[]"));

        return new Element[]{
                basicType,
                arrayModifier
        };
    }

    public BasicType getBasicType() {
        return basicType;
    }

    public ZeroOrOne<Token> getArrayModifier() {
        return arrayModifier;
    }
}
