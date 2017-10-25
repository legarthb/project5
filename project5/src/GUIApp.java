import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a model and passes it to a new view.
 * @author lambertk
 *
 */
public class GUIApp{

    public static void main(String[] args){
        final Deck deck = new Deck();
        final JFrame view = new MainView(deck);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setTitle("tHe GamE oF WaR");
        view.setSize(600, 350);
        view.setResizable(false);
        view.setVisible(true);
    }
}