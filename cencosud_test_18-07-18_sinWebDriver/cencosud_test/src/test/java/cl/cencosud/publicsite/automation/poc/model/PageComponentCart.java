package cl.cencosud.publicsite.automation.poc.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageComponentCart {
	
	
//	@FindBy(how = How.XPATH, using = "//*[@id=\"primary\"]/div[2]/div/div/h3/text()")
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"primary\"]/div[2]/div/div/h3/text()")
	private WebElement tituloProductoCart;
	@FindBy(how = How.CLASS_NAME, using = "box-image-carro")
	private WebElement imagenProductoCart;
	@FindBy(how = How.CLASS_NAME, using = "name")
	private WebElement nombreProductoCart;
	@FindBy(how = How.XPATH, using = "//*[@id=\"primary\"]/div[2]/div/div/h3/span")
	private WebElement cantidadProductoCart;
	@FindBy(how = How.ID, using = "add-to-cart")
	private WebElement objetoPdp;
	@FindBy(how = How.ID, using = "add-to-cart")
	private WebElement btnAgregarCarro;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'mini-cart-link-cart')]")
	private WebElement pdpBtnVerCarro;
	
	
	//*[@id="primary"]/div[2]/div/div/h3/text()
	
	
	
	public WebElement getBtnAgregarCarro() {
		return btnAgregarCarro;
	}
	public void setBtnAgregarCarro(WebElement btnAgregarCarro) {
		this.btnAgregarCarro = btnAgregarCarro;
	}
	public WebElement getPdpBtnVerCarro() {
		return pdpBtnVerCarro;
	}
	public void setPdpBtnVerCarro(WebElement pdpBtnVerCarro) {
		this.pdpBtnVerCarro = pdpBtnVerCarro;
	}
	public WebElement getObjetoPdp() {
		return objetoPdp;
	}
	public void setObjetoPdp(WebElement objetoPdp) {
		this.objetoPdp = objetoPdp;
	}
	public WebElement getTituloProductoCart() {
		return tituloProductoCart;
	}
	public void setTituloProductoCart(WebElement tituloProductoCart) {
		this.tituloProductoCart = tituloProductoCart;
	}
	public WebElement getImagenProductoCart() {
		return imagenProductoCart;
	}
	public void setImagenProductoCart(WebElement imagenProductoCart) {
		this.imagenProductoCart = imagenProductoCart;
	}
	public WebElement getNombreProductoCart() {
		return nombreProductoCart;
	}
	public void setNombreProductoCart(WebElement nombreProductoCart) {
		this.nombreProductoCart = nombreProductoCart;
	}
	public WebElement getCantidadProductoCart() {
		return cantidadProductoCart;
	}
	public void setCantidadProductoCart(WebElement cantidadProductoCart) {
		this.cantidadProductoCart = cantidadProductoCart;
	}
	
}
