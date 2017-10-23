package com.vietage.lang17.parser;

import com.vietage.lang17.parser.lexeme.Program;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Lang17Parser parser = new Lang17Parser();
        Program program = parser.parse("examples/helloWorld");
        System.out.println(program);
    }
}
