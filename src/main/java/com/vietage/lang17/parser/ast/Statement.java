package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     VAR_DEFINITION | ASSIGNMENT | IF | WHILE | LOOP_OP | CALL | RETURN
 * </pre>
 */
public class Statement extends Choice {

    private VarDefinition varDefinition;
    private Assignment assignment;
    private IfStatement ifStatement;
    private WhileLoop whileLoop;
    private LoopOp loopOp;
    private Call call;
    private ReturnStatement returnStatement;

    @Override
    protected Element[] getElements() {
        varDefinition = new VarDefinition();
        assignment = new Assignment();
        ifStatement = new IfStatement();
        whileLoop = new WhileLoop();
        loopOp = new LoopOp();
        call = new Call();
        returnStatement = new ReturnStatement();

        return new Element[]{
                varDefinition,
                assignment,
                ifStatement,
                whileLoop,
                loopOp,
                call,
                returnStatement
        };
    }
}
