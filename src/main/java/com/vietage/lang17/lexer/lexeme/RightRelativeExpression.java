package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     EQUAL_OP { WHITESPACE } REL_EXPR
 * </pre>
 */
public class RightRelativeExpression extends CompositeLexeme {

    private EqualOp equalOp;
    private RelativeExpression relativeExpression;

    @Override
    protected Lexeme[] getLexemes() {
        equalOp = new EqualOp();
        relativeExpression = new RelativeExpression();

        return new Lexeme[]{
                equalOp,
                new OptionalWhitespace(),
                relativeExpression
        };
    }

    public EqualOp getEqualOp() {
        return equalOp;
    }

    public RelativeExpression getRelativeExpression() {
        return relativeExpression;
    }
}
