package com.vietage.lang17.lexer.lexeme;

import com.vietage.lang17.parser.ast.Type;

import java.util.Map;

/**
 * EBNF:
 * <pre>
 *     'int' | 'float' | 'boolean' | 'string'
 * </pre>
 */
public class BasicType extends Choice {

    private static final Map<Integer, Type> TYPES = Map.ofEntries(
            Map.entry(0, Type.INTEGER),
            Map.entry(1, Type.FLOAT),
            Map.entry(2, Type.BOOLEAN),
            Map.entry(3, Type.STRING)
    );

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
        return TYPES.get(getCurrentElement());
    }
}
