/* Anthony Lydon - 2497467
 * 
 * A class to represent a column. 
 */

public class Column {

	/*
	 * Attributes representing the number of rows, the position the next counter
	 * dropped into the column will land in, and an array of the counters.
	 */
	private int numRows;
	private int nextSpace; // Represents the next space in the column a counter will fall into
	private Counter[] counterArray;

	// A constructor.
	public Column(int numRows) {
		this.numRows = numRows;
		counterArray = new Counter[numRows]; // Making a counterArray, which length is the number of rows.
		nextSpace = numRows - 1; // Setting the default position a counter will land in
	}

	// A getter for the counter array (added for final task)
	public Counter[] getCounterArray() {
		return counterArray;
	}

	// A boolean method which returns true if the column is full.
	public boolean isFull() {
		if (counterArray[0] == null) // Checking if the top space is empty
			return false;
		else
			return true; // Returning true if the top space is occupied by a counter
	}

	/*
	 * A boolean add method which takes as its arguments a Counter object. If the
	 * column is not full, the method returns true and adds the counter to the
	 * column. The position of the added counter is determined using the nextSpace
	 * variable
	 */
	public boolean add(Counter counter) {
		if (isFull())
			return false;
		else
			counterArray[nextSpace] = counter; 
		/*
		 * Adding a counter either to the bottom of the column or on top of the last
		 * counter.
		 */
		nextSpace -= 1; // Decrementing the target position for the next counter
		return true;

	}

	/*
	 * A method that takes a row as an argument and returns a String: either a
	 * counter character if there is a counter at that position or space character
	 * if the position is empty.
	 */
	public String displayRow(int rowNumber) {
		if (counterArray[rowNumber] == null) // Checking if the position is empty.
			return " ";
		else
			return (counterArray[rowNumber].toString());
		// Using the Counter's toString method to return a counter symbol
	}

	/*
	 * A method that displays a full column, with each row printed on a separate
	 * line, using the displayRow method.
	 */
	public void display() {
		for (int i = 0; i < numRows; i++) // Looping over all the rows
			System.out.println(displayRow(i)); // Printing a row on a new line

	}
}
