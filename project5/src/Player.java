import java.util.*;

public class Player extends Deck{
	
	private ArrayList<Card> unplayedPile = new ArrayList<Card>();
	private ArrayList<Card> winningPile = new ArrayList<Card>();
	
	public Player() {
		super();
	}
	public int getUnplayedSize() {
		return unplayedPile.size();
	}
	public int getWinningSize() {
		return winningPile.size();
	}
	public void addToUnplayedPile(Card c) {
		this.unplayedPile.add(0, c);
	}
	public void addToWinningsPile(Card c) {
		this.winningPile.add(0, c);
	}
	public Card getCard() {
		return unplayedPile.remove(0);
	}
	public boolean isDone() {
		return unplayedPile.size() == 0;
	}
	public int winningsCount() {
		return winningPile.size();
	}
}
