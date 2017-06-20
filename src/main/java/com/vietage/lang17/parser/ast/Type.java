package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     BASIC_TYPE [ '[]' ]
 * </pre>
 */
public class Type extends CompositeElement {

    private final BasicType basicType = new BasicType();
    private final ZeroOrOne<Token> arrayModifier = new ZeroOrOne<>(new Token("[]"));

    @Override
    protected Element[] getElements() {
        return new Element[]{
                basicType,
                arrayModifier
        };
    }
}
