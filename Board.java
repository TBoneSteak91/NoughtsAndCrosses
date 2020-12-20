/* Anthony Lydon - 2497467
 * 
 * A class to represent the game board.
 */

public class Board {
	/*
	 * Attributes representing the number of rows and columns and the array of
	 * columns
	 */
	private int rows;
	private int columns;
	private Column[] columnArray;

	public Board(int rows, int columns) { // A constructor
		this.rows = rows;
		this.columns = columns;
		columnArray = new Column[columns]; // Making a columnArray, which length is the number of columns.
		for (int i = 0; i < columns; i++) {
			columnArray[i] = new Column(rows);
			// Setting the length of each column to the number of rows using a for loop
		}
	}

	/*
	 * A boolean add method which takes a counter and a column number as its
	 * arguments and returns true if the board successfully adds a counter to the
	 * column and otherwise only returns false.
	 */
	public boolean add(Counter counter, int columnNumber) {
		if (columnArray[columnNumber].isFull()) // Checking if the column is full
			return false;
		else
			columnArray[columnNumber].add(counter); // Using the column's add method to add a counter.
		return true;

	}

	/*
	 * A toString method which returns a String representation of the board. 
	 */

	public String toString() {
		String board = new String(); // Making a String
		for (int i = 0; i < columns; i++)
			board += "|" + i; // Adding the column numbers along the top of the board
		board += "|\n";
		for (int i = 0; i < columns; i++)
			board += "--"; // Adding the line separating the column numbers from the board
		board += "\n";
		for (int k = 0; k < rows; k++) { // A for loop to loop over all rows
			for (int i = 0; i < columns; i++) 
				/*
				 * A second for loop nested in the row loop, to loop over each column space in a
				 * row
				 */
				board += "|" + columnArray[i].displayRow(k); 
			/*
			 * Using the Column object's displayRow method to add all the counter symbols
			 * and empty space characters to the board String.
			 */
			board += "|\n";
		}
		return board;
	}

	/*
	 * A boolean method which uses a for loop to check if the board is full by
	 * returning true if all columns are full and false if otherwise.
	 */
	public boolean isFull() {
		for (int i = 0; i < columns; i++)
			if (columnArray[i].isFull()) // Checking if a column is full using the Column object's isFull method
				continue;
			else
				return false;
		return true; // Returning true if all columns are full
	}

	// A getter for the Columns

	public int getColumns() {
		return columns;
	}

	/*
	 * A boolean method that takes a player as an argument and checks if that player
	 * has won
	 */
	public boolean hasWon(Player player) {

		/*
		 * Four for loops each checking if a set of four adjacent counters exist from the
		 * same player. There is a for loop for each type of potential winning position:
		 * vertical, horizontal, diagonal left and diagonal right. Each for loop contains
		 * a method to check either a row or column, and then this is looped over the whole 
		 * board
		 */

		for (int i = 0; i < columns; i++) { 
			// looping over the all the columns with a method to check for a vertical win.
			if (checkVerticals(player, i))
				return true;
		}

		for (int k = 0; k < rows; k++) { 
			// looping over the all the rows with a method to check for a horizontal win.
			if (checkHorizontals(player, k))
				return true;
		}

		for (int j = 0; j < rows - 3; j++) { 
			/*
			 * looping over the rows with a method to check for a diagonal win from the one
			 * direction, starting from the left side.
			 */
			if (checkDiagonalsLeft(player, j))
				return true;
		}

		for (int a = 0; a < rows - 3; a++) { 
			/*
			 * looping over the rows with a method to check for a diagonal win from the
			 * opposite direction, starting from the right side
			 */
			if (checkDiagonalsRight(player, a))
				return true;
		}

		return false; 
		// returns false if the entire board is checked via the four loops and no win is found
	}

	/*
	 * A method which, when passed a player and a column, checks if a vertical win
	 * exists for the player in the column. It uses another method to check if four 
	 * counters match from a particular position, then loops this over the whole column
	 */

	public boolean checkVerticals(Player player, int columnNum) {
		for (int i = 0; i < rows - 3; i++) { // Looping through the column by row position
			if (checkVerticalPosition(player, columnNum,i))
	        // Using a method to check if a vertical position of four wins.
				return true; // returns true if a win exists.
		}
		return false; // false if no win exists in the column
	}

	/*
	 * A method that when passed a player, column and a row index which acts as a
	 * start position, checks four adjacent counters vertically to see if they match
	 */

