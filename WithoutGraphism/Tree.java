import java.util.ArrayList;

public class Tree {
    private String name;
    private ArrayList<Tree> trees;
    private Window window;

    public Tree(String name, ArrayList<Tree> trees, Window window) {
        this.name = name;
        this.trees = trees;
        this.window = window;
    }

    public void addTree(Tree tree) {
        trees.add(tree);
    }

    public int size() {
        return trees.size();
    }

    public Tree getSubTree(int i) {
        return trees.get(i);
    }

    public String getName() {
        return name;
    }

    public String toString() {
        String str = "TITLE: " + name + "\n\n";
        if (trees.size() != 0) {
            for (int i = 0; i < trees.size(); i++) {
                str += trees.get(i).name + "\n";
            }
        }
        if (window != null) {
            str += window;
        }
        str += "-------------------------";
        return str;
    }
}