package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     REL_EXPR { WHITESPACE } [ RIGHT_REL_EXPR ]
 * </pre>
 */
public class EqualExpression extends CompositeElement {

    private final RelativeExpression relativeExpression = new RelativeExpression();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final ZeroOrOne<RightRelativeExpression> rightRelativeExpression =
            new ZeroOrOne<>(new RightRelativeExpression());

    @Override
    protected Element[] getElements() {
        return new Element[]{
                relativeExpression,
                optionalWhitespace,
                rightRelativeExpression
        };
    }
}
