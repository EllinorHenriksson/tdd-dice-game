package diceGame.controller;

import diceGame.model.Game;
import diceGame.view.Action;
import diceGame.view.Console;

public class Player {
  private Console console;
  private Game game;

  public Player(Console console, Game game) {
    this.console = console;
    this.game = game;
  }

  public void play() {
    console.printMenu();
    Action action = console.getAction();
  }
}
