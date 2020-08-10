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
        for (int i = 0; i < trees.size(); i++) {
            if (window != null && window.getOrder() == i) {
                str += window;
            }
            str += trees.get(i).name + "\n";
        }
        str += "-------------------------";
        return str;
    }
}