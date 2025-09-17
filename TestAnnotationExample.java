package maven;
import org.testng.annotations.Test;
public class TestAnnotationExample {
	@Test
    public void testLogin() {
        System.out.println("Test Case: Login executed");
    }

    @Test
    public void testLogout() {
        System.out.println("Test Case: Logout executed");
    }
}
