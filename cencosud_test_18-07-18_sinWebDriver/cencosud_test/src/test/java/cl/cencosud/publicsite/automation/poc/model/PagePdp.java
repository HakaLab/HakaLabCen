package cl.cencosud.publicsite.automation.poc.model;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PagePdp {
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'swatchanchor')]")
	private List<WebElement> checkOutRadioColores;
	@FindBy(how = How.ID, using = "va-size")
	private WebElement pdpSelectTalla;
	@FindBy(how = How.ID, using = "Quantity")
	private WebElement pdpSelectCantidad;
	//Boton Agregar al carro de compras  ID add-to-cart
	@FindBy(how = How.ID, using = "add-to-cart")
	private WebElement pdpAgregarCarro;
	@FindBy(how = How.XPATH, using = "//*[@id=\"product-content\"]/div[5]/div/a")
	private WebElement pdpBtnVerDisponibilidadDespacho;
	//Ventana desplegada Productos bonificado
	@FindBy(how = How.XPATH, using = "//*[@id=\"ext-gen44\"]/body/div[4]/div[3]/div/button[1]")
	private WebElement pdpBtnNoGracias;
	@FindBy(how = How.XPATH, using = "//*[@id=\"ext-gen44\"]/body/div[4]/div[3]/div/button[2]")
	private WebElement pdpBtnProductosDeBonificacion;
	//Mini Carro
	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[2]/div[2]/a[1]")
	private WebElement pdpBtnVerCarro;
	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[2]/div[2]/a[2]")
	private WebElement pdpBtnComprar;
	//CARRO COMPRA
	@FindBy(how = How.ID, using = "dwfrm_cart_couponCode")
	private WebElement pdpInputCuponCode;
	@FindBy(how = How.ID, using = "add-coupon")
	private WebElement pdpBtnAplicar;
	@FindBy(how = How.NAME, using = "dwfrm_cart_checkoutCart")
	private WebElement carroBtnIrALaCaja;	
	@FindBy(how = How.NAME, using = "dwfrm_cart_shipments_i0_items_i0_quantity")
	private WebElement pdpCarroSelectCantidad;
	@FindBy(how = How.ID, using = "dwopt_123423-999-_696544-999-")
	private WebElement pdpAssembly;//Cambio reciente
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'swatchanchor')]")
	private List<WebElement> pdpRadioColores;//CAMBIO RECIENTE
	
	
	
	
	
	
	
	
	
	
	
	
}
