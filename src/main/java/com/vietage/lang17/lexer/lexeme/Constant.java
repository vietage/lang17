package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     NUMBER | STRING | BOOLEAN
 * </pre>
 */
public class Constant extends Choice implements ValueExpressionLexeme {

    private ConstantLexeme[] constantElements;

    @Override
    protected Lexeme[] getLexemes() {
        constantElements = new ConstantLexeme[]{
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

    public ConstantLexeme getConstantElement() {
        return constantElements[getCurrentLexeme()];
    }
}
