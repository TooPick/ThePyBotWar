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
 * Classe qui représente un joueur (un tank + un controller + une ligne de vue + un gestionnaire d'input)
 *
 * @author Balthazar
 * @version 1.0
 */
public class Player {
    private InputMaker player;
    private TankController controller;
    private TankLineOfSight sight;
    private Tank tank;

    private Script script;

    /**
     * Constructor
     *
     * @param x Position x du joueur
     * @param y Position y du joueur
     * @param direction Direction du tank
     * @param scene Scène ou va être instancié le joueur
     * @param scriptPath Chemin du script que le tank va exécuter
     *
     * @see Direction
     * @see Scene
     */
    public Player(int x, int y, Direction direction, Scene scene, String scriptPath) {
        this.script = new Script(scriptPath);

        this.tank = new Tank(x, y, direction, scene);
        this.controller = new TankController();
        this.sight = new TankLineOfSight();
        this.player = new PythonPlayer(controller, sight, script.getExecutedCode());
    }

    /**
     * Met à jour la ligne de vue du tank, récupère les actions à effectuer et les exécutes
     */
    public void update() {
        TankAction.sight(tank, sight);
        player.getInput();
        TankAction.update(controller, tank);
    }

    /**
     * Renvoi le script exécuté par le tank
     *
     * @return Script du tank
     *
     * @see Script
     */
    public Script getScript () {
        return script;
    }

    /**
     * Renvoi le tank du joueur
     *
     * @return Le tank
     *
     * @see Tank
     */
    public Tank getTank () {
        return tank;
    }

    /**
     * Renvoi la ligne de vue du tank
     *
     * @return Ligne de vue
     *
     * @see TankLineOfSight
     */
    public TankLineOfSight getSight () {
        return sight;
    }

    /**
     * Renvoi le controller du tank
     *
     * @return Controller du tank
     *
     * @see TankController
     */
    public TankController getController () {
        return controller;
    }

    /**
     * Défini le gestionnaire d'action à effectuer
     *
     * @param player Gestionnaire d'action à effectuer
     *
     * @see InputMaker
     */
    public void setInputMaker (InputMaker player) {
        this.player = player;
    }

	public void setExecutedCode (String code) {
		script.setExecutedCode(code);
		player = new PythonPlayer(controller, sight, script.getExecutedCode());
	}
}
