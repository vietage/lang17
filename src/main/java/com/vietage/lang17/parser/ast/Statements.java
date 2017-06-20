package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     STATEMENT { WHITESPACE }
 * </pre>
 */
public class Statements extends CompositeElement {

    private final Statement statement = new Statement();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                statement,
                optionalWhitespace
        };
    }
}
