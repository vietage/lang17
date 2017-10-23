package com.vietage.lang17.parser.lexeme;

/**
 * EBNF:
 * <pre>
 *     EQUAL_OP { WHITESPACE } REL_EXPR
 * </pre>
 */
public class RightRelativeExpression extends CompositeElement {

    private EqualOp equalOp;
    private RelativeExpression relativeExpression;

    @Override
    protected Element[] getElements() {
        equalOp = new EqualOp();
        relativeExpression = new RelativeExpression();

        return new Element[]{
                equalOp,
                new OptionalWhitespace(),
                relativeExpression
        };
    }

    public EqualOp getEqualOp() {
        return equalOp;
    }

    public RelativeExpression getRelativeExpression() {
        return relativeExpression;
    }
}
