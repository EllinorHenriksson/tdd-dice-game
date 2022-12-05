package diceGame.controller;

import diceGame.model.Game;
import diceGame.view.Console;

public class App {
public static void main(String[] args) {
  App app = new App();
  app.run();
}

public void run() {
  Player player = new Player(new Console(), new Game());
}
}
