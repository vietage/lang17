package com.vietage.lang17.parser;

import com.vietage.lang17.parser.ast.Program;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Lang17Parser parser = new Lang17Parser();
        Program program = parser.parse("/tmp/test");
    }
}
