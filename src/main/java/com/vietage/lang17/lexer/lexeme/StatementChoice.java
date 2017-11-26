package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     VAR_DEFINITION | ASSIGNMENT | IF | WHILE | LOOP_OP | CALL | RETURN
 * </pre>
 */
public class StatementChoice extends Choice {

    private StatementChoiceElement[] statementChoiceElements;

    @Override
    protected Element[] getElements() {
        statementChoiceElements = new StatementChoiceElement[]{
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

    public StatementChoiceElement getStatementChoiceElement() {
        return statementChoiceElements[getCurrentElement()];
    }
}
