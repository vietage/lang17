package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     VAR_DEFINITION | ASSIGNMENT | IF | WHILE | LOOP_OP | CALL | RETURN
 * </pre>
 */
public class Statement extends Choice {

    private final VarDefinition varDefinition = new VarDefinition();
    private final Assignment assignment = new Assignment();
    private final IfStatement ifStatement = new IfStatement();
    private final WhileLoop whileLoop = new WhileLoop();
    private final LoopOp loopOp = new LoopOp();
    private final Call call = new Call();
    private final ReturnStatement returnStatement = new ReturnStatement();

    @Override
    protected Element[] getElements() {
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
