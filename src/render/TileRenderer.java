package render;

import physic.Tile;
import render.ressources.TileSprite;

import java.awt.*;

/**
 * Created by balthazar on 28/11/16.
 */
public class TileRenderer {

    public static void render (Tile tile, int xOffset, int yOffset, Graphics g) {
        if (tile == Tile.wall) {
            g.drawImage(TileSprite.wall, xOffset, yOffset, null);
        } else if (tile == Tile.empty) {
            g.drawImage(TileSprite.floor, xOffset, yOffset, null);
        }
    }
}
