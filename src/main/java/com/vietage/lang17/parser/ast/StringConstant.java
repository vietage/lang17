package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '"' { STR_CHAR } '"'
 * </pre>
 */
public class StringConstant extends CompositeElement {

    private final Token quotationMark = new Token("\"");
    private final StringToken stringToken = new StringToken();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                quotationMark,
                stringToken,
                quotationMark
        };
    }
}
