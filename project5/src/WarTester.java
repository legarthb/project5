
public class WarTester{
    public static void main(String[] args) {
     	WarGame game = new WarGame();
        game.deal();
        while (! game.winner()) {
            game.Step();
            game.toString();
        }
        game.toString();
    }
}
