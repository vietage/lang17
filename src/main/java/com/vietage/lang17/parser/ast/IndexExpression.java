package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '[' { WHITESPACE } EXPRESSION ']'
 * </pre>
 */
public class IndexExpression extends CompositeElement {

    private Expression expression;

    @Override
    protected Element[] getElements() {
        expression = new Expression();

        return new Element[]{
                new Token("["),
                new OptionalWhitespace(),
                expression,
                new Token("]")
        };
    }

    public Expression getExpression() {
        return expression;
    }
}
