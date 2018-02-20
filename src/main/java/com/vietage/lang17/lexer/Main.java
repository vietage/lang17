package com.vietage.lang17.lexer;

import com.vietage.lang17.lexer.lexeme.Root;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Lexer lexer = new Lexer();
        Root root = lexer.read("examples/helloWorld");

        System.out.println(root);
    }
}
