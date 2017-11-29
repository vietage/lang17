package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     BASIC_TYPE [ '[]' ]
 * </pre>
 */
public class Type extends CompositeLexeme {

    private BasicType basicType;
    private ZeroOrOne<Token> arrayModifier;

    @Override
    protected Lexeme[] getLexemes() {
        basicType = new BasicType();
        arrayModifier = new ZeroOrOne<>(new Token("[]"));

        return new Lexeme[]{
                basicType,
                arrayModifier
        };
    }

    public com.vietage.lang17.parser.ast.Type getType() {
        boolean isArray = arrayModifier.getResult();

        return isArray ?
                com.vietage.lang17.parser.ast.Type.getArrayType(basicType.getType()) :
                basicType.getType();
    }
}
