package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Runtime;

public class Break implements State {

    @Override
    public void run(Runtime runtime) {
        while (runtime.hasState()) {
            State state = runtime.getState();

            if (state instanceof While) {
                runtime.exitState();
                return;
            } else {
                runtime.exitState();
            }
        }
    }
}
