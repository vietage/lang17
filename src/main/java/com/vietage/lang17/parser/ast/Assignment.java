package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     VAR_ACCESS { WHITESPACE } '=' { WHITESPACE } EXPRESSION
 * </pre>
 */
public class Assignment extends CompositeElement {

    private final VarAccess varAccess = new VarAccess();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final Token equalsSign = new Token("=");
    private final Expression expression = new Expression();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                varAccess,
                optionalWhitespace,
                equalsSign,
                optionalWhitespace,
                expression
        };
    }
}
