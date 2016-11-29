package game;

import physic.Scene;
import physic.Tank;
import physic.Tile;
import render.SceneRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by balthazar on 29/11/16.
 */
public class Screen extends JPanel {
    private SceneRenderer renderer;
    private Scene scene;

    public Screen(Scene scene, SceneRenderer renderer) {
        super(true);    // double buffered.

        this.scene = scene;
        this.renderer = renderer;

        adaptSize();
    }

    public void setRenderer (SceneRenderer renderer) {
        this.renderer = renderer;
        adaptSize();
    }

    public void setScene (Scene scene) {
        this.scene = scene;
        adaptSize();
    }

    private void adaptSize() {
        this.setPreferredSize(new Dimension(
                scene.getWidth()*renderer.getTilesize(), scene.getHeight()*renderer.getTilesize()
        ));
    }


    public Tile getTileClicked(MouseEvent e) {
        int tx = e.getX() / renderer.getTilesize();
        int ty = e.getY() / renderer.getTilesize();

        return scene.getTileAt(tx, ty);
    }

    public Tank getTankClicked(MouseEvent e) {
        int tx = e.getX() / renderer.getTilesize();
        int ty = e.getY() / renderer.getTilesize();

        return scene.getTankAt(tx, ty);
    }


    @Override
    protected void paintComponent(Graphics g) {
        renderer.render(scene, 0, 0, g);
    }
}
