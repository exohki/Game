import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class CandyCaneForestRoomTest {
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
        Room candyCaneForestRoom = new CandyCaneForestRoom("Test description");
        candyCaneForestRoom.enter();
        assertEquals("You find yourself in the magical Candy Cane Forest. Test description\n", outContent.toString());
    }

    @Test
    public void testInteract() {
        Room candyCaneForestRoom = new CandyCaneForestRoom("Test description");


        System.setIn(new java.io.ByteArrayInputStream("1\n".getBytes()));

        int points = candyCaneForestRoom.interact();
        assertEquals("The air is filled with the sweet aroma of candy canes.\n" +
                "What do you want to do?\n" +
                "1. Taste a candy cane\n" +
                "2. Follow the candy cane path\n" +
                "You taste a delicious candy cane. It brings you joy! You earn 1 point.\n", outContent.toString());
        assertEquals(1, points);
    }
}
