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
        if (returnType.getElement() == returnType.getType()) {
            boolean isArray = returnType.getType().getArrayModifier().getResult();

            BasicType basicType = returnType.getType().getBasicType();

            if (basicType.getIntToken() == basicType.getElement()) {
                return isArray ? Type.INTEGER_ARRAY : Type.INTEGER;
            } else if (basicType.getFloatToken() == basicType.getElement()) {
                return isArray ? Type.FLOAT_ARRAY : Type.FLOAT;
            } else if (basicType.getBooleanToken() == basicType.getElement()) {
                return isArray ? Type.BOOLEAN_ARRAY : Type.BOOLEAN;
            } else if (basicType.getStringToken() == basicType.getElement()) {
                return isArray ? Type.STRING_ARRAY : Type.STRING;
            }
        }
        return null;
    }
}
