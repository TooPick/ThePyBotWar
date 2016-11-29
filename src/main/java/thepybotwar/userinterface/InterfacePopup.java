package thepybotwar.userinterface;

import thepybotwar.game.Game;
import thepybotwar.game.Player;
import thepybotwar.physic.Scene;
import thepybotwar.physic.Tank;
import thepybotwar.render.SceneRenderer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Classe qui affiche les menus popup
 *
 * @author Balthazar
 * @version 1.0
 */

public class InterfacePopup extends MouseAdapter {
    private Game game;

    /**
     * Constructor
     *
     * @param game Boucle de jeu
     *
     * @see Game
     */
    public InterfacePopup(Game game) {
        this.game = game;
    }

    /**
     * Indique le tank qui à été cliqué sinon null
     * @param e Evènement de la souris
     * @return Tank cliqué, sinon null
     */
    private Tank getTankClicked (MouseEvent e) {
        int tx = e.getX() / game.getRenderer().getTilesize();
        int ty = e.getY() / game.getRenderer().getTilesize();

        return (game.getScene().getTankAt(tx, ty));
    }

    /**
     * Renvoi la position x du click
     *
     * @param e Evènement de la souris
     * @return Position x du click
     */
    private int getSceneX (MouseEvent e) {
        return e.getX() / game.getRenderer().getTilesize();
    }

    /**
     * Renvoi la position y du click
     *
     * @param e Evènement de la souris
     * @return Position y du click
     */
    private int getSceneY (MouseEvent e) {
        return e.getY() / game.getRenderer().getTilesize();
    }

    /**
     * Gère l'affichage des popups en fonction du click
     *
     * @param e Evènement de la souris
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Tank tank = getTankClicked(e);
        if (tank != null) {
            JPopupMenu menu = createTankMenu(tank, game);
            menu.show(game.getScreen(), e.getX(), e.getY());
        } else {
            JPopupMenu menu = createTileMenu(getSceneX(e), getSceneY(e), game);
            menu.show(game.getScreen(), e.getX(), e.getY());
        }
    }

    /**
     * Affichage de la popup de gestion d'un tank
     *
     * @param tank Tank à editer
     * @param game Boucle de jeu
     * @return Fenetre popup
     *
     * @see Tank
     * @see Game
     */
    private JPopupMenu createTankMenu (Tank tank, Game game) {
        JPopupMenu menu = new JPopupMenu();

        JMenuItem appItem = new JMenuItem("editer apparence");
        appItem.addActionListener(e -> {
            TankInterface.showSkinDialog(tank, game.getRenderer());
        });
        menu.add (appItem);

        JMenuItem scriptItem = new JMenuItem("editer script");
        scriptItem.addActionListener(e -> {
            Player player = game.getPlayerOf(tank);
            ScriptInterface.showScriptDialog(player);
        });
        menu.add(scriptItem);

        JMenuItem delItem = new JMenuItem("retirer du jeu");
        delItem.addActionListener(e -> {
            Player player = game.getPlayerOf(tank);
            game.removePlayer(player);
        });
        menu.add(delItem);

        return menu;
    }

    /**
     * Affichage de la popup de création de tuile
     *
     * @param x Position x de la tuile
     * @param y Position y de la tuile
     * @param game Boucle de jeu
     * @return Fenetre popup
     *
     * @see Game
     */
    private JPopupMenu createTileMenu (int x, int y, Game game) {
        JPopupMenu menu = new JPopupMenu();

        if (! game.getScene().tileOccupied(x, y)) {
            JMenuItem addItem = new JMenuItem("ajouter un tank");
            addItem.addActionListener(e -> {
                PlayerInterface.showPlayerCreationDialog(game, x, y);
            });
            menu.add(addItem);
        }

        JMenuItem changeItem = new JMenuItem("changer contenu case");
        changeItem.addActionListener(e -> {
        //    SceneInterface.showTileEditionDialog (game.getScene(), game.getRenderer(), x, y);
        });
        menu.add(changeItem);

        return menu;
    }
}
