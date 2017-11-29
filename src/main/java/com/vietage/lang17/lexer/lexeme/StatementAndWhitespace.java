package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     STATEMENT { WHITESPACE }
 * </pre>
 */
public class StatementAndWhitespace extends CompositeLexeme {

    private StatementChoice statementChoice;

    @Override
    protected Lexeme[] getLexemes() {
        statementChoice = new StatementChoice();

        return new Lexeme[]{
                statementChoice,
                new OptionalWhitespace()
        };
    }

    public StatementChoice getStatementChoice() {
        return statementChoice;
    }
}
