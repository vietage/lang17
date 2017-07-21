package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     [ UNARY_OP ] { WHITESPACE } VAL_EXPR
 * </pre>
 */
public class UnaryExpression extends CompositeElement {

    private final ZeroOrOne<UnaryKeyword> unaryKeyword = new ZeroOrOne<>(new UnaryKeyword());
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final ValueExpression valueExpression = new ValueExpression();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                unaryKeyword,
                optionalWhitespace,
                valueExpression
        };
    }
}
