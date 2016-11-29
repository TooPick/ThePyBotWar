package userinterface;

import physic.Tank;
import render.SceneRenderer;
import render.TankRenderer;
import render.ressources.TankColor;
import render.ressources.TankSprite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by balthazar on 29/11/16.
 */

public abstract class TankInterface {
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
