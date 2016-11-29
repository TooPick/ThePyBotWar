package thepybotwar.physic;

/**
 * Enumération représentant les directions possibles d'un objet
 *
 * @author Balthazar
 * @version 1.0
 */
public enum Direction {
    up,down,left, right;

    /**
     * Donne l'opposé de la direction actuelle
     *
     * @return Nouvelle direction
     */
    public Direction opposite() {
        switch (this) {
            case up: return down;
            case down: return up;
            case left: return right;
            case right: return left;
            default: return down;
        }
    }

    /**
     * Tourne dans le sens des aiguilles d'une montre
     *
     * @return Nouvelle direction
     */
    public Direction clockwise() {
        switch (this) {
            case up: return right;
            case down: return left;
            case left: return up;
            case right: return down;
            default: return down;
        }
    }

    /**
     * Tourne dans le sens inverse des aiguilles d'une montre
     *
     * @return Nouvelle direction
     */
    public Direction anticlockwise() {
        switch (this) {
            case up: return left;
            case down: return right;
            case left: return down;
            case right: return up;
            default: return down;
        }
    }

    /**
     * Récupère la valeur du vecteur de direction sur l'axe X
     *
     * @return Vecteur X
     */
    public int vectorX() {
        switch (this) {
            case up: return 0;
            case down: return 0;
            case left: return -1;
            case right: return 1;
            default: return 0;
        }
    }

    /**
     * Récupère la valeur du vecteur de direction sur l'axe Y
     *
     * @return Vecteur Y
     */
    public int vectorY() {
        switch (this) {
            case up: return -1;
            case down: return 1;
            case left: return 0;
            case right: return 0;
            default: return 0;
        }
    }
}
