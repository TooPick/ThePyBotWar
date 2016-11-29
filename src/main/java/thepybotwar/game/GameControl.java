package thepybotwar.game;

import thepybotwar.userinterface.PlayerInterface;

/**
 * Classe qui gère les action sur la boucle de jeu
 *
 * @author Balthazar
 * @version 1.0
 */

public abstract class GameControl {

    /**
     * Met en pause la boucle de jeu
     *
     * @param game Boucle de jeu
     *
     * @see Game
     */
    public static void pause (Game game) {
        System.out.println("game : pause");
        game.setStatus(Game.Status.PAUSE);
    }

    /**
     * Démarre la boucle de jeu
     *
     * @param game Boucle de jeu
     *
     * @see Game
     */
    public static void play (Game game) {
        System.out.println ("game : play");
        game.setStatus(Game.Status.PLAY);
    }

    /**
     * Ajoute un joueur (un tank + controller) à la boucle de jeu
     *
     * @param game Boucle de jeu
     * @param x Position x du joueur
     * @param y Position y du joueur
     *
     * @see Game
     */
    public static void addPlayer (Game game, int x, int y) {
        Player player = PlayerInterface.showPlayerCreationDialog(game, x, y);
        if (player != null) {
            game.addPlayer(player);
        }
    }

    /**
     * Supprime un joueur (un tank + controller) de la boucle de jeu
     *
     * @param game Boucle de jeu
     * @param player Joueur à supprimer
     *
     * @see Game
     * @see Player
     */
    public static void removePlayer (Game game, Player player) {
        game.removePlayer (player);
    }
}
