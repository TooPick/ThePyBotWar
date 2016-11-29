package thepybotwar.userinterface;

import thepybotwar.game.Game;
import thepybotwar.game.Player;
import thepybotwar.physic.Direction;

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
