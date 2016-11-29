package thepybotwar.render;

import thepybotwar.physic.Projectile;
import thepybotwar.physic.Scene;
import thepybotwar.physic.Tank;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by balthazar on 28/11/16.
 */
public class SceneRenderer {
    private int tilesize;

    private Map<Tank, TankRenderer> tankRenderers;
    private Map<Projectile, ProjectileRenderer> projectileRenderers;

    public SceneRenderer(int tilesize) {
        this.tilesize = tilesize;
        this.tankRenderers = new HashMap<Tank, TankRenderer>();
        this.projectileRenderers = new HashMap<Projectile, ProjectileRenderer>();
    }

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

    public int getTilesize() {
        return tilesize;
    }

    public boolean ready() {
        for (TankRenderer renderer : tankRenderers.values()) {
            if (renderer.isMoving()) return false;
        }

        for (ProjectileRenderer renderer : projectileRenderers.values()) {
            if (renderer.isMoving()) return false;
        }
        return true;
    }

    public TankRenderer getTankRenderer (Tank tank) {
        return tankRenderers.get(tank);
    }
}
