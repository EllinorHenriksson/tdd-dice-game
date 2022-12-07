package diceGame.controller;

import java.util.Scanner;

import diceGame.model.Game;
import diceGame.view.Console;

public class App {
  public static void main(String[] args) {
    App app = new App();
    app.run();
  }

  public void run() {
    Console console = new Console();
    Game game = new Game();
    Player player = new Player(console, game);
    player.play();
  }
}
