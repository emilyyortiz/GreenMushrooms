/*
GreenMushrooms: Emily Ortiz, Tasnim Chowdhury, Kartik Vanjani
APCS PD8
FP: Show Us What You Got
2022-01-20
Time Spent: 5.5 Hours
*/
public class regBingo extends BingoGame {

  private static BingoCard Card = new BingoCard();

  public static void bingoTurn() {
    ballDrawn = Card.drawBall(ballBlower, ballDrawn);
    bingoCard = Card.markX(bingoCard);
    turn_num++;
    Card.printCard( bingoCard);
    Card.printBlower( ballBlower);
  }

}
