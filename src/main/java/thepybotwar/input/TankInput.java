package thepybotwar.input;

/**
 * Enumération qui représente les actions possibles du tank
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

    /**
     * Constructor
     *
     * @param id Identifiant de l'action
     * @param function Nom de la fonction (utilisée en python)
     * @param description Description de l'action
     */
    TankInput(int id, String function, String description) {
        this.id = id;
        this.function = function;
        this.description = description;
    }

    /**
     * Renvoi l'identifiant de l'action
     *
     * @return Identifiant de l'action
     */
    public int getId() {
        return id;
    }

    /**
     * Renvoi le nom de la fonction (utilisée en Python)
     *
     * @return Nom de la fonction
     */
    public String getFunction() {
        return function;
    }

    /**
     * Renvoi la description de l'action
     *
     * @return Description de l'action
     */
    public String getDescription() {
        return description;
    }

    /**
     * Renvoi le nombre d'actions possibles
     *
     * @return Nombre d'actions
     */
    public static int getNbId() {
        return 6;
    }
}
