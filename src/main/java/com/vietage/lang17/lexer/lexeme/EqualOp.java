package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.parser.ast.expression.EqualityOperator;

/**
 * EBNF:
 * <pre>
 *     '==' | '!='
 * </pre>
 */
public class EqualOp extends Choice {

    private static final EqualityOperator[] OPERATORS = new EqualityOperator[]{
            EqualityOperator.EQUAL,
            EqualityOperator.NOT_EQUAL
    };

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("=="),
                new Token("!=")
        };
    }

    public EqualityOperator getEqualityOperator() {
        return OPERATORS[getCurrentElement()];
    }
}
