package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     FUNCTION { WHITESPACE }
 * </pre>
 */
public class FunctionAndWhitespace extends CompositeElement {

    private final Function function = new Function();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                function,
                optionalWhitespace
        };
    }
}
