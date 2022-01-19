public class BingoGame {

  private BingoCard Card = new BingoCard();

  protected static int[] ballBlower = new int[99];
  protected static Comparable[][] bingoCard = new Comparable[5][5];
  protected static int ballDrawn;

  protected static boolean _BINGO;
  protected static int turn_num;

  public void initializeGame() {
    ballBlower = Card.popBlower(ballBlower);
    bingoCard = Card.popCard(bingoCard, ballBlower);

    ballDrawn = 0;
    _BINGO = false;
    turn_num = 0;

    Card.printCard(bingoCard);
  }

  public static void bingoTurn() {

  }

}
