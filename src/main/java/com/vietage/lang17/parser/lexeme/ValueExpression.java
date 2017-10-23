package com.vietage.lang17.parser.lexeme;

/**
 * EBNF:
 * <pre>
 *     BRACKETS_EXPR | CONST | VAR_ACCESS | NEW_ARRAY | CALL
 * </pre>
 */
public class ValueExpression extends Choice {

    private BracketsExpression bracketsExpression;
    private Constant constant;
    private VarAccess varAccess;
    private NewArray newArray;
    private Call call;

    @Override
    protected Element[] getElements() {
        bracketsExpression = new BracketsExpression();
        constant = new Constant();
        varAccess = new VarAccess();
        newArray = new NewArray();
        call = new Call();

        return new Element[]{
                bracketsExpression,
                constant,
                varAccess,
                newArray,
                call
        };
    }
}
