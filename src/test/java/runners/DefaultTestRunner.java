package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"},
        strict = true,
        features = "classpath:features",
        glue = "steps",
        tags = "@all"
)
public class DefaultTestRunner extends AbstractTestRunner {
}
