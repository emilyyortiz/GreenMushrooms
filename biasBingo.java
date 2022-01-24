;/*
GreenMushrooms: Emily Ortiz, Tasnim Chowdhury, Kartik Vanjani
APCS PD8
FP: Show Us What You Got
2022-01-20
Time Spent: 3 Hours
*/
public class biasBingo extends BingoGame {

  private static BingoCard Card = new BingoCard();

<<<<<<< HEAD
// draws a ball from the upper or lower half ballBlower -Tasnim
=======
  // draws a ball from the upper or lower half ballBlower
>>>>>>> 864488ccc9fb8fa5b91636189952653a7e23b2bc
  public static Object[] drawBall(int[] Blower, int drawnBall) { //- Tasnim

    //choosing
    System.out.println("Type 0 to draw a ball from the lower half.");
    System.out.println("Type 1 to draw a ball from the upper half.\n");
    System.out.println("Type 2 to draw a ball randomly.");
    System.out.println("Lower, Upper, or Random? : ");
    String s = in.nextLine();
    int half = -1;

    try {
      if (s.equals("0")) {
         half = 0;
      }
      if (s.equals("1")) {
         half = 1;
      }
    if (s.equals("2")) {
       half = 2;
      }
    }
    catch (Exception e) {
      System.out.println("Please type a valid input!");
    }

    System.out.println("\ndrawing ball...\n");
    tools.wait(500);

    int random = -1;
    while (random <= -1) {
      if (half == 2) {
        random = (int)Blower[((int)(Math.random() * Blower.length-1))]; //normal
      }
      if (half == 0) {
        random = (int)Blower[((int)(Math.random() * ((Blower.length-1)/2) ))]; //lower
      }
      if (half == 1) {
        random = (int)Blower[((int)(Math.random() * ((Blower.length-1)/2 + 50) ))]; //upper
      }
    }

    if (random > -1) {
      drawnBall = random;
      int i = tools.linSearchint(Blower, random);
      Blower[i] = -1;
      Blower = tools.selectionSortint(Blower);
      System.out.print("You drew a "+ drawnBall + " ball!\n");
    }
<<<<<<< HEAD

    System.out.println();
    return new Object[]{drawnBall, Blower};
  }
public static void ballDrawn ( 
=======

    System.out.println();
    return new Object[]{drawnBall, Blower};
  }

  public void bingoTurn() {
>>>>>>> 864488ccc9fb8fa5b91636189952653a7e23b2bc
    ballDrawn = drawBall(ballBlower, ballDrawn);
    bingoCard = Card.markX(bingoCard, ballDrawn);
    turn_num++;
    Card.printCard( bingoCard);
    Card.printBlower( ballBlower);
    System.out.print("\nPress enter to continue:");
  )
}





