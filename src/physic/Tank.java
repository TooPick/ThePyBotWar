package physic;

import input.TankAction;
import input.TankController;
import input.TankLineOfSight;

/**
 * Created by balthazar on 28/11/16.
 */
public class Tank {
    private int x, y;
    private Direction direction;
    private Scene context;

    private int pv;
    private static final int maxpv = 100;

    public Tank (int x, int y, Direction direction, Scene context) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.context = context;
        context.addTank(this);

       // this.pv = maxpv;
        this.pv = 20;
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

    public int getMaxPv() {
        return maxpv;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
        if (this. pv < 0) this.pv = 0;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Scene getContext () {
        return context;
    }
}
