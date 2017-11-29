package com.vietage.lang17.parser.command;

import com.vietage.lang17.lexer.lexeme.Arguments;
import com.vietage.lang17.lexer.lexeme.FunctionAndWhitespace;
import com.vietage.lang17.lexer.lexeme.RestArguments;
import com.vietage.lang17.parser.ast.Argument;
import com.vietage.lang17.parser.ast.Function;
import com.vietage.lang17.parser.ast.Type;

import java.util.Queue;

public class ParseFunction extends ParseCommand<FunctionAndWhitespace, Function> {

    public ParseFunction(FunctionAndWhitespace lexeme, ResultConsumer<Function> action) {
        super(lexeme, action);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        String name = lexeme.getFunction().getName().getResult();
        Type type = parseType(lexeme.getFunction().getReturnType().getType());

        Function function = new Function(name, type);

        parseArguments(function);
        parseStatements(function, commandQueue);

        resultConsumer.consume(function);
    }

    private void parseArguments(Function function) {
        if (lexeme.getFunction().getArguments().getResult()) {
            Arguments arguments = lexeme.getFunction().getArguments().getElement();

            // parse the first argument
            function.getArguments().add(parseArgument(arguments.getArgument()));

            // parse the rest arguments
            for (RestArguments restArguments : arguments.getRestArguments().getElements()) {
                function.getArguments().add(parseArgument(restArguments.getArgument()));
            }
        }
    }

    private void parseStatements(Function function, Queue<ParseCommand> commandQueue) {
        commandQueue.add(new ParseStatements(lexeme.getFunction().getBlock(),
                statement -> function.getStatements().add(statement)));
    }

    private Argument parseArgument(com.vietage.lang17.lexer.lexeme.Argument argument) {
        return new Argument(
                parseType(argument.getType()),
                argument.getName().getResult()
        );
    }

    private Type parseType(com.vietage.lang17.lexer.lexeme.Type type) {
        if (type == null) {
            // return void type
            return null;
        }
        return type.getType();
    }
}
