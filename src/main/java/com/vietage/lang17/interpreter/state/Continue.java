package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Runtime;

public class Continue implements State {

    @Override
    public void run(Runtime runtime) {
        while (runtime.hasState()) {
            State state = runtime.getState();

            if (state instanceof While) {
                return;
            } else {
                runtime.exitState();
            }
        }
    }
}
