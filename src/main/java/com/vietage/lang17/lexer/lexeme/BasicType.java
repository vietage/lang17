package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.parser.ast.Type;

/**
 * EBNF:
 * <pre>
 *     'int' | 'float' | 'boolean' | 'string'
 * </pre>
 */
public class BasicType extends Choice {

    private static final Type[] TYPES = new Type[]{
            Type.INTEGER,
            Type.FLOAT,
            Type.BOOLEAN,
            Type.STRING
    };

    @Override
    protected Element[] getElements() {
        return new Element[]{
                new Token("int"),
                new Token("float"),
                new Token("boolean"),
                new Token("string")
        };
    }

    public Type getType() {
        return TYPES[getCurrentElement()];
    }
}
