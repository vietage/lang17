package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     ADD_EXPR { WHITESPACE } [ RIGHT_AND_EXPRESSION ]
 * </pre>
 */
public class RelativeExpression extends CompositeElement {

    private AddExpression addExpression;
    private ZeroOrOne<RightAndExpression> rightAndExpression;

    @Override
    protected Element[] getElements() {
        addExpression = new AddExpression();
        rightAndExpression = new ZeroOrOne<>(new RightAndExpression());

        return new Element[]{
                addExpression,
                new OptionalWhitespace(),
                rightAndExpression
        };
    }

    public AddExpression getAddExpression() {
        return addExpression;
    }

    public ZeroOrOne<RightAndExpression> getRightAndExpression() {
        return rightAndExpression;
    }
}
