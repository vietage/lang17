package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     INT_PART [ '.' INT_PART ]
 * </pre>
 */
public class NumberConstant extends CompositeLexeme
        implements ConstantLexeme {

    private IntegerPart integerPart;
    private ZeroOrOne<FractionPart> fractionPart;

    @Override
    protected Lexeme[] getLexemes() {
        integerPart = new IntegerPart();
        fractionPart = new ZeroOrOne<>(new FractionPart());

        return new Lexeme[]{
                integerPart,
                fractionPart
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public IntegerPart getIntegerPart() {
        return integerPart;
    }

    public ZeroOrOne<FractionPart> getFractionPart() {
        return fractionPart;
    }
}
