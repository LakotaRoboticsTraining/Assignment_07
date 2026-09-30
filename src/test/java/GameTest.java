import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    private String captureOutput(Runnable action) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try {
            System.setOut(new PrintStream(outputStream));
            action.run();
            return outputStream.toString();
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    @DisplayName("Challenge 1: constructor + getters")
    void constructorStoresNameYearAndType() {
        Game game = new Game("Pokemon", 1996, "RPG");

        assertEquals("Pokemon", game.getName(),
            "challenge1 failed - getName() should return the name passed to the constructor (Pokemon).");
        assertEquals(1996, game.getYear(),
            "challenge1 failed - getYear() should return the year passed to the constructor (1996).");
        assertEquals("RPG", game.getType(),
            "challenge1 failed - getType() should return the type passed to the constructor (RPG).");
    }

    @Test
    @DisplayName("Challenge 1: toString includes details")
    void toStringIncludesGameDetails() {
        Game game = new Game("Spaceball", 1986, "Pinball");
        String result = game.toString();

        assertTrue(result.contains("Spaceball"),
            "challenge1 failed - toString() must include the game name (Spaceball).");
        assertTrue(result.contains("1986"),
            "challenge1 failed - toString() must include the year (1986).");
        assertTrue(result.contains("Pinball"),
            "challenge1 failed - toString() must include the type (Pinball).");
    }

    @Test
    @DisplayName("Challenge 2: play prints a message")
    void playPrintsAMessage() {
        Game game = new Game("Pokemon", 1996, "RPG");
        String output = captureOutput(game::play);

        assertTrue(output.toLowerCase().contains("play"),
            "challenge2 failed - play() should print a message containing the word play.");
    }

    @Test
    @DisplayName("Challenge 3: Main uses two Game objects")
    void mainDemonstratesGameObjects() {
        String output = captureOutput(() -> Main.main(new String[] {}));

        assertTrue(output.contains("Pokemon"),
            "challenge3 failed - Main should create/use a Pokemon game and print its name.");
        assertTrue(output.contains("1996"),
            "challenge3 failed - Main should print Pokemon's year (1996).");
        assertTrue(output.contains("RPG"),
            "challenge3 failed - Main should print Pokemon's type (RPG).");
        assertTrue(output.contains("Spaceball"),
            "challenge3 failed - Main should create/use a Spaceball game and print its name.");
    }
}
