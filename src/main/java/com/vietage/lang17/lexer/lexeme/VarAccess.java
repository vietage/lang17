package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     NAME { WHITESPACE } [ INDEX_EXPR ]
 * </pre>
 */
public class VarAccess extends CompositeLexeme implements ValueExpressionLexeme {

    private Name name;
    private ZeroOrOne<IndexExpression> indexExpression;

    @Override
    protected Lexeme[] getLexemes() {
        name = new Name();
        indexExpression = new ZeroOrOne<>(new IndexExpression());

        return new Lexeme[]{
                name,
                new OptionalWhitespace(),
                indexExpression
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Name getName() {
        return name;
    }

    public ZeroOrOne<IndexExpression> getIndexExpression() {
        return indexExpression;
    }
}
