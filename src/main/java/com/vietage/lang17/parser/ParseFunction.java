package com.vietage.lang17.parser;

import com.vietage.lang17.lexer.lexeme.BasicType;
import com.vietage.lang17.lexer.lexeme.FunctionAndWhitespace;
import com.vietage.lang17.lexer.lexeme.ReturnType;
import com.vietage.lang17.parser.ast.Function;
import com.vietage.lang17.parser.ast.Type;

import java.util.Queue;

public class ParseFunction extends ParseCommand<FunctionAndWhitespace, Function> {

    public ParseFunction(FunctionAndWhitespace lexeme, ParseAction<Function> action) {
        super(lexeme, action);
    }

    @Override
    public void parse(Queue<ParseCommand> commandQueue) {
        String name = lexeme.getFunction().getName().getResult();
        Type type = parseReturnType(lexeme.getFunction().getReturnType());

        Function function = new Function(name, type);

        action.doAction(function);

        // TODO parse function arguments and statements
    }

    private Type parseReturnType(ReturnType returnType) {
        com.vietage.lang17.lexer.lexeme.Type type = returnType.getType();

        if (type == null) {
            // return void type
            return null;
        }

        boolean isArray = type.getArrayModifier().getResult();

        BasicType basicType = type.getBasicType();

        return isArray ?
                Type.getArrayType(basicType.getType()) :
                basicType.getType();
    }
}
