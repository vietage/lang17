package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     NUMBER | STRING | BOOLEAN
 * </pre>
 */
public class Constant extends Choice {

    private NumberConstant numberConstant;
    private StringConstant stringConstant;
    private BooleanConstant booleanConstant;

    @Override
    protected Element[] getElements() {
        numberConstant = new NumberConstant();
        stringConstant = new StringConstant();
        booleanConstant = new BooleanConstant();

        return new Element[]{
                numberConstant,
                stringConstant,
                booleanConstant
        };
    }
}
