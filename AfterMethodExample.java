package maven;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class AfterMethodExample {
	@Test
    public void testAddToCart() {
        System.out.println("Test Case: Add to Cart executed");
    }

    @Test
    public void testRemoveFromCart() {
        System.out.println("Test Case: Remove from Cart executed");
    }

    @AfterMethod
    public void afterEachTest() {
        System.out.println(">>> AfterMethod: Cleaning up after test execution");
    }	

}
