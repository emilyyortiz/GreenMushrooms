/*
GreenMushrooms: Emily Ortiz, Tasnim Chowdhury, Kartik Vanjani
APCS PD8
FP: Show Us What You Got
2022-01-20
Time Spent: 5.5 Hours
*/
public class regBingo extends BingoGame {

  private static BingoCard Card = new BingoCard();

  public void bingoTurn() {
    System.out.println(ballDrawn);
    System.out.println(ballBlower);
    //ballDrawn = Card.drawBall(ballBlower[1], ballDrawn);
    bingoCard = Card.markX(bingoCard, ballDrawn);
    turn_num++;
    Card.printCard( bingoCard);
    Card.printBlower( ballBlower);
    System.out.print("\nPress enter to continue:");
  }

}
