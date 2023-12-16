import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class ToyWorkshopRoomTest {
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
        Room toyWorkshopRoom = new ToyWorkshopRoom("Test description");
        toyWorkshopRoom.enter();
        assertEquals("You enter Santa's Toy Workshop. Test description\n", outContent.toString());
    }

    @Test
    public void testInteract() {
        Room toyWorkshopRoom = new ToyWorkshopRoom("Test description");


        System.setIn(new java.io.ByteArrayInputStream("1\n".getBytes()));

        int points = toyWorkshopRoom.interact();
        assertEquals("You see busy elves working on toys.\n" +
                "What do you want to do?\n" +
                "1. Help the elves with toy making\n" +
                "2. Explore the toy workshop\n" +
                "You assist the elves in making toys. You earn 2 points.\n", outContent.toString());
        assertEquals(2, points);
    }
}
