package input;

import physic.Tank;

/**
 * Created by balthazar on 29/11/16.
 */
public class TankLineOfSight {
    public enum Sighted{
        NOTHING, TANK, WALL
    }

    private int distance;
    private Sighted sighted;

    public TankLineOfSight() {
        distance = 3;
        sighted = Sighted.NOTHING;  // tofix.
    }

    public int getType() {
        if (sighted == Sighted.NOTHING) return 0;
        if (sighted == Sighted.WALL) return 1;
        if (sighted == Sighted.TANK) return 2;
        return -1;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setSighted(Sighted type) {
        this.sighted = type;
    }
}
