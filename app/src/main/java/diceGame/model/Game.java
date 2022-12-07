package diceGame.model;

public class Game {
  private Player player;
  private Player computer;
  private Dice dice1;
  private Dice dice2;

  public Game() {
    player = new Player("Player");
    computer = new Player("Computer");
    dice1 = new Dice();
    dice2 = new Dice();
  }

  public Player newGame() {
    player.clearScore();
    computer.clearScore();
    // OBS! Fortsätt testa koden nedanför
    player.roll(dice1, dice2);
    notify(player);
    computer.roll(dice1, dice2);
    notify(computer);

    if (player.getScore() > computer.getScore()) {
      return player;
    } else {
      
    }

    return null;
  }

  private void notify(Player player) {

  }
}
