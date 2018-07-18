package cl.cencosud.publicsite.automation.poc.stage.set;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@TC212-1"}
//		,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/FlujoCompraCompleto_UsuarioRegistrado.html" }
)

public class FlujoCompraCompleto_UsuarioRegistrado_StageSet extends StageSet{

}
