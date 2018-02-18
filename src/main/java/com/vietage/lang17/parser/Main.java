package com.vietage.lang17.parser;

import com.vietage.lang17.formatter.Formatter;
import com.vietage.lang17.lexer.Lexer;
import com.vietage.lang17.lexer.lexeme.Root;
import com.vietage.lang17.parser.ast.Program;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        format("examples/formatterTest1");
        format("examples/formatterTest2");
        format("examples/formatterTest3");
        format("examples/formatterTest4");
//        format("examples/formatterTest5");
    }

    private static void format(String sourceFile) throws IOException {
        Lexer lexer = new Lexer();
        Root root = lexer.read(sourceFile);

        Parser parser = new Parser();
        Program program = parser.parse(root);

        Formatter formatter = new Formatter();
        formatter.format(program, System.out);
    }
}
