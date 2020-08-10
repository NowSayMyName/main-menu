public class Window {
    private String def;
    private int ordre;

    public Window(String str, int ordre) {
        def = str;
        this.ordre = ordre;
    }

    public int getOrder() {
        return ordre;
    }

    public String toString() {
        return "||| " + def + "|||\n";
    }
}

