import java.util.*;

public class WarGame{
    
    //Creating the players
    private Player playerOne;
    private Player playerTwo;
    private List<Card> warPile = new ArrayList<Card>();
    private String gameState = "";
    private Deck deck;
    public WarGame() {
    	    deck.shuffle();
    }
    public String ToString() {
        return gameState;
    }
    public void deal() {
        while (! this.deck.isEmpty()){
            this.playerOne.addToUnplayedPile(this.deck.deal());
            this.playerTwo.addToUnplayedPile(this.deck.deal());
        }
    }
    public void Step() {
        Card cardOne = this.playerOne.getCard();
        Card cardTwo = this.playerTwo.getCard();
        this.warPile.add(cardOne);
        this.warPile.add(cardTwo);
        this.gameState = "Player 1: " + cardOne.toString() + "\n" + "Player 2: " + cardTwo.toString();
        if (cardOne.getRank() == cardTwo.getRank())
            this.gameState += "\nCards added to War pile\n";
        else if (cardOne.getRank() > cardTwo.getRank()) {
            this.transferCards(playerOne);
            this.gameState = "\nCards go to Player 1\n";
        }
        else {
            this.transferCards(playerTwo);
            this.gameState += "\nCards go to Player 2";
        }
    }
    public void transferCards(Player player) {
    	    player.addToWinningsPile(this.warPile.remove(0));
    }
    public boolean winner() {
        if (this.playerOne.isDone() || this.playerTwo.isDone()) {
            int countOne = this.playerOne.winningsCount();
            int countTwo = this.playerTwo.winningsCount();
            if (countOne > countTwo) {
                System.out.println("Player 1 wins, " + countOne + " to " + countTwo + "!");
            }
            else if (countTwo > countOne) {
                System.out.println("Player 2 wins, " + countTwo + " to " + countOne + "!");
            }
            else {
                System.out.println("The game ends in a tie!");
            }
            return true;
        }
        else {
        	return false;
        }
    }
}

