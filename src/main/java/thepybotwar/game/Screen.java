package thepybotwar.game;

import thepybotwar.physic.Scene;
import thepybotwar.physic.Tank;
import thepybotwar.physic.Tile;
import thepybotwar.render.SceneRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Panneau d'affichage du jeu
 *
 * @author Balthazar
 * @version 1.0
 */
public class Screen extends JPanel {
    private SceneRenderer renderer;
    private Scene scene;

    /**
     * Constructor
     *
     * @param scene Scène à afficher
     * @param renderer Gestionnaire de rendu de scène
     *
     * @see Scene
     * @see SceneRenderer
     */
    public Screen(Scene scene, SceneRenderer renderer) {
        super(true);    // double buffered.

        this.scene = scene;
        this.renderer = renderer;

        adaptSize();
    }

    /**
     * Défini le gestionnaire de rendu de scène
     *
     * @param renderer Gestionnaire de rendu de scène
     *
     * @see SceneRenderer
     */
    public void setRenderer (SceneRenderer renderer) {
        this.renderer = renderer;
        adaptSize();
    }

    /**
     * Défini la scène à afficher
     *
     * @param scene Scène à afficher
     *
     * @see Scene
     */
    public void setScene (Scene scene) {
        this.scene = scene;
        adaptSize();
    }

    /**
     * Adapte le panneau d'affichage à l'écran de l'utilisateur
     */
    private void adaptSize() {
        this.setPreferredSize(new Dimension(
                scene.getWidth()*renderer.getTilesize(), scene.getHeight()*renderer.getTilesize()
        ));
    }

    /**
     * Affichage du panneau
     *
     * @param g Support d'affichage
     */
    @Override
    protected void paintComponent(Graphics g) {
        renderer.render(scene, 0, 0, g);
    }
}
