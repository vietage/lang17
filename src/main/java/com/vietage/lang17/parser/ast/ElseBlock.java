package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     'else' { WHITESPACE } BLOCK
 * </pre>
 */
public class ElseBlock extends CompositeElement {

    private Block block;

    @Override
    protected Element[] getElements() {
        block = new Block();

        return new Element[]{
                new Token("else"),
                new OptionalWhitespace(),
                block
        };
    }

    public Block getBlock() {
        return block;
    }
}
