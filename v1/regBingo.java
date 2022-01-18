public class regBingo extends BingoGame {

  private BingoCard Card = new BingoCard();

  public static void bingoTurn() {
    ballDrawn = Card.drawBall(ballBlower, ballDrawn);
    bingoCard = Card.markX(bingoCard);
    turn_num++;
    Card.printCard( bingoCard);
    Card.printBlower( ballBlower);
  }

}
