package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     { WHITESPACE } { FUNCTION { WHITESPACE } }
 * </pre>
 */
public class Program extends CompositeElement {

    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final ZeroOrMore<FunctionAndWhitespace> functions = new ZeroOrMore<>(FunctionAndWhitespace::new);

    @Override
    protected Element[] getElements() {
        return new Element[]{
                optionalWhitespace,
                functions
        };
    }
}
