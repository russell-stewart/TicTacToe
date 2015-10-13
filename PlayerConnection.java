import java.io.*;
import java.net.Socket;

public class PlayerConnection implements Runnable{
	private Socket playerSocket;
	private Board b;
	private InputStream in;
	private PrintStream out;
	private String marker;
	private BufferedReader br;
	private boolean isDone;
	private boolean shouldPrintGameOver;


	public PlayerConnection(Socket s, Board b){
		shouldPrintGameOver = true;
		isDone = false;
		playerSocket = s;
		this.b = b;
		marker = "";
		 try {
	        in = playerSocket.getInputStream();
	        out = new PrintStream(playerSocket.getOutputStream());
					br = new BufferedReader(new InputStreamReader(in));
	     } catch (IOException e) {
	    		e.printStackTrace();
	  		}
	}

	@Override
	public void run() {
		out.println("Game started!");
		//out.println(b);
		while(true);
	}

	public boolean isDone() {
		return isDone;
	}

	public void takeTurn() {
		try{
			if(marker.length() < 1) {
				out.println("Choose a character as your marker: ");
				try {
					marker = br.readLine();
					if(marker.length() > 1) marker = "x";
					out.println("Your marker will be " + marker);
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			if(b.isGameDone()) {
				if(shouldPrintGameOver) {
					out.println(b);
					out.println("Game over!");
					isDone = true;
					shouldPrintGameOver = false;
				}
			} else {
				out.println("It's your turn!");
				int row;
				int col;
				boolean shouldMove = true;

				while(shouldMove) {
						out.println(b);
						out.println("Enter a column and row to place your marker.");
						out.println("Enter a Column (1, 2, or 3): ");
						row = Integer.parseInt(br.readLine()) - 1;
						out.println("Enter a Row (1, 2, or 3):");
						col = Integer.parseInt(br.readLine()) - 1;
						if(b.setBoard(col , row , marker)) shouldMove = false;
						else out.println("Invalid move!");
					}
					out.println(b);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
