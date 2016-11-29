package thepybotwar.game;

import thepybotwar.physic.Scene;
import thepybotwar.physic.Tank;
import thepybotwar.physic.Tile;
import thepybotwar.render.SceneRenderer;

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

    @Override
    protected void paintComponent(Graphics g) {
        renderer.render(scene, 0, 0, g);
    }
}
