package steps;

import io.cucumber.java.Before;
import lombok.extern.java.Log;

@Log
public class TestInitialize {

    @Before
    public void TestSetUp() {
        log.info("Some tests setup if needed to implement in future");
    }

}
