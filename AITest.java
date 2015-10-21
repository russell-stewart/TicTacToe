public class AITest {
  public static void main(String[] args) {
    int wins = 0;
    int catscratches = 0;
    int totalgames = 400000;

    for(int i = 0 ; i < totalgames; i++) {
      Board b = new Board();
      AIPlayer p1 = new AIPlayer(b , "x" , 5);//undefeatable
      AIPlayer p2 = new AIPlayer(b , "o" , 1);//defeatable
      while(!b.isGameDone()) {
        p2.takeTurn();//p2 going first to give it a better chance of winning
        p1.takeTurn();
      }
      if(b.getSquare(0,0).equals(b.getSquare(0,1)) && b.getSquare(0,1).equals(b.getSquare(0,2)) && b.getSquare(0,0).equals("x")) wins++;
      else if(b.getSquare(1,0).equals(b.getSquare(1,1)) && b.getSquare(1,1).equals(b.getSquare(1,2)) && b.getSquare(1,0).equals("x")) wins++;
      else if(b.getSquare(2,0).equals(b.getSquare(2,1)) && b.getSquare(2,1).equals(b.getSquare(2,2)) && b.getSquare(2,0).equals("x")) wins++;
      else if(b.getSquare(0,0).equals(b.getSquare(1,0)) && b.getSquare(1,0).equals(b.getSquare(2,0)) && b.getSquare(0,0).equals("x")) wins++;
      else if(b.getSquare(0,1).equals(b.getSquare(1,1)) && b.getSquare(1,1).equals(b.getSquare(2,1)) && b.getSquare(0,1).equals("x")) wins++;
      else if(b.getSquare(0,2).equals(b.getSquare(1,2)) && b.getSquare(1,2).equals(b.getSquare(2,2)) && b.getSquare(0,2).equals("x")) wins++;
      else if(b.getSquare(0,0).equals(b.getSquare(1,1)) && b.getSquare(1,1).equals(b.getSquare(2,2)) && b.getSquare(0,0).equals("x")) wins++;
      else if(b.getSquare(0,2).equals(b.getSquare(1,1)) && b.getSquare(1,1).equals(b.getSquare(2,0)) && b.getSquare(0,2).equals("x")) wins++;
      else catscratches++;
    }
    System.out.println("Number of wins for x: " + wins);
    System.out.println("Number of catscratches: " + catscratches);
    System.out.println("Number of wins for o: " + (totalgames - wins - catscratches));
  }
}
