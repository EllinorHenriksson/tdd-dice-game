package diceGame.view;

import java.io.PrintStream;
import java.util.Scanner;

public class Console {
  private Scanner scan;
  private PrintStream print;

  public Console() {
    scan = new Scanner(System.in, "utf-8");
    print = new PrintStream(System.out);
  }
  
  public void printMenu() {
  }
}
