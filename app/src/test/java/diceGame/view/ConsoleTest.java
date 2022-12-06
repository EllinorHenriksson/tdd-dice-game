package diceGame.view;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

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
      sut.getAction();
      verify(mockedScanner).nextLine();
    }
  }
}
