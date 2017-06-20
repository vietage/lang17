package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     ADD_EXPR { WHITESPACE } [ RIGHT_AND_EXPRESSION ]
 * </pre>
 */
public class RelativeExpression extends CompositeElement {

    private final AndExpression andExpression = new AndExpression();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final ZeroOrOne<RightAndExpression> rightAndExpression = new ZeroOrOne<>(new RightAndExpression());

    @Override
    protected Element[] getElements() {
        return new Element[]{
                andExpression,
                optionalWhitespace,
                rightAndExpression
        };
    }
}
