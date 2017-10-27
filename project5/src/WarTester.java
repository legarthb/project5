/**
 * Terminal based tester application for top-level model class
 * @author Brian Legarth
 * @author Tommy Thetford
 * @author Chris Randall
 * @author Mark Donohue
 */

public class WarTester{
    public static void main(String[] args) {
     	WarGame game = new WarGame();
        game.deal();
        while (! game.winner()) {
            game.Step();
            System.out.println(game.toString());
        }
    }
}

