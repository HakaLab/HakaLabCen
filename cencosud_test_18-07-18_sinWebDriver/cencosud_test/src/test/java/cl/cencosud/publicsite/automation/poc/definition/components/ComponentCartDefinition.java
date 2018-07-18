package cl.cencosud.publicsite.automation.poc.definition.components;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;

import cl.cencosud.publicsite.automation.poc.business.flow.BaseFlow;
import cl.cencosud.publicsite.automation.poc.util.FlujoCompraServices;
import cl.cencosud.publicsite.automation.poc.util.GenericMethods;
import cl.cencosud.publicsite.automation.poc.util.PSCException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ComponentCartDefinition {
	private static final Log log = LogFactory.getLog(ComponentCartDefinition.class);
	
	@Given("^ingreso url$")
	public void ingreso_url() throws Throwable {
		BaseFlow.driver.manage().deleteAllCookies();
	    BaseFlow.driver.get("https://storefront:cen_2018@dev10-na01-cencosud.demandware.net/s/Paris/home");
	}
	

	@When("^ingreso sku \"(.*?)\"$")
	public void ingreso_sku(String sku) throws Throwable {
		try {
			FlujoCompraServices.ingresarSkuAndSearch(sku);
		} catch (Exception e) {
			log.error("Detenido en ingreso SKU : " + e);
		}
	}

	@When("^selecciono detalles de producto \"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void selecciono_detalles_de_producto(String tipoProducto, String cantidad, 
			String conArmado,String conGarantia) throws Throwable {
		try {
            //validar stock
            if(!GenericMethods.existElement(By.xpath("//div[@class=\"out-of-stock\"]"))){
                FlujoCompraServices.seleccionarCantidad(cantidad);
                FlujoCompraServices.seleccionarColor(tipoProducto);       
                FlujoCompraServices.seleccionarTalla(tipoProducto);
                FlujoCompraServices.seleccionarProductoConArmadoOrGarantia(conArmado,conGarantia,tipoProducto);
            }else {
                throw new PSCException("PRODUCTO SIN STOCK");
            }
        }catch (PSCException e) {
            log.info(e);
          //  BaseFlow.driver.quit();
        } 
        catch (Exception e) {
//            log.error(e);
            throw e;
        }
	    
	}
	
	@When("^se agrega producto al carro$")
	public void se_agrega_producto_al_carro() throws Throwable {
		try {
			if(BaseFlow.isActiveSessionDriver()) {
//				Thread.sleep(3000);
				GenericMethods.waitTime(BaseFlow.pageModel.getPdpAgregarCarro());
				GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getPdpAgregarCarro());
				GenericMethods.scrollClickElement(BaseFlow.driver,BaseFlow.pageModel.getPdpBtnVerCarro());
			}			
		}catch (PSCException e) {
			log.info(e);
		} 
		catch (Exception e) {
			log.error("Flujo detenido en agregar al carro por : " + e);
		}
	    
	}

	@Then("^Se valida titulo de carro de compra$")
	public void se_valida_titulo_de_carro_de_compra() throws Throwable {
		try {
//			Thread.sleep(3000);
			assertTrue("No se logra visualizar titulo en carro de compra", BaseFlow.pageComponentCart.getTituloProductoCart().isDisplayed());
		} catch (Exception e) {
			assertTrue("No se logra visualizar titulo en carro de compra", false);
		}
	    
	}

	@Then("^Se valida el numero de la cantidad de productos en el carro de compras$")
	public void se_valida_el_numero_de_la_cantidad_de_productos_en_el_carro_de_compras() throws Throwable {
		assertTrue("No se logra visualizar el numero de la cantidad del producto", BaseFlow.pageComponentCart.getCantidadProductoCart().isDisplayed());
	    
	}

	@When("^Se Selecciona la imagen del producto en el carro de compra$")
	public void se_Selecciona_la_imagen_del_producto_en_el_carro_de_compra() throws Throwable {
		BaseFlow.pageComponentCart.getImagenProductoCart().click();
	    
	}

	@Then("^Se verifica redireccionamiento al hacer click a la imagen del producto pdp$")
	public void se_verifica_redireccionamiento_al_hacer_click_a_la_imagen_del_producto_pdp() throws Throwable {
		 assertTrue("No se logro redireccionar a la pdp dando click a la imagen del producto", BaseFlow.pageComponentCart.getObjetoPdp().isDisplayed());
		 BaseFlow.driver.get("https://dev10-na01-cencosud.demandware.net/s/Paris/cart");
	}

	@When("^Se Selecciona el nombre del producto en el carro de compra$")
	public void se_Selecciona_el_nombre_del_producto_en_el_carro_de_compra() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se verifica redireccionamiento al hacer click nombre del producto pdp$")
	public void se_verifica_redireccionamiento_al_hacer_click_nombre_del_producto_pdp() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida el codigo sku en carro de compra$")
	public void se_valida_el_codigo_sku_en_carro_de_compra() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida la cantidad desplegable del producto en carro de compra$")
	public void se_valida_la_cantidad_desplegable_del_producto_en_carro_de_compra() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida los precios totales segun el precio del producto$")
	public void se_valida_los_precios_totales_segun_el_precio_del_producto() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida precios segun regla de  negocio$")
	public void se_valida_precios_segun_regla_de_negocio() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida iconos de metodos de envios$")
	public void se_valida_iconos_de_metodos_de_envios() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida producto con despacho a domicilio asociado$")
	public void se_valida_producto_con_despacho_a_domicilio_asociado() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida producto con retiro en tienda asociado$")
	public void se_valida_producto_con_retiro_en_tienda_asociado() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida producto con ambos atributos de entrega asociado$")
	public void se_valida_producto_con_ambos_atributos_de_entrega_asociado() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida producto con cualquier atributo de entrega asociado$")
	public void se_valida_producto_con_cualquier_atributo_de_entrega_asociado() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida el color del producto en el carro de compras$")
	public void se_valida_el_color_del_producto_en_el_carro_de_compras() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida la talla del producto en el carro de compras$")
	public void se_valida_la_talla_del_producto_en_el_carro_de_compras() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida la opcion de armado del producto en el carro de compras$")
	public void se_valida_la_opcion_de_armado_del_producto_en_el_carro_de_compras() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida la opcion de garantia del producto en el carro de compras$")
	public void se_valida_la_opcion_de_garantia_del_producto_en_el_carro_de_compras() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida la informacion del sub total en el carro de compra$")
	public void se_valida_la_informacion_del_sub_total_en_el_carro_de_compra() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Se valida la informacioon de descuento del producto en promocion$")
	public void se_valida_la_informacioon_de_descuento_del_producto_en_promocion() throws Throwable {
	 
	    
	}

















}