package com.vietage.lang17.parser.lexeme;

/**
 * EBNF:
 * <pre>
 *     NAME { WHITESPACE } [ INDEX_EXPR ]
 * </pre>
 */
public class VarAccess extends CompositeElement {

    private Name name;
    private ZeroOrOne<IndexExpression> indexExpression;

    @Override
    protected Element[] getElements() {
        name = new Name();
        indexExpression = new ZeroOrOne<>(new IndexExpression());

        return new Element[]{
                name,
                new OptionalWhitespace(),
                indexExpression
        };
    }

    public Name getName() {
        return name;
    }

    public ZeroOrOne<IndexExpression> getIndexExpression() {
        return indexExpression;
    }
}
