import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ChristmasRoomTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testEnter() {
        Room christmasRoom = new ChristmasRoom("Test description");
        christmasRoom.enter();
        assertEquals("You find yourself in a Christmas-themed room. Test description\n", outContent.toString());
    }

    @Test
    public void testInteract() {
        Room christmasRoom = new ChristmasRoom("Test description");


        System.setIn(new java.io.ByteArrayInputStream("1\n".getBytes()));

        int points = christmasRoom.interact();
        assertEquals("It's a festive atmosphere!\n" +
                "What do you want to do?\n" +
                "1. Admire the decorations\n" +
                "2. Listen to Christmas music\n" +
                "You take a moment to admire the beautiful decorations. You earn 1 point.\n", outContent.toString());
        assertEquals(1, points);
    }
}