package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '.' INT_PART
 * </pre>
 */
public class FractionPart extends CompositeElement {

    private final Token dotToken = new Token(".");
    private final IntegerPart integerPart = new IntegerPart();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                dotToken,
                integerPart
        };
    }
}
