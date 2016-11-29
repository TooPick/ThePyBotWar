package thepybotwar.render.ressources;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Classe qui représente un SpriteSheet (image composée de plusieurs images)
 *
 * @author Balthazar
 * @version 1.0
 */
public class SpriteSheet {
    private BufferedImage spriteSheet;
    private int spriteSize;

    /**
     * Creer un spritesheet depuis une image déjà en memoire.
     *
     * @param spritesize : la taille des sprites contenus.
     * @param ss : l'image a utiliser comme source.
     */
    public SpriteSheet(int spritesize, BufferedImage ss) {
        this.spriteSheet = ss;
        this.spriteSize = spritesize;
    }

    /**
     * Créer un spritesheet depuis un fichier image.
     *
     * @param spritesize : la taille des sprites contenus.
     * @param relativepath : le fichier a utiliser comme source.
     */
    public SpriteSheet(int spritesize, String relativepath) {

        try {
            this.spriteSheet = BufferedImageLoader.loadImage(relativepath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.spriteSize = spritesize;
    }

    /**
     * Retourne le sprite a la position voulue.
     *
     * @param x : position horizontale du sprite (en sprites)
     * @param y : position verticale du sprite (en sprites)
     * @param width : largeur du sprite (en sprites)
     * @param height : hauteurs du sprite (en sprites)
     * @return : le sprite a cette position avec ces dimensions.
     */
    public BufferedImage getSprite (int x, int y, int width, int height) {
        return spriteSheet.getSubimage(x*spriteSize, y*spriteSize,
                width*spriteSize, height*spriteSize);
    }
}
