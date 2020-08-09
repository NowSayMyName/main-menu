import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;


public class Display extends JFrame {
    //private Image background;
    private Selecter tree;
    private Selecter actualSelecter;
    private JPanel mainPanel;

    public Display(Selecter tree) {
        this.tree = tree;
        actualSelecter = tree;

        //set la taille de la fenetre
        this.setSize(1400, 850);
        
        //make it fullscreen
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);

        //Jpanel principal (content pane)
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.black);

        mainPanel.add(actualSelecter);

        //affichage de la fenetre et arret a la fermeture
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Selecter Singleplayer = new Selecter("Singleplayer");
        Selecter Multiplayer = new Selecter("Multiplayer");
        Selecter Options = new Selecter("Options");
        Selecter Credits = new Selecter("Credits");
        Selecter Quit = new Selecter("Quit");

        Selecter[] mainscreenSelecter = new Selecter[] {Singleplayer, Multiplayer, Options, Credits, Quit};
        Selecter mainscreen = new Selecter("", mainscreenSelecter, 500, 500, 1000, 1000);

        new Display(mainscreen);
    }
}