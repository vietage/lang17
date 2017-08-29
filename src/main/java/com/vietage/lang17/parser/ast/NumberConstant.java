package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     INT_PART [ '.' INT_PART ]
 * </pre>
 */
public class NumberConstant extends CompositeElement {

    private final IntegerPart integerPart = new IntegerPart();
    private final ZeroOrOne<FractionPart> fractionPart = new ZeroOrOne<>(new FractionPart());

    @Override
    protected Element[] getElements() {
        return new Element[]{
                integerPart,
                fractionPart
        };
    }
}
