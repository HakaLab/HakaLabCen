package cl.cencosud.publicsite.automation.stageSet;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by eduardo on 3/20/18.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cl/cencosud/publicsite/automation/definition"
        
)
public class StageSet {
}
