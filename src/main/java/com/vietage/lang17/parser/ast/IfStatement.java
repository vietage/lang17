package com.vietage.lang17.parser.ast;

/**
 * EBNF:
 * <pre>
 *     'if'
 *     { WHITESPACE } BRACKETS_EXPRESSION
 *     { WHITESPACE } BLOCK
 *     { WHITESPACE } [ ELSE_BLOCK ]
 * </pre>
 */
public class IfStatement extends CompositeElement {

    private final Token ifKeyword = new Token("if");
    private final OptionalWhitespace optionalWhitespace = new OptionalWhitespace();
    private final BracketsExpression bracketsExpression = new BracketsExpression();
    private final Block block = new Block();
    private final ZeroOrOne<ElseBlock> elseBlock = new ZeroOrOne<>(new ElseBlock());

    @Override
    protected Element[] getElements() {
        return new Element[]{
                ifKeyword,
                optionalWhitespace,
                bracketsExpression,
                optionalWhitespace,
                block,
                optionalWhitespace,
                elseBlock
        };
    }
}
