package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     NAME { WHITESPACE } '(' { WHITESPACE } [ EXPRESSIONS ] ')'
 * </pre>
 */
public class Call extends CompositeElement {

    private Name name;
    private ZeroOrOne<Expressions> expressions;

    @Override
    protected Element[] getElements() {
        name = new Name();
        expressions = new ZeroOrOne<>(new Expressions());

        return new Element[]{
                name,
                new OptionalWhitespace(),
                new Token("("),
                new OptionalWhitespace(),
                expressions,
                new Token(")")
        };
    }

    public Name getName() {
        return name;
    }

    public ZeroOrOne<Expressions> getExpressions() {
        return expressions;
    }
}
