package diceGame.model;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameTest {
  @Test void constructorShouldCreateTwoPlayerObjects() {
    try (MockedConstruction<Player> mock = mockConstruction(Player.class)) {
      Game sut = new Game();
      int expeced = 2;
      int actual = mock.constructed().size();
      assertEquals(expeced, actual, "The number of instantiated Player objects should be " + expeced);
    }
  }

  @Test void constructorShouldCreateTwoDiceObjects() {
    try (MockedConstruction<Dice> mock = mockConstruction(Dice.class)) {
      Game sut = new Game();
      int expeced = 2;
      int actual = mock.constructed().size();
      assertEquals(expeced, actual, "The number of instantiated Dice objects should be " + expeced);
    }
  }

  @Test void newGameShouldClearScoreForPlayerAndComputer() {
    try (MockedConstruction<Player> mock = mockConstruction(Player.class)) {
      Game sut = new Game();
      Player mockedPlayer = mock.constructed().get(0);
      Player mockedComputer = mock.constructed().get(1);
      sut.newGame();
      verify(mockedPlayer).clearScore();
      verify(mockedComputer).clearScore();
    }
  }

  @Test void newGameShouldCallRollOnPlayerAndComputer() {
    try (MockedConstruction<Player> mock = mockConstruction(Player.class)) {
      Game sut = new Game();
      Player mockedPlayer = mock.constructed().get(0);
      Player mockedComputer = mock.constructed().get(1);
      sut.newGame();
      verify(mockedPlayer).roll(any(Dice.class), any(Dice.class));
      verify(mockedComputer).roll(any(Dice.class), any(Dice.class));
    }
  }

  @Test void newGameShouldReturnPlayerIfHerScoreIsHigherThanComputer() {
    try (MockedConstruction<Player> mock = mockConstruction(Player.class)) {
      Game sut = new Game();
      Player mockedPlayer = mock.constructed().get(0);
      Player mockedComputer = mock.constructed().get(1);
      when(mockedPlayer.getScore()).thenReturn(2);
      when(mockedComputer.getScore()).thenReturn(1);

      Player expected = mockedPlayer;
      Player actual = sut.newGame();
      
      assertSame(expected, actual);
    }
  }

  @Test void newGameShouldReturnComputerIfScoresAreSame() {
    try (MockedConstruction<Player> mock = mockConstruction(Player.class)) {
      Game sut = new Game();
      Player mockedPlayer = mock.constructed().get(0);
      Player mockedComputer = mock.constructed().get(1);
      when(mockedPlayer.getScore()).thenReturn(2);
      when(mockedComputer.getScore()).thenReturn(2);

      Player expected = mockedComputer;
      Player actual = sut.newGame();
      
      assertSame(expected, actual);
    }
  }

  @Test void newGameShouldReturnComputerIfItsScoreIsHigherThanPlayer() {
    try (MockedConstruction<Player> mock = mockConstruction(Player.class)) {
      Game sut = new Game();
      Player mockedPlayer = mock.constructed().get(0);
      Player mockedComputer = mock.constructed().get(1);
      when(mockedPlayer.getScore()).thenReturn(1);
      when(mockedComputer.getScore()).thenReturn(2);

      Player expected = mockedComputer;
      Player actual = sut.newGame();
      
      assertSame(expected, actual);
    }
  }
}
