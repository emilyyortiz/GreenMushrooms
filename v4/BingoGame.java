/*
GreenMushrooms: Emily Ortiz, Tasnim Chowdhury, Kartik Vanjani
APCS PD8
FP: Show Us What You Got
2022-01-20
Time Spent: 6 Hours
*/
import java.util.Scanner;

public class BingoGame {
  private static SortsNSearches tools = new SortsNSearches();
  static Scanner in = new Scanner (System.in);

  protected BingoCard Card = new BingoCard();

  protected static int[] ballBlower = new int[99];
  protected static Comparable[][] bingoCard = new Comparable[5][5];
  protected static int ballDrawn = -1;

  protected static boolean _BINGO = false;
  protected static int turn_num = 1;

  public void initializeGame() {
    ballBlower = Card.popBlower(ballBlower);
    bingoCard = Card.popCard(bingoCard, ballBlower);


    ballDrawn = 0;
    _BINGO = false;
    turn_num = 0;

    System.out.print("\nStarting your game...\n");
    Card.printCard(bingoCard);
    System.out.println("\n----------------------------------------------------");
    System.out.print("\nPress enter to draw your first ball: ");
    String statement = in.nextLine();

  }

  public void bingoTurn() {
    Object[] drawBallResult = (Card.drawBall(ballBlower, ballDrawn));
    ballDrawn = (int)drawBallResult[0];
    ballBlower = (int[])drawBallResult[1];
    bingoCard = Card.markX(bingoCard, ballDrawn);
    Card.printCard( bingoCard);

    System.out.println("\n----------------------------------------------------");
    tools.wait(100);
    System.out.println("\nType Blower to check what balls are left. " );
    System.out.print("\nOr press enter to continue: ");
    String statement = in.nextLine();
    if (statement.equals("Blower")) {
      Card.printBlower(ballBlower);
      System.out.println("\nPress enter to continue: " );
      statement = in.nextLine();
    }

    _BINGO = Card.checkBingo(bingoCard, turn_num);
    turn_num++;
    }


  BingoGame() {
    initializeGame();
    while (_BINGO == false) {
      bingoTurn();

      /*
      System.out.println("\n----------------------------------------------------");
      System.out.println("\nType Blower to check what balls are left. " );
      System.out.print("\nOr press enter to draw another ball: ");
      String statement = in.nextLine();
      if (statement.equals("Blower")) {
        Card.printBlower(ballBlower);
        System.out.println("\nPress enter to continue: " );
        statement = in.nextLine();
      }
      */
    }
    System.out.println("You little runt, congrats! It took ONLY " + turn_num + " turns!\n");

  } //constructor


} // end class
