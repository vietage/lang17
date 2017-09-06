package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     [ UNARY_OP ] { WHITESPACE } VAL_EXPR
 * </pre>
 */
public class UnaryExpression extends CompositeElement {

    private ZeroOrOne<UnaryKeyword> unaryKeyword;
    private ValueExpression valueExpression;

    @Override
    protected Element[] getElements() {
        unaryKeyword = new ZeroOrOne<>(new UnaryKeyword());
        valueExpression = new ValueExpression();

        return new Element[]{
                unaryKeyword,
                new OptionalWhitespace(),
                valueExpression
        };
    }

    public ZeroOrOne<UnaryKeyword> getUnaryKeyword() {
        return unaryKeyword;
    }

    public ValueExpression getValueExpression() {
        return valueExpression;
    }
}
