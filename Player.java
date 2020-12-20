/* Anthony Lydon - 2497467
 * 
 * A class to represent a player. 
 */

public class Player {

	// Attributes storing the player's name and their counter symbol.
	private String name;
	private char counterSymbol;

	// A constructor
	public Player(String name, char counterSymbol) {
		this.name = name;
		this.counterSymbol = counterSymbol;
	}

	// Getters for both the name and counter symbol.
	public String getName() {
		return name;
	}

	public char getCounterSymbol() {
		return counterSymbol;
	}

	// A toString method returning the player's name.
	public String toString() {
		return name;
	}

}
