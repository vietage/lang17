package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     NUMBER | STRING | BOOLEAN
 * </pre>
 */
public class Constant extends Choice {

    private final NumberConstant numberConstant = new NumberConstant();
    private final StringConstant stringConstant = new StringConstant();
    private final BooleanConstant booleanConstant = new BooleanConstant();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                numberConstant,
                stringConstant,
                booleanConstant
        };
    }
}
