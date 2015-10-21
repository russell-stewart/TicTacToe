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
        System.out.println("How many robots would you like to play? (0-2):");
        int response = s.nextInt();
        if(response == 0) {
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
          }else if(response == 1) {
            Board b = new Board();
            System.out.println("Enter a difficulty for the robot (1-5): ");
            int d = s.nextInt();
            AIPlayer ai = new AIPlayer(b , "*" , d);
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
          }else if(response == 2) {
            Board b = new Board();
            System.out.println("Enter a difficulty for the robot (1-5): ");
            int d = s.nextInt();
            AIPlayer p1 = new AIPlayer(b , "x" , d);
            AIPlayer p2 = new AIPlayer(b , "o" , d);
            System.out.println("Robots ready!");
            while(!b.isGameDone()) {
              p1.takeTurn();
              p2.takeTurn();
            }
            System.out.println(b);
            System.out.println("Game over!");
          }else {
            System.out.println("no.");
          }
    }
}
