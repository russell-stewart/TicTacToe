import java.io.Serializable;

public class Board implements Serializable{

	private String[][] board;

	public Board(){
		board = new String [3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = "-";
			}
		}
	}
	public String toString(){
		String s = "";
		for(int i = 0; i<board.length; i++){
			for(int j = 0;j<board[i].length; j++){
				s += board[i][j];
			}
			s+= "\n";
		}
		return s;
	}
	public void setBoard(String[][] s){
		board = s;
	}
	public boolean setBoard(int column, int row, String s){
		if(board[column][row].equals("-")) {
			board[column][row] = s;
			return true;
		}
		else return false;
	}
	public String[][] getBoard(){
		return board;
	}

	public boolean isGameDone() {
		if(board[0][0].equals(board[0][1]) && board [0][1].equals(board[0][2]) && !board[0][0].equals("-")) return true;
		else if(board[1][0].equals(board[1][1]) && board [1][1].equals(board[1][2]) && !board[1][0].equals("-")) return true;
		else if(board[2][0].equals(board[2][1]) && board [2][1].equals(board[2][2]) && !board[2][0].equals("-")) return true;
		else if(board[0][0].equals(board[1][0]) && board [1][0].equals(board[2][0]) && !board[0][0].equals("-")) return true;
		else if(board[0][1].equals(board[1][1]) && board [1][1].equals(board[2][1]) && !board[0][1].equals("-")) return true;
		else if(board[0][2].equals(board[1][2]) && board [1][2].equals(board[2][2]) && !board[0][2].equals("-")) return true;
		else if(board[0][0].equals(board[1][1]) && board [1][1].equals(board[2][2]) && !board[0][0].equals("-")) return true;
		else if(board[0][2].equals(board[1][1]) && board [1][1].equals(board[2][0]) && !board[0][2].equals("-")) return true;
		else if(!board[0][0].equals("-") && !board[0][1].equals("-") && !board[0][2].equals("-") && !board[1][0].equals("-") && !board[1][1].equals("-") && !board[1][2].equals("-") && !board[2][0].equals("-") && !board[2][1].equals("-") && !board[2][2].equals("-")) return true;
		else return false;
	}
}
