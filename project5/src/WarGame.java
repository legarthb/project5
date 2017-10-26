
import java.util.*;
import javax.swing.*;

/**
 * Represents a game of war with playing cards.
 * @author Brian Legarth
 * @author Tommy Thetford
 * @author Chris Randall
 * @author Mark Donohue
 */

public class WarGame{
    
    //Creating the players
    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    private Card cardOne = null;
    private Card cardTwo = null;
    private List<Card> warPile = new ArrayList<Card>();
    private String gameState = "";
    private Deck deck = new Deck();
    private int moveCount = 0;
    
    /**
     * Constructor which shuffles the deck for play.
     */
    public WarGame() {
    	    this.deck.shuffle();
    }
    
    /**
     * Plays the instance variable Card CardOne
     * @return cardOne - player one's card
     */
    public Card playOneCard() {
    		return cardOne;
    }

    /**
     * Plays the instance variable Card CardTwo
     * @return cardOne - player two's card
     */
    public Card playTwoCard() {
    		return cardTwo;
    }
    
    /**
     * Gives a string representation of the current game state.
     * @return gameState - the current game state
     */
    public String toString() {
        return gameState;
    }
    
    /**
     * Deals out the cards to the players from the shuffled deck.
     */
    public void deal() {
        while (! this.deck.isEmpty()){
            this.playerOne.addToUnplayedPile(this.deck.deal());
            this.playerTwo.addToUnplayedPile(this.deck.deal());
        }
    }
    
    /**
     * Performs a move in the game of war, with both players playing
     * cards and alters the game state according to the results of the move
     */
    public void Step() {
    		moveCount += 1;
        cardOne = this.playerOne.getCard();
        cardTwo = this.playerTwo.getCard();
        this.gameState = "Player 1: \nCurrent Card: " 
        			+ cardOne.toString() 
        			+ "\nUnplayed Pile: " + this.playerOne.getUnplayedSize()
        			+ "\nWar Pile: " + this.warPile.size()
        			+ "\nWin Pile: " + this.playerOne.getWinningSize()
        			+ "\n\nPlayer 2: \nCurrent Card: " 
        			+ cardTwo.toString() 
        			+ "\nUnplayed Pile: " + this.playerTwo.getUnplayedSize()
        			+ "\nWar Pile: " + this.warPile.size()
        			+ "\nWin Pile: " + this.playerTwo.getWinningSize()
        			+ "\n\nMove Count: " + moveCount;
        this.warPile.add(cardOne);
        this.warPile.add(cardTwo);
        if (cardOne.getRank() == cardTwo.getRank())
            this.gameState += "\n\nCards added to War pile";
        else if (cardOne.getRank() > cardTwo.getRank()) {
            this.transferCards(playerOne);
            this.gameState += "\n\nCards go to Player 1";
        }
        else {
            this.transferCards(playerTwo);
            this.gameState += "\n\nCards go to Player 2";
        }
    }
    
    /**
     * Adds cards to the winnings pile of the necessary player.
     * @param player - the player to whom the cards in the winings pile go
     */
    public void transferCards(Player player) {
    		while (! this.warPile.isEmpty()) {
    			player.addToWinningsPile(this.warPile.remove(0));
    		}
    }
    
    /**
     * Displays the results of the game
     * @return a boolean value as to whether or not the game is over.
     */
    public boolean winner() {
        if (this.playerOne.isDone() || this.playerTwo.isDone()) {
            int countOne = this.playerOne.winningsCount();
            int countTwo = this.playerTwo.winningsCount();
            if (countOne > countTwo) {
                JOptionPane.showMessageDialog(null, "Player 1 wins, " + countOne + " to " + countTwo + "!");
            }
            else if (countTwo > countOne) {
            		JOptionPane.showMessageDialog(null, "Player 2 wins, " + countTwo + " to " + countOne + "!");
            }
            else {
            		JOptionPane.showMessageDialog(null, "The game ends in a tie!");
            }
            return true;
        }
        else {
        	return false;
        }
    }
}


