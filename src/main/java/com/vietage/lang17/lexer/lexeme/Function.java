package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     RETURN_TYPE
 *     { WHITESPACE } NAME
 *     { WHITESPACE } '('
 *     { WHITESPACE } [ ARGUMENTS ] ')'
 *     { WHITESPACE } BLOCK
 * </pre>
 */
public class Function extends CompositeElement {

    private ReturnType returnType;
    private Name name;
    private ZeroOrOne<Arguments> arguments;
    private Block block;

    @Override
    protected Element[] getElements() {
        returnType = new ReturnType();
        name = new Name();
        arguments = new ZeroOrOne<>(new Arguments());
        block = new Block();

        return new Element[]{
                returnType,
                new OptionalWhitespace(),
                name,
                new OptionalWhitespace(),
                new Token("("),
                new OptionalWhitespace(),
                arguments,
                new Token(")"),
                new OptionalWhitespace(),
                block
        };
    }

    public ReturnType getReturnType() {
        return returnType;
    }

    public Name getName() {
        return name;
    }

    public ZeroOrOne<Arguments> getArguments() {
        return arguments;
    }

    public Block getBlock() {
        return block;
    }
}
