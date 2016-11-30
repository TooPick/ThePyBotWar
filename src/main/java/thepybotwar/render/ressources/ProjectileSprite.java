package thepybotwar.render.ressources;

import java.awt.image.BufferedImage;

/**
 * Classe qui représente le sprite d'un projectile
 *
 * @author Balthazar
 * @version 1.0
 */
public abstract class ProjectileSprite {
    private static SpriteSheet sheet = new SpriteSheet(24,
            "images/projectiles_spritesheet.png");

    private static BufferedImage projectile = sheet.getSprite(0, 0, 1, 1);

    /**
     * Renvoi le sprite du projectile
     *
     * @return Sprite du projectile
     */
    public static BufferedImage get() {
        return projectile;
    }
}
