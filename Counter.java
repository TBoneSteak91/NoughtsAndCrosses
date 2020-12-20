/* Anthony Lydon - 2497467
 * 
 * A class to represent a game counter.
 */

public class Counter {

	// An attribute referencing the Player object the counter belongs to.
	private Player player;

	// A constructor.
	public Counter(Player player) {
		this.player = player;
	}

	// A getter for the player attribute.
	public Player getPlayer() {
		return player;
	}

	// A toString method returning the Player's counter symbol.
	public String toString() {
		return Character.toString(player.getCounterSymbol());
	}

	/*
	 * A boolean equals method returning true if, when passed another object, the
	 * object is a Counter from the same Player.
	 */
	public boolean equals(Object counter) {
		if (!(counter instanceof Counter)) { // Checking if the object is a Counter.
			return false;
		} else {
			Counter other = (Counter) counter;
			if (player.getCounterSymbol() == other.player.getCounterSymbol()) {
				// Checking if the counter belongs to the same player.
				return true;
			} else {
				return false;
			}
		}
	}
}
