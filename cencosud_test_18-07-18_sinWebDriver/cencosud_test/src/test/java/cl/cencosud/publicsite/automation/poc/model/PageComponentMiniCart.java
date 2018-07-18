package cl.cencosud.publicsite.automation.poc.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageComponentMiniCart {
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"primary\"]/div[2]/div/div/h3/text()")
	private WebElement tituloProductoMiniCart;
	@FindBy(how = How.CLASS_NAME, using = "box-image-mc box-image-os")
	private WebElement imagenProductoMiniCart;
	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[1]/div[2]/div/div[2]/div[1]/h4/a")
	private WebElement nameProductoMiniCart;
	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[1]/div[2]/div/div[2]/div[3]/p/span")
	private WebElement cantProductoMiniCart;
	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[1]/h3/span")
	private WebElement cantElementoMiniCart;
	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[1]/div[2]/div/div[2]/div[1]/div/div/h5")
	private WebElement precioProductoMiniCart;
	
	
	
	
	
	public WebElement getTituloProductoMiniCart() {
		return tituloProductoMiniCart;
	}
	public void setTituloProductoMiniCart(WebElement tituloProductoMiniCart) {
		this.tituloProductoMiniCart = tituloProductoMiniCart;
	}
	public WebElement getImagenProductoMiniCart() {
		return imagenProductoMiniCart;
	}
	public void setImagenProductoMiniCart(WebElement imagenProductoMiniCart) {
		this.imagenProductoMiniCart = imagenProductoMiniCart;
	}
	public WebElement getNameProductoMiniCart() {
		return nameProductoMiniCart;
	}
	public void setNameProductoMiniCart(WebElement nameProductoMiniCart) {
		this.nameProductoMiniCart = nameProductoMiniCart;
	}
	public WebElement getCantProductoMiniCart() {
		return cantProductoMiniCart;
	}
	public void setCantProductoMiniCart(WebElement cantProductoMiniCart) {
		this.cantProductoMiniCart = cantProductoMiniCart;
	}
	public WebElement getCantElementoMiniCart() {
		return cantElementoMiniCart;
	}
	public void setCantElementoMiniCart(WebElement cantElementoMiniCart) {
		this.cantElementoMiniCart = cantElementoMiniCart;
	}


}
