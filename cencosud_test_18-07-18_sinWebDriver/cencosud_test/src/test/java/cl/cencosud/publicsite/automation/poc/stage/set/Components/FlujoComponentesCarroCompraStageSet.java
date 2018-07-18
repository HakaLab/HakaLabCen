package cl.cencosud.publicsite.automation.poc.stage.set.Components;


import org.junit.runner.RunWith;

import cl.cencosud.publicsite.automation.poc.stage.set.StageSet;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@Cart"}

		
		,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/FlujoComponentesCart.html" }
		
			
)

public class FlujoComponentesCarroCompraStageSet extends StageSet{

}
