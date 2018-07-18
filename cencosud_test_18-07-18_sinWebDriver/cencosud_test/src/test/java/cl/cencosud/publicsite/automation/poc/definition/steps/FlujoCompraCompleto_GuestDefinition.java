package cl.cencosud.publicsite.automation.poc.definition.steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.basic.BasicTreeUI.TreeHomeAction;

import org.apache.commons.exec.OS;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cl.cencosud.publicsite.automation.constants.Constants;
import cl.cencosud.publicsite.automation.poc.business.flow.BaseFlow;
import cl.cencosud.publicsite.automation.poc.util.CreateFileExcel;
import cl.cencosud.publicsite.automation.poc.util.FlujoCompraServices;
import cl.cencosud.publicsite.automation.poc.util.GenericMethods;
import cl.cencosud.publicsite.automation.poc.util.ManagementMicrosoftService;
import cl.cencosud.publicsite.automation.poc.util.PSCException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class FlujoCompraCompleto_GuestDefinition {
	private static final Log log = LogFactory.getLog(FlujoCompraCompleto_GuestDefinition.class);

	List<String> datos = new ArrayList<String>();
    public static String nombreHoja;
	@Given("^ingreso url_guest\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_url_guest(String tipoProducto, String tc, String sku, String tipoEntrega, 
		String tipoDespacho, String metodoPago, String nTarjeta, String nDocumento, String factura) throws Throwable {
		BaseFlow.driver.manage().deleteAllCookies();
	    BaseFlow.driver.get("https://storefront:cen_2018@dev10-na01-cencosud.demandware.net/s/Paris/home");
	    //datos = Arrays.asList(tc,"Guest",nDocumento,sku,tipoEntrega,tipoDespacho,metodoPago,nTarjeta,"","",System.getProperty("os.name"),Constants.Browser);
//       ManagementMicrosoftService.WriteFileExcel(nombreExcel, datos);
	    List<String> datos = FlujoCompraServices.createDataForExcel(sku,  tipoEntrega,  tipoDespacho,  metodoPago,  nTarjeta, tipoProducto, factura);
        FlujoCompraServices.createSheetForNameTestCase(nombreHoja,tc, datos);
	}

	@When("^ingreso sku como_guest\"(.*?)\"$")
	public void ingreso_sku(String sku) throws Exception {
		try {
			FlujoCompraServices.ingresarSkuAndSearch(sku);
		} catch (Exception e) {
			log.error("Flujo de Usuario invitado, detenido en ingreso SKU : " + e);
		}
	}
	@When("^selecciono detalles de producto en PDP_guest\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void selecciono_detalles_de_producto_en_PDP_guest(String tipoProducto, String cantidad, String conArmado,String conGarantia) throws Exception {
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
//            BaseFlow.driver.quit();
        } 
        catch (Exception e) {
//            log.error(e);
            throw e;
        }
	}

	@When("^se agrega producto al carro_guest$")
	public void se_agrega_producto_al_carro() throws Exception {
		try {
			if(BaseFlow.isActiveSessionDriver()) {
				GenericMethods.waitTime(BaseFlow.pageModel.getPdpAgregarCarro());
				GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getPdpAgregarCarro());
			}			
		}catch (PSCException e) {
			log.info(e);
		} 
		catch (Exception e) {
			log.error("Flujo detenido en agregar al carro por : " + e);
		}
	}

	@When("^Producto de bonificacion_guest\"(.*?)\"$")
	public void producto_de_bonificacion(String agregarBonificacion) throws Exception {
		try {
			JavascriptExecutor js=(JavascriptExecutor)BaseFlow.driver;
			String script = "return document.getElementsByClassName('ui-dialog ui-widget ui-widget-content ui-corner-all ui-front bonus-products-modal ui-dialog-buttons').length;";
			String existe = js.executeScript(script).toString();
			if(!existe.equals("0")){
				FlujoCompraServices.productoBonificacion(agregarBonificacion);
			}
		}catch (Exception e) {
			log.error("Flujo de Usuario invitado, detenido en producto de bonificacion por: " + e);
		}
	}

	@When("^ingreso a mini carro_guest\"(.*?)\"$")
	public void ingreso_a_mini_carro(String seleccionCarroOrPago) throws Exception {
		try {
			GenericMethods.waitTime(BaseFlow.pageModel.getPdpBtnVerCarro());
			if (seleccionCarroOrPago.equals(Constants.MINICARRO_COMPRAR)) {
				GenericMethods.scrollClickElement(BaseFlow.driver,BaseFlow.pageModel.getPdpBtnComprar());
			} else if (seleccionCarroOrPago.equals(Constants.MINICARRO_CARRO)) {
				GenericMethods.scrollClickElement(BaseFlow.driver,BaseFlow.pageModel.getPdpBtnVerCarro());
			} else {
				throw new PSCException("el valor de 'seleccionCarroOrPago' es "+seleccionCarroOrPago+", el cual no es valido de acuerdo a la tipificacion,ver en el feature");
			} 
		}catch (PSCException e) {
			log.error(e);
		} catch (Exception e) {
			log.error("Flujo de Usuario invitado en checkOut, detenido en ingreso a mini carro por: " + e);
		}
	}
	
	
	 

	@When("^ingreso al carro de compras o comprar directamente_guest\"(.*?)\"\"(.*?)\"$")
	public void ingreso_al_carro_de_compras_o_comprar_directamente_guest(String seleccionCarroOrPago, String cdgoDescuento) throws Exception {
		try {
			if (seleccionCarroOrPago.equals(Constants.MINICARRO_CARRO)) {
				if(!cdgoDescuento.equals("")) {
					BaseFlow.pageModel.getCarroTxtCodigoDescuento().sendKeys(cdgoDescuento);
					BaseFlow.pageModel.getCarroBtnDescuento().click();
					if(!FlujoCompraServices.isValidCdgoDescuento()) {
						throw new PSCException("Codigo de descuento "+cdgoDescuento+" no ha sido aplicado");
					}
				}
				GenericMethods.waitTime(BaseFlow.pageModel.getCarroBtnIrALaCaja());
				GenericMethods.scrollClickElement(BaseFlow.driver,BaseFlow.pageModel.getCarroBtnIrALaCaja()); 
			}
		} catch (PSCException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(
					"log.error(\"Flujo de Usuario registrado en checkOut, detenido en ingreso al carro de compras o comprar directamente  : "
							+ e);
		}
	}
	
	@When("^selecciono tipo de cliente_guest$")
	public void selecciono_tipo_de_cliente() throws Exception {
		try {
//				GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutBtnInvitado());
				Thread.sleep(5000);
				BaseFlow.pageModel.getCheckoutBtnInvitado().click();
		} catch (Exception e) {
			log.error("Flujo detenido en seleccion tipo de cliente : " + e);
		}
	}

	@When("^ingresamos datos de cliente_guest\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingresamos_datos_de_cliente(String nombreCliente, String apellidoCliente, String email, String telefono,
			String tipoDocumento, String nDocumento) throws Exception {
		try {
			BaseFlow.pageModel.getCheckoutTextNombre().sendKeys(nombreCliente);
			BaseFlow.pageModel.getCheckoutTextApellido().sendKeys(apellidoCliente);
			BaseFlow.pageModel.getCheckoutTextEmail().sendKeys(email);
			BaseFlow.pageModel.getCheckoutTextTelefono().sendKeys(telefono);
			FlujoCompraServices.seleccionDocumento(tipoDocumento, nDocumento);
			GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutBtncontinuar());
			BaseFlow.pageModel.getCheckoutBtncontinuar().click();
		} catch (Exception e) {
			log.error("Flujo detenido en ingreso datos del cliente : " + e);
		}
	}


	@When("^selecciono tipo de entrega_guest\"(.*?)\"$")
	public void selecciono_tipo_de_entrega(String tipoEntrega) throws Exception {
		try {
			if (tipoEntrega.equals(Constants.TIPODESPACHO_RETIRO_EN_TIENDA)) {
				BaseFlow.pageModel.getCheckoutBtnRetiroEnTienda().click();
			}else if (tipoEntrega.equals(Constants.TIPODESPACHO_DOMICILIO))  {
				BaseFlow.pageModel.getCheckoutBtnDespachoDomicilio().click();
			}else{
				throw new PSCException("el valor de 'tipoEntrega' es "+tipoEntrega+", el cual no es valido de acuerdo a la tipificacion,ver en el feature");
			}
		} catch (PSCException e) {
			log.info(e);
		}catch (Exception e) {
			log.error("Flujo detenido en seleccion tipo de entrega : " + e);
		}

	}

	@When("^ingreso Datos Despacho o Tienda_guest\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_Datos_Despacho_o_Tienda(String tipoEntrega, String tipoDespacho, String tipoUbicacion,
			String ubicacion, String direccion, String numeroCasaDepto, String cdgPostal, String region, String comuna,
			String calle, String numeroCalle) throws Exception {
		try {
			FlujoCompraServices.ingresoDatosDespachoOrTienda(tipoEntrega, tipoUbicacion, ubicacion, direccion, numeroCasaDepto, cdgPostal, region, comuna, calle, numeroCalle);
		} catch (Exception e) {
			log.error("Flujo detenido en ingreso datos despacho o tienda : " + e);
		}

	}

	@When("^seleccionar tipo de despacho_guest\"(.*?)\"\"(.*?)\"$")
	public void selecciono_boton_continuar_compra(String tipoEntrega, String tipoDespacho) throws Exception {
		try {
			
			Thread.sleep(2000);
			if (tipoEntrega.equals("domicilio")) {
		    	if(tipoDespacho.equals("standard")) {
		    		//TODO eliminar if de preSale
		    		if(GenericMethods.existElement(By.xpath("//label[@for=\"shipping-method-5\"]"))) {
		    			WebElement radio = GenericMethods.findElementReturnWebElement(By.xpath("//label[@for=\"shipping-method-5\"]"));
			    		radio.click();
		    		}else  	if(!BaseFlow.pageModel.getEntregaRadioDespachoDomicilioStandar().isSelected()) {
			    		WebElement radio = GenericMethods.findElementReturnWebElement(By.xpath("//label[@for=\"shipping-method-1\"]"));
			    		radio.click();
			    	}
			    	
			    }else if(!BaseFlow.pageModel.getEntregaRadioDespachoDomicilioProgramada().isSelected()){
			    	WebElement radio = GenericMethods.findElementReturnWebElement(By.xpath("//label[@for=\"shipping-method-2\"]"));
	                radio.click();
	                BaseFlow.pageModel.getCheckoutListRadioDespachoProgramado().get(0).click();
			    }
			}
			GenericMethods.waitTime(BaseFlow.pageModel.getEntregaBtnFacturacion());
	    	GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getEntregaBtnFacturacion());
		} catch (Exception e) {
			log.error("Flujo detenido en seleccion boton continuar compra : " + e);
		}
	}
	
	
	@When("^ingreso compra con factura_guest\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_compra_con_factura(String ingresaFactura, String nomEmpresa, String razonSocial, String regionFactura, String calleFactura, String numCasaDeptoFactura, 
			String personaContactoFactura, String rutFactura, String giro, String comunaFactura, String numeroFactura, String fonoFactura, String emailFactura) throws Exception {
		try {
			if (ingresaFactura.equalsIgnoreCase("true")) {
				BaseFlow.pageModel.getCheckoutBtnIngresaDatosFactura().click();
				FlujoCompraServices.ingresoDatosFactura(nomEmpresa, razonSocial, regionFactura, calleFactura, numCasaDeptoFactura, personaContactoFactura, 
						rutFactura, giro, comunaFactura, numeroFactura, fonoFactura, emailFactura);
				BaseFlow.pageModel.getCheckoutBtnIngresaDatosFactura().click();
			}
		} catch (Exception e) {
			log.error("Flujo detenido en ingreso compra con factura guest: " + e);
		}
	}

	@When("^ingreso codigo novios bebe y casa_guest\"(.*?)\"$")
	public void ingreso_codigo_novios_bebe_y_casa(String codNoviosBebeCasa) throws Exception {
		try {
			// Falta tomar los id de los objetos e ingresarlos a page model
			// BaseFlow.pageModel.getCheckoutInputCodNoviosBebeCasa().sendKeys(codNoviosBebeCasa);
			// BaseFlow.pageModel.getCheckoutBtnCodNoviosBebeCasa().click();
		} catch (Exception e) {
			log.error("Flujo detenido en ingreso codigo novios bebe casa guest: " + e);
		}
	}

	@When("^selecciono metodo pago_guest\"(.*?)\"$")
	public void selecciono_metodo_pago_guest(String metodoPago) throws Throwable {
		try {
			if (metodoPago.equals(Constants.TARJETA_CREDITO_CENCOSUD)) {
				GenericMethods.scrollElement(BaseFlow.driver, BaseFlow.pageModel.getCheckOutHrefCencosudCredito());
				GenericMethods.waitTime(BaseFlow.pageModel.getCheckOutHrefCencosudCredito());
				BaseFlow.pageModel.getCheckOutHrefCencosudCredito().click();
			} else if (metodoPago.equals(Constants.TARJETA_CREDITO)) {
				 GenericMethods.waitTime(BaseFlow.pageModel.getCheckOutHrefTarjetaCredito()); 
				 GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getCheckOutHrefTarjetaCredito());
				 //llenar datos de tgarjeta
			} else if (metodoPago.equals(Constants.REDCOMPRA)) {
				GenericMethods.scrollElement(BaseFlow.driver, BaseFlow.pageModel.getCheckOutHrefRedCompra());
				GenericMethods.waitTime(BaseFlow.pageModel.getCheckOutHrefRedCompra());
				BaseFlow.pageModel.getCheckOutHrefRedCompra().click();
			}

		} catch (Exception e) {
			log.error("Flujo detenido en seleccion metodo de pago guest: " + e);
		}

	}
	

	@When("^ingreso datos metodo pago_guest\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_datos_metodo_pago(String metodoPago, String codigoGiftCard, String claveGiftCard, String nombreTitularTarjeta,
			String apellidoTitularTarjeta, String numeroTarjeta, String mesTarjeta, String anioTarjeta, String cvvTarjeta, String nCuotas,
			String guardarTarjeta, String TipoTarjetaCenco, String rut) throws Exception {
		try {
			FlujoCompraServices.ingresarDatosMetodosPago(metodoPago, numeroTarjeta, mesTarjeta, anioTarjeta,cvvTarjeta,nombreTitularTarjeta, apellidoTitularTarjeta,rut,codigoGiftCard,claveGiftCard );

		}catch (PSCException e) {
			log.info(e);
		}catch (Exception e) {
			log.error("Flujo detenido en ingreso datos metodo pago guest : " + e);
		}
	}
	
	@Then("^se valida orden de compra$")
	public void se_valida_orden_de_compra() throws Exception {
		try {
			WebElement element = GenericMethods.implicityWait(12,By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[5]/div[2]/dl[1]/dd"));    //*[@id="main"]/div/div/div[1]/div[5]/div[2]/dl[1]/dd
	        if(element != null) {
	            String numOC = BaseFlow.pageModel.getCheckoutDivNumOrdenCompra().getText().toString();
	            ManagementMicrosoftService.WriteNumeroOCToExcelFile(nombreHoja,0,numOC);
	            log.info("La OC se ha generado correctamente : "+BaseFlow.pageModel.getCheckoutDivNumOrdenCompra().getText().toString());
	        }else {
	            log.info("OC No generada");
	        }
		}catch (Exception e) {
			log.error(e);
			throw e;
		}
	}


}
