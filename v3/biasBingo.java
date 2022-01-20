/*
GreenMushrooms: Emily Ortiz, Tasnim Chowdhury, Kartik Vanjani
APCS PD8
FP: Show Us What You Got
2022-01-20
Time Spent: 5.5 Hours
*/
public class biasBingo extends BingoGame {

  private static BingoCard Card = new BingoCard();

  // draws a ball from the upper or lower half ballBlower
  public static int drawBall(int[] Blower, int drawnBall) {
    System.out.println("Note: Method in progress.");
    return 0;
  }

  public void bingoTurn() {
    ballDrawn = drawBall(ballBlower, ballDrawn);
    bingoCard = Card.markX(bingoCard, ballDrawn);
    turn_num++;
    Card.printCard( bingoCard);
    Card.printBlower( ballBlower);
    System.out.print("\nPress enter to continue:");
  }




}
