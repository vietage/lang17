package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     REL_EXPR { WHITESPACE } [ RIGHT_REL_EXPR ]
 * </pre>
 */
public class EqualExpression extends CompositeLexeme {

    private RelativeExpression relativeExpression;
    private ZeroOrOne<RightRelativeExpression> rightRelativeExpression;

    @Override
    protected Lexeme[] getLexemes() {
        relativeExpression = new RelativeExpression();
        rightRelativeExpression = new ZeroOrOne<>(new RightRelativeExpression());

        return new Lexeme[]{
                relativeExpression,
                new OptionalWhitespace(),
                rightRelativeExpression
        };
    }

    public RelativeExpression getRelativeExpression() {
        return relativeExpression;
    }

    public ZeroOrOne<RightRelativeExpression> getRightRelativeExpression() {
        return rightRelativeExpression;
    }
}
