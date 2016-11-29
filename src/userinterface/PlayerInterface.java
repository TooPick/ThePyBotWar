package userinterface;

import game.Game;
import game.Player;
import physic.Direction;

/**
 * Created by balthazar on 29/11/16.
 */
public abstract class PlayerInterface {
    public static Player showPlayerCreationDialog(Game game, int x, int y) {
        Player newPlayer = null;
        Player player = new Player(x, y, Direction.down, game.getScene(), "kek.py");
        return player;
    }

}
