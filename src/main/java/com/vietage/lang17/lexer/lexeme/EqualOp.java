package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.parser.ast.expression.EqualityOperator;

/**
 * EBNF:
 * <pre>
 *     '==' | '!='
 * </pre>
 */
public class EqualOp extends Choice {

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("=="),
                new Token("!=")
        };
    }

    public EqualityOperator getEqualityOperator() {
        return EqualityOperator.values()[getCurrentElement()];
    }
}
