import java.util.ArrayList;
import java.util.Random;

public class BingoCard {
  private static SortsNSearches tools = new SortsNSearches();

  // populates ballBlower with 100 balls numbered 1 to 100
  public static int[] popBlower(int[] Blower) {
    for(int i = 0; i <= 99; i++){
      Blower[i] = i + 1;
    }
    return Blower;
  }

  // prints ballBlower
  public static void printBlower(int[] Blower) {
    String foo = "[";
    for( int i = 0; i < Blower.length; i++ ) {
      foo += Blower[i] + ", ";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length() - 2);
    foo += "]";
    System.out.println(foo);
  }

  // draws a random ball from the ballBlower
  public static int drawBall(int[] Blower, int drawnBall) {
    int random = Blower[((int)(Math.random() * Blower.length) +1)];
    if (random > -1) {
      drawnBall = random;
      int i = tools.binSearch(Blower, random);
      Blower[i] = -1;
      Blower = tools.selectionSort(Blower);
    } else {
      drawBall(Blower, drawnBall);
    }
    return drawnBall;

  }

  // populates bingoCard with bingoCard.length-1 random numbers from the blower (no repeats)
  public static Comparable[][] popCard( Comparable[][] Card, int[] Blower) {
    int[] usedValues = new int[25];
    for (int i = 0; i < 5; i++){
        for (int a = 0; a < 5; a++){
          int ballDrawn = (int)(Math.random() * 100) + 1;
          // checks if ball has already been used
          for(int x : usedValues){
            if(x == ballDrawn){
              ballDrawn = (int)(Math.random() * 100) + 1;
            }
          }
         Card[i][a] = ballDrawn;
        } // end populating a row
    } // end populating entire card
    Card[2][2] = "X";
    return Card;
  }

  // prints 5 by 5 bingoCard in matrix format
  public static void printCard( Comparable[][] Card) {

  }

  // marks X where the ballDrawn number is present in the bingo card
  public static Comparable[][] markX( Comparable[][] Card) {
    return Card;

  }

  // checks 12 possible winning bingo states to see if the game is over
  public static boolean checkBingo( Comparable[][] Card) {
    return false;

  }

  //testing above methods
  public static void main(String args[]){
    int[] ballBlower = new int[100];
    popBlower(ballBlower);
    printBlower(ballBlower);
    Comparable[][] Card = new Comparable[5][5];
    popCard(Card, ballBlower);
  }

} //end bingoCard
