package suite;

import org.junit.runner.RunWith;
import com.intuit.karate.junit4.Karate;


import cucumber.api.CucumberOptions;

	

@RunWith(Karate.class)
@CucumberOptions (tags = "@Smoke")
public class ApiTestRunner {

}
