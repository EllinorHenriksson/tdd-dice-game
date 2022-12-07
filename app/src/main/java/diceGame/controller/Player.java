package diceGame.controller;

import diceGame.model.Game;
import diceGame.model.Subscriber;
import diceGame.view.Action;
import diceGame.view.Console;

public class Player implements Subscriber {
  private Console console;
  private Game game;

  public Player(Console console, Game game) {
    this.console = console;
    this.game = game;
  }

  public void play() {
    Action action = null;

    while (action != Action.QUIT) {
      console.printMenu();
      action = console.getAction();
      if (action == Action.PLAY) {
        diceGame.model.Player winner = game.newGame();
        console.presentWinner(winner);
      }
    }
  }

  @Override
  public void update(diceGame.model.Player player) {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.out.println("" + e);
    }

    console.presentScore(player);
  }
}
