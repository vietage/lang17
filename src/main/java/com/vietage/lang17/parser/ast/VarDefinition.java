package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     TYPE
 *     { WHITESPACE } NAME
 *     { WHITESPACE } '='
 *     { WHITESPACE } EXPRESSION
 * </pre>
 */
public class VarDefinition extends CompositeElement {

    private final Type type = new Type();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final Name name = new Name();
    private final Token equalsSign = new Token("=");
    private final Expression expression = new Expression();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                type,
                optionalWhitespace,
                name,
                optionalWhitespace,
                equalsSign,
                optionalWhitespace,
                expression
        };
    }
}
