package diceGame.view;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import diceGame.model.Player;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleTest {
  @Test void constructorShouldCreateScanner() {
    try (MockedConstruction<Scanner> mock = mockConstruction(Scanner.class)) {
      Console sut = new Console();
      int expeced = 1;
      int actual = mock.constructed().size();
      assertEquals(expeced, actual, "The number of instantiated Scanner objects should be " + expeced);
    }
  }

  @Test void constructorShouldCreatePrintStream() {
    try (MockedConstruction<PrintStream> mock = mockConstruction(PrintStream.class)) {
      Console sut = new Console();
      int expeced = 1;
      int actual = mock.constructed().size();
      assertEquals(expeced, actual, "The number of instantiated PrintStream objects should be " + expeced);
    }
  }

  @Test void printMenuShouldCallPrintlnOnPrintStreamObject() {
    try (MockedConstruction<PrintStream> mock = mockConstruction(PrintStream.class)) {
      Console sut = new Console();
      PrintStream mockedPrintStream = mock.constructed().get(0);
      sut.printMenu();
      verify(mockedPrintStream).println(anyString());
    }
  }

  @Test void getActionShouldCallNextLineOnScannerObject() {
    try (MockedConstruction<Scanner> mock = mockConstruction(Scanner.class)) {
      Console sut = new Console();
      Scanner mockedScanner = mock.constructed().get(0);
      when(mockedScanner.nextLine()).thenReturn("p");
      sut.getAction();
      verify(mockedScanner).nextLine();
    }
  }

  @Test void getActionShouldReturnOtherForInvalidInput() {
    try (MockedConstruction<Scanner> mock = mockConstruction(Scanner.class)) {
      Console sut = new Console();
      Scanner mockedScanner = mock.constructed().get(0);
      when(mockedScanner.nextLine()).thenReturn("x");

      Action expected = Action.OTHER;
      Action actual = sut.getAction();

      assertEquals(expected, actual, "Should return " + expected + " for invalid input");
    }
  }

  @Test void getActionShouldReturnPlayForInputP() {
    try (MockedConstruction<Scanner> mock = mockConstruction(Scanner.class)) {
      Console sut = new Console();
      Scanner mockedScanner = mock.constructed().get(0);
      when(mockedScanner.nextLine()).thenReturn("p");

      Action expected = Action.PLAY;
      Action actual = sut.getAction();

      assertEquals(expected, actual, "Should return " + expected + " for input 'p'");
    }
  }

  @Test void getActionShouldReturnQuitForInputQ() {
    try (MockedConstruction<Scanner> mock = mockConstruction(Scanner.class)) {
      Console sut = new Console();
      Scanner mockedScanner = mock.constructed().get(0);
      when(mockedScanner.nextLine()).thenReturn("q");

      Action expected = Action.QUIT;
      Action actual = sut.getAction();

      assertEquals(expected, actual, "Should return " + expected + " for input 'q'");
    }
  }

  @Test void presentWinnerShouldCallGetNameOnWinnerAntPrintlnOnPrintStream() {
    try (MockedConstruction<PrintStream> mock = mockConstruction(PrintStream.class)) {
      Console sut = new Console();
      PrintStream mockedPrintStream = mock.constructed().get(0);
      Player winner = mock(Player.class);
      when(winner.getName()).thenReturn("Computer");
      sut.presentWinner(winner);

      verify(winner).getName();
      verify(mockedPrintStream).println(anyString());
    }
  }
}
