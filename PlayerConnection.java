import java.io.*;
import java.net.Socket;

public class PlayerConnection implements Runnable{
	private Socket playerSocket;
	private Board b;
	private InputStream in;
	private PrintStream out;
	private String marker;
	private BufferedReader br;


	public PlayerConnection(Socket s, Board b){
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
			out.println("It's your turn!");
			out.println(b);
			out.println("Enter a column and row to place your marker.");
			out.println("Enter a Row (1, 2, or 3): ");
			int row = Integer.parseInt(br.readLine()) - 1;
			out.println("Enter a Column (1, 2, or 3):");
			int col = Integer.parseInt(br.readLine()) - 1;
			b.setBoard(col , row , marker);
			out.println(b);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
