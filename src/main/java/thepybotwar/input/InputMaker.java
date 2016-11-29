package thepybotwar.input;

/**
 * Created by balthazar on 28/11/16.
 */
public abstract class InputMaker {
    protected TankController controller;
    protected TankLineOfSight sight;

    public InputMaker(TankController controller, TankLineOfSight sight) {
        this.controller = controller;
        this.sight = sight;
    }

    public TankController getController() {
        return controller;
    }

    public TankLineOfSight getSight() {
        return sight;
    }

    public abstract void getInput();
}
