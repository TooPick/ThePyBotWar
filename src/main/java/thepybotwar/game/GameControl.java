package thepybotwar.game;

import thepybotwar.userinterface.PlayerInterface;

/**
 * Created by balthazar on 29/11/16.
 */

public abstract class GameControl {
    public static void pause (Game game) {
        System.out.println("game : pause");
        game.setStatus(Game.Status.PAUSE);
    }

    public static void play (Game game) {
        System.out.println ("game : play");
        game.setStatus(Game.Status.PLAY);
    }

    public static void addPlayer (Game game, int x, int y) {
        Player player = PlayerInterface.showPlayerCreationDialog(game, x, y);
        if (player != null) {
            game.addPlayer(player);
        }
    }

    public static void removePlayer (Game game, Player player) {
        game.removePlayer (player);
    }
}
