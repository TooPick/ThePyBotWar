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
 * Classe qui représente la boucle de jeu principale
 *
 * @author Balthazar
 * @version 1.0
 *
 * TODO : ScriptInterface.showScriptEditor, refaire le layout + appliquer si on appuie sur le bouton.
 */
public class Game implements Runnable {

    /**
     * Enumération qui représente le status de la boucle jeu
     */
    public static enum Status {
        PLAY, PAUSE, STOP
    }

    private Status status;

    /**
     * Renvoi le status de la boucle de jeu
     *
     * @return Status de la boucle
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Défini le status de la boucle de jeu
     *
     * @param status Status de la boucle
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    private ArrayList<Player> players;

    /**
     * Ajoute un joueur au jeu (un tank + controller)
     *
     * @param player Joueur à ajouter
     *
     * @see Player
     */
    public void addPlayer (Player player) {
        players.add(player);
        scene.addTank(player.getTank());
    }

    /**
     * Supprime un joueur du jeu (un tank + controller)
     *
     * @param player Joueur à supprimer
     *
     * @see Player
     */
    public void removePlayer (Player player) {
        players.remove(player);
        scene.removeTank(player.getTank());
    }

    private Scene scene;

    /**
     * Renvoi la scène utilisée par le jeu
     *
     * @return Scène utilisée
     *
     * @see Scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Défini la scène utilisée par le jeu
     *
     * @param scene Scène utilisée
     *
     * @see Scene
     */
    public void setScene (Scene scene) {
        this.scene = scene;
    }

    private SceneRenderer renderer;

    /**
     * Renvoi le gestionnaire de rendu de la scène
     *
     * @return Gestionnaire de rendu
     *
     * @see SceneRenderer
     */
    public SceneRenderer getRenderer () {
        return renderer;
    }

    /**
     * Défini le gestionnaire de rendu de la scène
     *
     * @param renderer Gestionnaire de rendu
     *
     * @see SceneRenderer
     */
    public void setRenderer (SceneRenderer renderer) {
        this.renderer = renderer;
    }

    private Screen screen;

    private String baltPathScript = "scripts/petitscript.py";

    private int activePlayer;

    /**
     * Constructor
     * Initialise tous les éléments du jeu
     */
    public Game() {
        this.scene = new Scene(40, 20);
        this.renderer = new SceneRenderer(24);

        players = new ArrayList<Player>();
        players.add(new Player(14, 2, Direction.down, scene, baltPathScript));
        players.add(new Player(15, 7, Direction.up, scene, baltPathScript));
        activePlayer = 0;

        this.screen = new Screen(scene, renderer);
        screen.addMouseListener(new InterfacePopup(this));
        this.status = Status.PAUSE;
    }

    /**
     * Lancement de la boucle de jeu
     */
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

    /**
     * Met à jour tous les éléments de la scène
     */
    private void update () {
        if (renderer.ready() && status == Status.PLAY) {
            players.get(activePlayer).update();
            activePlayer++;
            if (activePlayer >= players.size()) activePlayer = 0;
        }
    }

    /**
     * Raffaichit l'affichage graphique
     */
    private void render () {
        screen.repaint();
    }

    /**
     * Renvoi la fenêtre de jeu
     *
     * @return Fenetre de jeu
     */
    public JPanel getScreen () {
        return screen;
    }

    /**
     * Renvoi le joueur (tank + controller) d'un tank donné, renvoi null si le tank n'est pas trouvé
     *
     * @param tank Tank à rechercher
     * @return Joueur trouvé
     *
     * @see Player
     */
    public Player getPlayerOf (Tank tank) {
        for (Player player : players) {
            if (player.getTank() == tank) return player;
        }
        return null;
    }
}
