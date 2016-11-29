package physic;

/**
 * Created by balthazar on 28/11/16.
 */
public class Projectile {
    private int x, y;
    private Direction direction;
    private Scene context;

    public Projectile(int x, int y, Direction direction, Scene context) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.context = context;
        context.addProjectile(this);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
