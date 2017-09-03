package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     BASIC_TYPE { WHITESPACE } INDEX_EXPR
 * </pre>
 */
public class NewArray extends CompositeElement {

    private final BasicType basicType = new BasicType();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final IndexExpression indexExpression = new IndexExpression();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                basicType,
                optionalWhitespace,
                indexExpression
        };
    }
}
