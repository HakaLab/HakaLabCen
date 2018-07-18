package cl.cencosud.publicsite.automation.poc.stage.set.Components;


import org.junit.runner.RunWith;

import cl.cencosud.publicsite.automation.poc.stage.set.StageSet;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@MiniCart"}

		
		,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ComponentMiniCart.html" }
		
			
)

public class ComponentMiniCartStageSet extends StageSet{

}
