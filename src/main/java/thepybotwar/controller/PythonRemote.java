package thepybotwar.controller;

import thepybotwar.input.TankController;
import thepybotwar.input.TankInput;

/**
 * Classe donnée à l'interpréteur Python
 *
 * @author Nicolas
 * @version 1.0
 */

public class PythonRemote {
    PythonThread thread;
    TankController controller;
    boolean lock = false;

    /**
     * Constructor
     *
     * @param thread Thread Python
     * @param controller Controller du tank
     *
     * @see PythonThread
     * @see TankController
     */
    public PythonRemote(PythonThread thread, TankController controller) {
        this.thread = thread;
        this.controller = controller;
    }

    /**
     * Le tank tire
     * Endormissement du thread
     */
    public void shoot() {
        controller.unsetAll();
        controller.set(TankInput.SHOOT);
        thread.suspend();
    }

    /**
     * Le tank anvance droit devant lui
     * Endormissement du thread
     */
    public void moveForward() {
        controller.unsetAll();
        controller.set(TankInput.MOVEFORWARD);
        thread.suspend();
    }

    /**
     * Le tank recule
     * Endormissement du thread
     */
    public void moveBackward() {
        controller.unsetAll();
        controller.set(TankInput.MOVEBACKWARD);
        thread.suspend();
    }

    /**
     * Le tank tourne dans le sens des aiguilles d'une montre
     * Endormissement du thread
     */
    public void turnClockWise() {
        controller.unsetAll();
        controller.set(TankInput.TURNCLOCKWISE);
        thread.suspend();
    }

    /**
     * Le tank tourne dans le sens inverse des aiguilles d'une montre
     * Endormissement du thread
     */
    public void turnAntiClockWise() {
        controller.unsetAll();
        controller.set(TankInput.TURNCLOCKWISE);
        thread.suspend();
    }

    /**
     * Le tank ne fait rien
     * Endormissement du thread
     */
    public void noAction() {
        controller.unsetAll();
        controller.set(TankInput.NOACTION);
        thread.suspend();
    }
}
