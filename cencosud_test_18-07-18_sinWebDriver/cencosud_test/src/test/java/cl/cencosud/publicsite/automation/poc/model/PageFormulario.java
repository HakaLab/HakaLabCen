package cl.cencosud.publicsite.automation.poc.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageFormulario {
	
	
	@FindBy(how = How.ID, using = "")
	private WebElement labelNombre;
	
	@FindBy(how = How.ID, using = "")
	private WebElement nombre;
	
	@FindBy(how = How.ID, using = "")
	private WebElement labelRut;
	
	@FindBy(how = How.ID, using = "")
	private WebElement msjerror;

	public WebElement getMsjerror() {
		return msjerror;
	}

	public void setMsjerror(WebElement msjerror) {
		this.msjerror = msjerror;
	}

	public WebElement getLabelNombre() {
		return labelNombre;
	}

	public void setLabelNombre(WebElement labelNombre) {
		this.labelNombre = labelNombre;
	}

	public WebElement getNombre() {
		return nombre;
	}

	public void setNombre(WebElement nombre) {
		this.nombre = nombre;
	}

	public WebElement getLabelRut() {
		return labelRut;
	}

	public void setLabelRut(WebElement labelRut) {
		this.labelRut = labelRut;
	}

}
