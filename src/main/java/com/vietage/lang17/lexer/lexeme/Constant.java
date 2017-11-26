package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     NUMBER | STRING | BOOLEAN
 * </pre>
 */
public class Constant extends Choice implements ValueExpressionElement {

    private ConstantElement[] constantElements;

    @Override
    protected Element[] getElements() {
        constantElements = new ConstantElement[]{
                new NumberConstant(),
                new StringConstant(),
                new BooleanConstant()
        };
        return constantElements;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public ConstantElement getConstantElement() {
        return constantElements[getCurrentElement()];
    }
}
