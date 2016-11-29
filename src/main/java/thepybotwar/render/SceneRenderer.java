package thepybotwar.render;

import thepybotwar.physic.Projectile;
import thepybotwar.physic.Scene;
import thepybotwar.physic.Tank;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe qui gère le rendu graphique de la scène
 *
 * @author Balthazar
 * @version 1.0
 */
public class SceneRenderer {
    private int tilesize;

    private Map<Tank, TankRenderer> tankRenderers;
    private Map<Projectile, ProjectileRenderer> projectileRenderers;

    /**
     * Constructor
     *
     * @param tilesize Nombre de pixels par tuile (taille de l'image)
     */
    public SceneRenderer(int tilesize) {
        this.tilesize = tilesize;
        this.tankRenderers = new HashMap<Tank, TankRenderer>();
        this.projectileRenderers = new HashMap<Projectile, ProjectileRenderer>();
    }

    /**
     * Rendu graphique de la scène
     *
     * @param scene Scène à afficher
     * @param xOffset Position x absolue de l'image de la scène
     * @param yOffset Position y absolue de l'image de la scènes
     * @param g Support d'affichage
     *
     * @see Scene
     */
    public void render (Scene scene, int xOffset, int yOffset, Graphics g) {
        for (int y = 0; y < scene.getHeight(); y++) {
            int ya = y * tilesize;
            for (int x = 0; x < scene.getWidth(); x++) {
                int xa = x * tilesize;

                TileRenderer.render(scene.getTileAt(x, y), xa + xOffset, ya + yOffset, g);
            }
        }

        for (Tank tank : scene.getTanks()) {
            TankRenderer renderer = tankRenderers.get(tank);
            if (renderer == null) {
                renderer = new TankRenderer(tank, "new tank", tilesize);
                tankRenderers.put(tank, renderer);
            }
            renderer.render(tank, xOffset, yOffset, g);
        }

        for (Projectile projectile : scene.getProjectiles()) {
            ProjectileRenderer renderer = projectileRenderers.get(projectile);
            if (renderer == null) {
                renderer = new ProjectileRenderer(projectile, tilesize);
                projectileRenderers.put(projectile, renderer);
            }
            renderer.render(projectile, xOffset, yOffset, g);
        }
    }

    /**
     * Renvoi le nombre de pixels par tuile (taille de l'image)
     * @return Nombre de pixels
     */
    public int getTilesize() {
        return tilesize;
    }

    /**
     * Indique qu'aucun des sprites n'est entrain de se mettre à jour (est entrain de bouger)
     *
     * @return Scène prête (aucun sprite ne bouge) : true, sinon : false
     */
    public boolean ready() {
        for (TankRenderer renderer : tankRenderers.values()) {
            if (renderer.isMoving()) return false;
        }

        for (ProjectileRenderer renderer : projectileRenderers.values()) {
            if (renderer.isMoving()) return false;
        }
        return true;
    }

    /**
     * Renvoi le gestionnaire de rendu d'un tank
     *
     * @param tank Tank à afficher
     * @return Gestionnaire de rendu du tank
     *
     * @see Tank
     * @see TankRenderer
     */
    public TankRenderer getTankRenderer (Tank tank) {
        return tankRenderers.get(tank);
    }
}
