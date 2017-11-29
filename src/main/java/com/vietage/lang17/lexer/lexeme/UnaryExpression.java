package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     [ UNARY_OP ] { WHITESPACE } VAL_EXPR
 * </pre>
 */
public class UnaryExpression extends CompositeLexeme {

    private ZeroOrOne<UnaryKeyword> unaryKeyword;
    private ValueExpression valueExpression;

    @Override
    protected Lexeme[] getLexemes() {
        unaryKeyword = new ZeroOrOne<>(new UnaryKeyword());
        valueExpression = new ValueExpression();

        return new Lexeme[]{
                unaryKeyword,
                new OptionalWhitespace(),
                valueExpression
        };
    }

    public ZeroOrOne<UnaryKeyword> getUnaryKeyword() {
        return unaryKeyword;
    }

    public ValueExpression getValueExpression() {
        return valueExpression;
    }
}
