package thepybotwar.controller;

import thepybotwar.input.TankController;
import thepybotwar.input.TankInput;

/**
 * Created by balthazar on 29/11/16.
 */

public class PythonRemote {
    PythonThread thread;
    TankController controller;
    boolean lock = false;

    public PythonRemote(PythonThread thread, TankController controller) {
        this.thread = thread;
        this.controller = controller;
    }

    public void shoot() {
        controller.unsetAll();
        controller.set(TankInput.SHOOT);
        thread.suspend();
    }

    public void moveForward() {
        controller.unsetAll();
        controller.set(TankInput.MOVEFORWARD);
        thread.suspend();
    }

    public void moveBackward() {
        controller.unsetAll();
        controller.set(TankInput.MOVEBACKWARD);
        thread.suspend();
    }

    public void turnClockWise() {
        controller.unsetAll();
        controller.set(TankInput.TURNCLOCKWISE);
        thread.suspend();
    }

    public void turnAntiClockWise() {
        controller.unsetAll();
        controller.set(TankInput.TURNCLOCKWISE);
        thread.suspend();
    }

    public void noAction() {
        controller.unsetAll();
        controller.set(TankInput.NOACTION);
        thread.suspend();
    }

	public void unLock() {
        lock = false;
    }

    public synchronized void waitNextInput() {
        boolean lock = true;
        try {
            thread.wait();
        } catch (InterruptedException e) {
          //  e.printStackTrace();
        }
    }
}
