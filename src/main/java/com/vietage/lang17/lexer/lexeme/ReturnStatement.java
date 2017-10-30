package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     'return' { WHITESPACE } EXPRESSION
 * </pre>
 */
public class ReturnStatement extends CompositeElement {

    private Expression expression;

    @Override
    protected Element[] getElements() {
        expression = new Expression();

        return new Element[]{
                new Token("return"),
                new OptionalWhitespace(),
                expression
        };
    }

    public Expression getExpression() {
        return expression;
    }
}
