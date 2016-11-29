package thepybotwar.userinterface;

import thepybotwar.physic.Tank;
import thepybotwar.render.SceneRenderer;
import thepybotwar.render.TankRenderer;
import thepybotwar.render.ressources.TankColor;
import thepybotwar.render.ressources.TankSprite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interfaces graphiques liées aux tanks
 *
 * @author Balthazar
 * @version 1.0
 */

public abstract class TankInterface {

    /**
     * Fenetre de visualisation des skin du tank
     *
     * @param tank Tank à editer
     * @param context Gestionnaire de rendu de scène
     *
     * @see Tank
     * @see SceneRenderer
     */
    public static void showSkinDialog(Tank tank, SceneRenderer context) {
        TankRenderer renderer = context.getTankRenderer(tank);
        JPanel colorPanel = new JPanel();

        for (TankColor color : TankColor.values()) {
            JButton colorButton = new JButton(new ImageIcon(TankSprite.get(color, tank.getDirection())));
            colorButton.addActionListener(e -> renderer.setColor(color));
            colorPanel.add(colorButton);
        }
        String newName = JOptionPane.showInputDialog(null, colorPanel, "edition tank", JOptionPane.PLAIN_MESSAGE);
        if (newName != "") {
            renderer.setName(newName);
        }
        System.out.println (renderer.getName());
    }
}
