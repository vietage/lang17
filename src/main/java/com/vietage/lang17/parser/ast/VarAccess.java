package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     NAME { WHITESPACE } [ INDEX_EXPR ]
 * </pre>
 */
public class VarAccess extends CompositeElement {

    private final Name name = new Name();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final ZeroOrOne<IndexExpression> indexExpression = new ZeroOrOne<>(new IndexExpression());

    @Override
    protected Element[] getElements() {
        return new Element[]{
                name,
                optionalWhitespace,
                indexExpression
        };
    }
}
