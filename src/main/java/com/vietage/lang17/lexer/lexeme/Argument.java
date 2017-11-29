package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     TYPE { WHITESPACE } NAME
 * </pre>
 */
public class Argument extends CompositeLexeme {

    private Type type;
    private Name name;

    @Override
    protected Lexeme[] getLexemes() {
        type = new Type();
        name = new Name();

        return new Lexeme[]{
                type,
                new OptionalWhitespace(),
                name
        };
    }

    public Type getType() {
        return type;
    }

    public Name getName() {
        return name;
    }
}
