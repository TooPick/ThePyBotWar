package thepybotwar.physic;

import java.util.ArrayList;

/**
 * Classe représentant la scène ou les tank vont s'affronter
 *
 * @author Balthazar
 * @version 1.0
 */
public class Scene {
    private int width, height;

    private ArrayList<Tank> tanks;
    private ArrayList<Projectile> projectiles;

    private Tile[] tiles;

    /**
     * Constructor
     *
     * @param width Largeur de la scène
     * @param height Hauteur de la scène
     */
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

    /**
     * Getter
     *
     * @return Largeur de la scène
     */
    public int getWidth() {
        return width;
    }

    /**
     * Setter
     *
     * @param width Largeur de la scène
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Getter
     *
     * @return Hauteur de la scène
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setter
     *
     * @param height Hauteur de la scène
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Renvoi la liste des tanks sur la scène
     *
     * @return Liste des tanks
     *
     * @see Tank
     */
    public ArrayList<Tank> getTanks() {
        return tanks;
    }

    /**
     * Renvoi le tank qui se trouve sur une position donnée, renvoi null si aucun tank trouvé
     *
     * @param x Position x à rechercher
     * @param y Position y à rechercher
     * @return Tank trouvé ou null
     *
     * @see Tank
     */
    public Tank getTankAt (int x, int y) {
        for (Tank tank : tanks) {
            if (tank.getX() == x && tank.getY() == y) return tank;
        }
        return null;
    }

    /**
     * Ajoute un tank sur la scène
     *
     * @param tank Tank à ajouter sur la scène
     *
     * @see Tank
     */
    public void addTank (Tank tank) {
        tanks.add(tank);
    }

    /**
     * Supprime un tank de la scène
     *
     * @param tank Tank à supprimer
     *
     * @see Tank
     */
    public void removeTank (Tank tank) {
        tanks.remove(tank);
    }

    /**
     * Renvoi la liste des projectiles qui sont sur la scène
     *
     * @return Liste des projectiles
     *
     * @see Projectile
     */
    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    /**
     * Renvoi le projectile qui se situe sur une position donnée, renvoi null si aucun projectile trouvé
     *
     * @param x Position x à rechercher
     * @param y Position y à rechercher
     * @return Projectile trouvé ou null
     *
     * @see Projectile
     */
    public Projectile getProjectileAt (int x, int y) {
        for (Projectile projectile : projectiles) {
            if (projectile.getX() == x && projectile.getY() == y) return projectile;
        }
        return null;
    }

    /**
     * Ajoute un projectile à la scène
     *
     * @param projectile Projectile à ajouter
     *
     * @see Projectile
     */
    public void addProjectile (Projectile projectile) {
        projectiles.add(projectile);
    }

    /**
     * Supprime un projectile de la scène
     *
     * @param projectile Projectile à supprimer
     *
     * @see Projectile
     */
    public void removeProjectile (Projectile projectile) {
        projectiles.remove(projectile);
    }

    /**
     * Renvoi la tuile qui se situe sur une porision donnée
     *
     * @param x Position x à rechercher
     * @param y Position y à rechercher
     * @return Tuile trouvée
     *
     * @see Tile
     */
    public Tile getTileAt (int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) return Tile.empty;
        else return tiles[x + y * width];
    }

    /**
     * Permet de savoir si une tuile est occupée ou vide
     *
     * @param x Position x à tester
     * @param y Position y à tester
     * @return Occupé : true, Vide : false
     */
    public boolean tileOccupied (int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) return true;
        if (getTileAt(x, y).isSolid()) return true;
        if (getTankAt(x, y) != null) return true;
        return false;
    }
}
