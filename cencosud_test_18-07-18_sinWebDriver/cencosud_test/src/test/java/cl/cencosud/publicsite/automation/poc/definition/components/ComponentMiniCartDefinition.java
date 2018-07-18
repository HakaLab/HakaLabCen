package cl.cencosud.publicsite.automation.poc.definition.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cl.cencosud.publicsite.automation.poc.business.flow.BaseFlow;
import cl.cencosud.publicsite.automation.poc.model.CompraSingleton;
import cl.cencosud.publicsite.automation.poc.model.PageComponentMiniCart;
import cl.cencosud.publicsite.automation.poc.util.FlujoCompraServices;
import cl.cencosud.publicsite.automation.poc.util.GenericMethods;
import cl.cencosud.publicsite.automation.poc.util.PSCException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ComponentMiniCartDefinition {
	private static final Log log = LogFactory.getLog(ComponentMiniCartDefinition.class);
	CompraSingleton singleton=CompraSingleton.getInstance(); 
	@Given("^ingreso url miniCart$")
	public void ingreso_url_miniCart() throws Throwable {
		BaseFlow.driver.manage().deleteAllCookies();
	    BaseFlow.driver.get("https://storefront:cen_2018@dev10-na01-cencosud.demandware.net/s/Paris/home");
	}

	@When("^ingreso sku miniCart\"(.*?)\"$")
	public void ingreso_sku_miniCart(String sku) throws Throwable {
			try {
			FlujoCompraServices.ingresarSkuAndSearch(sku);
		} catch (Exception e) {
			log.error("Detenido en ingreso SKU : " + e);
		}
	}

	@When("^selecciono detalles de producto miniCart\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void selecciono_detalles_de_producto_miniCart(String tipoProducto, String cantidad, String conArmado, String conGarantia) throws Throwable {
		try {
      //validar stock
		      if(!GenericMethods.existElement(By.xpath("//div[@class=\"out-of-stock\"]"))){
		          FlujoCompraServices.seleccionarCantidad(cantidad);
		          FlujoCompraServices.seleccionarColor(tipoProducto);       
		          FlujoCompraServices.seleccionarTalla(tipoProducto);
		          FlujoCompraServices.seleccionarProductoConArmadoOrGarantia(conArmado,conGarantia,tipoProducto);
		         singleton.setCantidadSku(cantidad);
		         singleton.setNombreSku(BaseFlow.componentPdp.getNameProductoPdp().getText());
		         singleton.setPrecioSku(BaseFlow.componentPdp.getPrecioProductoPdp().getText());
		      }else {
		          throw new PSCException("PRODUCTO SIN STOCK");
		      }
		  }catch (PSCException e) {
		      log.info(e);
		    //  BaseFlow.driver.quit();
		  } 
		  catch (Exception e) {
		//      log.error(e);
		      throw e;
		  }
  
	}

	@When("^se agrega producto al carro miniCart$")
	public void se_agrega_producto_al_carro_miniCart() throws Throwable {
		try {
			if(BaseFlow.isActiveSessionDriver()) {
				
//				Thread.sleep(3000);
				GenericMethods.waitTime(BaseFlow.pageModel.getPdpAgregarCarro());
				GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getPdpAgregarCarro());
//				GenericMethods.scrollClickElement(BaseFlow.driver,BaseFlow.pageModel.getPdpBtnVerCarro());
			}
			
			
		}catch (PSCException e) {
			log.info(e);
		} 
		catch (Exception e) {
			log.error("Flujo detenido en agregar al carro por : " + e);
		}

	}
	
	@When("^se cancela producto bonificacion para mostrar miniCart$")
	public void se_cancela_producto_bonificacion_para_mostrar_miniCart() throws Throwable {
		JavascriptExecutor js=(JavascriptExecutor)BaseFlow.driver;
		String script = "return document.getElementsByClassName('ui-dialog ui-widget ui-widget-content ui-corner-all ui-front bonus-products-modal ui-dialog-buttons').length;";
		String existe = js.executeScript(script).toString();
		if(!existe.equals("0")){
			FlujoCompraServices.productoBonificacion("false");
		}
	}
	
	@Then("^Se valida titulo de mini carro$")
	public void se_valida_titulo_de_mini_carro() throws Throwable {
		assertTrue("No se logra visualizar titulo en mini carro", BaseFlow.componentMiniCart.getCantProductoMiniCart().isDisplayed());
	}

	@Then("^Se valida imagen de sku en mini carro$")
	public void se_valida_imagen_de_sku_en_mini_carro() throws Throwable {

	}

	@Then("^Se valida nombre de sku en mini carro$")
	public void se_valida_nombre_de_sku_en_mini_carro() throws Throwable {
		assertEquals("El nombre de Sku del mini carro es distinto al nombre de sku ingresado en el pdp",singleton.getNombreSku(), BaseFlow.componentMiniCart.getNameProductoMiniCart().getText());
	}

	

	@Then("^Se valida el numero de la cantidad de productos en el mini carros$")
	public void se_valida_el_numero_de_la_cantidad_de_productos_en_el_mini_carros() throws Throwable {
		assertEquals("La canttidad de Sku del mini carro es distinta a la cantidad ingresada en el pdp",singleton.getCantidadSku(), BaseFlow.componentMiniCart.getCantProductoMiniCart().getText());
	}

	@When("^Se Selecciona la imagen del producto en el mini carro$")
	public void se_Selecciona_la_imagen_del_producto_en_el_mini_carro() throws Throwable {

	}
	


//
//	@Then("^Se valida titulo de carro de compra$")
//	public void se_valida_titulo_de_carro_de_compra() throws Throwable {
//		try {
////			Thread.sleep(3000);
//			assertTrue("No se logra visualizar titulo en carro de compra", BaseFlow.pageComponentCart.getTituloProductoCart().isDisplayed());
//		} catch (Exception e) {
//			assertTrue("No se logra visualizar titulo en carro de compra", false);
//		}
//	    
//	}
//
//	@Then("^Se valida el numero de la cantidad de productos en el carro de compras$")
//	public void se_valida_el_numero_de_la_cantidad_de_productos_en_el_carro_de_compras() throws Throwable {
//		assertTrue("No se logra visualizar el numero de la cantidad del producto", BaseFlow.pageComponentCart.getCantidadProductoCart().isDisplayed());
//	    
//	}
//
//	@When("^Se Selecciona la imagen del producto en el carro de compra$")
//	public void se_Selecciona_la_imagen_del_producto_en_el_carro_de_compra() throws Throwable {
//		BaseFlow.pageComponentCart.getImagenProductoCart().click();
//	    
//	}
//
//	@Then("^Se verifica redireccionamiento al hacer click a la imagen del producto pdp$")
//	public void se_verifica_redireccionamiento_al_hacer_click_a_la_imagen_del_producto_pdp() throws Throwable {
//		 assertTrue("No se logro redireccionar a la pdp dando click a la imagen del producto", BaseFlow.pageComponentCart.getObjetoPdp().isDisplayed());
//		 BaseFlow.driver.get("https://dev10-na01-cencosud.demandware.net/s/Paris/cart");
//	}


}