package thepybotwar.input;

/**
 * Classe qui représente le controller du tank
 *
 * @author Balthazar
 * @version 1.0
 */
public class TankController {
    private InputMaker source;
    private boolean requested[];

    /**
     * Constructor
     */
    public TankController() {
        this.requested = new boolean[TankInput.getNbId()];
    }

    /**
     * Supprime une action à effectuer
     *
     * @param input Action à supprimer
     *
     * @see TankInput
     */
    public void unset (TankInput input) {
        this.requested[input.getId()] = false;
    }

    /**
     * Ajoute une action à effectuer
     *
     * @param input Action à ajouter
     *
     * @see TankInput
     */
    public void set (TankInput input) {
        this.requested[input.getId()] = true;
    }

    /**
     * Supprime toutes les actions
     */
    public void unsetAll () {
        for (int i = 0; i< requested.length; i++)
            requested[i] = false;
    }

    /**
     * Permet de savoir si une action est en cours
     *
     * @param input Action à tester
     * @return Action en cours : true, sinon : false
     */
    public boolean isSet (TankInput input) {
        return requested[input.getId()];
    }
}
