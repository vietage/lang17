package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.parser.ast.expression.RelationalOperator;

/**
 * EBNF:
 * <pre>
 *     '<' | '>' | '<=' | '>='
 * </pre>
 */
public class RelativeOp extends Choice {

    private static final RelationalOperator[] RELATIONAL_OPERATORS =
            new RelationalOperator[]{
                    RelationalOperator.LESS,
                    RelationalOperator.GREATER,
                    RelationalOperator.LESS_OR_EQUAL,
                    RelationalOperator.GREATER_OR_EQUAL
            };

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("<"),
                new Token(">"),
                new Token("<="),
                new Token(">=")
        };
    }

    public RelationalOperator getRelationalOperator() {
        return RELATIONAL_OPERATORS[getCurrentElement()];
    }
}
