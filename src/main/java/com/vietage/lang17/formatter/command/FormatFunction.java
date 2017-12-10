package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.Argument;
import com.vietage.lang17.parser.ast.Function;
import com.vietage.lang17.parser.ast.Type;

import java.util.Deque;
import java.util.EnumMap;
import java.util.Map;

public class FormatFunction extends FormatCommand {

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

    private final Function function;
    private boolean firstTime = true;

    protected FormatFunction(int indent, Function function) {
        super(indent);
        this.function = function;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {
        if (firstTime) {
            firstTime = false;
            commands.push(this);

            out.print(formatReturnType(function.getReturnType()), indent);
            out.print(" ", indent);
            out.print(function.getName(), indent);
            out.print("(", indent);

            formatArguments(out);

            out.println(")", indent);
            out.println("{", indent);

            commands.push(new FormatStatements(indent + 4, function.getStatements()));
        } else {
            out.println("}", indent);
        }
    }

    private void formatArguments(IndentPrintStream out) {
        boolean first = true;

        for (Argument argument : function.getArguments()) {
            if (!first) {
                out.print(", ", indent);
            }
            first = false;

            out.print(formatReturnType(argument.getType()), indent);
            out.print(argument.getName(), indent);
        }
    }

    private String formatReturnType(Type type) {
        if (type == null) {
            return "void";
        }

        String typeName = TYPE_NAMES.get(type);

        if (typeName == null) {
            throw new RuntimeException("Unsupported type: " + type);
        }

        return typeName;
    }
}
