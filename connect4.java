import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class connect4 {

	public static void main(String[] args) {
		char[][] grid = new char[6][7];
		for (int row = 0; row < grid.length; row++){
			for (int col = 0; col < grid[0].length; col++){
				grid[row][col] = ' ';
			}
		}
		char player1 = 'X';
		char player2 = 'O';
		boolean winner = false;
		boolean winner2 = false;
		while(winner == false && winner2 == false) {
			int move = humanMove(grid);
			//add
			for (int row = grid.length-1; row >= 0; row--){
				if(grid[row][move] == ' '){
					grid[row][move] = player1;
					break;
				}
			}
			System.out.println("Player 2's Turn: ");
			int player2Move = computerMove(grid);
			//add
			for (int row1 = grid.length-1; row1 >= 0; row1--){
				if(grid[row1][player2Move] == ' '){
					grid[row1][player2Move] = player2;
					break;
				}
			}
			printBoard(grid);
			winner = checkWinner(grid, player1);
			winner2 = checkWinner(grid, player2);
			if(winner == true)
				System.out.println("X Wins!");
			if(winner2 == true)
				System.out.println("O Wins!");
			
			//check for winner
			
		}
	}

	public static void printBoard(char[][] board) {
		System.out.println(" 1 2 3 4 5 6 7 8 ");
		System.out.println(" - - - - - - - - ");
		for (int row = 0; row < board.length; row++){
			System.out.print("|");
			for (int col = 0; col < board[0].length; col++){
				System.out.print(board[row][col]);
				System.out.print("|");
			}
			System.out.println();
	}
}
	
	public static int humanMove(char[][] board) {
		boolean valid = false;
		int play = 0;
		while(valid == false) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Player please enter column 0-6: ");
			play = scan.nextInt();
			if(play < 0 || play > 6)
				continue;
			else
				valid = true;
			
			
		}
		return play;
	}
	
	public static int computerMove(char[][] board) {
		Random rand = new Random();
		int computerMove = rand.nextInt(7);
		boolean valid = false;
		return computerMove;
		}
	public static boolean checkWinner(char[][] board, char player) {
		//check for 4 across
				for(int row = 0; row<board.length; row++){
					for (int col = 0;col < board[0].length - 3;col++){
						if (board[row][col] == player   && 
							board[row][col+1] == player &&
							board[row][col+2] == player &&
							board[row][col+3] == player){
							return true;
						}
					}			
				}
				//check for 4 up and down
				for(int row = 0; row < board.length - 3; row++){
					for(int col = 0; col < board[0].length; col++){
						if (board[row][col] == player   && 
							board[row+1][col] == player &&
							board[row+2][col] == player &&
							board[row+3][col] == player){
							return true;
						}
					}
				}
				//check upward diagonal
				for(int row = 3; row < board.length; row++){
					for(int col = 0; col < board[0].length - 3; col++){
						if (board[row][col] == player   && 
							board[row-1][col+1] == player &&
							board[row-2][col+2] == player &&
							board[row-3][col+3] == player){
							return true;
						}
					}
				}
				//check downward diagonal
				for(int row = 0; row < board.length - 3; row++){
					for(int col = 0; col < board[0].length - 3; col++){
						if (board[row][col] == player   && 
							board[row+1][col+1] == player &&
							board[row+2][col+2] == player &&
							board[row+3][col+3] == player){
							return true;
						}
					}
				}
		return false;
	}

public static int evaluate(char[][] board, char player, int play) {
	int eval = 0;
	for(int row = 0; row<board.length; row++){
		for (int col = 0;col < board[0].length - 3;col++){
			if (board[row][play] == player) { //I would like to of gotten help on this section
				continue; //as it ties in a lot of the Mini-Max
			}
			else
				eval++;
		}
	}
	return eval;
}
	
public static int miniMax(char [][] board, int depth, boolean maximizingPlayer, boolean winner, char player) {
	int minVal;
	int maxVal = 0;
	//int player2 = 1;
	if (depth == 0 || winner == true)
		return board.hashCode();
	if (maximizingPlayer == true) {
		maxVal = Integer.MIN_VALUE;
		for(int row = 0; row<board.length; row++){
			for (int col = 0;col < board[0].length - 3;col++){
				if (board[row][col] == player   && 
					board[row][col+1] == player &&
					board[row][col+2] == player)
					maxVal+=1;
	}
	
}
		for(int row = 0; row < board.length - 3; row++){
			for(int col = 0; col < board[0].length; col++){
				if (board[row][col] == player   && 
					board[row+1][col] == player &&
					board[row+2][col] == player)
					maxVal+=1;
			}
		}
		for(int row = 3; row < board.length; row++){
			for(int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == player   && 
					board[row-1][col+1] == player &&
					board[row-2][col+2] == player)
					maxVal+=1;
			}
		}
		for(int row = 0; row < board.length - 3; row++){
			for(int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == player   && 
					board[row+1][col+1] == player &&
					board[row+2][col+2] == player)
					maxVal+=1;
			}
		}
	return evaluate(board, player, maxVal);	
}
	else {
		minVal = Integer.MAX_VALUE;
		for(int row = 0; row<board.length; row++){
			for (int col = 0;col < board[0].length - 3;col++){
				if (board[row][col] == player   && 
					board[row][col+1] == player &&
					board[row][col+2] == player)
					minVal+=1;
	}
}
		for(int row = 0; row < board.length - 3; row++){
			for(int col = 0; col < board[0].length; col++){
				if (board[row][col] == player   && 
					board[row+1][col] == player &&
					board[row+2][col] == player)
					minVal+=1;
			}
		}
		for(int row = 3; row < board.length; row++){
			for(int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == player   && 
					board[row-1][col+1] == player &&
					board[row-2][col+2] == player)
					minVal+=1;
			}
		}
		for(int row = 0; row < board.length - 3; row++){
			for(int col = 0; col < board[0].length - 3; col++){
				if (board[row][col] == player   && 
					board[row+1][col+1] == player &&
					board[row+2][col+2] == player)
					minVal+=1;
			}
		}
		return evaluate(board, player, minVal);
}
}
}


