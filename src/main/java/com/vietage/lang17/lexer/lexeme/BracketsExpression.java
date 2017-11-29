package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     '(' { WHITESPACE } EXPRESSION ')'
 * </pre>
 */
public class BracketsExpression extends CompositeLexeme
        implements ValueExpressionLexeme {

    private Expression expression;

    @Override
    protected Lexeme[] getLexemes() {
        expression = new Expression();

        return new Lexeme[]{
                new Token("("),
                new OptionalWhitespace(),
                expression,
                new Token(")")
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Expression getExpression() {
        return expression;
    }
}
