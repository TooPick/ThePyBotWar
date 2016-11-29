package game;


import physic.Direction;
import physic.Scene;
import physic.Tank;
import render.SceneRenderer;
import userinterface.ScriptInterface;
import userinterface.TankInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by balthazar on 28/11/16.
 */

/**
 * TODO : ScriptInterface.showScriptEditor, refaire le layout + appliquer si on appuie sur le bouton.
 */
public class Game implements Runnable {
    public static enum Status {
        PLAY, PAUSE, STOP
    }

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private ArrayList<Player> players;

    public void addPlayer (Player player) {
        players.add(player);
        scene.addTank(player.getTank());
    }

    public void removePlayer (Player player) {
        players.remove(player);
        scene.removeTank(player.getTank());
    }

    private Scene scene;

    public Scene getScene() {
        return scene;
    }

    public void setScene (Scene scene) {
        this.scene = scene;
    }

    private SceneRenderer renderer;
    private Screen screen;

    // TODO : classe a part, hors de Game. C'est surement la qu'on va ajouter le MouseListener.
    /**
    public static class Screen extends JPanel {
        public Screen(Scene scene, SceneRenderer renderer) {
            super();
            setPreferredSize(new Dimension(
                    scene.getWidth()*renderer.getTilesize(), scene.getHeight()*renderer.getTilesize()
            ));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            renderer.render(scene, 0, 0, g);
        }
    }
        **/
    private String pathScript = "/home/balthazar/IdeaProjects/thepybotwar2/src/petitscript.py";

    private int activePlayer;

    public Game() {
        this.scene = new Scene(40, 20);
        this.renderer = new SceneRenderer(24);

        players = new ArrayList<>();
        players.add(new Player(14, 2, Direction.down, scene, pathScript));
        players.add(new Player(15, 7, Direction.up, scene, pathScript));
        activePlayer = 0;

        this.screen = new Screen(scene, renderer);

        screen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPopupMenu menu = new JPopupMenu();
                Tank tank = screen.getTankClicked(e);
                if (tank != null) {
                    JMenuItem appitem = new JMenuItem("editer apparance");
                    appitem.addActionListener(e1 -> {
                        TankInterface.showSkinDialog(tank, renderer);
                    });
                    menu.add(appitem);
                    JMenuItem scriptitem = new JMenuItem("editer script");
                    scriptitem.addActionListener(e12 -> {
                        ScriptInterface.showScriptDialog(getPlayerOf(tank));
                    });
                    menu.add(scriptitem);
                    menu.show(screen, e.getX(), e.getY());
                } else {

                }
            }
        });

        this.status = Status.PAUSE;
    }

    @Override
    public void run() {
        status = Status.PLAY;
        while (status != Status.STOP) {
            update();
            render();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update () {
        if (renderer.ready() && status == Status.PLAY) {
            players.get(activePlayer).update();
            activePlayer++;
            if (activePlayer >= players.size()) activePlayer = 0;
        }
    }

    private void render () {
        screen.repaint();
    }

    public JPanel getScreen () {
        return screen;
    }

    public Player getPlayerOf (Tank tank) {
        for (Player player : players) {
            if (player.getTank() == tank) return player;
        }
        return null;
    }
}