	public boolean checkVerticalPosition(Player player, int column, int rowNum) {
		for (int i = 0; i < 4; i++) { // Looping over four positions
			if (columnArray[column].getCounterArray()[rowNum + i] == null) 
				// Checking if there is an empty space and returning false if so.
				return false;
			else if (columnArray[column].getCounterArray()[rowNum + i]
					.equals(new Counter(player))) // Checking if a counter matches the player's counter
				continue; // If the counter matches, the next counter is checked.
			else
				return false; // If a different counter is found, false is returned.
		}
		return true; // If the loop is completed and all four counters match, true is returned.
	}

	/*
	 * A method which, when passed a player and a row number, checks if a horizontal
	 * win exists for the player in the row. It uses another method to check if four 
	 * counters match from a particular position, then loops this over the whole row
	 */

	public boolean checkHorizontals(Player player, int rowNum) {
		for (int i = 0; i < columns - 3; i++) { // Looping through the row by column position
			if (checkHorizontalPosition(player, rowNum,i)) 
			// Using a method to check if a horizontal position of four wins.
				return true; // returns true if a win exists.
		}
		return false; // false if no win exists in the row

	}

	/*
	 * A method that when passed a player, row number and a row index which acts as
	 * a start position, checks four adjacent counters horizontally to see if they
	 * match. 
	 */

	public boolean checkHorizontalPosition(Player player, int row, int columnNum) {
		for (int i = 0; i < 4; i++) { // Looping over four positions
			if (columnArray[columnNum + i].getCounterArray()[row] == null)
			// Checking if there is an empty space and returning no win if so.
																			 
				return false;
			else if (columnArray[columnNum + i].getCounterArray()[row].equals(new Counter(player))) 
			//Checking if a counter matches the player's counter						 
				continue; // If the counter matches, the next counter is checked.
			else
				return false; // If a different counter is found, false is returned.
		}
		return true; // If the loop is completed and all four counters match, true is returned.
	}

	/*
	 * A method which, when passed a player and a row number, checks if a diagonal
	 * win exists for the player in the row, from the left direction. It uses another 
	 * method to check if four counters match from a particular position, then loops 
	 * this over the whole row
	 */

	public boolean checkDiagonalsLeft(Player player, int rowNum) {
		for (int i = 0; i < columns - 3; i++) { // Looping through the row by column position, starting from the left.
			if (checkDiagonalPositionLeft(player, rowNum,i)) 
				// Using a method to check if a diagonal position of four wins.
						 
				return true; // returns true if a win exists
		}
		return false; // false if no win exists
	}

	/*
	 * A method that when passed a player, row number and a row index which acts as
	 * a start position, checks four adjacent counters diagonally to see if they
	 * match, from one direction.
	 */

	public boolean checkDiagonalPositionLeft(Player player, int row, int checkCount) {
		for (int i = 0; i < 4; i++) { // Looping over four positions, starting from the left.
			if (columnArray[checkCount + i].getCounterArray()[row+ i] == null)
			 // Checking if there is an empty space and returning no win if so.					 
				return false;
			else if (columnArray[checkCount + i].getCounterArray()[row + i].equals(new Counter(player))) 
			// Checking if a counter matches the player's counter
				continue; // If the counter matches, the next counter is checked.
			else
				return false; // If a different counter is found, false is returned.
		}
		return true; // If the loop is completed and all four counters match, true is returned.
	}

	/*
	 * A method which, when passed a player and a row number, checks if a diagonal
	 * win exists for the player in the row, from the right direction. It uses another 
	 * method to check if four counters match from a particular position, then loops 
	 * this over the whole row
	 */

	public boolean checkDiagonalsRight(Player player, int rowNum) {
		for (int i = columns - 1; i > 2; i--) { // Looping over four positions, this time from the right.
			if (checkDiagonalPositionRight(player, rowNum, i))
				return true; // returns true if a win exists
		}
		return false; // false if no win exists
	}

	/*
	 * A method that when passed a player, row number and a row index which acts as
	 * a start position, checks four adjacent counters diagonally to see if they
	 * match, from a different direction than checkDiagonalPositionLeft
	 */

	public boolean checkDiagonalPositionRight(Player player, int row, int checkCount) {
		for (int i = 0; i < 4; i++) { // Looping over four positions, starting from the right.
			if (columnArray[checkCount - i].getCounterArray()[row+ i] == null) 
				// Checking if there is an empty space and returning no win if so.
				return false;
			else if (columnArray[checkCount - i].getCounterArray()[row + i].equals(new Counter(player)))
				continue; // If the counter matches, the next counter is checked.
			else
				return false; // If a different counter is found, false is returned.
		}
		return true; // If the loop is completed and all four counters match, true is returned.
	}

}
