/*
GreenMushrooms: Emily Ortiz, Tasnim Chowdhury, Kartik Vanjani
APCS PD8
FP: Show Us What You Got
2022-01-20
Time Spent: 11 Hours
*/

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
    int ball_num = 0;
    for( int i = 0; i < Blower.length; i++ ) {
      if (Blower[i] != -1) {
        foo += Blower[i] + ", ";
        ball_num++;
      }
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length() - 2);
    foo += "]";
    System.out.println(ball_num +" Balls left in the Ball Blower:");
    System.out.println();
    System.out.println(foo);
  }

  // draws a random ball from the ballBlower
  public static Object[] drawBall(int[] Blower, int drawnBall) {
    int random = (int)Blower[((int)(Math.random() * Blower.length-1))];
    if (random > -1) {
      drawnBall = random;
      int i = tools.linSearchint(Blower, random);
      Blower[i] = -1;
      Blower = tools.selectionSortint(Blower);
      System.out.print("You drew a "+ drawnBall + " ball!\n");
    } else {
      drawBall(Blower, drawnBall);
    }
    System.out.println();
    return new Object[]{drawnBall, Blower};

  }

  // populates bingoCard with bingoCard.length-1 random numbers from the blower (no repeats)
  public static Comparable[][] popCard( Comparable[][] Card, int[] Blower) {
    //make deep copy of blower
    int[] data = new int[Blower.length];
    for (int i = 0; i < Blower.length; i++) {
      data[i] = Blower[i];
    }
    //populating from the deep copy
    for (Comparable[] row : Card ) {
      int pos = 0;
      int randomIndex = -1;
      while (pos < row.length) {
        int temp = (int)(Math.random() * data.length);
        if ( data[temp] != -1) {
          randomIndex = temp;
          row[pos] = data[randomIndex];
          //making sure there are no repeats
          data[randomIndex] = -1;
          pos++;
        }
      }
    }
    Card[2][2] = "X";
    return Card;
  }

  // prints 5 by 5 bingoCard in matrix format
  public static void printCard( Comparable[][] Card) {
    System.out.println("Your current Bingo Card:");
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
    boolean found = false;
    for (Comparable[] row : Card) {
      match = (int)(tools.linSearch(row, (Comparable)ballDrawn));
      System.out.println(match);
      if (match > -1) {
        Comparable temp = row[match];
        row[match] = "X";
        System.out.println("X marks the spot at " + temp + ".\n");
        match = -1;
        found = true;

      } else {
        System.out.println("AGHHH");
        found = false;
        break;
      }
    }
    if (found == false) {
      System.out.println("No matches this time D:\n");
    }

    return Card;
  }

  // checks 12 possible winning bingo states to see if the game is over
  public static boolean checkBingo( Comparable[][] Card, int turn_num) {
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
      System.out.println("\nYou've got BINGO!\n");
      return match;
  }
  if (turn_num >= Card[0].length ) {
    System.out.println("\nSorry buddy, no BINGO for you yet! :( \n");
  }

  return match;
 } //end method

/*
  //testing above methods
  public static void main(String args[]){
    int[] ballBlower = new int[99];
    Comparable[][] Card = new Comparable[5][5];
    popBlower(ballBlower);
    popCard(Card, ballBlower);

    int drawnBall = 0;

    drawnBall = (int)(drawBall(ballBlower, drawnBall))[0];
    ballBlower = (int[])(drawBall(ballBlower, drawnBall))[1];

    drawnBall = (int)Card[0][0];
    markX(Card, drawnBall);
    drawnBall = (int)Card[1][0];
    markX(Card, drawnBall);
    drawnBall = (int)Card[2][0];
    markX(Card, drawnBall);
    drawnBall = (int)Card[3][0];
    markX(Card, drawnBall);
    drawnBall = (int)Card[4][0];
    markX(Card, drawnBall);

    printCard(Card);
    System.out.println(checkBingo(Card, 0));
  }
*/

} //end bingoCard
