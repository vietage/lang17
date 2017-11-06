package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     ARGUMENT { WHITESPACE } { ',' { WHITESPACE } ARGUMENT { WHITESPACE } }
 * </pre>
 */
public class Arguments extends CompositeElement {

    private Argument argument;
    private ZeroOrMore<RestArguments> restArguments;

    @Override
    protected Element[] getElements() {
        argument = new Argument();
        restArguments = new ZeroOrMore<>(RestArguments::new);

        return new Element[]{
                argument,
                new OptionalWhitespace(),
                restArguments
        };
    }

    public Argument getArgument() {
        return argument;
    }

    public ZeroOrMore<RestArguments> getRestArguments() {
        return restArguments;
    }
}