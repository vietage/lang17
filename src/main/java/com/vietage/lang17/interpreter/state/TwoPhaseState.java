package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Runtime;

public abstract class TwoPhaseState implements State {

    private boolean init = true;

    abstract void onInitialize(Runtime runtime);

    abstract void onReturn(Runtime runtime);

    @Override
    public void run(Runtime runtime) {
        if (init) {
            init = false;

            onInitialize(runtime);
        } else {
            runtime.exitState();

            onReturn(runtime);
        }
    }
}
