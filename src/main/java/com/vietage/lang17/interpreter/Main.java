package com.vietage.lang17.interpreter;

import com.vietage.lang17.lexer.Lexer;
import com.vietage.lang17.lexer.lexeme.Root;
import com.vietage.lang17.parser.Parser;
import com.vietage.lang17.parser.ast.Program;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Lexer lexer = new Lexer();
        Root root = lexer.read("examples/quicksort");

        Parser parser = new Parser();
        Program program = parser.parse(root);

        Interpreter interpreter = new Interpreter();
        interpreter.interpret(program);
    }
}
