package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     'if'
 *     { WHITESPACE } BRACKETS_EXPRESSION
 *     { WHITESPACE } BLOCK
 *     { WHITESPACE } [ ELSE_BLOCK ]
 * </pre>
 */
public class IfStatement extends CompositeLexeme implements StatementChoiceLexeme {

    private BracketsExpression bracketsExpression;
    private Block block;
    private ZeroOrOne<ElseBlock> elseBlock;

    @Override
    protected Lexeme[] getLexemes() {
        bracketsExpression = new BracketsExpression();
        block = new Block();
        elseBlock = new ZeroOrOne<>(new ElseBlock());

        return new Lexeme[]{
                new Token("if"),
                new OptionalWhitespace(),
                bracketsExpression,
                new OptionalWhitespace(),
                block,
                new OptionalWhitespace(),
                elseBlock
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public BracketsExpression getBracketsExpression() {
        return bracketsExpression;
    }

    public Block getBlock() {
        return block;
    }

    public ZeroOrOne<ElseBlock> getElseBlock() {
        return elseBlock;
    }
}
