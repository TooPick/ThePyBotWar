package thepybotwar.render.ressources;

import thepybotwar.physic.Direction;

import java.awt.image.BufferedImage;

/**
 * Created by balthazar on 28/11/16.
 */
public abstract class TankSprite {
    private static SpriteSheet sheet = new SpriteSheet(24,
            "/home/balthazar/IdeaProjects/thepybotwarfinal/ThePyBotWar/src/main/java/thepybotwar/render/ressources/tanks_sprites.png");

    public static BufferedImage blue[] = {
            sheet.getSprite(0,0,1,1),
            sheet.getSprite(1,0,1,1),
            sheet.getSprite(2,0,1,1),
            sheet.getSprite(3,0,1,1)
    };

    public static BufferedImage khaki[] = {
            sheet.getSprite(0,1,1,1),
            sheet.getSprite(1,1,1,1),
            sheet.getSprite(2,1,1,1),
            sheet.getSprite(3,1,1,1)
    };


    public static BufferedImage cyan[] = {
            sheet.getSprite(0,2,1,1),
            sheet.getSprite(1,2,1,1),
            sheet.getSprite(2,2,1,1),
            sheet.getSprite(3,2,1,1)
    };

    public static BufferedImage yellow[] = {
            sheet.getSprite(0,3,1,1),
            sheet.getSprite(1,3,1,1),
            sheet.getSprite(2,3,1,1),
            sheet.getSprite(3,3,1,1)
    };


    public static BufferedImage red[] = {
            sheet.getSprite(4,0,1,1),
            sheet.getSprite(5,0,1,1),
            sheet.getSprite(6,0,1,1),
            sheet.getSprite(7,0,1,1)
    };

    public static BufferedImage pink[] = {
            sheet.getSprite(4,1,1,1),
            sheet.getSprite(5,1,1,1),
            sheet.getSprite(6,1,1,1),
            sheet.getSprite(7,1,1,1)
    };

    public static BufferedImage green[] = {
            sheet.getSprite(4,2,1,1),
            sheet.getSprite(5,2,1,1),
            sheet.getSprite(6,2,1,1),
            sheet.getSprite(7,2,1,1)
    };

    public static BufferedImage purple[] = {
            sheet.getSprite(4,3,1,1),
            sheet.getSprite(5,3,1,1),
            sheet.getSprite(6,3,1,1),
            sheet.getSprite(7,3,1,1)
    };

    private static BufferedImage[] collectionOf (TankColor color) {
        if (color == TankColor.BLUE) return blue;
        if (color == TankColor.KHAKI) return khaki;
        if (color == TankColor.CYAN) return cyan;
        if (color == TankColor.YELLOW) return yellow;
        if (color == TankColor.RED) return red;
        if (color == TankColor.PINK) return pink;
        if (color == TankColor.GREEN) return green;
        if (color == TankColor.PURPLE) return purple;
        return null;
    }

    public static BufferedImage get (TankColor color, Direction dir) {
        BufferedImage[] collection = collectionOf(color);
        if (dir == Direction.down) return collection[0];
        if (dir == Direction.up) return collection[1];
        if (dir == Direction.left) return collection[2];
        if (dir == Direction.right) return collection[3];
        return null;
    }
}
