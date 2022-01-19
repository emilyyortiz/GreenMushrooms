public class biasBingo extends BingoGame {

  private static BingoCard Card = new BingoCard();

  // draws a ball from the upper or lower half ballBlower
  public static int drawBall(int[] Blower, int drawnBall) {
    return 0;
  }

  public static void bingoTurn() {
    ballDrawn = drawBall(ballBlower, ballDrawn);
    bingoCard = Card.markX(bingoCard);
    turn_num++;
    Card.printCard( bingoCard);
    Card.printBlower( ballBlower);
  }




}
