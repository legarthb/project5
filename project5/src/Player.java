import java.util.*;

/**
 * Represents a player in the game of war.
 * @author Brian Legarth
 * @author Tommy Thetford
 * @author Chris Randall
 * @author Mark Donohue
 */


public class Player extends Deck{
	
	private ArrayList<Card> unplayedPile = new ArrayList<Card>();
	private ArrayList<Card> winningPile = new ArrayList<Card>();
	
    /**
     * Constructor. Creates a player.
     */
	public Player() {
		super();
		
	/**
	 * Returns size of the unplayedPile List.
	 * @return the size of the player's unplayed pile.
	 */
	}
	public int getUnplayedSize() {
		return unplayedPile.size();
	
	/**
	 * Returns size of the winningPile List.
	 * @return the size of the player's winning pile.
	 */
	}
	public int getWinningSize() {
		return winningPile.size();
	
	/**
	 * Adds a specified card to the player's unplayed pile.
	 * @param c - the card to be added
	 */
	}
	public void addToUnplayedPile(Card c) {
		this.unplayedPile.add(0, c);
		
	/**
	 * Adds a specified card to the player's winning pile.
	 * @param c - the card to be added
	 */
	}
	public void addToWinningsPile(Card c) {
		this.winningPile.add(0, c);
	}
	
	/**
	 * Removes and returns the first card of the player's unplayed pile.
	 * @return the first card in the player's unplayed pile.
	 */
	public Card getCard() {
		return unplayedPile.remove(0);
	}
	
	/**
	 * Checks to see if the unplayed pile is empty
	 * @return a boolean value true if the size of unplayed pile is zero, false otherwise
	 */
	public boolean isDone() {
		return unplayedPile.size() == 0;
	}
	
	/**
	 * Returns the size of the player's winnings pile.
	 * @return the size of the player's winnings pile.
	 */
	public int winningsCount() {
		return winningPile.size();
	}
}
