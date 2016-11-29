package render;

import physic.Projectile;
import render.ressources.ProjectileSprite;

import java.awt.*;

/**
 * Created by balthazar on 28/11/16.
 */
public class ProjectileRenderer {
    private int tilesize;
    private int x, y;
    private int sx, sy;

    public ProjectileRenderer(Projectile projectile, int tilesize) {
        this.tilesize = tilesize;
        this.x = projectile.getX() * tilesize;
        this.y = projectile.getY() * tilesize;

        this.sx = this.sy = 0;
    }

    public boolean isMoving() {
        return (sx != 0 || sy != 0);
    }

    private void update(Projectile projectile) {
        int tx = projectile.getX()*tilesize;
        int ty = projectile.getY()*tilesize;

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


    public void render (Projectile projectile, int xOffset, int yOffset, Graphics g) {
        g.drawImage(ProjectileSprite.get(), x + xOffset, y + yOffset, null);
    }
}
