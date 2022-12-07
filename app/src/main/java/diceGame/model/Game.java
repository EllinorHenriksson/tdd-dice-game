package diceGame.model;

import java.util.ArrayList;

public class Game {
  private Player player;
  private Player computer;
  private Dice dice1;
  private Dice dice2;
  private ArrayList<Subscriber> subscribers;

  public Game() {
    player = new Player("Player");
    computer = new Player("Computer");
    dice1 = new Dice();
    dice2 = new Dice();
    subscribers = new ArrayList<>();
  }

  public void subscribe(Subscriber subscriber) {
    subscribers.add(subscriber);
  }

  public void unsubscribe(Subscriber subscriber) {
    subscribers.remove(subscriber);
  }

  private void notify(Player player) {
    for (Subscriber s : subscribers) {
      s.update(player);
    }
  }

  public Player newGame() {
    player.clearScore();
    computer.clearScore();
    player.roll(dice1, dice2);
    notify(player);
    computer.roll(dice1, dice2);
    notify(computer);

    if (player.getScore() > computer.getScore()) {
      return player;
    } else {
      return computer;
    }
  }
}
