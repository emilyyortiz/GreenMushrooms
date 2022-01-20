import java.util.ArrayList;
import java.util.Random;

public class BingoCard {
  private static SortsNSearches tools = new SortsNSearches();

  // populates ballBlower with 99 balls numbered 1 to 99
  public static int[] popBlower(int[] Blower) {
    for(int i = 0; i <= 98; i++){
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
    System.out.println("Current state of the ballBlower:");
    System.out.println(foo);
  }

  // draws a random ball from the ballBlower
  public static Object[] drawBall(int[] Blower, int drawnBall) {
    int random = (int)Blower[((int)(Math.random() * Blower.length-1) +1)];
    if (random > -1) {
      drawnBall = random;
      int i = tools.linSearchint(Blower, random);
      Blower[i] = -1;
      Blower = tools.selectionSortint(Blower);
    } else {
      drawBall(Blower, drawnBall);
    }
    return new Object[]{drawnBall, Blower};

  }

  // populates bingoCard with bingoCard.length-1 random numbers from the blower (no repeats)
  public static Comparable[][] popCard( Comparable[][] Card, int[] Blower) {
    System.out.println("popCard method in progress.");
    int[] usedValues = new int[25];
    for (int i = 0; i < 5; i++){
        for (int a = 0; a < 5; a++){
          int ballDrawn = (int)(Math.random() * 99) + 1;
          // checks if ball has already been used
          for(int x : usedValues){
            while(x == ballDrawn){
              ballDrawn = (int)(Math.random() * 99) + 1;
            }
          }
         Card[i][a] = ballDrawn;
         usedValues[5 * i + a] = ballDrawn;
        } // end populating a row
    } // end populating entire card
    Card[2][2] = "X";
//    System.out.println("Printing usedValues:");
//    printBlower(usedValues);
    return Card;
  }

  // prints 5 by 5 bingoCard in matrix format
  public static void printCard( Comparable[][] Card) {
    System.out.println("");
    System.out.println("Your current BingoCard:");
    System.out.println("");
    int rows = Card.length;
        int columns = Card[0].length;
        String str = "|\t";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                str += Card[i][j] + "\t";
            }
            System.out.println(str + "|");
            str = "|\t";
  }
}

  // marks X where the ballDrawn number is present in the bingo card
  public static Comparable[][] markX( Comparable[][] Card, int ballDrawn) {
    int match = -1;
    for (Comparable[] row : Card) {
      match = (int)(tools.linSearch(row, (Comparable)ballDrawn));
      if (match > -1) {
        row[match] = "X";
        match = -1;
      }
    }

    return Card;
  }

  // checks 12 possible winning bingo states to see if the game is over
  public static boolean checkBingo( Comparable[][] Card) {
    boolean match = false;

    // checks 5 rows
    for (Comparable[] row : Card ) {
      for (Comparable value : row) {
        if (value.equals("X")) {
          match = true;
        } else {
          match = false;
          break;
        }
      }
      if (match == true) {
        return match;
      }
    }

    // checks 5 columns
    for (int i = 0; i <= Card.length-1; i++) {
      for (Comparable[] row : Card) {
        if (row[i].equals("X")) {
          match = true;
        } else {
          match = false;
          break;
        }
      }
      if (match == true) {
        return match;
    }
  }

    // checks top-left to bottom-right diagonal
    for (int i = 0; i <= Card[0].length-1; i++) {
      if ((Card[i][i]).equals("X")) {
        match = true;
      } else {
        match = false;
        break;
      }
    }
    if (match == true) {
      return match;
  }

  // checks top-right to bottom-left diagonal
  int column = 0;
  for (int i = Card[0].length-1; i >= 0; i--) {
    if ((Card[i][column]).equals("X")) {
      match = true;
    } else {
      match = false;
      break;
    }
    column++;
    }
    if (match == true) {
      return match;
  }

  return match;
 } //end method

  //testing above methods
  public static void main(String args[]){
    int[] ballBlower = new int[99];
    Comparable[][] Card = new Comparable[5][5];
    popBlower(ballBlower);
    popCard(Card, ballBlower);
    int drawnBall = 0;
//    printBlower(ballBlower);
    drawnBall = (int)(drawBall(ballBlower, drawnBall))[0];
    ballBlower = (int[])(drawBall(ballBlower, drawnBall))[1];
    drawnBall = (int)Card[0][4];
    markX(Card, drawnBall);
    drawnBall = (int)Card[1][3];
    markX(Card, drawnBall);
//    drawnBall = (int)Card[2][2];
    markX(Card, drawnBall);
    drawnBall = (int)Card[3][1];
    markX(Card, drawnBall);
    drawnBall = (int)Card[4][0];
    markX(Card, drawnBall);

    printCard(Card);
    System.out.println(checkBingo(Card));
  }

} //end bingoCard
