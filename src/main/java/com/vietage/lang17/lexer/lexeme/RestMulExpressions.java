package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     ADD_OP { WHITESPACE } MUL_EXPR
 * </pre>
 */
public class RestMulExpressions extends CompositeLexeme {

    private AddKeyword addKeyword;
    private MulExpression mulExpression;

    @Override
    protected Lexeme[] getLexemes() {
        addKeyword = new AddKeyword();
        mulExpression = new MulExpression();

        return new Lexeme[]{
                addKeyword,
                new OptionalWhitespace(),
                mulExpression
        };
    }

    public AddKeyword getAddKeyword() {
        return addKeyword;
    }

    public MulExpression getMulExpression() {
        return mulExpression;
    }
}
