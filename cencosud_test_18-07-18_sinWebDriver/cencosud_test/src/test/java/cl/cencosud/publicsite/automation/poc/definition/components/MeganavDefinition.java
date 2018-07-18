package cl.cencosud.publicsite.automation.poc.definition.components;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cl.cencosud.publicsite.automation.poc.business.flow.BaseFlow;
import cl.cencosud.publicsite.automation.poc.util.ComponentUtil;
import cl.cencosud.publicsite.automation.poc.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MeganavDefinition {
	
//	@Given("^ingresi pagina paris\\.cl$")
//	public void ingresi_pagina_paris_cl() throws Throwable {
//	  BaseFlow.driver.get("https://storefront:cen_2018@dev10-na01-cencosud.demandware.net/s/Paris/404?lang=es_CL");
//	}
	
	@Then("^valido que se visualicen (\\d+) categorias$")
	public void valido_que_se_visualicen_categorias(int nCategorias) throws Throwable {
		 List<WebElement> elements = BaseFlow.driver.findElements(By.className("top-category-nav"));
		 if (elements.size() == nCategorias) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Then("^validar mouse sobre categoria \"(.*?)\"$")
	public void validar_mouse_sobre_categoria(String categoria) throws Throwable {
		 assertTrue(ComponentUtil.returnOneElement(categoria)); 
	}

	@Then("^validar Url de categoria\\. \"(.*?)\"$")
	public void validar_Url_de_categoria(String arg1) throws Throwable {
		List<WebElement> elements = BaseFlow.driver.findElements(By.className("top-category-nav"));
	    for (int i = 1; i < elements.size(); i++) {
	 			assertTrue(ComponentUtil.sendGet1(BaseFlow.driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li["+i+"]/a"))));
		}
	}
}
