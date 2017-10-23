package com.vietage.lang17.parser.lexeme;

/**
 * EBNF:
 * <pre>
 *     'while'
 *     { WHITESPACE } BRACKETS_EXPRESSION
 *     { WHITESPACE } BLOCK
 * </pre>
 */
public class WhileLoop extends CompositeElement {

    private BracketsExpression bracketsExpression;
    private Block block;

    @Override
    protected Element[] getElements() {
        bracketsExpression = new BracketsExpression();
        block = new Block();

        return new Element[]{
                new Token("while"),
                new OptionalWhitespace(),
                bracketsExpression,
                new OptionalWhitespace(),
                block
        };
    }

    public BracketsExpression getBracketsExpression() {
        return bracketsExpression;
    }

    public Block getBlock() {
        return block;
    }
}
