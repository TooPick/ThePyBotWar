package thepybotwar.game;

import thepybotwar.physic.Direction;
import thepybotwar.physic.Scene;
import thepybotwar.physic.Tank;
import thepybotwar.render.SceneRenderer;
import thepybotwar.userinterface.InterfacePopup;
import thepybotwar.userinterface.ScriptInterface;
import thepybotwar.userinterface.TankInterface;

import javax.swing.*;
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

    public SceneRenderer getRenderer () {
        return renderer;
    }

    public void setRenderer (SceneRenderer renderer) {
        this.renderer = renderer;
    }

    private Screen screen;

    private String baltPathScript = "/home/balthazar/IdeaProjects/thepybotwarfinal/ThePyBotWar/src/main/java/thepybotwar/petitscript.py";
    private String alexPathScript = "D:\\_Alex\\PROJET\\src\\main\\java\\thepybotwar\\petitscript.py";

    private int activePlayer;

    public Game() {
        this.scene = new Scene(40, 20);
        this.renderer = new SceneRenderer(24);

        players = new ArrayList<Player>();
        players.add(new Player(14, 2, Direction.down, scene, alexPathScript));
        players.add(new Player(15, 7, Direction.up, scene, alexPathScript));
        activePlayer = 0;

        this.screen = new Screen(scene, renderer);
        screen.addMouseListener(new InterfacePopup(this));
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
