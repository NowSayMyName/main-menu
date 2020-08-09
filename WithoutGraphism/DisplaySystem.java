import java.util.ArrayList;
import java.util.Scanner;

public class DisplaySystem {
    private Tree tree;
    private Tree selectedTree;

    public DisplaySystem(Tree tree) {
        this.tree = tree;
        this.selectedTree = tree;
    }

    public static void main(String[] args) {
        Tree Singleplayer = new Tree("Singleplayer", new ArrayList<Tree>(0) , new Window("Singleplayer options"));
        Tree Multiplayer = new Tree("Multiplayer", new ArrayList<Tree>(0) , new Window("Multiplayer options"));
        Tree Options = new Tree("Options", new ArrayList<Tree>(0) , new Window("Options display"));
        Tree Credits = new Tree("Credits", new ArrayList<Tree>(0) , new Window("Credits display"));
        ArrayList<Tree> trees = new ArrayList<Tree>();
        trees.add(Singleplayer);
        trees.add(Multiplayer);
        trees.add(Options);
        trees.add(Credits);

        Tree Back = new Tree("Back", trees, null); 

        Singleplayer.addTree(Back);
        Multiplayer.addTree(Back);
        Options.addTree(Back);
        Credits.addTree(Back);

        DisplaySystem disp = new DisplaySystem(Back);
        Scanner sc = new Scanner(System.in) ;
        System.out.println(disp.selectedTree);
        while (true) {
            System.out.println("### KEYBOARD ENTRY ###");
            String str = sc.nextLine();
            System.out.println("### ### ###### ### ###");
            System.out.println("-------------------------");

            for (int i=0; i<disp.selectedTree.size(); i++) {
                if (str.equals(disp.selectedTree.getSubTree(i).getName())) {
                    disp.selectedTree = disp.selectedTree.getSubTree(i);
                    System.out.println(disp.selectedTree);
                    break;
                }
            }
        }
    }
}