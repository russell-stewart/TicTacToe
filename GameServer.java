import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;


public class GameServer {

    private static int port = 8003;
    private static int maxConnections = 2;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Would you like to play with one robot? (y/n)");
        String response = s.nextLine();
        if(response.equals("n")) {
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
               while(!players[0].isDone() || !players[1].isDone()) {
                 players[0].takeTurn();
                 players[1].takeTurn();
               }
             } catch (IOException e) {
               e.printStackTrace();
             }
          }else {
            Board b = new Board();
            AIPlayer ai = new AIPlayer(b);
            System.out.println("Robot made!");
            ServerSocket myServer = null;
            Socket playerSocket = null;

            try {
              myServer = new ServerSocket(port);
              System.out.println("Server started");
              PlayerConnection player = null;
              playerSocket = myServer.accept();
              player = new PlayerConnection(playerSocket , b);
              Thread t = new Thread(player);
              t.start();
              System.out.println("Got a player!");
              Thread t1 = new Thread(ai);
              t1.start();
              System.out.println("Robot ready!");
              while(!b.isGameDone()) {
                player.takeTurn();
                ai.takeTurn();
              }
              player.takeTurn();
            }catch (IOException e) {
              System.out.println("server error");
            }
          }
    }
}
