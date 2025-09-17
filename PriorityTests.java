package maven;
import org.testng.annotations.Test;

public class PriorityTests {
	 @Test(priority = 1)
	    public void testLogin() {
	        System.out.println("Test 1: Login successful");
	    }

	    @Test(priority = 2)
	    public void testSearch() {
	        System.out.println("Test 2: Search functionality works");
	    }

	    @Test(priority = 3)
	    public void testAddToCart() {
	        System.out.println("Test 3: Add to cart successful");
	    }

	    @Test(priority = 4)
	    public void testLogout() {
	        System.out.println("Test 4: Logout successful");
	    }
}
