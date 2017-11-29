package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     MUL_OP { WHITESPACE } UNARY_EXPR { WHITESPACE }
 * </pre>
 */
public class RestUnaryExpressions extends CompositeLexeme {

    private MulKeyword mulKeyword;
    private UnaryExpression unaryExpression;

    @Override
    protected Lexeme[] getLexemes() {
        mulKeyword = new MulKeyword();
        unaryExpression = new UnaryExpression();

        return new Lexeme[]{
                mulKeyword,
                new OptionalWhitespace(),
                unaryExpression,
                new OptionalWhitespace()
        };
    }

    public MulKeyword getMulKeyword() {
        return mulKeyword;
    }

    public UnaryExpression getUnaryExpression() {
        return unaryExpression;
    }
}
