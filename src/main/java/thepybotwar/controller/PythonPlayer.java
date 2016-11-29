package thepybotwar.controller;

import thepybotwar.input.InputMaker;
import thepybotwar.input.TankController;
import thepybotwar.input.TankLineOfSight;

/**
 * Gère le thread en fonction des inputs du joueur
 *
 * @author Nicolas
 * @version 1.0
 */
public class PythonPlayer extends InputMaker {
    PythonThread thread;
    PythonRemote remote;

    private boolean running;

    /**
     * Constructor
     * Initialise l'interpréteur de Python
     *
     * @param controller Controller du tank
     * @param sight Ligne de vu du tank
     * @param scriptString Texte du script à exécuter
     *
     * @see TankController
     * @see TankLineOfSight
     */
    public PythonPlayer(TankController controller, TankLineOfSight sight, String scriptString) {
        super(controller, sight);
        this.thread = new PythonThread(scriptString);
        this.remote = new PythonRemote(thread,controller,sight);
        thread.setRemote(remote);
        thread.initInterpreter();
        running = false;
    }

    /**
     * Gère le démarrage du thread en fonction des inputs
     */
    public synchronized void getInput() {
        if (! running) {
            running = true;
            thread.start();
        }
        thread.resume();
    }
}
