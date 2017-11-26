package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     TYPE
 *     { WHITESPACE } NAME
 *     { WHITESPACE } '='
 *     { WHITESPACE } EXPRESSION
 * </pre>
 */
public class VarDefinition extends CompositeElement implements StatementChoiceElement {

    private Type type;
    private Name name;
    private Token equalsSign;
    private Expression expression;

    @Override
    protected Element[] getElements() {
        type = new Type();
        name = new Name();
        equalsSign = new Token("=");
        expression = new Expression();

        return new Element[]{
                type,
                new OptionalWhitespace(),
                name,
                new OptionalWhitespace(),
                equalsSign,
                new OptionalWhitespace(),
                expression
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type getType() {
        return type;
    }

    public Name getName() {
        return name;
    }

    public Token getEqualsSign() {
        return equalsSign;
    }

    public Expression getExpression() {
        return expression;
    }
}
