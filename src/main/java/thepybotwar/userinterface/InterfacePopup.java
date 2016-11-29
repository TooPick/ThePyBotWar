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
 * Created by balthazar on 29/11/16.
 */

public class InterfacePopup extends MouseAdapter {
    private Game game;

    public InterfacePopup(Game game) {
        this.game = game;
    }

    private Tank getTankClicked (MouseEvent e) {
        int tx = e.getX() / game.getRenderer().getTilesize();
        int ty = e.getY() / game.getRenderer().getTilesize();

        return (game.getScene().getTankAt(tx, ty));
    }

    private int getSceneX (MouseEvent e) {
        return e.getX() / game.getRenderer().getTilesize();
    }

    private int getSceneY (MouseEvent e) {
        return e.getY() / game.getRenderer().getTilesize();
    }

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
