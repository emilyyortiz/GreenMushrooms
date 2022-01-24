/*
GreenMushrooms: Emily Ortiz, Tasnim Chowdhury, Kartik Vanjani
APCS PD8
FP: Show Us What You Got
2022-01-20
Time Spent: 11 Hours
*/
import java.util.Scanner;

public class BingoCard {
  private static SortsNSearches tools = new SortsNSearches();
  private static Scanner in = new Scanner (System.in);

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
    System.out.println("\n" + ball_num +" Balls left in the Ball Blower:");
    System.out.println();
    System.out.println(foo);
  }

  // draws a random ball from the ballBlower
  public static Object[] drawBall0(int[] Blower, int drawnBall) {
    System.out.println("\ndrawing ball...\n");
    tools.wait(500);
    int random = (int)Blower[((int)(Math.random() * Blower.length-1))];
    while (random <= -1) {
      random = (int)Blower[((int)(Math.random() * Blower.length-1))];
    //  System.out.println("drew again...");
    }
    if (random > -1) {
      drawnBall = random;
  //    System.out.println("Confirmed.");
      int i = tools.linSearchint(Blower, random);
      Blower[i] = -1;
      Blower = tools.selectionSortint(Blower);
      System.out.print("You drew a "+ drawnBall + " ball!\n");
    }

    System.out.println();
    return new Object[]{drawnBall, Blower};

  }

  // draws a ball from the upper or lower half ballBlower -Tasnim
  public static Object[] drawBall1(int[] Blower, int drawnBall) { //- Tasnim

    //choosing
    System.out.println("\nType 0 to draw a ball from the lower half.");
    System.out.println("Type 1 to draw a ball from the upper half.");
    System.out.println("Type 2 to draw a ball randomly.\n");
    System.out.print("Lower, Upper, or Random?: ");
    String s = in.nextLine();
    int half = -1;

    while (half == -1){
      if (s.equals("0")) {
         half = 0;
      }
      else if (s.equals("1")) {
         half = 1;
      }
      else if (s.equals("2")) {
       half = 2;
      }
      else{
        System.out.println("Please type a valid input!");
        s = in.nextLine();
        //drawBall1(int[] Blower; int drawnBall);
      }
    }

    System.out.println("\ndrawing ball...\n");
    tools.wait(500);

    int random = -1;
    while (random <= -1) {
      if (half == 2) {
        random = (int)Blower[((int)(Math.random() * Blower.length-1))]; //normal
      }
      if (half == 0) {
        random = (int)Blower[((int)(Math.random() * ((Blower.length-1)/2) ))]; //lower
      }
      if (half == 1) {
        random = (int)Blower[((int)(Math.random() * ((Blower.length-1)/2 + 50) ))]; //upper
      }
    }

    if (random > -1) {
      drawnBall = random;
      int i = tools.linSearchint(Blower, random);
      Blower[i] = -1;
      Blower = tools.selectionSortint(Blower);
      System.out.print("You drew a "+ drawnBall + " ball!\n");
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
          row[pos] = (Comparable)data[randomIndex];
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
    tools.wait(200);
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
    System.out.println("Checking for matches in the card...\n");
    tools.wait(100);
    int match = -2;
    boolean found = false;
    for (Comparable[] row : Card) {
      match = (int)(tools.linSearch(row, (Comparable)ballDrawn));
  //    System.out.println(match + ", Ball: " + ballDrawn);
      if (match > -1) {
        Comparable temp = row[match];
        row[match] = "X";
        System.out.println("X marks the spot at " + temp + ".\n");
        match = -1;
        found = true;
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
    System.out.println("\nchecking for BINGO...");
    tools.wait(500);
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

} //end bingoCard
