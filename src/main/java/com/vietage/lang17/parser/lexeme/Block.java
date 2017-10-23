package com.vietage.lang17.parser.lexeme;

/**
 * EBNF:
 * <pre>
 *     '{' { WHITESPACE } { STATEMENT { WHITESPACE } } '}'
 * </pre>
 */
public class Block extends CompositeElement {

    private ZeroOrMore<Statements> statements;

    @Override
    protected Element[] getElements() {
        statements = new ZeroOrMore<>(Statements::new);

        return new Element[]{
                new Token("{"),
                new OptionalWhitespace(),
                statements,
                new Token("}")
        };
    }

    public ZeroOrMore<Statements> getStatements() {
        return statements;
    }
}
