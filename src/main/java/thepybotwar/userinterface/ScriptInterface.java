package thepybotwar.userinterface;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import thepybotwar.controller.PythonPlayer;
import thepybotwar.game.Player;
import thepybotwar.input.TankInput;
import thepybotwar.script.Script;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Interfaces graphiques liées aux scripts
 *
 * @author Balthazar
 * @version 1.0
 */
public abstract class ScriptInterface {

    /**
     * Affichage de la fenetre de gestion de script
     *
     * @param user Joueur auquel le script doit être édité
     *
     * @see Player
     */
    public static void showScriptDialog(Player user) {
        Script script = user.getScript();

        JPanel editorPanel = new JPanel();

        RSyntaxTextArea codeArea = new RSyntaxTextArea();
        codeArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
        codeArea.setText(script.getExecutedCode());

        UndoManager manager = new UndoManager();
        codeArea.getDocument().addUndoableEditListener(manager);

        JButton undoButton = new JButton("undo");   // TODO : mettre une icone a la place.
        undoButton.addActionListener(e -> {
            if (manager.canUndo()) manager.undo();
        });

        JButton redoButton = new JButton("redo");   // TODO : idem
        redoButton.addActionListener(e -> {
            if (manager.canRedo()) manager.redo();
        });

        JButton saveButton = new JButton("save");   // TODO : idem
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.discardAllEdits();
                script.setExecutedCode(codeArea.getText());
                script.save();
                user.setInputMaker(new PythonPlayer(user.getController(), user.getSight(), script.getExecutedCode()));
            }
        });

        JScrollPane scrollPane= new JScrollPane(codeArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(500,110));

        JPanel helpPanel = createHelpPanel(codeArea);
        helpPanel.setPreferredSize(new Dimension(351,141));

        editorPanel.add(scrollPane);
        editorPanel.add(helpPanel);
        editorPanel.add(undoButton);
        editorPanel.add(redoButton);
        editorPanel.add(saveButton);

        JOptionPane.showMessageDialog(null, editorPanel, "edition script", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Fenetre d'aide de l'utilisateur
     *
     * @param codeArea Champs d'édition de code
     * @return Fenetre d'aide
     */
    private static JPanel createHelpPanel (RSyntaxTextArea codeArea) {
        JPanel helpPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        helpPanel.setOpaque(true);
        helpPanel.setBackground(Color.WHITE);
        helpPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel description = new JLabel("");
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setAlignmentX(Component.RIGHT_ALIGNMENT);

        DefaultListModel<String> namelist = new DefaultListModel<>();
        DefaultListModel<String> descrlist = new DefaultListModel<>();

        for (TankInput input : TankInput.values()) {
            namelist.addElement(input.getFunction());
            descrlist.addElement(input.getDescription());
        }

        JList list = new JList(namelist);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = list.getSelectedIndex();
                description.setText(descrlist.elementAt(index));
                if (e.getClickCount() == 2) {
                    codeArea.insert(namelist.elementAt(index), codeArea.getCaretPosition());
                }
            }
        });

        JLabel separator = new JLabel( "--------------------------------------------------------\n" +
                        "----------------------    Aide    ----------------------");
        helpPanel.add(list);
        helpPanel.add(separator);
        helpPanel.add(description);

        return helpPanel;
    }

}
