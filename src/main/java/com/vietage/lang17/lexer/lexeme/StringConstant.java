package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     '"' { STR_CHAR } '"'
 * </pre>
 */
public class StringConstant extends CompositeLexeme
        implements ConstantLexeme {

    private StringToken stringToken;

    @Override
    protected Lexeme[] getLexemes() {
        stringToken = new StringToken();

        return new Lexeme[]{
                new Token("\""),
                stringToken,
                new Token("\"")
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public StringToken getStringToken() {
        return stringToken;
    }
}
