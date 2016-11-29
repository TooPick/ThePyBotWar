package controller;

import input.InputMaker;
import input.TankController;
import input.TankLineOfSight;

/**
 * Created by balthazar on 29/11/16.
 */
public class PythonPlayer extends InputMaker {
    PythonThread thread;
    PythonRemote remote;

    private boolean running;

    public PythonPlayer(TankController controller, TankLineOfSight sight, String scriptString) {
        super(controller, sight);
        this.thread = new PythonThread(scriptString);
        this.remote = new PythonRemote(thread,controller);
        thread.setRemote(remote);
        thread.initInterpreter();

        running = false;
    }

    public synchronized void getInput() {
        if (! running) {
            running = true;
            thread.start();
        }
        thread.resume();
    }
}
