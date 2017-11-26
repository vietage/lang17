package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     'while'
 *     { WHITESPACE } BRACKETS_EXPRESSION
 *     { WHITESPACE } BLOCK
 * </pre>
 */
public class WhileLoop extends CompositeElement implements StatementChoiceElement {

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

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public BracketsExpression getBracketsExpression() {
        return bracketsExpression;
    }

    public Block getBlock() {
        return block;
    }
}
