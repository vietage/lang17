package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     VAR_DEFINITION | ASSIGNMENT | IF | WHILE | LOOP_OP | CALL | RETURN
 * </pre>
 */
public class StatementChoice extends Choice {

    private Statement[] statements;

    @Override
    protected Element[] getElements() {
        statements = new Statement[]{
                new VarDefinition(),
                new Assignment(),
                new IfStatement(),
                new WhileLoop(),
                new LoopOp(),
                new Call(),
                new ReturnStatement()
        };
        return statements;
    }

    public Statement getStatement() {
        return statements[getCurrentElement()];
    }
}
