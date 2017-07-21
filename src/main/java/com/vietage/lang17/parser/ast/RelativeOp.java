package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '<' | '>' | '<=' | '>='
 * </pre>
 */
public class RelativeOp extends Choice {

    private final Token lessThanKeyword = new Token("<");
    private final Token greaterThanKeyword = new Token(">");
    private final Token lessOrEqualThanKeyword = new Token("<=");
    private final Token greaterOrEqualThanKeyword = new Token(">=");

    @Override
    protected Element[] getElements() {
        return new Element[]{
                lessThanKeyword,
                greaterThanKeyword,
                lessOrEqualThanKeyword,
                greaterOrEqualThanKeyword
        };
    }
}
