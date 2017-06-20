package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     'else' { WHITESPACE } BLOCK
 * </pre>
 */
public class ElseBlock extends CompositeElement {

    private final Token elseKeyword = new Token("else");
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final Block block = new Block();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                elseKeyword,
                optionalWhitespace,
                block
        };
    }
}
