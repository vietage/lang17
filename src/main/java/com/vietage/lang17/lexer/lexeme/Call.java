package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     NAME { WHITESPACE } '(' { WHITESPACE } [ EXPRESSIONS ] ')'
 * </pre>
 */
public class Call extends CompositeLexeme
        implements StatementChoiceLexeme, ValueExpressionLexeme {

    private Name name;
    private ZeroOrOne<Expressions> expressions;

    @Override
    protected Lexeme[] getLexemes() {
        name = new Name();
        expressions = new ZeroOrOne<>(new Expressions());

        return new Lexeme[]{
                name,
                new OptionalWhitespace(),
                new Token("("),
                new OptionalWhitespace(),
                expressions,
                new Token(")")
        };
    }

    @Override
    public void accept(StatementChoiceLexeme.Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(ValueExpressionLexeme.Visitor visitor) {
        visitor.visit(this);
    }

    public Name getName() {
        return name;
    }

    public ZeroOrOne<Expressions> getExpressions() {
        return expressions;
    }
}
