package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     'return' { WHITESPACE } EXPRESSION
 * </pre>
 */
public class ReturnStatement extends CompositeLexeme implements StatementChoiceLexeme {

    private Expression expression;

    @Override
    protected Lexeme[] getLexemes() {
        expression = new Expression();

        return new Lexeme[]{
                new Token("return"),
                new OptionalWhitespace(),
                expression
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
