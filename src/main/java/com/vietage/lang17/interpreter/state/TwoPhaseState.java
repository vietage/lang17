package com.vietage.lang17.interpreter.state;

import com.vietage.lang17.interpreter.Runtime;

public abstract class TwoPhaseState implements State {

    private boolean init = true;

    protected abstract void onInitialize(Runtime runtime);

    protected abstract void onReturn(Runtime runtime);

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
