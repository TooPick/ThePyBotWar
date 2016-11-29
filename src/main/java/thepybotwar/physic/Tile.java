package thepybotwar.physic;

/**
 * Classe qui représente une tuile d'une scène
 *
 * @author Balthazar
 * @version 1.0
 */
public class Tile {
    private boolean isSolid;

    public static Tile wall = new Tile(true);
    public static Tile empty = new Tile(false);

    /**
     * Constructor
     *
     * @param isSolid Défini quelque chose peut traversé ou être posé sur la tuile
     */
    public Tile(boolean isSolid) {
         this.isSolid = isSolid;
    }

    /**
     * Renvoi si la tuile est solide ou non (si un objet peut la traverser, être posé dessus ou non)
     *
     * @return Tuile solide : true, Tuile non solide : false
     */
    public boolean isSolid() {
        return isSolid;
    }
}
