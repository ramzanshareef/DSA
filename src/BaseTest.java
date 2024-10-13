import org.junit.Test;
import static org.junit.Assert.*;

public class BaseTest {
    @Test
    public void testAdd() {
        Base testObj = new Base();
        assertEquals(6, testObj.add(2, 4));
    }
}