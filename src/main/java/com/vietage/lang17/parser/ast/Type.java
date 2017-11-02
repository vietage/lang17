package com.vietage.lang17.parser.ast;

import java.util.EnumMap;
import java.util.Map;

public enum Type {

    INTEGER,
    FLOAT,
    BOOLEAN,
    STRING,
    INTEGER_ARRAY,
    FLOAT_ARRAY,
    BOOLEAN_ARRAY,
    STRING_ARRAY;

    private static final Map<Type, Type> TYPE_TO_ARRAY_TYPE = new EnumMap<>(
            Map.ofEntries(
                    Map.entry(INTEGER, INTEGER_ARRAY),
                    Map.entry(FLOAT, FLOAT_ARRAY),
                    Map.entry(BOOLEAN, BOOLEAN_ARRAY),
                    Map.entry(STRING, STRING_ARRAY)
            ));

    public static Type getArrayType(Type type) {
        return TYPE_TO_ARRAY_TYPE.get(type);
    }
}
