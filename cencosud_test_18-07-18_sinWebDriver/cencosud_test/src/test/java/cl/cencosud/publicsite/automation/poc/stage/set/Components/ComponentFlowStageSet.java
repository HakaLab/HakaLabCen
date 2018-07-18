package cl.cencosud.publicsite.automation.poc.stage.set.Components;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import cl.cencosud.publicsite.automation.poc.stage.set.StageSet;


@RunWith(Cucumber.class)
@CucumberOptions(
	tags = {"@ComponentMeganav,@footerComponent,@headerComponent"},
			plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/componentes.html"}
        
)
public class ComponentFlowStageSet extends StageSet {
	
}
