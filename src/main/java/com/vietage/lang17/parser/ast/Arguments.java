package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 * ARGUMENT { WHITESPACE } { ',' { WHITESPACE } ARGUMENT { WHITESPACE } } .
 * </pre>
 */
public class Arguments extends CompositeElement {

    private final Argument argument = new Argument();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final ZeroOrMore<RestArguments> restArguments = new ZeroOrMore<>(RestArguments::new);

    @Override
    protected Element[] getElements() {
        return new Element[]{
                argument,
                optionalWhitespace,
                restArguments
        };
    }
}
