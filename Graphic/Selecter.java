import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class Selecter extends JPanel implements ActionListener {
    private String name;
    private Selecter[] select;
    private JButton[] buttons;
    private JTextArea displayedName;

    public Selecter(String name) {
        this.name = name;

        this.setLayout(null);
        this.setBackground(Color.green);

        displayedName = new JTextArea(name);
        displayedName.setBackground(Color.white);
        this.add(displayedName);
    }
    
    public Selecter(String name, Selecter[] select, int xPos, int yPos, int x, int y) {
        this.name = name;
        this.select = select;

        this.setLayout(null);
        this.setBounds(xPos, yPos, x, y);
        this.setBackground(Color.green);

        displayedName = new JTextArea(name);
        displayedName.setBackground(Color.white);
        this.add(displayedName);

        buttons = new JButton[select.length];
        for (int i = 0; i < select.length; i++) {
            buttons[i] = new JButton(select[i].name);
            buttons[i].setBounds(5, 5+i*25, 100, 25+i*25);
            buttons[i].setVisible(true);
        }

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //int i = buttons.getIndex(e.getSource());
        //System.out.println("button pressed: " + select[i].name);
    }

}