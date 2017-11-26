package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     '(' { WHITESPACE } EXPRESSION ')'
 * </pre>
 */
public class BracketsExpression extends CompositeElement
        implements ValueExpressionElement {

    private Expression expression;

    @Override
    protected Element[] getElements() {
        expression = new Expression();

        return new Element[]{
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
