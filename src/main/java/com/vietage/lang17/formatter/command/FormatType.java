package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.Type;

import java.util.EnumMap;
import java.util.Map;
import java.util.Queue;

public class FormatType extends FormatCommand {

    private static final Map<Type, String> TYPE_NAMES = new EnumMap<>(
            Map.ofEntries(
                    Map.entry(Type.INTEGER, "int"),
                    Map.entry(Type.FLOAT, "float"),
                    Map.entry(Type.BOOLEAN, "boolean"),
                    Map.entry(Type.STRING, "string"),
                    Map.entry(Type.INTEGER_ARRAY, "int[]"),
                    Map.entry(Type.FLOAT_ARRAY, "float[]"),
                    Map.entry(Type.BOOLEAN_ARRAY, "boolean[]"),
                    Map.entry(Type.STRING_ARRAY, "string[]")
            )
    );

    private final Type type;

    public FormatType(int indent, Type type) {
        super(indent);
        this.type = type;
    }

    @Override
    public void format(IndentPrintStream out, Queue<FormatCommand> commandQueue) {
        if (type == null) {
            out.print("void", indent);
            return;
        }

        String typeName = TYPE_NAMES.get(type);

        if (typeName == null) {
            throw new RuntimeException("Unsupported type: " + type);
        }

        out.print(typeName, indent);
    }
}
