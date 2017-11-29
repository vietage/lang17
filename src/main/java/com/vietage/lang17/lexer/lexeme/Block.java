package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     '{' { WHITESPACE } { STATEMENT { WHITESPACE } } '}'
 * </pre>
 */
public class Block extends CompositeLexeme {

    private ZeroOrMore<StatementAndWhitespace> statements;

    @Override
    protected Lexeme[] getLexemes() {
        statements = new ZeroOrMore<>(StatementAndWhitespace::new);

        return new Lexeme[]{
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
