package cl.cencosud.publicsite.automation.poc.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageComponentPdp {
	
	
	
	@FindBy(how = How.CLASS_NAME, using = "js-product-name")
	private WebElement nameProductoPdp;
	@FindBy(how = How.XPATH, using = "//*[@id=\"pdpMain\"]/div/div[2]/div[1]")
	private WebElement promocionProductoPdp;
	@FindBy(how = How.CLASS_NAME, using = "summary")
	private WebElement regaloProductoPdp;
	@FindBy(how = How.CLASS_NAME, using = "rating")
	private WebElement rankingProductoPdp;
	@FindBy(how = How.CLASS_NAME, using = "default-price")
	private WebElement precioProductoPdp;
	@FindBy(how = How.CLASS_NAME, using = "details-points")
	private WebElement divDetallePuntosCencoPdp;
	@FindBy(how = How.XPATH, using = "//*[@id=\"product-content\"]/div[2]/div[2]/div[2]/div/strong")
	private WebElement puntosCencoProductoPdp;
	@FindBy(how = How.CLASS_NAME, using = "fee-details")
	private WebElement divDetalleTarjetaPdp;	
	@FindBy(how = How.CLASS_NAME, using = "productthumbnail")
	private WebElement imagenMiniaturaPdp;
	@FindBy(how = How.CLASS_NAME, using = "zoomImg")
	private WebElement imagenGrandeZoomPdp;
	@FindBy(how = How.ID, using = "Quantity")
	private WebElement selectCantidadProductoPdp;
	@FindBy(how = How.ID, using = "add-to-cart")
	private WebElement btnAgregarCarroPdp;
	@FindBy(how = How.XPATH, using = "//*[@id=\"product-content\"]/div[5]/div/p")
	private WebElement opcionesEntregaPdp;
	@FindBy(how = How.CLASS_NAME, using = "icon-delivery")
	private WebElement iconoDespachoPdp;
	@FindBy(how = How.CLASS_NAME, using = "link-cyan")
	private WebElement linkDespachoPdp;
	@FindBy(how = How.XPATH, using = "//*[contains(@href,'#collapseDescription')]")
	private WebElement linkDescripcionProductoPdp;
	@FindBy(how = How.ID, using = "collapseDescription")
	private WebElement divDescripcionProductoPdp;
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@FindBy(how = How.CLASS_NAME, using = "js-product-name")
//	private WebElement imagenProductoPdp;
//	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[1]/div[2]/div/div[2]/div[1]/h4/a")
//	private WebElement nameProductoPdp;
	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[1]/div[2]/div/div[2]/div[3]/p/span")
	private WebElement cantProductoPdp;
	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[1]/h3/span")
	private WebElement cantElementoPdp;
	
	


	
	
	
	
	

}
