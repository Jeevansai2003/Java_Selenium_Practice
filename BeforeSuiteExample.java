package maven;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BeforeSuiteExample {
	@BeforeSuite
    public void beforeSuiteSetup() {
        System.out.println(">>> BeforeSuite: Setting up global configurations (DB Connection, Reports, etc.)");
    }

    @Test
    public void testCaseOne() {
        System.out.println("Test Case 1 executed");
    }

    @Test
    public void testCaseTwo() {
        System.out.println("Test Case 2 executed");
    }
}
