package cl.cencosud.publicsite.automation.stageSet;

import org.junit.runner.RunWith;

import cl.cencosud.publicsite.automation.constants.Constants;
import cl.cencosud.publicsite.automation.definition.FlujoCompraCompletoDefinition_UsuarioRegistrado;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//		tags = {"@TC213,@TC215"}//@TC212,@TC214,@TC216@TC213 
//		tags = {"@TC218,@TC220"}//@TC217,@TC219,@TC221 
		tags = {"@TC230,@TC231"}//@TC227,TC2328,TC229
		,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/UsuarioRegistrado_variation.html"}
)

public class FlujoCompraCompleto_UsuarioRegistrado_StageSet extends StageSet{

}
