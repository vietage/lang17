package com.vietage.lang17.parser.lexeme;

/**
 * EBNF:
 * <pre>
 *     ADD_OP { WHITESPACE } MUL_EXPR
 * </pre>
 */
public class RestMulExpressions extends CompositeElement {

    private AddKeyword addKeyword;
    private MulExpression mulExpression;

    @Override
    protected Element[] getElements() {
        addKeyword = new AddKeyword();
        mulExpression = new MulExpression();

        return new Element[]{
                addKeyword,
                new OptionalWhitespace(),
                mulExpression
        };
    }

    public AddKeyword getAddKeyword() {
        return addKeyword;
    }

    public MulExpression getMulExpression() {
        return mulExpression;
    }
}
