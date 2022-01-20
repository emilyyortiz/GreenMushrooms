public class regBingo extends BingoGame {

  private static BingoCard Card = new BingoCard();

  public static void bingoTurn() {
    ballDrawn = Card.drawBall(ballBlower, ballDrawn);
    bingoCard = Card.markX(bingoCard);
    turn_num++;
    Card.printCard( bingoCard);
    Card.printBlower( ballBlower);
    System.out.print("\nPress enter to continue:");
  }

}
