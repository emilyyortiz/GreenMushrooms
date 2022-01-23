;/*
GreenMushrooms: Emily Ortiz, Tasnim Chowdhury, Kartik Vanjani
APCS PD8
FP: Show Us What You Got
2022-01-20
Time Spent: 3 Hours
*/
public class biasBingo extends BingoGame {

  private static BingoCard Card = new BingoCard();

  // draws a ball from the upper or lower half ballBlower
  public static int drawBall(int[] Blower, int drawnBall) {
    System.out.print("Type 0 to draw a ball from the lower half, and any other key to draw from the upper half: ");
    int  half; 
    int random = (int)Blower[((int)(Math.random() * 50))];
    if (random > -1) {
      drawnBall = random;
      if (half != 0){
        random += 50;
      }
     
      System.out.print("You drew a "+ drawnBall + " ball!\n");
    } else {
      drawBall(Blower, drawnBall);
    
 
   return new drawnBall 
	return new Blower 
  }

  private void bingoTurn() {
    ballDrawn = drawBall(ballBlower, ballDrawn);
    bingoCard = Card.markX(bingoCard, ballDrawn);
    turn_num++;
    Card.printCard( bingoCard);
    Card.printBlower( ballBlower);
    System.out.print("\nPress enter to continue:");
  }




}
