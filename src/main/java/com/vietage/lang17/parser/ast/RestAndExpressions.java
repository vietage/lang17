package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '||' { WHITESPACE } AND_EXPR { WHITESPACE }
 * </pre>
 */
public class RestAndExpressions extends CompositeElement {

    private final Token orKeyword = new Token("||");
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final AndExpression andExpression = new AndExpression();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                orKeyword,
                optionalWhitespace,
                andExpression,
                optionalWhitespace
        };
    }
}
