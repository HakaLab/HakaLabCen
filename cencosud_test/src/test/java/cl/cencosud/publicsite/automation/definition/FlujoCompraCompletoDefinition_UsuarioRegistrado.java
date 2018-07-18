package cl.cencosud.publicsite.automation.definition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cl.cencosud.publicsite.automation.Exception.PSCException;
import cl.cencosud.publicsite.automation.constants.Constants;
import cl.cencosud.publicsite.automation.flow.BaseFlow;
import cl.cencosud.publicsite.automation.services.FlujoCompraService;
import cl.cencosud.publicsite.automation.services.ManagementMicrosoftService;
import cl.cencosud.publicsite.automation.util.GenericMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlujoCompraCompletoDefinition_UsuarioRegistrado {
	private static final Log log = LogFactory.getLog(FlujoCompraCompletoDefinition_UsuarioRegistrado.class);
	List<String> datos = new ArrayList<String>();
	public static String nombreHoja;
	
	@Given("^Ingreso a la url de paris_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_a_la_url_de_paris_registrado(String tc,String login,String usuario,String sku, String despacho, String despachoDomicilio, String metodoPago, String numeroTarjeta,String tipoProducto,String factura) throws Throwable {
		try {
			BaseFlow.driver.manage().deleteAllCookies();
			BaseFlow.driver.get("https://storefront:cen_2018@dev10-na01-cencosud.demandware.net/s/Paris/home");
			log.info("Inicio de compra en paris.cl");
			
			List<String> datos = FlujoCompraService.createDataForExcel(tc, login,usuario, sku,  despacho,  despachoDomicilio,  metodoPago,  numeroTarjeta, tipoProducto, factura);
			FlujoCompraService.createSheetForNameTestCase(nombreHoja,tc, datos);
			log.info("Se crea registro en documento excel con datos de prueba");
		} catch (Exception e) {
			log.error(e);
		}
	}

	@When("^Ingreso al login_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_al_login_registrado(String usuario, String clave, String tipoLogin) throws Exception {
		try {
				if(tipoLogin.equals(Constants.TIPOLOGIN_HOME)) {
					WebElement HomeLblLogin =GenericMethods.implicityWait(5,By.id("clickLogin"));
					HomeLblLogin.click();
//					GenericMethods.implicityWait(BaseFlow.pageModel.getLoginTxtUsuario());
					BaseFlow.pageModel.getLoginTxtUsuario().sendKeys(usuario);
					BaseFlow.pageModel.getLoginTxtClave().sendKeys(clave);
					BaseFlow.pageModel.getLoginBtnIniciarSesion().click();
			}
		}catch (Exception e) {
			 log.error("Caida en : ingreso al login_registrado :",e);
			 throw e;
		}
		
	}
	
	@When("^valido login ok_registrado$")
	public void valido_login_ok_registrado() throws Exception {
	   try {
			   if (!FlujoCompraService.isValidLogin()) {
				   throw new PSCException("Login Erroneo = "+BaseFlow.pageModel.getLoginLblError().getText());
	  		   }
	   } catch (PSCException e) {
		   log.info(e);
//		   BaseFlow.driver.quit();
		   System.exit(0);
	   }catch (Exception e) {
		   log.error("Caida en : valido login ok_registrado ",e);
	   }
	} 

	
	@When("^ingreso sku_registrado\"(.*?)\"$")
	public void ingreso_sku_registrado(String sku) throws Exception {
		try {
				FlujoCompraService.ingresarSkuAndSearch(sku);
		}catch (Exception e) {
			log.error("Caida en : ingreso sku_registrado ",e);
		}
	}
	
	@When("^selecciono detalles de producto en PDP_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void selecciono_detalles_de_producto_en_PDP_registrado(String tipoProducto, String cantidad, String conArmado,String conGarantia) throws Exception {
		try {
			if(!GenericMethods.existElement(By.xpath("//div[@class=\"out-of-stock\"]"))){
				FlujoCompraService.seleccionarCantidad(cantidad);
				FlujoCompraService.seleccionarColor(tipoProducto);	   
		    	FlujoCompraService.seleccionarTalla(tipoProducto);
				FlujoCompraService.seleccionarProductoConArmadoOrGarantia(conArmado,conGarantia,tipoProducto);
			}else {
				throw new PSCException("PRODUCTO SIN STOCK");
			}
		}catch (PSCException e) {
			log.info(e);
			BaseFlow.driver.quit();
//			System.exit(0);
		}catch (Exception e) {
			log.error("Caida en : selecciono detalles de producto en PDP_registrado ",e);
			throw e;
		}
	}


	@When("^se agrega producto al carro_registrado$")
	public void se_agrega_producto_al_carro_registrado() throws Exception {
		try {
			WebElement addToCart = GenericMethods.implicityWait(10, By.id("add-to-cart"));
			GenericMethods.scrollClickElement(addToCart);
		}catch (Exception e) {
			log.info("Caida en : se agrega producto al carro_registrado ",e);
			throw e;
		}
	}
		
	@When("^Ingresar bonificacion_registrado\"(.*?)\"$")
	public void ingresar_bonificacion_registrado(String agregarBonificacion) throws Exception {
		try {
			JavascriptExecutor js=(JavascriptExecutor)BaseFlow.driver;
			String script = "return document.getElementsByClassName('ui-dialog ui-widget ui-widget-content ui-corner-all ui-front bonus-products-modal ui-dialog-buttons').length;";
			String existe = js.executeScript(script).toString();
			if(!existe.equals("0")){
				FlujoCompraService.productoBonificacion(agregarBonificacion);
			}
		} catch (Exception e) {
			log.info("Caida en : ingresar bonificacion_registrado ",e);
			throw e;
		}
	}

	
	//opcion que permite ir a ver carro o comprar
	@When("^ingreso a mini carro_registrado\"(.*?)\"$")
	public void ingreso_a_mini_carro_registrado(String seleccionCarroOrPago) throws Exception {
	    try {
	    		if (seleccionCarroOrPago.equals(Constants.MINICARRO_COMPRAR)) {
	    			GenericMethods.scrollClickElement(BaseFlow.pageModel.getPdpBtnComprar());
			    }else if(seleccionCarroOrPago.equals(Constants.MINICARRO_CARRO)){
			    	GenericMethods.scrollClickElement(BaseFlow.pageModel.getPdpBtnVerCarro());
			    }else {
			    	throw new PSCException("el valor de 'seleccionCarroOrPago' es "+seleccionCarroOrPago+", el cual no es valido de acuerdo a la tipificacion,ver en el feature");
			    }	
		} catch (PSCException e) {
			log.info(e);
		}catch (Exception e) {
			log.info("Caida en : ingreso a mini carro_registrado ",e);
			throw e;
		}
	}
	
	@When("^ingreso al carro de compras o comprar directamente_registrado\"(.*?)\"\"(.*?)\"$")
	public void ingreso_al_carro_de_compras_o_comprar_directamente_registrado(String seleccionCarroOrPago,String cdgoDescuento) throws Exception{
		try {
			if (seleccionCarroOrPago.equals(Constants.MINICARRO_CARRO)) {
				if(!cdgoDescuento.equals("")) {
					BaseFlow.pageModel.getCarroTxtCodigoDescuento().sendKeys(cdgoDescuento);
					BaseFlow.pageModel.getCarroBtnDescuento().click();
					if(!FlujoCompraService.isValidCdgoDescuento()) {
						throw new PSCException("Codigo de descuento "+cdgoDescuento+" no ha sido aplicado");
					}
				}
				WebElement irACaja = GenericMethods.implicityWait(3,By.name("dwfrm_cart_checkoutCart"));
				GenericMethods.scrollClickElement(irACaja); 
			}
		}catch (Exception e) {
			log.info("Caida en : ingreso al carro de compras o comprar directamente_registrado ",e);
			throw e;
		}
	}

	
	@When("^ingresar login en el checkOuts_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingresar_login_en_el_checkOuts_registrado(String tipoLogin, String usuario, String clave, String recordarClave) throws Exception {
		try {
			if(tipoLogin.equals(Constants.TIPOLOGIN_CHECKOUT)) {
				 BaseFlow.pageModel.getLoginTxtUsuario().sendKeys(usuario);
				    BaseFlow.pageModel.getLoginTxtClave().sendKeys(clave);
				    if(recordarClave == "true") {
				    	BaseFlow.pageModel.getLoginTxtRecordarClave().click();
				    }
				    BaseFlow.pageModel.getLoginBtnIniciarSesion().click();
			 } 
		} catch (Exception e) {
			log.info("Caida en : ingresar login en el checkOuts_registrado ",e);
			throw e;
		} 
	}
	
	
	@When("^ingresar tipo de entrega_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingresar_tipo_de_entrega_registrado(String despacho,String direccionCompleta, String calle, String numeroCasa, String codigoPostal) throws Exception {
	    //si es una nueva ubicacion
		try {
			if (despacho.equals(Constants.TIPODESPACHO_RETIRO_EN_TIENDA)) {
				if(GenericMethods.existElement(By.id("shipping-method-select-6"))) {
					WebElement webElement = GenericMethods.findElementReturnWebElement(By.id("shipping-method-select-6"));
					webElement.click();
				}else if(GenericMethods.existElement(By.id("shipping-method-select-2"))) {
					WebElement webElement = GenericMethods.findElementReturnWebElement(By.id("shipping-method-select-4"));
					webElement.click();
				}
				BaseFlow.pageModel.getCheckoutBtnRetiroTienda().click();
				FlujoCompraService.ingresarRetiroEnTienda(despacho);
//				GenericMethods.implicityWait(1,BaseFlow.pageModel.getEntregaBtnFacturacion());
				GenericMethods.scrollClickElement(BaseFlow.pageModel.getEntregaBtnFacturacion());
				//TODO ver logica retiro en tienda
			}else if (despacho.equals(Constants.TIPODESPACHO_DOMICILIO)) {
				if(GenericMethods.existElement(By.id("shipping-method-select-5")))	{
					WebElement radioPresale = GenericMethods.findElementReturnWebElement(By.id("shipping-method-select-5"));
					radioPresale.click();
				}else {
					WebElement radioStandar = GenericMethods.findElementReturnWebElement(By.id("shipping-method-select-1"));
					radioStandar.click();
				}
				FlujoCompraService.ingresarDireccion(despacho,direccionCompleta,calle,numeroCasa,codigoPostal);
//				GenericMethods.implicityWait(BaseFlow.pageModel.getEntregaBtnFacturacion());
				GenericMethods.scrollClickElement(BaseFlow.pageModel.getEntregaBtnFacturacion());
			}else {
				throw new PSCException("el valor de 'tipoEntrega' es "+despacho+", el cual no es valido de acuerdo a la tipificacion,ver en el feature");
			}
		} catch (PSCException e) {
			log.error(e);
		}catch (Exception e) {
			log.info("Caida en : ingresar tipo de entrega_registrado ",e);
			throw e;
		}
	}
	
	@When("^seleccionar tipo de despacho_registrado\"(.*?)\"$")
	public void seleccionar_tipo_de_despacho_registrado(String tipoDespacho) throws Exception {
		try {
	    	if(tipoDespacho.equals(Constants.TIPODESPACHODOMICILIO_ESTANDAR)) {
	    		if(GenericMethods.existElement(By.id("shipping-method-5"))) {
	    			WebElement presale = GenericMethods.implicityWait(3,By.xpath("//label[@for=\"shipping-method-5\"]"));
	    			presale.click();
	    		}else {
	    			if(!BaseFlow.pageModel.getEntregaRadioDespachoDomicilioStandar().isSelected()) {
			    		WebElement radio = GenericMethods.implicityWait(3,By.xpath("//label[@for=\"shipping-method-1\"]"));
			    		radio.click();
			    	}
	    		}
		    }else if(tipoDespacho.equals(Constants.TIPODESPACHODOMICILIO_PROGRAMADO)) {
    			WebElement radio = GenericMethods.implicityWait(3,By.xpath("//label[@for=\"shipping-method-2\"]"));
	    		radio.click();
	    		BaseFlow.pageModel.getCheckoutListRadioDespachoProgramado().get(0).click();
		    }						
//			GenericMethods.implicityWait(3,BaseFlow.pageModel.getEntregaBtnFacturacion());
	    	GenericMethods.scrollClickElement(BaseFlow.pageModel.getEntregaBtnFacturacion());
		} catch (Exception e) {
			log.info("Caida en : seleccionar tipo de despacho_registrado ",e);
			throw e;
		}	
	}
	@When("^ingreso compra con factura_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_compra_con_factura_registrado(String ingresaFactura, String nomEmpresa, String razonSocial, String regionFactura, String calleFactura, String numCasaDeptoFactura, 
			String personaContactoFactura, String rutFactura, String giro, String comunaFactura, String numeroFactura, String fonoFactura, String emailFactura) throws Exception {
		try {
			//Aplicar logica de facturas guardadas
			if (ingresaFactura.equalsIgnoreCase("true")) {
				BaseFlow.pageModel.getCheckoutBtnIngresaDatosFactura().click();
				FlujoCompraService.ingresoDatosFactura(nomEmpresa, razonSocial, regionFactura, calleFactura, numCasaDeptoFactura, personaContactoFactura, 
						rutFactura, giro, comunaFactura, numeroFactura, fonoFactura, emailFactura);
				BaseFlow.pageModel.getCheckoutBtnIngresaDatosFactura().click();
			}
		} catch (Exception e) {
			log.info("Caida en : ingreso compra con factura_registrado ",e);
			throw e;
		}
	}
	
	@When("^ingreso codigo novios bebe y casa_registrado\"(.*?)\"$")
	public void ingreso_codigo_novios_bebe_y_casa_registrado(String codigoNovios) throws Throwable {
//		BaseFlow.pageModel.getCheckOutTxtCodigoNovios().sendKeys(codigoNovios);
//		GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getCheckOutBtnNovios());
	}

	@When("^ingreso a modulo de pago_registrado\"(.*?)\"$")
	public void ingreso_a_modulo_de_pago_registrado(String metodoPago) throws Exception {
		try {
			if (metodoPago.equals(Constants.TARJETA_CREDITO_CENCOSUD)) {
				GenericMethods.scrollElement(BaseFlow.pageModel.getCheckOutHrefCencosudCredito());
				BaseFlow.pageModel.getCheckOutHrefCencosudCredito().click();
			} else if (metodoPago.equals(Constants.TARJETA_CREDITO)) {
				GenericMethods.scrollElement(BaseFlow.pageModel.getCheckOutHrefTarjetaCredito());
				BaseFlow.pageModel.getCheckOutHrefTarjetaCredito().click();
			} else if (metodoPago.equals(Constants.REDCOMPRA)) {
				 BaseFlow.pageModel.getCheckOutHrefRedCompra().click();
			}
		} catch (Exception e) {
			log.info("Caida en : ingreso a modulo de pago_registrado ",e);
			throw e;
		}
	}

	@When("^ingreso datos metodo pago_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_datos_metodo_pago_registrado(String metodoPago, String codigoGiftCard, String claveGiftCard, String nombreTitularTarjeta,
			String apellidoTitularTarjeta, String numeroTarjeta, String mesTarjeta, String anioTarjeta, String cvvTarjeta, String nCuotas,
			String guardarTarjeta, String TipoTarjetaCenco, String rut,String claveRedCompra) throws Exception {
		try {
			FlujoCompraService.ingresarDatosMetodosPago(metodoPago, codigoGiftCard, claveGiftCard,numeroTarjeta, mesTarjeta, anioTarjeta,cvvTarjeta,nombreTitularTarjeta, apellidoTitularTarjeta, rut,claveRedCompra);

		} catch (PSCException e) {
			log.info(e);
		}catch (Exception e) {
			log.info("Caida en : ingreso datos metodo pago_registrado ",e);
			throw e;
		}
	}
	
	@Then("^verifico que se genere la orden de compra_registrado$")
	public void verifico_que_se_genere_la_orden_de_compra_registrado() throws Exception {
		try {
			WebElement element = GenericMethods.implicityWait(15,By.xpath("//*[@id=\"main\"]/div/div/div[1]/div[5]/div[2]/dl[1]/dd"));	//*[@id="main"]/div/div/div[1]/div[5]/div[2]/dl[1]/dd
			String numOC = BaseFlow.pageModel.getCheckoutDivNumOrdenCompra().getText().toString();
			ManagementMicrosoftService.WriteNumeroOCToExcelFile(nombreHoja,0,numOC);
			log.info("La OC se ha generado correctamente : "+BaseFlow.pageModel.getCheckoutDivNumOrdenCompra().getText().toString());
		} catch (Exception e) {
			log.info("OC No generada");
			log.error(e);
			ManagementMicrosoftService.deleteLastRow(nombreHoja);
			GenericMethods.screenShot("ErrorOC");
			throw e;
		}
		}
}

