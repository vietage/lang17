package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     '{' { WHITESPACE } { STATEMENT { WHITESPACE } } '}'
 * </pre>
 */
public class Block extends CompositeElement {

    private ZeroOrMore<StatementAndWhitespace> statements;

    @Override
    protected Element[] getElements() {
        statements = new ZeroOrMore<>(StatementAndWhitespace::new);

        return new Element[]{
                new Token("{"),
                new OptionalWhitespace(),
                statements,
                new Token("}")
        };
    }

    public ZeroOrMore<StatementAndWhitespace> getStatements() {
        return statements;
    }
}
