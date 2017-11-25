package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.parser.ast.expression.RelationalOperator;

/**
 * EBNF:
 * <pre>
 *     '<' | '>' | '<=' | '>='
 * </pre>
 */
public class RelativeOp extends Choice {

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("<"),
                new Token("<="),
                new Token(">"),
                new Token(">=")
        };
    }

    public RelationalOperator getRelationalOperator() {
        return RelationalOperator.values()[getCurrentElement()];
    }
}
