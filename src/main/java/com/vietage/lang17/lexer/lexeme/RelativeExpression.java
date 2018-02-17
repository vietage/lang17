package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     ADD_EXPR { WHITESPACE } [ RIGHT_ADD_EXPRESSION ]
 * </pre>
 */
public class RelativeExpression extends CompositeLexeme {

    private AddExpression addExpression;
    private ZeroOrOne<RightAddExpression> rightAddExpression;

    @Override
    protected Lexeme[] getLexemes() {
        addExpression = new AddExpression();
        rightAddExpression = new ZeroOrOne<>(new RightAddExpression());

        return new Lexeme[]{
                addExpression,
                new OptionalWhitespace(),
                rightAddExpression
        };
    }

    public AddExpression getAddExpression() {
        return addExpression;
    }

    public ZeroOrOne<RightAddExpression> getRightAddExpression() {
        return rightAddExpression;
    }
}
