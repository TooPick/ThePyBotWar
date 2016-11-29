package thepybotwar.input;

/**
 * Created by balthazar on 28/11/16.
 */
public class TankController {
    private InputMaker source;
    private boolean requested[];

    public TankController() {
        this.requested = new boolean[TankInput.getNbId()];
    }

    public void unset (TankInput input) {
        this.requested[input.getId()] = false;
    }

    public void set (TankInput input) {
        this.requested[input.getId()] = true;
    }

    public void unsetAll () {
        for (int i = 0; i< requested.length; i++)
            requested[i] = false;
    }

    public boolean isSet (TankInput input) {
        return requested[input.getId()];
    }
}
