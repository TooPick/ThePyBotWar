package thepybotwar.userinterface;

import thepybotwar.game.Game;
import thepybotwar.game.Player;
import thepybotwar.physic.Direction;

/**
 * Interfaces graphique liées au joueur
 *
 * @author Balthazar
 * @version 1.0
 */
public abstract class PlayerInterface {

    /**
     * Fenetre de création d'un nouveau joueur
     *
     * @param game Boucle de jeu
     * @param x Position x du nouveau joueur
     * @param y Position y du nouveau joueur
     * @return Nouveau joueur
     *
     * @see Player
     */
    public static Player showPlayerCreationDialog(Game game, int x, int y) {
        Player newPlayer = null;
        Player player = new Player(x, y, Direction.down, game.getScene(), "kek.py");
        return player;
    }

}
