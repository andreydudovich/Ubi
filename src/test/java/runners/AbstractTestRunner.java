package runners;
import lombok.extern.java.Log;
import org.junit.AfterClass;
import org.junit.BeforeClass;

@Log
public class AbstractTestRunner {

    @BeforeClass
    public static void setUp() {
        log.info("Set up");
    }

    @AfterClass
    public static void tearDown() {
        log.info("Tear down");
    }
}
