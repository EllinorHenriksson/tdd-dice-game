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
    String text = "\n*** Dice Game ***\nPlay or quit (p/q)? ";
    print.print(text);
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
    String text = "\n" + winner.getName() + " wins!";
    print.println(text);
  }

  public void presentScore(Player player) {
    String text = "\n" + player.getName() + " rolls " + player.getScore();
    print.println(text);
  }
}
