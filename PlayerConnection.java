import java.io.*;
import java.net.Socket;

public class PlayerConnection implements Runnable{
	private Socket playerSocket;
	private Board b;
	private InputStream in;
	private PrintStream out;
	private String marker;


	public PlayerConnection(Socket s, Board b){
		playerSocket = s;
		this.b = b;
		marker = "";
		 try {
	        in = playerSocket.getInputStream();
	        out = new PrintStream(playerSocket.getOutputStream());
	     } catch (IOException e) {
	    		e.printStackTrace();
	  		}
	}

	@Override
	public void run() {
		out.println("Game started!");
		BufferedReader b = new BufferedReader(new InputStreamReader(in));
		out.println("Choose a character as your marker: ");
		try {
			marker = b.readLine();
			out.println("Your marker will be " + marker);
			if(marker.length > 1) marker = "x";
		} catch(IOException e) {
			e.printStackTrace();
		}
		//out.println(b);
		while(true);
	}

	public void takeTurn() {
		out.println("It's your turn!");
		out.println(b);
	}
}
