package com.vietage.lang17.lexer.lexeme;

/**
 * EBNF:
 * <pre>
 *     'break' | 'continue'
 * </pre>
 */
public class LoopOp extends Choice implements Statement {

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("break"),
                new Token("continue")
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
