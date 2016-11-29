package thepybotwar.game;

import thepybotwar.controller.PythonPlayer;
import thepybotwar.input.InputMaker;
import thepybotwar.input.TankAction;
import thepybotwar.input.TankController;
import thepybotwar.input.TankLineOfSight;
import thepybotwar.physic.Direction;
import thepybotwar.physic.Scene;
import thepybotwar.physic.Tank;
import thepybotwar.script.Script;

/**
 * Created by balthazar on 29/11/16.
 */
public class Player {
    private InputMaker player;
    private TankController controller;
    private TankLineOfSight sight;
    private Tank tank;

    private Script script;

    public Player(int x, int y, Direction direction, Scene scene, String scriptPath) {
        this.script = new Script(scriptPath);

        this.tank = new Tank(x, y, direction, scene);
        this.controller = new TankController();
        this.sight = new TankLineOfSight();
        this.player = new PythonPlayer(controller, sight, script.getExecutedCode());
    }

    public void update() {
        TankAction.sight(tank, sight);
        player.getInput();
        TankAction.update(controller, tank);
    }

    public Script getScript () {
        return script;
    }

    public Tank getTank () {
        return tank;
    }

    public TankLineOfSight getSight () {
        return sight;
    }

    public TankController getController () {
        return controller;
    }

    public void setInputMaker (InputMaker player) {
        this.player = player;
    }
}
