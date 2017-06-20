package com.vietage.lang17.parser.ast;

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

    private final ReturnType returnType = new ReturnType();
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final Name name = new Name();
    private final Token leftParenthesis = new Token("(");
    private final ZeroOrOne<Arguments> arguments = new ZeroOrOne<>(new Arguments());
    private final Token rightParenthesis = new Token(")");
    private final Block block = new Block();

    @Override
    protected Element[] getElements() {
        return new Element[]{
                returnType,
                optionalWhitespace,
                name,
                optionalWhitespace,
                leftParenthesis,
                optionalWhitespace,
                arguments,
                rightParenthesis,
                optionalWhitespace,
                block
        };
    }
}
