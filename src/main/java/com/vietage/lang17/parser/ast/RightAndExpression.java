package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     REL_OP { WHITESPACE } ADD_EXPR
 * </pre>
 */
public class RightAndExpression extends CompositeElement {

    private final RelativeOp relativeOp = new RelativeOp();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final AddExpression addExpression = new AddExpression();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                relativeOp,
                optionalWhitespace,
                addExpression
        };
    }
}
