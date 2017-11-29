package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     VAR_ACCESS { WHITESPACE } '=' { WHITESPACE } EXPRESSION
 * </pre>
 */
public class Assignment extends CompositeLexeme implements StatementChoiceLexeme {

    private VarAccess varAccess;
    private Expression expression;

    @Override
    protected Lexeme[] getLexemes() {
        varAccess = new VarAccess();
        expression = new Expression();

        return new Lexeme[]{
                varAccess,
                new OptionalWhitespace(),
                new Token("="),
                new OptionalWhitespace(),
                expression
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public VarAccess getVarAccess() {
        return varAccess;
    }

    public Expression getExpression() {
        return expression;
    }
}
