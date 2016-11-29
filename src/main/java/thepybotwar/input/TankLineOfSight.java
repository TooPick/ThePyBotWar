package thepybotwar.input;

/**
 * Classe qui représente la ligne de vue d'un tank
 *
 * @author Balthazar
 * @version 1.0
 */
public class TankLineOfSight {

    /**
     * Enumération des objets possibles
     */
    public enum Sighted{
        NOTHING, TANK, WALL
    }

    private int distance;
    private Sighted sighted;

    /**
     * Constructor
     */
    public TankLineOfSight() {
        distance = 3;
        sighted = Sighted.NOTHING;  // tofix.
    }

    /**
     * Renvoi le type du prochain objet sur la ligne de vue
     *
     * @return Type d'objet
     */
    public int getType() {
        if (sighted == Sighted.NOTHING) return 0;
        if (sighted == Sighted.WALL) return 1;
        if (sighted == Sighted.TANK) return 2;
        return -1;
    }

    /**
     * Défini la distance de l'objet sur la ligne de vue
     *
     * @param distance Distance de l'objet
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Renvoi la distance de l'objet sur la ligne de vue
     *
     * @return Distance de l'objet
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Défini le type de l'objet sur la ligne de vue
     *
     * @param type Type de l'objet
     */
    public void setSighted(Sighted type) {
        this.sighted = type;
    }
}
