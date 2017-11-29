package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     VAR_DEFINITION | ASSIGNMENT | IF | WHILE | LOOP_OP | CALL | RETURN
 * </pre>
 */
public class StatementChoice extends Choice {

    private StatementChoiceLexeme[] statementChoiceElements;

    @Override
    protected Lexeme[] getLexemes() {
        statementChoiceElements = new StatementChoiceLexeme[]{
                new VarDefinition(),
                new Assignment(),
                new IfStatement(),
                new WhileLoop(),
                new LoopOp(),
                new Call(),
                new ReturnStatement()
        };
        return statementChoiceElements;
    }

    public StatementChoiceLexeme getStatementChoiceElement() {
        return statementChoiceElements[getCurrentLexeme()];
    }
}
