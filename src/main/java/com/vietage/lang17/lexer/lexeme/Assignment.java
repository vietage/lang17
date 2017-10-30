package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     VAR_ACCESS { WHITESPACE } '=' { WHITESPACE } EXPRESSION
 * </pre>
 */
public class Assignment extends CompositeElement {

    private VarAccess varAccess;
    private Expression expression;

    @Override
    protected Element[] getElements() {
        varAccess = new VarAccess();
        expression = new Expression();

        return new Element[]{
                varAccess,
                new OptionalWhitespace(),
                new Token("="),
                new OptionalWhitespace(),
                expression
        };
    }

    public VarAccess getVarAccess() {
        return varAccess;
    }

    public Expression getExpression() {
        return expression;
    }
}
