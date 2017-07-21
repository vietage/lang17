package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     ADD_OP { WHITESPACE } MUL_EXPR
 * </pre>
 */
public class RestMulExpressions extends CompositeElement {

    private final AddKeyword addKeyword = new AddKeyword();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final MulExpression mulExpression = new MulExpression();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                addKeyword,
                optionalWhitespace,
                mulExpression
        };
    }
}
