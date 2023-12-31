import java.util.Arrays;
import java.util.Scanner;
public class tictactoe {
	// Global variable
	static int currentPlayer = 1;
	static int  rowChoice = 4;
	static int columnsChoice = 4;
	// You can change the size of several columns and rows
	public static void main(String[] args) {
		char[][] board = new char[rowChoice][columnsChoice];
		
		// Reset the matrix in char 'o'
		for (int i = 0; i < rowChoice; i++) {
			for (int j = 0; j < columnsChoice; j++) {
				board[i][j] = '-';
				
			}
		}
		printBoard(board);
		makeMove(board);
	}
	// Print the matrix/game board
	private static void printBoard(char[][] board) {
		System.out.println("Current Board:");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	// A function that aims to allow players to start playing on the board
	private static void makeMove(char[][] board) {
		Scanner scan = new Scanner(System.in);
		int row, column;
		char symbol;
		if (currentPlayer == 1) {
			System.out.print("Player  " + currentPlayer + ", enter your move row : ");
			row = scan.nextInt();
			System.out.print("Player  " + currentPlayer + ", enter your move column : ");
			column = scan.nextInt();
			symbol = 'x';
			isValidMove(board, symbol, row ,column);
		
			
		} else {
			System.out.print("Player  " + currentPlayer + ", enter your move row : ");
			row = scan.nextInt();
			System.out.print("Player  " + currentPlayer + ", enter your move column : ");
			column = scan.nextInt();
			symbol = 'o';
			isValidMove(board, symbol, row ,column);
			
			
		}
	}
	// A function that checks the input is valid
	private static void isValidMove(char[][] board, char symbol,int row,int columns) {
		boolean toContinue = true;
		while (toContinue) {
			if (row >= 0 && row < board.length && columns  >= 0 && columns  < board[0].length && board[row][columns] == '-') {
				board[row][columns] = symbol;
				printBoard(board);
				toContinue = false;
				if(checkWin(board,symbol)){
					System.out.println("the winner is player : " + currentPlayer);
					
				}
				else {
					currentPlayer = currentPlayer == 1 ? 2 : 1;
					makeMove(board);
				}
			} else {
				System.out.println("invalid number");
				makeMove(board);
			}
		}
	}
	// A function whose purpose is to check if there is a winning game
	private static boolean checkWin(char[][] board, char symbol) {
		int countRow;
		int countColumn;
		int countDiagonal = 0;
		int countAntiDiagonal = 0;
		for (int i = 0; i < board.length; i++) {
			countRow = 0;
			countColumn = 0;
	
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == symbol){
					countRow++;
					if(rowChoice == countRow){
						return true;
					}
				}
				if(board[j][i] == symbol){
					countColumn++;
					if(rowChoice == countColumn)
						return true;
				}
				
			}
			if(board[i][i] == symbol){
				countDiagonal++;
				if(rowChoice == countDiagonal)
					return true;
				
			}
			if(board[i][columnsChoice - 1 - i] == symbol){
				countAntiDiagonal++;
				if(rowChoice == countAntiDiagonal)
					return true;
				
			}
		}
		
		return false;
		
	}
}
