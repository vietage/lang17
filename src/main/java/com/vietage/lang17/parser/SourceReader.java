package com.vietage.lang17.parser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SourceReader {

    public static final int EOF = -1;

    private final char[] source;
    private int position = 0;

    public SourceReader(String file) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(file));
        source = new String(bytes, StandardCharsets.UTF_8).toCharArray();
    }

    public int read(char[] cbuf) {
        int endIndex = Math.min(source.length - position, cbuf.length);
        if (endIndex < 1) {
            return EOF;
        }
        int i = 0;
        while (i < endIndex) {
            cbuf[i++] = source[position++];
        }
        return i;
    }

    public void reset(int newPosition) {
        if (newPosition < 0 || newPosition > source.length) {
            throw new IllegalArgumentException("The index must be between 0 and " + source.length);
        }
        position = newPosition;
    }

    public int getPosition() {
        return position;
    }

    public boolean isEndOfFile() {
        return position == source.length;
    }
}
