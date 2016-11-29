package thepybotwar.physic;

/**
 * Classe représentant un projectile tiré par un tank
 *
 * @author Balthazar
 * @version 1.0
 */
public class Projectile {
    private int x, y;
    private Direction direction;
    private Scene context;

    /**
     * Constructor
     *
     * @param x Position x du projectile
     * @param y Position y du projectile
     * @param direction Direction du projectile
     * @param context Scène ou va être instancié le projectile
     *
     * @see Direction
     * @see Scene
     */
    public Projectile(int x, int y, Direction direction, Scene context) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.context = context;
        context.addProjectile(this);
    }

    /**
     * Renvoi la position x du projectile
     *
     * @return Position x
     */
    public int getX() {
        return x;
    }

    /**
     * Défini la position x du projectile
     *
     * @param x Position x du projectile
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Renvoi la position y du projectile
     *
     * @return Position y
     */
    public int getY() {
        return y;
    }

    /**
     * Défini la position y du projectile
     *
     * @param y Position y du projectile
     */
    public void setY(int y) {
        this.y = y;
    }
}
