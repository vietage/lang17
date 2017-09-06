package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     STATEMENT { WHITESPACE }
 * </pre>
 */
public class Statements extends CompositeElement {

    private Statement statement;

    @Override
    protected Element[] getElements() {
        statement = new Statement();

        return new Element[]{
                statement,
                new OptionalWhitespace()
        };
    }

    public Statement getStatement() {
        return statement;
    }
}
