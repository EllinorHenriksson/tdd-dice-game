package diceGame.view;

import java.io.PrintStream;
import java.util.Scanner;

import diceGame.model.Player;

public class Console {
  private Scanner scan;
  private PrintStream print;

  public Console() {
    scan = new Scanner(System.in, "utf-8");
    print = new PrintStream(System.out);
  }
  
  public void printMenu() {
    String text = "\nDice Game\nPlay or quit (p/q)? ";
    print.println(text);
  }

  public Action getAction() {
    String action = scan.nextLine();

    if (action.equals("p")) {
      return Action.PLAY;
    } else if (action.equals("q")) {
      return Action.QUIT;
    }

    return Action.OTHER;
  }

  public void presentWinner(Player winner) {
    String text = winner.getName() + " wins!";
    print.println(text);
  }
}
