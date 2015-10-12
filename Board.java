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
	public void setBoard(int column, int row, String s){
		board[column][row] = s;
	}
	public String[][] getBoard(){
		return board;
	}
}
