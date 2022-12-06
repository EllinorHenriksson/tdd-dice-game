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
    Game mockedGame = mock(Game.class);
    Player sut = new Player(mockedConsole, mockedGame);
    sut.play();
    verify(mockedConsole).printMenu();
  }

  @Test void playShouldCallGetActionOnConsole() {
    Console mockedConsole = mock(Console.class);
    Game mockedGame = mock(Game.class);
    Player sut = new Player(mockedConsole, mockedGame);
    sut.play();
    verify(mockedConsole).getAction();
  }

  @Test void playShouldCallGetActionTwiceForInvalidInputFollowedByValidInput() {
    Console mockedConsole = mock(Console.class);
    when(mockedConsole.getAction()).thenReturn(Action.OTHER, Action.PLAY);
    Game mockedGame = mock(Game.class);
    Player sut = new Player(mockedConsole, mockedGame);
    sut.play();
    verify(mockedConsole, times(2)).getAction();
  }
}
