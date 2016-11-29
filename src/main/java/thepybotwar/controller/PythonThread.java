package thepybotwar.controller;
// jython

import org.python.util.PythonInterpreter;

/**
 * Thread qui exécute l'interpréteur
 *
 * @author Nicolas
 * @version 1.0
 */
public class PythonThread extends Thread {
    PythonInterpreter interpreter;
    PythonRemote remote;
    String scriptString;

    /**
     * Constructor
     *
     * @param scriptString Code du script à exécuter
     */
    public PythonThread(String scriptString) {
        interpreter = new PythonInterpreter();
        this.scriptString = scriptString;
    }

    /**
     * Lance l'interprétation du script Python
     *
     * @see Thread
     */
    public void run() {
        interpreter.exec(scriptString);
    }

    /**
     * Définir toutes les fonctions Python utilisées par les scripts
     */
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
        interpreter.exec("def turnAntiClockWise() :\n\tremote.turnAntiClockWise()");
        interpreter.exec("def noAction() :\n\tremote.noAction()");
    }

    /**
     * Défini la classe utlisée par l'interpréteur
     * A utliser avant initInterpreter()
     *
     * @param remote PythonRemote
     *
     * @see PythonRemote
     */
    public void setRemote(PythonRemote remote) {
        this.remote = remote;
    }
}
