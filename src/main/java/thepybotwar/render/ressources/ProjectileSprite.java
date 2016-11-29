package thepybotwar.render.ressources;

import java.awt.image.BufferedImage;

/**
 * Created by balthazar on 28/11/16.
 */
public abstract class ProjectileSprite {
    private static SpriteSheet sheet = new SpriteSheet(24,
            "/home/balthazar/IdeaProjects/thepybotwarfinal/ThePyBotWar/src/main/java/thepybotwar/render/ressources/projectiles_spritesheet.png");

    private static BufferedImage projectile = sheet.getSprite(0, 0, 1, 1);

    public static BufferedImage get() {
        return projectile;
    }
}
