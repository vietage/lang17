package com.vietage.lang17.parser.lexeme;

/**
 * EBNF:
 * <pre>
 *     MUL_OP { WHITESPACE } UNARY_EXPR { WHITESPACE }
 * </pre>
 */
public class RestUnaryExpressions extends CompositeElement {

    private MulKeyword mulKeyword;
    private UnaryExpression unaryExpression;

    @Override
    protected Element[] getElements() {
        mulKeyword = new MulKeyword();
        unaryExpression = new UnaryExpression();

        return new Element[]{
                mulKeyword,
                new OptionalWhitespace(),
                unaryExpression,
                new OptionalWhitespace()
        };
    }

    public MulKeyword getMulKeyword() {
        return mulKeyword;
    }

    public UnaryExpression getUnaryExpression() {
        return unaryExpression;
    }
}
