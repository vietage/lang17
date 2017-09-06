package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '.' INT_PART
 * </pre>
 */
public class FractionPart extends CompositeElement {

    private IntegerPart integerPart;

    @Override
    protected Element[] getElements() {
        integerPart = new IntegerPart();

        return new Element[]{
                new Token("."),
                integerPart
        };
    }

    public IntegerPart getIntegerPart() {
        return integerPart;
    }
}
