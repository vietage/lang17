package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     CHAR { ALPHA_NUM }
 * </pre>
 */
public class Name extends CompositeElement {

    private final CharElement charElement = new CharElement();
    private final ZeroOrMore<AlphaNumeric> alphaNumerics = new ZeroOrMore<>(AlphaNumeric::new);

    @Override
    protected Element[] getElements() {
        return new Element[]{
                charElement,
                alphaNumerics
        };
    }
}
