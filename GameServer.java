import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class GameServer {

    private static int port = 8003;
    private static int maxConnections = 2;

    public static void main(String[] args) {
        ServerSocket myServer = null;
        Socket playerSocket = null;
        int i = 0;
        PlayerConnection[] players = new PlayerConnection[2];


        try {
            myServer = new ServerSocket(port);
            System.out.println("Server started");
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            Board b = new Board();
            while(i++ < maxConnections || maxConnections == 0) {
            	  PlayerConnection connection = null;
                playerSocket = myServer.accept();
                players[i-1] = connection;
                players[i-1] = new PlayerConnection(playerSocket, b);

                Thread t = new Thread(players[i-1]);
                t.start();
                System.out.println("Got a player!");

            }
            System.out.println("Both players ready!");
            while(true) {
              players[0].takeTurn();
              players[1].takeTurn();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
