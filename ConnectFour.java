/* Anthony Lydon - 2497467
 * 
 * A class that holds a main method.
 */

import java.util.Random;

public class ConnectFour {

	public static void main(String[] args) {
		
		/*
		 * Given test code for task 1.c
		 * 
		 * Player p1 = new Player( "Clive" , 'x' ); Counter c = new Counter(p1);
		 * System.out.println(c.getPlayer().toString() + ", " + c.toString());
		 */

		/*
		 * Given test code for task 2.c
		 * 
		 * Column col = new Column( 4 ); for ( int i= 0 ;i< 5 ;i++) { Boolean result =
		 * col.add( new Counter(p1)); System.out.println(result); }
		 */
		
		/* Given test code for task 2.e
		 * 
		 * Column col = new Column( 6 ); Player p1 = new Player( "Clive" , 'o' ); Player
		 * p2 = new Player( "Sharon" , 'x' ); for ( int i= 0 ;i< 3 ;i++) { col.add( new
		 * Counter(p1)); col.add( new Counter(p2)); } col.display();
		 */
		
		/* Given test code for task 3.e
		 * 
		 * Board board = new Board( 6 , 7 ); Player p1 = new Player( "Clive" , 'o' );
		 * Player p2 = new Player( "Sharon" , 'x' ); board.add( new Counter(p2), 6 );
		 * board.add( new Counter(p1), 3 ); board.add( new Counter(p2), 4 ); board.add(
		 * new Counter(p1), 4 ); board.add( new Counter(p2), 5 ); board.add( new
		 * Counter(p1), 5 ); board.add( new Counter(p2), 6 ); board.add( new
		 * Counter(p1), 5 ); board.add( new Counter(p2), 6 ); board.add( new
		 * Counter(p1), 6 );
		 */
		
		/* Code to test tasks 4 and 5
		 * Board board = new Board( 6 , 7 ); Player p1 = new Player( "Clive" , 'o' );
		 * Player p2 = new Player( "Sharon" , 'x' ); game(p1,p2,board);
		 * System.out.print(board.toString());
		 */
		
		
	}

	/*
	 * A static method in which two players play randomly, including the winner
	 * method from the final task
	 */

	public static void game(Player p1, Player p2, Board board) {
		Random rand = new Random();
		int randomNum = rand.nextInt(board.getColumns()); 
		// Generating a random number using java.util.Random, between 0 and the number of columns.
															
		do { // a do while loop that executes as long as the board isn't full.
			do { // a do while loop for the first player's turn
				if (board.add(new Counter(p1),randomNum)) {
			    // tries to add a Counter to a random column and ends the loop if successful					 
					break;
				} else
					randomNum = rand.nextInt(board.getColumns()); 
				    // generates a new random number if the board is full and tries again
											 
				continue;
			} while (true);

			if (board.hasWon(p1)) { // Checks if player 1 won on their turn, and end the game loop if so
				break;
			}

			randomNum = rand.nextInt(board.getColumns()); // generates a new random number for player 2

			do { // the same do while loop as before, but for player 2's turn
				if (board.add(new Counter(p2), randomNum)) {
					break;
				} else
					randomNum = rand.nextInt(board.getColumns());
				continue;
			} while (true);
			if (board.hasWon(p2)) { // Checks if player 2 won on their turn, and ends the game loop if so
				break;
			}

			randomNum = rand.nextInt(board.getColumns()); // A new random number for player 1
		} while (!board.isFull());

	}

}
