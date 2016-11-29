package thepybotwar.physic;

import java.util.ArrayList;

/**
 * Created by balthazar on 28/11/16.
 */

public class Scene {
    private int width, height;

    private ArrayList<Tank> tanks;
    private ArrayList<Projectile> projectiles;

    private Tile[] tiles;

    public Scene(int width, int height) {
        this.height = height;
        this.width = width;
        this.tanks = new ArrayList<Tank>();
        this.projectiles = new ArrayList<Projectile>();

        this.tiles = new Tile[height * width];

        // TODO : retirer ca.
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x == 0 || x == width-1) tiles[x + y * width] = Tile.wall;
                else if (y == 0 || y == height-1) tiles[x + y * width] = Tile.wall;
                else tiles[x + y * width] = Tile.empty;
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<Tank> getTanks() {
        return tanks;
    }

    public Tank getTankAt (int x, int y) {
        for (Tank tank : tanks) {
            if (tank.getX() == x && tank.getY() == y) return tank;
        }
        return null;
    }

    public void addTank (Tank tank) {
        tanks.add(tank);
    }

    public void removeTank (Tank tank) {
        tanks.remove(tank);
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public Projectile getProjectileAt (int x, int y) {
        for (Projectile projectile : projectiles) {
            if (projectile.getX() == x && projectile.getY() == y) return projectile;
        }
        return null;
    }

    public void addProjectile (Projectile projectile) {
        projectiles.add(projectile);
    }

    public void removeProjectile (Projectile projectile) {
        projectiles.remove(projectile);
    }

    public Tile getTileAt (int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) return Tile.empty;
        else return tiles[x + y * width];
    }

    public boolean tileOccupied (int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) return true;
        if (getTileAt(x, y).isSolid()) return true;
        if (getTankAt(x, y) != null) return true;
        return false;
    }
}
