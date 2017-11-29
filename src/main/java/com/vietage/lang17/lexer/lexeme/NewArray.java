package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     BASIC_TYPE { WHITESPACE } INDEX_EXPR
 * </pre>
 */
public class NewArray extends CompositeLexeme implements ValueExpressionLexeme {

    private BasicType basicType;
    private IndexExpression indexExpression;

    @Override
    protected Lexeme[] getLexemes() {
        basicType = new BasicType();
        indexExpression = new IndexExpression();

        return new Lexeme[]{
                basicType,
                new OptionalWhitespace(),
                indexExpression
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public BasicType getBasicType() {
        return basicType;
    }

    public IndexExpression getIndexExpression() {
        return indexExpression;
    }
}
