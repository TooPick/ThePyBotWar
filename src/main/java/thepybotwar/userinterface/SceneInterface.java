package thepybotwar.userinterface;

import thepybotwar.physic.Scene;
import thepybotwar.physic.Tile;
import thepybotwar.render.ressources.TileSprite;

import javax.swing.*;

/**
 * Created by balthazar on 29/11/16.
 */

public abstract class SceneInterface {
    public static void showTileEditionDialog(Scene scene, int x, int y) {
        JPanel panel = new JPanel();
        JButton floorButton = new JButton(new ImageIcon(TileSprite.floor));
        floorButton.addActionListener(e -> scene.setTileAt(x, y, Tile.empty));
        JButton wallButton = new JButton((new ImageIcon(TileSprite.wall)));
        wallButton.addActionListener(e -> scene.setTileAt(x, y, Tile.wall));

        panel.add(floorButton);
        panel.add(wallButton);

        JOptionPane.showMessageDialog(null, panel, "edition Tuile", JOptionPane.PLAIN_MESSAGE);
    }
}
