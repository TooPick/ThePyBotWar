package thepybotwar.render;

import thepybotwar.physic.Tile;
import thepybotwar.render.ressources.TileSprite;

import java.awt.*;

/**
 * Classe qui gère le rendu graphique d'une tuile de la scène
 *
 * @author Balthazar
 * @version 1.0
 */
public class TileRenderer {

    /**
     * Rendu graphique de la tuile
     *
     * @param tile Tuile à afficher
     * @param xOffset Position x absolue de l'image de la tuile
     * @param yOffset Position y absolue de l'image de la tuile
     * @param g Support d'affichage
     *
     * @see Tile
     */
    public static void render (Tile tile, int xOffset, int yOffset, Graphics g) {
        if (tile == Tile.wall) {
            g.drawImage(TileSprite.wall, xOffset, yOffset, null);
        } else if (tile == Tile.empty) {
            g.drawImage(TileSprite.floor, xOffset, yOffset, null);
        }
    }
}
