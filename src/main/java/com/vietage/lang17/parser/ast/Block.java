package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     '{' { WHITESPACE } { STATEMENT { WHITESPACE } } '}'
 * </pre>
 */
public class Block extends CompositeElement {

    private final Token leftCurlyBracket = new Token("{");
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final ZeroOrMore<Statements> statements = new ZeroOrMore<>(Statements::new);
    private final Token rightCurlyBracket = new Token("}");

    @Override
    protected Element[] getElements() {
        return new Element[]{
                leftCurlyBracket,
                optionalWhitespace,
                statements,
                rightCurlyBracket
        };
    }
}
