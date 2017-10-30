package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     REL_OP { WHITESPACE } ADD_EXPR
 * </pre>
 */
public class RightAndExpression extends CompositeElement {

    private RelativeOp relativeOp;
    private AddExpression addExpression;

    @Override
    protected Element[] getElements() {
        relativeOp = new RelativeOp();
        addExpression = new AddExpression();

        return new Element[]{
                relativeOp,
                new OptionalWhitespace(),
                addExpression
        };
    }

    public RelativeOp getRelativeOp() {
        return relativeOp;
    }

    public AddExpression getAddExpression() {
        return addExpression;
    }
}
