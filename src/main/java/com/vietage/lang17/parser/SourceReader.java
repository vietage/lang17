package com.vietage.lang17.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SourceReader {

    private final List<String> lines;

    private String currentLine;

    private Position position = new Position(0, 0);

    public SourceReader(String file) throws IOException {
        lines = Files.readAllLines(Paths.get(file));
        currentLine = lines.iterator().next();
    }

    public boolean read(char[] cbuf) {
        int count = readChars(cbuf, 0, cbuf.length);

        while (count != cbuf.length && !isEndOfFile()) {
            position.setLine(position.getLine() + 1);
            position.setColumn(0);
            currentLine = lines.get(position.getLine());

            count += readChars(cbuf, count, cbuf.length);
        }

        return count == cbuf.length;
    }

    private int readChars(char[] cbuf, int start, int end) {
        int cbufEndIndex = start + Math.min(currentLine.length() - position.getColumn(), end - start);

        int cbufIndex = start;
        int lineIndex = position.getColumn();
        while (cbufIndex < cbufEndIndex) {
            cbuf[cbufIndex++] = currentLine.charAt(lineIndex++);
        }

        position.setColumn(lineIndex);

        return cbufIndex - start;
    }

    public boolean isEndOfFile() {
        return position.getLine() == lines.size() - 1 &&
                position.getColumn() == currentLine.length();
    }


    public void reset(Position newPosition) {
        if (newPosition.getLine() >= lines.size() - 1 ||
                newPosition.getColumn() > lines.get(newPosition.getLine()).length()) {
            throw new IllegalArgumentException("Illegal position: " + newPosition);
        }
        position = newPosition;
        currentLine = lines.get(position.getLine());
    }

    public Position getPosition() {
        return new Position(position);
    }

    public String getLine(int number) {
        if (number < 0 || number > lines.size() - 1) {
            throw new IllegalArgumentException("Illegal line number: " + number);
        }
        return lines.get(number);
    }
}
