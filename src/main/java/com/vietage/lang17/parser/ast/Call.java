package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     NAME { WHITESPACE } '(' { WHITESPACE } [ EXPRESSIONS ] ')'
 * </pre>
 */
public class Call extends CompositeElement {

    private final Name name = new Name();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final Token leftParenthesis = new Token("(");
    private final ZeroOrOne<Expressions> expressions = new ZeroOrOne<>(new Expressions());
    private final Token rightParenthesis = new Token(")");

    @Override
    protected Element[] getElements() {
        return new Element[]{
                name,
                optionalWhitespace,
                leftParenthesis,
                optionalWhitespace,
                expressions,
                rightParenthesis
        };
    }
}
