import java.util.*;

public class AIPlayer implements Runnable{
  private Board b;
  private Random r;
  private String marker;
  private int difficulty;

  public AIPlayer(Board b , String marker , int difficulty) {
    this.b = b;
    r = new Random();
    this.marker = marker;
    this.difficulty = difficulty;
  }

  public void run() {
    while(true);
  }

  public void takeTurn() {
    boolean hasMoved = false;
    if(b.isGameDone()) hasMoved = true;

    Random rand = new Random();
    int x1 = rand.nextInt(difficulty);
    int x2 = rand.nextInt(difficulty);
    if(!hasMoved && x1 == x2 && difficulty < 5) {
      while(!hasMoved) {
        int col = rand.nextInt(3);
        int row = rand.nextInt(3);
        hasMoved = b.setBoard(col , row , marker);
      }
    }

    //makes robot win
    //checks for pairs around top left corner
    if(!hasMoved && b.getSquare(0,0).equals(marker) && b.getSquare(0,0).equals(b.getSquare(0,1))) hasMoved = b.setBoard(0 , 2 , marker);
    if(!hasMoved && b.getSquare(0,0).equals(marker) && b.getSquare(0,0).equals(b.getSquare(1,1))) hasMoved = b.setBoard(2 , 2 , marker);
    if(!hasMoved && b.getSquare(0,0).equals(marker) && b.getSquare(0,0).equals(b.getSquare(1,0))) hasMoved = b.setBoard(2 , 0 , marker);
    //checks for pairs around top right corner
    if(!hasMoved && b.getSquare(2,0).equals(marker) && b.getSquare(2,0).equals(b.getSquare(1,0))) hasMoved = b.setBoard(0 , 0 , marker);
    if(!hasMoved && b.getSquare(2,0).equals(marker) && b.getSquare(2,0).equals(b.getSquare(1,1))) hasMoved = b.setBoard(0 , 2 , marker);
    if(!hasMoved && b.getSquare(2,0).equals(marker) && b.getSquare(2,0).equals(b.getSquare(2,1))) hasMoved = b.setBoard(2 , 2 , marker);
    //checks for pairs around bottom left corner
    if(!hasMoved && b.getSquare(0,2).equals(marker) && b.getSquare(0,2).equals(b.getSquare(0,1))) hasMoved = b.setBoard(0 , 0 , marker);
    if(!hasMoved && b.getSquare(0,2).equals(marker) && b.getSquare(0,2).equals(b.getSquare(1,1))) hasMoved = b.setBoard(2 , 0 , marker);
    if(!hasMoved && b.getSquare(0,2).equals(marker) && b.getSquare(0,2).equals(b.getSquare(1,2))) hasMoved = b.setBoard(2 , 2 , marker);
    //checks for pairs around bottom right corner
    if(!hasMoved && b.getSquare(2,2).equals(marker) && b.getSquare(2,2).equals(b.getSquare(2,1))) hasMoved = b.setBoard(2 , 0 , marker);
    if(!hasMoved && b.getSquare(2,2).equals(marker) && b.getSquare(2,2).equals(b.getSquare(1,1))) hasMoved = b.setBoard(0 , 0 , marker);
    if(!hasMoved && b.getSquare(2,2).equals(marker) && b.getSquare(2,2).equals(b.getSquare(1,2))) hasMoved = b.setBoard(0 , 2 , marker);
    //checks for x'es with middle empty
    if(!hasMoved && b.getSquare(0,0).equals(marker) && b.getSquare(0,0).equals(b.getSquare(2,2))) hasMoved = b.setBoard(1 , 1 , marker);
    if(!hasMoved && b.getSquare(2,0).equals(marker) && b.getSquare(2,0).equals(b.getSquare(0,2))) hasMoved = b.setBoard(1 , 1 , marker);
    //checks for crosses with middle empty
    if(!hasMoved && b.getSquare(1,0).equals(marker) && b.getSquare(1,0).equals(b.getSquare(1,2))) hasMoved = b.setBoard(1 , 1 , marker);
    if(!hasMoved && b.getSquare(0,1).equals(marker) && b.getSquare(0,1).equals(b.getSquare(2,1))) hasMoved = b.setBoard(1 , 1 , marker);
    //checks for middle + non-corner edge
    if(!hasMoved && b.getSquare(0,1).equals(marker) && b.getSquare(0,1).equals(b.getSquare(1,1))) hasMoved = b.setBoard(2 , 1 , marker);
    if(!hasMoved && b.getSquare(1,0).equals(marker) && b.getSquare(1,0).equals(b.getSquare(1,1))) hasMoved = b.setBoard(1 , 2 , marker);
    if(!hasMoved && b.getSquare(2,1).equals(marker) && b.getSquare(2,1).equals(b.getSquare(1,1))) hasMoved = b.setBoard(0 , 1 , marker);
    if(!hasMoved && b.getSquare(1,2).equals(marker) && b.getSquare(1,2).equals(b.getSquare(1,1))) hasMoved = b.setBoard(1 , 0 , marker);
    //checks for two corners in same row or column
    if(!hasMoved && b.getSquare(0,0).equals(marker) && b.getSquare(0,0).equals(b.getSquare(0,2))) hasMoved = b.setBoard(0 , 1 , marker);
    if(!hasMoved && b.getSquare(0,0).equals(marker) && b.getSquare(0,0).equals(b.getSquare(2,0))) hasMoved = b.setBoard(1 , 0 , marker);
    if(!hasMoved && b.getSquare(2,2).equals(marker) && b.getSquare(2,2).equals(b.getSquare(0,2))) hasMoved = b.setBoard(1 , 2 , marker);
    if(!hasMoved && b.getSquare(2,2).equals(marker) && b.getSquare(2,2).equals(b.getSquare(2,0))) hasMoved = b.setBoard(2 , 1 , marker);

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
    //checks for two corners in same row or column
    if(!hasMoved && !b.getSquare(0,0).equals("-") && b.getSquare(0,0).equals(b.getSquare(0,2))) hasMoved = b.setBoard(0 , 1 , marker);
    if(!hasMoved && !b.getSquare(0,0).equals("-") && b.getSquare(0,0).equals(b.getSquare(2,0))) hasMoved = b.setBoard(1 , 0 , marker);
    if(!hasMoved && !b.getSquare(2,2).equals("-") && b.getSquare(2,2).equals(b.getSquare(0,2))) hasMoved = b.setBoard(1 , 2 , marker);
    if(!hasMoved && !b.getSquare(2,2).equals("-") && b.getSquare(2,2).equals(b.getSquare(2,0))) hasMoved = b.setBoard(2 , 1 , marker);

    //tries to move into middle
    if(!hasMoved) hasMoved = b.setBoard(1,1,marker);

    //else tries to move into random corner or middle
    int availableCorners = 0;
    if(b.getSquare(0,0).equals("-")) availableCorners++;
    if(b.getSquare(2,0).equals("-")) availableCorners++;
    if(b.getSquare(0,2).equals("-")) availableCorners++;
    if(b.getSquare(2,2).equals("-")) availableCorners++;
    while(availableCorners != 0 && !hasMoved) {
      int corner = r.nextInt(4);
      if(corner == 0 && !hasMoved) hasMoved = b.setBoard(0 , 0 , marker);
      if(corner == 1 && !hasMoved) hasMoved = b.setBoard(0 , 2 , marker);
      if(corner == 2 && !hasMoved) hasMoved = b.setBoard(2 , 0 , marker);
      if(corner == 3 && !hasMoved) hasMoved = b.setBoard(2 , 2 , marker);
    }

    //else moves to random other square
    while(!hasMoved) {
      int space = r.nextInt(4);
      if(space == 0) hasMoved = b.setBoard(1 , 0 , marker);
      if(space == 1) hasMoved = b.setBoard(0 , 1 , marker);
      if(space == 2) hasMoved = b.setBoard(1 , 2 , marker);
      if(space == 3) hasMoved = b.setBoard(2 , 1 , marker);
    }

    System.out.println(b);
  }
}
