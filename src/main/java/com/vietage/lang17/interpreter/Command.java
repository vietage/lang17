package com.vietage.lang17.interpreter;

import java.util.Deque;

public interface Command {

    void run(Deque<Command> commands);
}
