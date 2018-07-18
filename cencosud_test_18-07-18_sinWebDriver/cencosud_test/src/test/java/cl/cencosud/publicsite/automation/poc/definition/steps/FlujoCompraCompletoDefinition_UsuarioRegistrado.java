package cl.cencosud.publicsite.automation.poc.definition.steps;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cl.cencosud.publicsite.automation.constants.Constants;
import cl.cencosud.publicsite.automation.poc.business.flow.BaseFlow;
import cl.cencosud.publicsite.automation.poc.util.FlujoCompraServices;
import cl.cencosud.publicsite.automation.poc.util.GenericMethods;
import cl.cencosud.publicsite.automation.poc.util.PSCException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlujoCompraCompletoDefinition_UsuarioRegistrado {
	private static final Log log = LogFactory.getLog(FlujoCompraServices.class);

	@Given("^Ingreso a la url de paris_registrado$")
	public void ingreso_a_la_url_de_paris_registrado() throws Exception {
		BaseFlow.driver.manage().deleteAllCookies();
		BaseFlow.driver.get("https://storefront:cen_2018@dev10-na01-cencosud.demandware.net/s/Paris/404?lang=es_CL");
	}

	@When("^Ingreso al login_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_al_login_registrado(String usuario, String clave, String tipoLogin) throws Exception {
		try {
			if (tipoLogin.equals("home")) {
				GenericMethods.waitTime(BaseFlow.pageModel.getHomeLblLogin());
				BaseFlow.pageModel.getHomeLblLogin().click();
				GenericMethods.waitTime(BaseFlow.pageModel.getLoginTxtUsuario());
				BaseFlow.pageModel.getLoginTxtUsuario().sendKeys(usuario);
				BaseFlow.pageModel.getLoginTxtClave().sendKeys(clave);
				BaseFlow.pageModel.getLoginBtnIniciarSesion().click();
			}
		} catch (Exception e) {
			log.error("Caida en : ingreso al login_registrado :", e);
			throw e;
		}

	}

	@When("^valido login ok_registrado$")
	public void valido_login_ok_registrado() throws Exception {
		try {
			if (!FlujoCompraServices.isValidLogin()) {
				throw new PSCException("Login Erroneo = " + BaseFlow.pageModel.getLoginLblError().getText());
			}
		} catch (PSCException e) {
			log.info(e);
			BaseFlow.driver.quit();
		} catch (Exception e) {
			log.error("Caida en : valido login ok_registrado ", e);
		}
	}

	@When("^ingreso sku_registrado\"(.*?)\"$")
	public void ingreso_sku_registrado(String sku) throws Exception {
		try {
			if (BaseFlow.isActiveSessionDriver()) {
				FlujoCompraServices.ingresarSkuAndSearch(sku);
			}
		} catch (PSCException e) {
			log.info(e);
		} catch (Exception e) {
			log.error("Caida en : ingreso sku_registrado ", e);
		}
	}

	@When("^selecciono detalles de producto en PDP_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void selecciono_detalles_de_producto_en_PDP_registrado(String tipoProducto, String cantidad,
			String conArmado, String conGarantia) throws Exception {
		try {
			if (!GenericMethods.existElement(By.xpath("//div[@class=\"out-of-stock\"]"))) {
				FlujoCompraServices.seleccionarCantidad(cantidad);
				FlujoCompraServices.seleccionarColor(tipoProducto);
				FlujoCompraServices.seleccionarTalla(tipoProducto);
				FlujoCompraServices.seleccionarProductoConArmadoOrGarantia(conArmado, conGarantia, tipoProducto);
			} else {
				throw new PSCException("PRODUCTO SIN STOCK");
			}
		} catch (PSCException e) {
			log.info(e);
			BaseFlow.driver.quit();
		} catch (Exception e) {
			log.error("Caida en : selecciono detalles de producto en PDP_registrado ", e);
			throw e;
		}
	}

	@When("^se agrega producto al carro_registrado$")
	public void se_agrega_producto_al_carro_registrado() throws Exception {
		try {
			if (BaseFlow.isActiveSessionDriver()) {
				GenericMethods.waitTime(BaseFlow.pageModel.getPdpAgregarCarro());
				GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getPdpAgregarCarro());
			}
		} catch (PSCException e) {
			log.info(e);
		} catch (Exception e) {
			log.info("Caida en : se agrega producto al carro_registrado ", e);
			throw e;
		}
	}

	@When("^Ingresar bonificacion_registrado\"(.*?)\"$")
	public void ingresar_bonificacion_registrado(String agregarBonificacion) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) BaseFlow.driver;
			String script = "return document.getElementsByClassName('ui-dialog ui-widget ui-widget-content ui-corner-all ui-front bonus-products-modal ui-dialog-buttons').length;";
			String existe = js.executeScript(script).toString();
			if (!existe.equals("0")) {
				FlujoCompraServices.productoBonificacion(agregarBonificacion);
			}
		} catch (Exception e) {
			log.info("Caida en : ingresar bonificacion_registrado ", e);
			throw e;
		}
	}

	// opcion que permite ir a ver carro o comprar
	@When("^ingreso a mini carro_registrado\"(.*?)\"$")
	public void ingreso_a_mini_carro_registrado(String seleccionCarroOrPago) throws Exception {
		try {
			if (seleccionCarroOrPago.equals("comprar")) {
				GenericMethods.waitTime(BaseFlow.pageModel.getPdpBtnComprar());
				GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getPdpBtnComprar());
			} else if (seleccionCarroOrPago.equals("carro")) {
				GenericMethods.waitTime(BaseFlow.pageModel.getPdpBtnVerCarro());
				GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getPdpBtnVerCarro());
			} else {
				throw new PSCException("el valor de 'seleccionCarroOrPago' es " + seleccionCarroOrPago
						+ ", el cual no es valido de acuerdo a la tipificacion,ver en el feature");
			}
		} catch (PSCException e) {
			log.info(e);
		} catch (Exception e) {
			log.info("Caida en : ingreso a mini carro_registrado ", e);
			throw e;
		}
	}

	@When("^ingreso al carro de compras o comprar directamente_registrado\"(.*?)\"\"(.*?)\"$")
	public void ingreso_al_carro_de_compras_o_comprar_directamente_registrado(String seleccionCarroOrPago,
			String cdgoDescuento) throws Exception {
		try {
			if (seleccionCarroOrPago.equals("carro")) {
				if (!cdgoDescuento.equals("")) {
					BaseFlow.pageModel.getCarroTxtCodigoDescuento().sendKeys(cdgoDescuento);
					BaseFlow.pageModel.getCarroBtnDescuento().click();
					if (!FlujoCompraServices.isValidCdgoDescuento()) {
						throw new PSCException("Codigo de descuento " + cdgoDescuento + " no ha sido aplicado");
					}
				}
				GenericMethods.waitTime(BaseFlow.pageModel.getCarroBtnIrALaCaja());
				GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getCarroBtnIrALaCaja());
			}
		} catch (PSCException e) {
			log.info(e);
		} catch (Exception e) {
			log.info("Caida en : ingreso al carro de compras o comprar directamente_registrado ", e);
			throw e;
		}
	}

	@When("^ingresar login en el checkOuts_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingresar_login_en_el_checkOuts_registrado(String tipoLogin, String usuario, String clave,
			String recordarClave) throws Exception {
		try {
			if (tipoLogin.equals("checkout")) {
				BaseFlow.pageModel.getLoginTxtUsuario().sendKeys(usuario);
				BaseFlow.pageModel.getLoginTxtClave().sendKeys(clave);
				if (recordarClave == "true") {
					BaseFlow.pageModel.getLoginTxtRecordarClave().click();
				}
				BaseFlow.pageModel.getLoginBtnIniciarSesion().click();
			}
		} catch (Exception e) {
			log.info("Caida en : ingresar login en el checkOuts_registrado ", e);
			throw e;
		}
	}

	@When("^ingresar tipo de entrega_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingresar_tipo_de_entrega_registrado(String despacho, String direccionCompleta, String calle,
			String numeroCasa, String codigoPostal) throws Exception {
		// si es una nueva ubicacion
		try {
			if (despacho.equals(Constants.TIPODESPACHO_RETIRO_EN_TIENDA)) {
				BaseFlow.pageModel.getCheckoutBtnRetiroEnTienda().click();
				// ingresoDatosDespachoOrTienda()
				// TODO ver logica retiro en tienda
			} else if (despacho.equals(Constants.TIPODESPACHO_DOMICILIO)) {
				BaseFlow.pageModel.getCheckoutBtnDespachoDomicilio().click();
				FlujoCompraServices.ingresarDireccion(despacho, direccionCompleta, calle, numeroCasa, codigoPostal);
				GenericMethods.waitTime(BaseFlow.pageModel.getEntregaBtnFacturacion());
				GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getEntregaBtnFacturacion());
			} else {
				throw new PSCException("el valor de 'tipoEntrega' es " + despacho
						+ ", el cual no es valido de acuerdo a la tipificacion,ver en el feature");
			}
		} catch (PSCException e) {
			log.error(e);
		} catch (Exception e) {
			log.info("Caida en : ingresar tipo de entrega_registrado ", e);
			throw e;
		}
	}

	@When("^seleccionar tipo de despacho_registrado\"(.*?)\"$")
	public void seleccionar_tipo_de_despacho_registrado(String tipoDespacho) throws Exception {
		try {
			Thread.sleep(2000);
			if (tipoDespacho.equals("standar")) {
				if (!BaseFlow.pageModel.getEntregaRadioDespachoDomicilioStandar().isSelected()) {
					WebElement radio = GenericMethods
							.findElementReturnWebElement(By.xpath("//label[@for=\"shipping-method-1\"]"));
					radio.click();
				}
			} else if (!BaseFlow.pageModel.getEntregaRadioDespachoDomicilioProgramada().isSelected()) {
				WebElement radio = GenericMethods
						.findElementReturnWebElement(By.xpath("//label[@for=\"shipping-method-2\"]"));
				radio.click();
			}
			GenericMethods.waitTime(BaseFlow.pageModel.getEntregaBtnFacturacion());
			GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getEntregaBtnFacturacion());
		} catch (Exception e) {
			log.info("Caida en : seleccionar tipo de despacho_registrado ", e);
			throw e;
		}
	}

	@When("^ingreso compra con factura_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_compra_con_factura_registrado(String ingresaFactura, String nomEmpresa, String razonSocial,
			String regionFactura, String calleFactura, String numCasaDeptoFactura, String personaContactoFactura,
			String rutFactura, String giro, String comunaFactura, String numeroFactura, String fonoFactura,
			String emailFactura) throws Exception {
		try {
			if (ingresaFactura.equalsIgnoreCase("true")) {
				BaseFlow.pageModel.getCheckoutBtnIngresaDatosFactura().click();
				FlujoCompraServices.ingresoDatosFactura(nomEmpresa, razonSocial, regionFactura, calleFactura,
						numCasaDeptoFactura, personaContactoFactura, rutFactura, giro, comunaFactura, numeroFactura,
						fonoFactura, emailFactura);
				BaseFlow.pageModel.getCheckoutBtnIngresaDatosFactura().click();
			}
		} catch (Exception e) {
			log.info("Caida en : ingreso compra con factura_registrado ", e);
			throw e;
		}
	}

	@When("^ingreso codigo novios bebe y casa_registrado\"(.*?)\"$")
	public void ingreso_codigo_novios_bebe_y_casa_registrado(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^ingreso a modulo de pago_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_a_modulo_de_pago_registrado(String metodoPago, String tarjetaNombre, String tarjetaApellido,
			String rutTarjeta, String numeroTarjeta, String mesAñoTarjeta, String cvvTarjeta, String cuotasTarjeta,
			String banco, String codigoGiftCard) throws Exception {
		try {
			if (metodoPago.equals("Tarjeta Cencosud")) {
				GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getCheckOutHrefCencosudCredito());
			} else if (metodoPago.equals("Credit card")) {
				GenericMethods.waitTime(BaseFlow.pageModel.getCheckOutHrefTarjetaCredito());
				GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getCheckOutHrefTarjetaCredito());
				// llenar datos de tgarjeta
			} else if (metodoPago.equals("RedCompra")) {
				// BaseFlow.pageModel.getCheckoutBtnRedcompraCard().click();
			}
		} catch (Exception e) {
			log.info("Caida en : ingreso a modulo de pago_registrado ", e);
			throw e;
		}
	}

	@When("^ingreso datos metodo pago_registrado\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"\"(.*?)\"$")
	public void ingreso_datos_metodo_pago_registrado(String metodoPago, String codigoGiftCard, String claveGiftCard,
			String nombreTitularTarjeta, String apellidoTitularTarjeta, String numeroTarjeta, String mesTarjeta,
			String anioTarjeta, String cvvTarjeta, String nCuotas, String guardarTarjeta, String TipoTarjetaCenco,
			String rut) throws Exception {
		try {
			FlujoCompraServices.ingresarDatosMetodosPago(metodoPago, numeroTarjeta, mesTarjeta, anioTarjeta, cvvTarjeta,
					nombreTitularTarjeta, apellidoTitularTarjeta, rut, codigoGiftCard, claveGiftCard);

		} catch (Exception e) {
			log.info("Caida en : ingreso datos metodo pago_registrado ", e);
			throw e;
		}
	}

	@Then("^verifico que se genere la orden de compra_registrado\"(.*?)\"$")
	public void verifico_que_se_genere_la_orden_de_compra_registrado(String status) throws Exception {
		GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutDivNumOrdenCompra());
		Thread.sleep(2000);
		assertTrue("no se encuentra orden de compra", BaseFlow.pageModel.getCheckoutDivNumOrdenCompra().isDisplayed());
	}

}
