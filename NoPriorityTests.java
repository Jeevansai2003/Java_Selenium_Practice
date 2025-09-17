package maven;
import org.testng.annotations.Test;

public class NoPriorityTests {
	@Test
    public void testLogin() {
        System.out.println("Test 1: Login successful");
    }

    @Test
    public void testSearch() {
        System.out.println("Test 2: Search functionality works");
    }

    @Test
    public void testAddToCart() {
        System.out.println("Test 3: Add to cart successful");
    }

    @Test
    public void testLogout() {
        System.out.println("Test 4: Logout successful");
    }
}
