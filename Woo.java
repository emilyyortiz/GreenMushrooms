import java.util.Scanner;

public class Woo {

  static Scanner in = new Scanner (System.in);
  static int gameCtr = 0;

  public Woo() {
    String player = "";
    int gameNum = 0;
  }

  public static void Welcome() {
    System.out.println("\nWelcome to Bingo!");
    System.out.println("Made by Tasnim Chowdhury, Kartik Vanjani, and Emily Ortiz\n\n");
    System.out.print("What is your name? ");
    String player = in.nextLine();
    System.out.println("Hi there " + player + "! Press enter to get started:");
  }

  public static void start() {
    String statement = in.nextLine();
    while (!statement.equals("No")){
      play();
      System.out.println("Temporary print statement. Pretend a game is played.");
      gameCtr++;
      System.out.print("Would you like to play again? Type 'No' to stop and any key to continue: ");
      statement = in.nextLine();
    }
  }

  public static void play() {
    biasBingo game = new biasBingo();
    game.bingoTurn();
    in.nextLine();
  }

  public static void main( String[] args ) {
    Welcome();
    start();
    System.out.println("\nThanks for playing "+ gameCtr + " games.");

  } //end main

} //end Woo
