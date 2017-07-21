package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     'return' { WHITESPACE } EXPRESSION
 * </pre>
 */
public class ReturnStatement extends CompositeElement {

    private final Token returnKeyword = new Token("return");
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final Expression expression = new Expression();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                returnKeyword,
                optionalWhitespace,
                expression
        };
    }
}
