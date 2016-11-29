import game.Game;

import javax.swing.*;

/**
 * Created by balthazar on 28/11/16.
 */
public class Main {
    public static void main (String args[]) {
        Game game = new Game();

        JFrame frame = new JFrame("pybotwar");
        frame.setContentPane(game.getScreen());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        game.run();
    }
}
