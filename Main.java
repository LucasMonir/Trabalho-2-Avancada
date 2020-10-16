import Controllers.JanelaController;
import Views.Janela;

public class Main {
    public static void main(String[] args) {
        Janela jn = new Janela();

        new JanelaController(jn);
    }
}
