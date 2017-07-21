package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     BRACKETS_EXPR | CONST | VAR_ACCESS | NEW_ARRAY | CALL
 * </pre>
 */
public class ValueExpression extends Choice {

    private final BracketsExpression bracketsExpression = new BracketsExpression();
    private final Constant constant = new Constant();
    private final VarAccess varAccess = new VarAccess();
    private final NewArray newArray = new NewArray();
    private final Call call = new Call();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                bracketsExpression,
                constant,
                varAccess,
                newArray,
                call
        };
    }
}
