package thepybotwar.render.ressources;

import java.awt.image.BufferedImage;

/**
 * Created by balthazar on 28/11/16.
 */
public abstract class TileSprite {
    private static SpriteSheet sheet = new SpriteSheet(24,
            "D:\\_Alex\\PROJET-GL\\src\\main\\java\\thepybotwar\\render\\ressources\\components_spritesheet.png");

    public static BufferedImage wall = sheet.getSprite(0, 0, 1, 1);
    public static BufferedImage floor = sheet.getSprite(1, 0, 1, 1);
}
