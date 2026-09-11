import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    void constructorStoresNameYearAndType() {
        Game game = new Game("Pokemon", 1996, "RPG");

        assertEquals("Pokemon", game.getName(),
            "getName() should return the name passed to the constructor.");
        assertEquals(1996, game.getYear(),
            "getYear() should return the year passed to the constructor.");
        assertEquals("RPG", game.getType(),
            "getType() should return the type passed to the constructor.");
    }

    @Test
    void toStringIncludesGameDetails() {
        Game game = new Game("Spaceball", 1986, "Pinball");

        String result = game.toString();

        assertTrue(result.contains("Spaceball"),
            "toString() should include the game name.");
        assertTrue(result.contains("1986"),
            "toString() should include the game year.");
        assertTrue(result.contains("Pinball"),
            "toString() should include the game type.");
    }

    @Test
    void playPrintsAMessage() {
        Game game = new Game("Pokemon", 1996, "RPG");

        String output = captureOutput(game::play);

        assertTrue(output.toLowerCase().contains("play"),
            "play() should print a message about playing the game.");
    }

    @Test
    void mainDemonstratesGameObjects() {
        String output = captureOutput(() -> Main.main(new String[]{}));

        assertTrue(output.contains("Pokemon"),
            "Main should create and use a Pokemon game.");
        assertTrue(output.contains("1996"),
            "Main should print the Pokemon release year.");
        assertTrue(output.contains("RPG"),
            "Main should print the Pokemon game type.");
        assertTrue(output.contains("Spaceball"),
            "Main should create and use a Spaceball game.");
    }
}
