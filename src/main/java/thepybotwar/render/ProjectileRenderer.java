package thepybotwar.render;

import thepybotwar.physic.Projectile;
import thepybotwar.render.ressources.ProjectileSprite;

import java.awt.*;

/**
 * Classe qui gère le rendu graphique d'un projectile
 *
 * @author Balthazar
 * @version 1.0
 */
public class ProjectileRenderer {
    private int tilesize;
    private int x, y;
    private int sx, sy;

    /**
     * Constructor
     *
     * @param projectile Projectile à afficher
     * @param tilesize Nombre de pixels par tuile (taille de l'image)
     *
     * @see Projectile
     */
    public ProjectileRenderer(Projectile projectile, int tilesize) {
        this.tilesize = tilesize;
        this.x = projectile.getX() * tilesize;
        this.y = projectile.getY() * tilesize;

        this.sx = this.sy = 0;
    }

    /**
     * Permet de savoir si le projectile est en cours de mouvement
     *
     * @return Projectile en mouvement : true, sinon : false
     */
    public boolean isMoving() {
        return (sx != 0 || sy != 0);
    }

    /**
     * Mise à jour de l'affichage graphique d'un projectile
     *
     * @param projectile Projectile à mettre à jour
     *
     * @see Projectile
     */
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

    /**
     * Rendu graphique du projectile
     *
     * @param projectile Projectile à afficher
     * @param xOffset Position x absolue de l'image du projectile
     * @param yOffset Position y absolue de l'image du projectile
     * @param g Support d'affichage
     *
     * @see Projectile
     */
    public void render (Projectile projectile, int xOffset, int yOffset, Graphics g) {
        g.drawImage(ProjectileSprite.get(), x + xOffset, y + yOffset, null);
    }
}
