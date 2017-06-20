package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     ',' { WHITESPACE } ARGUMENT { WHITESPACE }
 * </pre>
 */
public class RestArguments extends CompositeElement {

    private final Token comma = new Token(",");
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final Argument argument = new Argument();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                comma,
                optionalWhitespace,
                argument,
                optionalWhitespace
        };
    }
}
