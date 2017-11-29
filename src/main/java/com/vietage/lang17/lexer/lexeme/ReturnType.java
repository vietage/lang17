package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     'void' | TYPE
 * </pre>
 */
public class ReturnType extends Choice {

    private Type type;

    @Override
    protected Lexeme[] getLexemes() {
        type = new Type();

        return new Lexeme[]{
                new Token("void"),
                type
        };
    }

    public Type getType() {
        return getLexeme() == type ? type : null;
    }
}
