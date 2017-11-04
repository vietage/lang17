package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     STATEMENT { WHITESPACE }
 * </pre>
 */
public class StatementAndWhitespace extends CompositeElement {

    private StatementChoice statementChoice;

    @Override
    protected Element[] getElements() {
        statementChoice = new StatementChoice();

        return new Element[]{
                statementChoice,
                new OptionalWhitespace()
        };
    }

    public StatementChoice getStatementChoice() {
        return statementChoice;
    }
}
