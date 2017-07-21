package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     EQUAL_OP { WHITESPACE } REL_EXPR
 * </pre>
 */
public class RightRelativeExpression extends CompositeElement {

    private final EqualOp equalOp = new EqualOp();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final RelativeExpression relativeExpression = new RelativeExpression();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                equalOp,
                optionalWhitespace,
                relativeExpression
        };
    }
}
