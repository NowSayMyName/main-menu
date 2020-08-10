import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplaySystem extends JFrame implements ActionListener{
    private Tree selectedTree;
    private ArrayList<JButton> buttons;
    private JPanel mainPanel;

    public DisplaySystem(Tree tree) {
        this.selectedTree = tree;
        buttons = new ArrayList<JButton>();

        this.setSize(1400, 850);
        //make it fullscreen
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.black);
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    public void createButtons() {
        for (int i = 0; i < buttons.size(); i++) {
            mainPanel.remove(buttons.get(i));
        }
        buttons.clear();
        for (int i = 0; i < selectedTree.size(); i++) {
            buttons.add(new JButton(selectedTree.getSubTree(i).getName()));
            buttons.get(i).setBounds(20, 20 + 25*i, 200, 25);
            buttons.get(i).setBackground(Color.white);
            buttons.get(i).setVisible(true);
            mainPanel.add(buttons.get(i));
            buttons.get(i).addActionListener(this);
        }
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<buttons.size(); i++) {
            if (buttons.get(i) == e.getSource()) {
                selectedTree = selectedTree.getSubTree(i);
                createButtons();
                break;
            }
        }
    }

    public void runDisplay() {
        createButtons();

        while (true) {
        }
    }

    public static void main(String[] args) {
        Tree Singleplayer = new Tree("Singleplayer", new ArrayList<Tree>(0) , new Window("Singleplayer options", 0));
        Tree Multiplayer = new Tree("Multiplayer", new ArrayList<Tree>(0) , new Window("Multiplayer options", 0));
        Tree Options = new Tree("Options", new ArrayList<Tree>(0) , new Window("Options display", 0));
        Tree Credits = new Tree("Credits", new ArrayList<Tree>(0) , new Window("Credits display", 0));

        Tree continuegame = new Tree("Continue game", new ArrayList<Tree>(0) , new Window("Enjoy your game", 0));
        Tree newgame = new Tree("New game", new ArrayList<Tree>(0) , new Window("Starting over :/", 0));
        continuegame.addTree(Singleplayer);
        newgame.addTree(Singleplayer);

        ArrayList<Tree> trees = new ArrayList<Tree>();
        trees.add(Singleplayer);
        trees.add(Multiplayer);
        trees.add(Options);
        trees.add(Credits);

        Tree Back = new Tree("Back", trees, null); 

        //Single player menu
        Singleplayer.addTree(continuegame);
        Singleplayer.addTree(newgame);
        Singleplayer.addTree(Back);
        
        Multiplayer.addTree(Back);
        Options.addTree(Back);
        Credits.addTree(Back);

        DisplaySystem disp = new DisplaySystem(Back);
        disp.runDisplay();
    }
}