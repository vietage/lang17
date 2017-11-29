package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     REL_OP { WHITESPACE } ADD_EXPR
 * </pre>
 */
public class RightAddExpression extends CompositeLexeme {

    private RelativeOp relativeOp;
    private AddExpression addExpression;

    @Override
    protected Lexeme[] getLexemes() {
        relativeOp = new RelativeOp();
        addExpression = new AddExpression();

        return new Lexeme[]{
                relativeOp,
                new OptionalWhitespace(),
                addExpression
        };
    }

    public RelativeOp getRelativeOp() {
        return relativeOp;
    }

    public AddExpression getAddExpression() {
        return addExpression;
    }
}
