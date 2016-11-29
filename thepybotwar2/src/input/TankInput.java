package input;

/**
 * Created by balthazar on 28/11/16.
 */
public enum TankInput {
    NOACTION(0,"noAction()", "ne fait rien"),
    SHOOT(1, "shoot()", "tire un projectile"),
    MOVEFORWARD(2, "moveForward()", "avance d'une case"),
    MOVEBACKWARD(3,"moveBackward()", "recule d'une case"),
    TURNCLOCKWISE(4,"turnClockWise()", "pivote (sens horaire)"),
    TURNNOCLOCKWISE(5,"turnAntiClockWise()", "pivote (sens antihoraire");

    private int id;
    private String function;
    private String description;

    TankInput(int id, String function, String description) {
        this.id = id;
        this.function = function;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getFunction() {
        return function;
    }

    public String getDescription() {
        return description;
    }

    public static int getNbId() {
        return 6;
    }
}
