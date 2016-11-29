package thepybotwar.input;

import thepybotwar.physic.Projectile;
import thepybotwar.physic.Tank;

/**
 * Classe qui représente les actions des tanks
 *
 * @author Balthazar
 * @version 1.0
 */
public abstract class TankAction {
    /**
     * Exécute l'action demmandée
     *
     * @param controller Controller du tank
     * @param tank Tank qui effectue l'action
     *
     * @see TankController
     * @see Tank
     */
    public static void update(TankController controller, Tank tank) {
        if (! tank.isAlive()) return;

        if (controller.isSet(TankInput.NOACTION)) no_action(tank);
        if (controller.isSet(TankInput.SHOOT)) shoot(tank);
        if (controller.isSet(TankInput.MOVEFORWARD)) moveForward(tank);
        if (controller.isSet(TankInput.MOVEBACKWARD)) moveBackward(tank);
        if (controller.isSet(TankInput.TURNCLOCKWISE)) turnClockwise(tank);
        if (controller.isSet(TankInput.TURNNOCLOCKWISE)) turnAntiClockwise(tank);
    }

    /**
     * Le tank ne fait rien
     *
     * @param tank Tank qui effectue l'action
     *
     * @see Tank
     */
    private static void no_action (Tank tank) {

    }

    /**
     * Le tank tire
     *
     * @param tank Tank qui effectue l'action
     *
     * @see Tank
     */
    private static void shoot (Tank tank) {
        int px = tank.getX() + tank.getDirection().vectorX();
        int py = tank.getY() + tank.getDirection().vectorY();
        Projectile projectile = new Projectile(px, py, tank.getDirection(), tank.getContext());
    }

    /**
     * Le tank tourne dans le sens des aiguilles d'une montre
     *
     * @param tank Tank qui effectue l'action
     *
     * @see Tank
     */
    private static void turnClockwise (Tank tank) {
        tank.setDirection(tank.getDirection().clockwise());
    }

    /**
     * Le tank tourne dans le sens inverse des aiguilles d'une montre
     *
     * @param tank Tank qui effectue l'action
     *
     * @see Tank
     */
    private static void turnAntiClockwise (Tank tank) {
        tank.setDirection(tank.getDirection().anticlockwise());
    }

    /**
     * Le tank avance droit devant lui
     *
     * @param tank Tank qui effectue l'action
     *
     * @see Tank
     */
    private static void moveForward (Tank tank) {
        int ox = tank.getX() + tank.getDirection().vectorX();
        int oy = tank.getY() + tank.getDirection().vectorY();
        if (tank.getContext().tileOccupied(ox, oy)) return;

        tank.setX(ox);
        tank.setY(oy);
    }

    /**
     * Le tank avance derrière lui
     *
     * @param tank Tank qui effectue l'action
     *
     * @see Tank
     */
    private static void moveBackward (Tank tank) {
        int ox = tank.getX() + tank.getDirection().opposite().vectorX();
        int oy = tank.getY() + tank.getDirection().opposite().vectorY();
        if (tank.getContext().tileOccupied(ox, oy)) return;

        tank.setX(ox);
        tank.setY(oy);
    }

    /**
     * Le tank analyse ce qu'il y a devant lui
     *
     * @param tank Tank qui effectue l'action
     * @param sight Ligne de vue du tank
     *
     * @see Tank
     * @see TankLineOfSight
     */
    public static void sight (Tank tank, TankLineOfSight sight) {
        int sx = tank.getX() + tank.getDirection().vectorX();
        int sy = tank.getY() + tank.getDirection().vectorY();

        for (int i = 1; i >= 0; i++) {
            if (sx < 0 || sx >= tank.getContext().getWidth() || sy < 0 || sy >= tank.getContext().getHeight()) {
                sight.setDistance(i);
                sight.setSighted(TankLineOfSight.Sighted.NOTHING);
                return;
            }

            if (tank.getContext().getTileAt(sx, sy).isSolid()) {
                sight.setDistance(i);
                sight.setSighted(TankLineOfSight.Sighted.WALL);
            }

            if (tank.getContext().getTankAt(sx, sy) != null) {
                sight.setDistance(i);
                sight.setSighted(TankLineOfSight.Sighted.TANK);
            }
            sx += tank.getDirection().vectorX();
            sy += tank.getDirection().vectorY();
        }
    }
}
