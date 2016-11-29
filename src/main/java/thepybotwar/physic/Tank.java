package thepybotwar.physic;

/**
 * Classe qui représente un tank
 *
 * @author Balthazar
 * @version 1.0
 */
public class Tank {
    private int x, y;
    private Direction direction;
    private Scene context;

    private int pv;
    private static final int maxpv = 100;

    /**
     * Constructor
     *
     * @param x Position x du tank
     * @param y Position y du tank
     * @param direction Direction du tank
     * @param context Scène où va être instancié le tank
     *
     * @see Direction
     * @see Scene
     */
    public Tank (int x, int y, Direction direction, Scene context) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.context = context;
        context.addTank(this);

       // this.pv = maxpv;
        this.pv = 20;
    }

    /**
     * Renvoi la position x du tank
     *
     * @return Position x
     */
    public int getX() {
        return x;
    }

    /**
     * Défini la position x du tank
     *
     * @param x Position x du tank
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Renvoi la position y du tank
     *
     * @return Position y
     */
    public int getY() {
        return y;
    }

    /**
     * Défini la position y du tank
     *
     * @param y Position y du tank
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getter : Maximum de Points de Vie du tank
     *
     * @return Nombre de Points de Vie maximum
     */
    public int getMaxPv() {
        return maxpv;
    }

    /**
     * Getter : Nombre de Points de Vie actuel du tank
     *
     * @return Nombre de Points de Vie actuel
     */
    public int getPv() {
        return pv;
    }

    /**
     * Défini le nombre de points actuel du tank
     *
     * @param pv Nombre de points du tank
     */
    public void setPv(int pv) {
        this.pv = pv;
        if (this. pv < 0) this.pv = 0;
    }

    /**
     * Renvoi la direction actuelle du tank
     *
     * @return Direction du tank
     *
     * @see Direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Défini la direction actuelle du tank
     *
     * @param direction Direction du tank
     *
     * @see Direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Renvoi la scène sur laquelle se trouve le tank
     *
     * @return Scène où se trouve le tank
     *
     * @see Scene
     */
    public Scene getContext () {
        return context;
    }

    public boolean isAlive () {
        return pv > 0;
    }
}
