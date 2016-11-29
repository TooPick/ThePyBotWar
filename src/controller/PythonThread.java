package controller;
// jython

import input.TankInput;
import org.python.util.PythonInterpreter;

/**
 * Created by balthazar on 29/11/16.
 */
public class PythonThread extends Thread {
    PythonInterpreter interpreter;
    PythonRemote remote;
    String scriptString;

    public PythonThread(String scriptString) {
        interpreter = new PythonInterpreter();
        this.scriptString = scriptString;
    }

    public void run() {
        interpreter.exec(scriptString);
    }

    public void initInterpreter() {
        interpreter.exec("import time");
        interpreter.exec("import sys");
        interpreter.exec("import inspect");
        interpreter.set("remote", remote);
        interpreter.exec("def shoot() :\n\tremote.shoot()");
        interpreter.exec("def moveForward() :\n\tremote.moveForward()");
        interpreter.exec("def moveBackward() :\n\tremote.moveBackward()");
        interpreter.exec("def turnClockWise() :\n\tremote.turnClockWise()");
        interpreter.exec("def turnAntiClockWise() :\n\tremote.turnAntiClockWise()");
        interpreter.exec("def noAction() :\n\tremote.noAction()");
    }

    public void setRemote(PythonRemote remote) {
        this.remote = remote;
    }
}
