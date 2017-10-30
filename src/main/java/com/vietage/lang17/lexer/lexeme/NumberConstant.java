package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     INT_PART [ '.' INT_PART ]
 * </pre>
 */
public class NumberConstant extends CompositeElement {

    private IntegerPart integerPart;
    private ZeroOrOne<FractionPart> fractionPart;

    @Override
    protected Element[] getElements() {
        integerPart = new IntegerPart();
        fractionPart = new ZeroOrOne<>(new FractionPart());

        return new Element[]{
                integerPart,
                fractionPart
        };
    }

    public IntegerPart getIntegerPart() {
        return integerPart;
    }

    public ZeroOrOne<FractionPart> getFractionPart() {
        return fractionPart;
    }
}
