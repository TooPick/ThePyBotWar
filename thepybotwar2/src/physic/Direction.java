package physic;


/**
 * Created by balthazar on 28/11/16.
 */
public enum Direction {
    up,down,left, right;

    public Direction opposite() {
        switch (this) {
            case up: return down;
            case down: return up;
            case left: return right;
            case right: return left;
            default: return down;
        }
    }

    public Direction clockwise() {
        switch (this) {
            case up: return right;
            case down: return left;
            case left: return up;
            case right: return down;
            default: return down;
        }
    }

    public Direction anticlockwise() {
        switch (this) {
            case up: return left;
            case down: return right;
            case left: return down;
            case right: return up;
            default: return down;
        }
    }

    public int vectorX() {
        switch (this) {
            case up: return 0;
            case down: return 0;
            case left: return -1;
            case right: return 1;
            default: return 0;
        }
    }

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
