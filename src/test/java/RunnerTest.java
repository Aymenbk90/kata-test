import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.DriversUtils;

import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:cucumber.json"},
        features = "src/test/java/features",
        tags = "@book",
        glue = {"pages","features.step_definitions"})

public class RunnerTest {
	@AfterClass 
	  public static void tearDownClass() {
	    // Close web driver
		DriversUtils.tearDown();
	  }
}
