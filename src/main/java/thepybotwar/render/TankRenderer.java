package thepybotwar.render;

import thepybotwar.physic.Tank;
import thepybotwar.render.ressources.TankColor;
import thepybotwar.render.ressources.TankSprite;

import java.awt.*;

/**
 * Created by balthazar on 28/11/16.
 */
public class TankRenderer {
    private static final int healthBarLength = 20;  // en pixels.


    private TankColor color;
    private String name;

    private int tilesize;
    private int x, y;
    private int sx, sy;

    public TankRenderer (Tank tank, String name, int tilesize) {
        this.tilesize = tilesize;
        this.x = tank.getX() * tilesize;
        this.y = tank.getY() * tilesize;

        this.color = TankColor.BLUE;

        this.sx = this.sy = 0;
    }


    public boolean isMoving() {
        return (sx != 0 || sy != 0);
    }

    private void update(Tank tank) {
        int tx = tank.getX()*tilesize;
        int ty = tank.getY()*tilesize;

        if (! isMoving() && (tx != x || ty != y) ) {
            int vx = tx - x;    // calcul du vecteur
            int vy = ty - y;

            double length = Math.sqrt(vx*vx + vy*vy);   // longeur du vecteur
            double nx = vx / length;    // calcul du vecteur unitaire
            double ny = vy / length;

            int speed = 2;
            sx = (int) (nx * speed);  // vitesse = vecteur unitaire * SPEED
            sy = (int) (ny * speed);
        }

        x += sx;
        y += sy;

        if (tx == x && ty == y) {
            sx = sy = 0;
        }
    }

    public void render (Tank tank, int xOffset, int yOffset, Graphics g) {
        update(tank);
        g.drawImage(TankSprite.get(color, tank.getDirection()), x + xOffset, y + yOffset, null);

        g.setColor(Color.RED);
        g.fillRect(x + xOffset, (y-5) + yOffset, healthBarLength, 2);

        int lifeLenght = (tank.getPv() * healthBarLength) / tank.getMaxPv();
        g.setColor(Color.GREEN);
        g.fillRect(x + xOffset, (y-5) + yOffset, lifeLenght, 2);
    }

    public TankColor getColor() {
        return color;
    }

    public void setColor(TankColor color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
