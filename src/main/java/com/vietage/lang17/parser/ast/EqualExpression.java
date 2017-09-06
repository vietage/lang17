package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     REL_EXPR { WHITESPACE } [ RIGHT_REL_EXPR ]
 * </pre>
 */
public class EqualExpression extends CompositeElement {

    private RelativeExpression relativeExpression;
    private ZeroOrOne<RightRelativeExpression> rightRelativeExpression;

    @Override
    protected Element[] getElements() {
        relativeExpression = new RelativeExpression();
        rightRelativeExpression = new ZeroOrOne<>(new RightRelativeExpression());

        return new Element[]{
                relativeExpression,
                new OptionalWhitespace(),
                rightRelativeExpression
        };
    }

    public RelativeExpression getRelativeExpression() {
        return relativeExpression;
    }

    public ZeroOrOne<RightRelativeExpression> getRightRelativeExpression() {
        return rightRelativeExpression;
    }
}
