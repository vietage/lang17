package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     'while'
 *     { WHITESPACE } BRACKETS_EXPRESSION
 *     { WHITESPACE } BLOCK
 * </pre>
 */
public class WhileLoop extends CompositeElement {

    private final Token whileKeyword = new Token("while");
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final BracketsExpression bracketsExpression = new BracketsExpression();
    private final Block block = new Block();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                whileKeyword,
                optionalWhitespace,
                bracketsExpression,
                optionalWhitespace,
                block
        };
    }
}
