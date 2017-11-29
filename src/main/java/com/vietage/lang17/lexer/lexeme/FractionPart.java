package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     '.' INT_PART
 * </pre>
 */
public class FractionPart extends CompositeLexeme {

    private IntegerPart integerPart;

    @Override
    protected Lexeme[] getLexemes() {
        integerPart = new IntegerPart();

        return new Lexeme[]{
                new Token("."),
                integerPart
        };
    }

    public IntegerPart getIntegerPart() {
        return integerPart;
    }
}
