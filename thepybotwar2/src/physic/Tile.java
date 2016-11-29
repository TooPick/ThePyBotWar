package physic;

/**
 * Created by balthazar on 28/11/16.
 */
public class Tile {
    private boolean isSolid;

    public static Tile wall = new Tile(true);
    public static Tile empty = new Tile(false);

    public Tile(boolean isSolid) {
         this.isSolid = isSolid;
    }

    public boolean isSolid() {
        return isSolid;
    }
}
