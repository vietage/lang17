package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     'else' { WHITESPACE } BLOCK
 * </pre>
 */
public class ElseBlock extends CompositeLexeme {

    private Block block;

    @Override
    protected Lexeme[] getLexemes() {
        block = new Block();

        return new Lexeme[]{
                new Token("else"),
                new OptionalWhitespace(),
                block
        };
    }

    public Block getBlock() {
        return block;
    }
}
