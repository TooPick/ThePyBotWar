package thepybotwar.input;

/**
 * Classe qui indique à un tank les actions à effectuer
 */
public abstract class InputMaker {
    protected TankController controller;
    protected TankLineOfSight sight;

    /**
     * Constructor
     *
     * @param controller Controller du tank
     * @param sight Ligne de vue du tank
     *
     * @see TankController
     * @see TankLineOfSight
     */
    public InputMaker(TankController controller, TankLineOfSight sight) {
        this.controller = controller;
        this.sight = sight;
    }

    /**
     * Renvoi le controller du tank
     *
     * @return Controller du tank
     *
     * @see TankController
     */
    public TankController getController() {
        return controller;
    }

    /**
     * Renvoi la ligne de vue du tank
     *
     * @return Ligne de vue du tank
     *
     * @see TankLineOfSight
     */
    public TankLineOfSight getSight() {
        return sight;
    }

    /**
     * Signale au InputMaker qu'il peut indiquer les actions à effectuer
     */
    public abstract void getInput();
}
