import java.util.*;

public class AIPlayer implements Runnable{
  private Board b;
  private Random r;
  private String marker;

  public AIPlayer(Board b) {
    this.b = b;
    r = new Random();
    marker = "*";
  }

  public void run() {
    while(true);
  }

  public void takeTurn() {
    boolean hasMoved = false;
    //makes robot win
    //checks for pairs around top left corner
    if(!hasMoved && b.getSquare(0,0).equals("*") && b.getSquare(0,0).equals(b.getSquare(0,1))) hasMoved = b.setBoard(0 , 2 , marker);
    if(!hasMoved && b.getSquare(0,0).equals("*") && b.getSquare(0,0).equals(b.getSquare(1,1))) hasMoved = b.setBoard(2 , 2 , marker);
    if(!hasMoved && b.getSquare(0,0).equals("*") && b.getSquare(0,0).equals(b.getSquare(1,0))) hasMoved = b.setBoard(2 , 0 , marker);
    //checks for pairs around top right corner
    if(!hasMoved && b.getSquare(2,0).equals("*") && b.getSquare(2,0).equals(b.getSquare(1,0))) hasMoved = b.setBoard(0 , 0 , marker);
    if(!hasMoved && b.getSquare(2,0).equals("*") && b.getSquare(2,0).equals(b.getSquare(1,1))) hasMoved = b.setBoard(0 , 2 , marker);
    if(!hasMoved && b.getSquare(2,0).equals("*") && b.getSquare(2,0).equals(b.getSquare(2,1))) hasMoved = b.setBoard(2 , 2 , marker);
    //checks for pairs around bottom left corner
    if(!hasMoved && b.getSquare(0,2).equals("*") && b.getSquare(0,2).equals(b.getSquare(0,1))) hasMoved = b.setBoard(0 , 0 , marker);
    if(!hasMoved && b.getSquare(0,2).equals("*") && b.getSquare(0,2).equals(b.getSquare(1,1))) hasMoved = b.setBoard(2 , 0 , marker);
    if(!hasMoved && b.getSquare(0,2).equals("*") && b.getSquare(0,2).equals(b.getSquare(1,2))) hasMoved = b.setBoard(2 , 2 , marker);
    //checks for pairs around bottom right corner
    if(!hasMoved && b.getSquare(2,2).equals("*") && b.getSquare(2,2).equals(b.getSquare(2,1))) hasMoved = b.setBoard(2 , 0 , marker);
    if(!hasMoved && b.getSquare(2,2).equals("*") && b.getSquare(2,2).equals(b.getSquare(1,1))) hasMoved = b.setBoard(0 , 0 , marker);
    if(!hasMoved && b.getSquare(2,2).equals("*") && b.getSquare(2,2).equals(b.getSquare(1,2))) hasMoved = b.setBoard(0 , 2 , marker);
    //checks for x'es with middle empty
    if(!hasMoved && b.getSquare(0,0).equals("*") && b.getSquare(0,0).equals(b.getSquare(2,2))) hasMoved = b.setBoard(1 , 1 , marker);
    if(!hasMoved && b.getSquare(2,0).equals("*") && b.getSquare(2,0).equals(b.getSquare(0,2))) hasMoved = b.setBoard(1 , 1 , marker);
    //checks for crosses with middle empty
    if(!hasMoved && b.getSquare(1,0).equals("*") && b.getSquare(1,0).equals(b.getSquare(1,2))) hasMoved = b.setBoard(1 , 1 , marker);
    if(!hasMoved && b.getSquare(0,1).equals("*") && b.getSquare(0,1).equals(b.getSquare(2,1))) hasMoved = b.setBoard(1 , 1 , marker);
    //checks for middle + non-corner edge
    if(!hasMoved && b.getSquare(0,1).equals("*") && b.getSquare(0,1).equals(b.getSquare(1,1))) hasMoved = b.setBoard(2 , 1 , marker);
    if(!hasMoved && b.getSquare(1,0).equals("*") && b.getSquare(1,0).equals(b.getSquare(1,1))) hasMoved = b.setBoard(1 , 2 , marker);
    if(!hasMoved && b.getSquare(2,1).equals("*") && b.getSquare(2,1).equals(b.getSquare(1,1))) hasMoved = b.setBoard(0 , 1 , marker);
    if(!hasMoved && b.getSquare(1,2).equals("*") && b.getSquare(1,2).equals(b.getSquare(1,1))) hasMoved = b.setBoard(1 , 0 , marker);


    //checks for pairs around top left corner
    if(!hasMoved && !b.getSquare(0,0).equals("-") && b.getSquare(0,0).equals(b.getSquare(0,1))) hasMoved = b.setBoard(0 , 2 , marker);
    if(!hasMoved && !b.getSquare(0,0).equals("-") && b.getSquare(0,0).equals(b.getSquare(1,1))) hasMoved = b.setBoard(2 , 2 , marker);
    if(!hasMoved && !b.getSquare(0,0).equals("-") && b.getSquare(0,0).equals(b.getSquare(1,0))) hasMoved = b.setBoard(2 , 0 , marker);
    //checks for pairs around top right corner
    if(!hasMoved && !b.getSquare(2,0).equals("-") && b.getSquare(2,0).equals(b.getSquare(1,0))) hasMoved = b.setBoard(0 , 0 , marker);
    if(!hasMoved && !b.getSquare(2,0).equals("-") && b.getSquare(2,0).equals(b.getSquare(1,1))) hasMoved = b.setBoard(0 , 2 , marker);
    if(!hasMoved && !b.getSquare(2,0).equals("-") && b.getSquare(2,0).equals(b.getSquare(2,1))) hasMoved = b.setBoard(2 , 2 , marker);
    //checks for pairs around bottom left corner
    if(!hasMoved && !b.getSquare(0,2).equals("-") && b.getSquare(0,2).equals(b.getSquare(0,1))) hasMoved = b.setBoard(0 , 0 , marker);
    if(!hasMoved && !b.getSquare(0,2).equals("-") && b.getSquare(0,2).equals(b.getSquare(1,1))) hasMoved = b.setBoard(2 , 0 , marker);
    if(!hasMoved && !b.getSquare(0,2).equals("-") && b.getSquare(0,2).equals(b.getSquare(1,2))) hasMoved = b.setBoard(2 , 2 , marker);
    //checks for pairs around bottom right corner
    if(!hasMoved && !b.getSquare(2,2).equals("-") && b.getSquare(2,2).equals(b.getSquare(2,1))) hasMoved = b.setBoard(2 , 0 , marker);
    if(!hasMoved && !b.getSquare(2,2).equals("-") && b.getSquare(2,2).equals(b.getSquare(1,1))) hasMoved = b.setBoard(0 , 0 , marker);
    if(!hasMoved && !b.getSquare(2,2).equals("-") && b.getSquare(2,2).equals(b.getSquare(1,2))) hasMoved = b.setBoard(0 , 2 , marker);
    //checks for x'es with middle empty
    if(!hasMoved && !b.getSquare(0,0).equals("-") && b.getSquare(0,0).equals(b.getSquare(2,2))) hasMoved = b.setBoard(1 , 1 , marker);
    if(!hasMoved && !b.getSquare(2,0).equals("-") && b.getSquare(2,0).equals(b.getSquare(0,2))) hasMoved = b.setBoard(1 , 1 , marker);
    //checks for crosses with middle empty
    if(!hasMoved && !b.getSquare(1,0).equals("-") && b.getSquare(1,0).equals(b.getSquare(1,2))) hasMoved = b.setBoard(1 , 1 , marker);
    if(!hasMoved && !b.getSquare(0,1).equals("-") && b.getSquare(0,1).equals(b.getSquare(2,1))) hasMoved = b.setBoard(1 , 1 , marker);
    //checks for middle + non-corner edge
    if(!hasMoved && !b.getSquare(0,1).equals("-") && b.getSquare(0,1).equals(b.getSquare(1,1))) hasMoved = b.setBoard(2 , 1 , marker);
    if(!hasMoved && !b.getSquare(1,0).equals("-") && b.getSquare(1,0).equals(b.getSquare(1,1))) hasMoved = b.setBoard(1 , 2 , marker);
    if(!hasMoved && !b.getSquare(2,1).equals("-") && b.getSquare(2,1).equals(b.getSquare(1,1))) hasMoved = b.setBoard(0 , 1 , marker);
    if(!hasMoved && !b.getSquare(1,2).equals("-") && b.getSquare(1,2).equals(b.getSquare(1,1))) hasMoved = b.setBoard(1 , 0 , marker);

    //else tries to move into random corner or middle
    int corner = r.nextInt(5);
    if(corner == 0 && !hasMoved) hasMoved = b.setBoard(0 , 0 , marker);
    if(corner == 1 && !hasMoved) hasMoved = b.setBoard(0 , 2 , marker);
    if(corner == 2 && !hasMoved) hasMoved = b.setBoard(1 , 1 , marker);
    if(corner == 3 && !hasMoved) hasMoved = b.setBoard(2 , 0 , marker);
    if(corner == 4 && !hasMoved) hasMoved = b.setBoard(2 , 2 , marker);
  }
}
