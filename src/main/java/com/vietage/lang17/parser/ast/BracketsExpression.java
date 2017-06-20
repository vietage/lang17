package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '(' { WHITESPACE } EXPRESSION ')'
 * </pre>
 */
public class BracketsExpression extends CompositeElement {

    private final Token leftParenthesis = new Token("(");
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final Expression expression = new Expression();
    private final Token rightParenthesis = new Token(")");

    @Override
    protected Element[] getElements() {
        return new Element[]{
                leftParenthesis,
                optionalWhitespace,
                expression,
                rightParenthesis
        };
    }
}
