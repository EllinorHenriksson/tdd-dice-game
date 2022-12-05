package diceGame.controller;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

class AppTest {
  @Test void runShouldCreateUser() {
    try (MockedConstruction<Player> mock = mockConstruction(Player.class)) {
        App sut = new App();
        int expeced = 1;
        sut.run();
        int actual = mock.constructed().size();
        assertEquals(expeced, actual, "The number of instantiated Player objects should be " + expeced);
    }
  }
}
