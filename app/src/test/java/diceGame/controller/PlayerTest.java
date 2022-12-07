package diceGame.controller;

import org.junit.jupiter.api.Test;

import diceGame.model.Game;
import diceGame.view.Action;
import diceGame.view.Console;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerTest {
  @Test void playShouldCallPrintMenuOnConsole() {
    Console mockedConsole = mock(Console.class);
    when(mockedConsole.getAction()).thenReturn(Action.QUIT);
    Game mockedGame = mock(Game.class);
    Player sut = new Player(mockedConsole, mockedGame);
    sut.play();
    verify(mockedConsole).printMenu();
  }

  @Test void playShouldCallGetActionOnConsole() {
    Console mockedConsole = mock(Console.class);
        when(mockedConsole.getAction()).thenReturn(Action.QUIT);

    Game mockedGame = mock(Game.class);
    Player sut = new Player(mockedConsole, mockedGame);
    sut.play();
    verify(mockedConsole).getAction();
  }

  @Test void playShouldCallGetActionTwiceForPlayFollowedByQuit() {
    Console mockedConsole = mock(Console.class);
    when(mockedConsole.getAction()).thenReturn(Action.PLAY, Action.QUIT);
    Game mockedGame = mock(Game.class);
    Player sut = new Player(mockedConsole, mockedGame);
    sut.play();
    verify(mockedConsole, times(2)).getAction();
  }

  @Test void playShouldCallNewGameAndPresentWinnerForPlay() {
    Console mockedConsole = mock(Console.class);
    when(mockedConsole.getAction()).thenReturn(Action.PLAY, Action.QUIT);
    Game mockedGame = mock(Game.class);
    Player sut = new Player(mockedConsole, mockedGame);
    sut.play();
    verify(mockedGame).newGame();
    verify(mockedConsole).presentWinner(null);
  }

  @Test void updateShouldCallPresentScoreOnConsole() {
    Console mockedConsole = mock(Console.class);
    Game mockedGame = mock(Game.class);
    Player sut = new Player(mockedConsole, mockedGame);
    diceGame.model.Player mockedPlayer = mock(diceGame.model.Player.class);
    sut.update(mockedPlayer);
    verify(mockedConsole).presentScore(mockedPlayer);
  }
}
