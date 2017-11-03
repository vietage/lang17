package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     STATEMENT { WHITESPACE }
 * </pre>
 */
public class StatementAndWhitespace extends CompositeElement {

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
