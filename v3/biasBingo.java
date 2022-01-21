/*
GreenMushrooms: Emily Ortiz, Tasnim Chowdhury, Kartik Vanjani
APCS PD8
FP: Show Us What You Got
2022-01-20
Time Spent: 2 Hours
*/
public class biasBingo extends BingoGame {

  private static BingoCard Card = new BingoCard();

  // draws a ball from the upper or lower half ballBlower
  public static Object[] drawBall(int[] Blower, int drawnBall) {
    System.out.print("Type 0 to draw a ball from the lower half, and any other key to draw from the upper half: ");
    int half = in.nextLine();
    int random = (int)Blower[((int)(Math.random() * 50))];
    if (random > -1) {
      drawnBall = random;
      if (half != 0){
        random += 50;
      }
      int i = tools.linSearchint(Blower, random);
      Blower[i] = -1;
      Blower = tools.selectionSortint(Blower);
      System.out.print("You drew a "+ drawnBall + " ball!\n");
    } else {
      drawBall(Blower, drawnBall);
    }
    System.out.println();
    return new Object[]{drawnBall, Blower};

  }

  biasBingo() {

  }

}
