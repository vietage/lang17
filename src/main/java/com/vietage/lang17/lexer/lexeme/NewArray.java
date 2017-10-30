package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     BASIC_TYPE { WHITESPACE } INDEX_EXPR
 * </pre>
 */
public class NewArray extends CompositeElement {

    private BasicType basicType;
    private IndexExpression indexExpression;

    @Override
    protected Element[] getElements() {
        basicType = new BasicType();
        indexExpression = new IndexExpression();

        return new Element[]{
                basicType,
                new OptionalWhitespace(),
                indexExpression
        };
    }

    public BasicType getBasicType() {
        return basicType;
    }

    public IndexExpression getIndexExpression() {
        return indexExpression;
    }
}
