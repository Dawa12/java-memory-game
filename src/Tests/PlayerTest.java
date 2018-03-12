package Tests;
import com.company.Player;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    @Test
    public void testPlayerInputLength() {
        Player bob = new Player("Bob");
        bob.setName("bob");
//        check if player entered valid name
        assertTrue(bob.getName().length() > 1);
    }
}
