package cl.cencosud.publicsite.automation.poc.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageHome {

	//iniciar sesion
	@FindBy(how = How.ID, using = "clickLogin") 
	private WebElement homeBtnInicioSesion;
	//Busqueda en imagen 'Lupa' o solo con enter  sin ID
	@FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[4]/div[1]/form/div/input")
	private WebElement homeBtnBuscar;
	//Busqueda en Textbox 'Que estas buscando del homePage
	@FindBy(how = How.ID, using = "q")
	private WebElement homeInputIngresobusqueda;
	
	
	
}
