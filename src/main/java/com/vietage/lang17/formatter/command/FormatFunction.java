package com.vietage.lang17.formatter.command;

import com.vietage.lang17.formatter.IndentPrintStream;
import com.vietage.lang17.parser.ast.Argument;
import com.vietage.lang17.parser.ast.Function;
import com.vietage.lang17.parser.ast.Type;
import com.vietage.lang17.parser.ast.expression.FunctionCall;
import com.vietage.lang17.parser.ast.statement.BreakStatement;
import com.vietage.lang17.parser.ast.statement.ContinueStatement;
import com.vietage.lang17.parser.ast.statement.IfStatement;
import com.vietage.lang17.parser.ast.statement.ReturnStatement;
import com.vietage.lang17.parser.ast.statement.Statement;
import com.vietage.lang17.parser.ast.statement.VariableAssignment;
import com.vietage.lang17.parser.ast.statement.VariableDefinition;
import com.vietage.lang17.parser.ast.statement.WhileLoop;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FormatFunction extends FormatCommand implements Statement.Visitor {

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
    private Deque<FormatCommand> commands;
    private boolean firstTime = true;

    protected FormatFunction(int indent, Function function) {
        super(indent);
        this.function = function;
    }

    @Override
    public void format(IndentPrintStream out, Deque<FormatCommand> commands) {
        this.commands = commands;

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

            formatStatements(out);
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

    private void formatStatements(IndentPrintStream out) {
        Iterator<Statement> it = getReverseIterator(function.getStatements());

        while (it.hasNext()) {
            it.next().visit(this);
        }
    }

    private Iterator<Statement> getReverseIterator(List<Statement> statements) {
        return new ArrayDeque<>(statements).descendingIterator();
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

    @Override
    public void visit(ContinueStatement continueStatement) {
        commands.push(new FormatContinueStatement(indent + 4, continueStatement));
    }

    @Override
    public void visit(BreakStatement breakStatement) {
        commands.push(new FormatBreakStatement(indent + 4, breakStatement));
    }

    @Override
    public void visit(FunctionCall functionCall) {
        commands.push(new FormatFunctionCall(indent + 4, functionCall));
    }

    @Override
    public void visit(WhileLoop whileLoop) {
        commands.push(new FormatWhileLoop(indent + 4, whileLoop));
    }

    @Override
    public void visit(ReturnStatement returnStatement) {
        commands.push(new FormatReturnStatement(indent + 4, returnStatement));
    }

    @Override
    public void visit(IfStatement ifStatement) {
        commands.push(new FormatIfStatement(indent + 4, ifStatement));
    }

    @Override
    public void visit(VariableDefinition variableDefinition) {
        commands.push(new FormatVariableDefinition(indent + 4, variableDefinition));
    }

    @Override
    public void visit(VariableAssignment variableAssignment) {
        commands.push(new FormatVariableAssignment(indent + 4, variableAssignment));
    }
}
