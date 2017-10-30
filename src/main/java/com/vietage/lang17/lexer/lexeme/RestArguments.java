package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     ',' { WHITESPACE } ARGUMENT { WHITESPACE }
 * </pre>
 */
public class RestArguments extends CompositeElement {

    private Argument argument;

    @Override
    protected Element[] getElements() {
        argument = new Argument();

        return new Element[]{
                new Token(","),
                new OptionalWhitespace(),
                argument,
                new OptionalWhitespace()
        };
    }

    public Argument getArgument() {
        return argument;
    }
}
