import java.util.LinkedList;

publicLinkedList<E>yer {
	private final LinkedList<Card> deck;
	private string name;

	public Player(String name, LinkedList<Card> deck) {
		this.name = name;
		this.deck = deck;
	}
	
	public boolean hasCard() {
		return !deck.isEmpty();
}
