package cl.cencosud.publicsite.automation.poc.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.cencosud.publicsite.automation.constants.Constants;
import cl.cencosud.publicsite.automation.poc.business.flow.BaseFlow;
import cl.cencosud.publicsite.automation.poc.definition.steps.FlujoCompraCompleto_GuestDefinition;

public final class FlujoCompraServices {
	// private static final Logger logger =
	// LoggerFactory.getLogger(FlujoCompraServices.class);
	private static final Log log = LogFactory.getLog(FlujoCompraServices.class);

	public static List<String> createDataForExcel(String sku, String despacho, String despachoDomicilio, String metodoPago, String numeroTarjeta,String tipoProducto,String factura) {
//      Map<String, String> MapDatos = new LinkedHashMap<String, String>();
//      MapDatos.put("numOC", "");
      List<String> datos = new ArrayList<String>();
      datos.add("Oc no se ha generado");
      datos.add("User Guest");
      String tipoOrden = factura.equals("true")?tipoProducto+" With Factura":tipoProducto+" No Factura"; 
      datos.add( tipoOrden);
      datos.add(sku);
      String tipoDelivery = despacho.equals("domicilio")?"Home Delivery":"Collect from store";
      datos.add(tipoDelivery);
      String subtypeDelivery = despachoDomicilio.equalsIgnoreCase("standard")?"Standard":"Programmed";
      datos.add(subtypeDelivery);
      String[] paymentMethod = metodoPago.split("C"); 
      datos.add(paymentMethod[0]+" "+"Card" );
      datos.add(numeroTarjeta);
      return datos;
  }
	
	public static void createSheetForNameTestCase(String nombreHoja, String nombreCasoPrueba, List<String> datos)
			throws Exception {
		String[] tc = nombreCasoPrueba.split("\\-");
		if (nombreHoja == null) {
			FlujoCompraCompleto_GuestDefinition.nombreHoja = tc[0];
			ManagementMicrosoftService.createNewSheet(FlujoCompraCompleto_GuestDefinition.nombreHoja);
			ManagementMicrosoftService.WriteSheetExcel(FlujoCompraCompleto_GuestDefinition.nombreHoja, datos);
		} else {
			if (!nombreHoja.equals(tc[0])) {
				FlujoCompraCompleto_GuestDefinition.nombreHoja = tc[0];
				ManagementMicrosoftService.createNewSheet(FlujoCompraCompleto_GuestDefinition.nombreHoja);
				ManagementMicrosoftService.WriteSheetExcel(FlujoCompraCompleto_GuestDefinition.nombreHoja, datos);
			} else {
				ManagementMicrosoftService.WriteSheetExcel(FlujoCompraCompleto_GuestDefinition.nombreHoja, datos);
			}
		}
	}

	public static Boolean isValidLogin() throws Exception {
		boolean valid = false;
		if (BaseFlow.driver.findElements(By.className("error-form")).size() == 0) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}

	public static Boolean isValidCdgoDescuento() throws Exception {
		boolean valid = false;
		if (BaseFlow.driver.findElements(By.className("error")).size() == 0) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}

	public static void ingresarSkuAndSearch(String sku) {
		try {
			BaseFlow.pageModel.getHomeTxtIngresobusqueda().sendKeys(sku);
			Thread.sleep(2000);
			BaseFlow.pageModel.getHomeBtnBuscar().click();
		} catch (Exception e) {
			log.info("", e);
		}

	}

	public static void seleccionarCantidad(String cantidad) {
		try {
			GenericMethods.waitTime(BaseFlow.pageModel.getPdpCantidad());
			Select pdpCantidad = new Select(BaseFlow.pageModel.getPdpCantidad());
			pdpCantidad.selectByVisibleText(cantidad);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public static void seleccionarColor(String tipoProducto) {
		if (!tipoProducto.equalsIgnoreCase(Constants.productoOption)
				&& !tipoProducto.equalsIgnoreCase(Constants.productoOptionGarantia)
				&& !tipoProducto.equalsIgnoreCase(Constants.productoStandard)) {
			if (BaseFlow.pageModel.getCheckOutRadioColores().size() != 0) {
				if (BaseFlow.pageModel.getCheckOutRadioColores().get(0).isSelected()) {
					BaseFlow.pageModel.getCheckOutRadioColores().get(1).click();
				} else {
					BaseFlow.pageModel.getCheckOutRadioColores().get(0).click();
				}
			}
		}
	}

	// public static void seleccionarCantidadEnCarroCompra(String cantidadEnCarro) {
	// try {
	// if(!cantidadEnCarro.equals("")) {
	// if(BaseFlow.pageModel.getCarroListCantidadProductoEnCarroCompras().size()==0)
	// {
	// Select pdpCantidad = new
	// Select(BaseFlow.pageModel.getCarroListCantidadProductoEnCarroCompras().get(0));
	// pdpCantidad.selectByVisibleText(cantidadEnCarro);
	// }else {
	// Select pdpCantidad = new
	// Select(BaseFlow.pageModel.getCarroListCantidadProductoEnCarroCompras().get(1));
	// pdpCantidad.selectByVisibleText(cantidadEnCarro);
	// }
	// }
	// } catch (Exception e) {
	// }
	// }

	public static void seleccionarTalla(String tipoProducto) {
		try {
			String talla = "";
			if (!tipoProducto.equalsIgnoreCase(Constants.productoOption)
					&& !tipoProducto.equalsIgnoreCase(Constants.productoOptionGarantia)
					&& !tipoProducto.equalsIgnoreCase(Constants.productoStandard)) {
				GenericMethods.waitTime(BaseFlow.pageModel.getCheckOutSelectTalla());
				Select pdpSelectTalla = new Select(BaseFlow.pageModel.getCheckOutSelectTalla());
				if (pdpSelectTalla.getOptions().size() != 0) {
					for (WebElement option : pdpSelectTalla.getOptions()) {
						if (!option.getText().equalsIgnoreCase("Seleccionar Talla")) {
							if (option.isEnabled()) {
								talla = option.getText();
								break;
							}
						}
					}
					pdpSelectTalla.selectByVisibleText(talla);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	public static void seleccionarProductoConArmadoOrGarantia(String conArmado, String conGarantia,
			String tipoProducto) {
		try {
			if (!tipoProducto.equalsIgnoreCase(Constants.productoStandard)
					&& !tipoProducto.equalsIgnoreCase(Constants.ProductoVariation)) {
				if (!conArmado.equals("")) {
					// GenericMethods.waitTime(BaseFlow.pageModel.getPdpSelectConArmado());
					WebElement selectConArmado = GenericMethods
							.findElementReturnWebElement(By.xpath("//*[contains(@id,'dwopt_')]"));
					Select pdpSelectConArmado = new Select(selectConArmado);
					if (pdpSelectConArmado.getOptions().size() != 0) {
						if (conArmado.equals("true")) {
							pdpSelectConArmado.selectByValue("123");
						} else if (conArmado.equals("false")) {
							pdpSelectConArmado.selectByValue("0");
						} else {
							throw new PSCException("el valor de  dato 'conArmado'es :" + conArmado
									+ " el cual no es soportado por el set de pruebas, consulte la tipificacion en el feature");
						}
					}
				} else if (!conGarantia.equals("")) {
					String garantia = "";
					GenericMethods.waitTime(BaseFlow.pageModel.getPdpSelectGarantia());
					Select pdpSelectgarantia = new Select(BaseFlow.pageModel.getPdpSelectGarantia());
					if (pdpSelectgarantia.getOptions().size() != 0) {
						if (conGarantia.equals("true")) {
							for (WebElement option : pdpSelectgarantia.getOptions()) {
								 if(!option.getText().equalsIgnoreCase("Seleccione Warranty") 
										 && !option.getText().equalsIgnoreCase("No Warranty")) {
									if (option.isEnabled()) {
										garantia = option.getText();
										break;
									}
								}
							}
						} else if (conGarantia.equals("false")) {
							for (WebElement option : pdpSelectgarantia.getOptions()) {
								if (option.getText().equalsIgnoreCase("None")) {
									if (option.isEnabled()) {
										garantia = option.getText();
										break;
									}
								}
							}
						} else {
							throw new PSCException("el valor de  dato 'conGarantia'es :" + conArmado
									+ " el cual no es soportado por el set de pruebas, consulte la tipificacion en el feature");
						}
						pdpSelectgarantia.selectByVisibleText(garantia);
					}
				}
			}
		} catch (PSCException e) {
			log.info(e);
		} catch (Exception e) {
			log.error(e);
		}
	}

	// public static void SeleccionarProductoConGarantia()

	public static void ingresarDireccion(String despacho, String direccionCompleta, String calle, String numeroCasa,
			String codigoPostal) {
		if (despacho.equals("domicilio")) {
			if (BaseFlow.pageModel.getCheckoutInputIntroduceUbicacion().isDisplayed()) {

			} else {
				// capturar n direcciones
				if (BaseFlow.pageModel.getCheckOutRadioDirecciones().size() != 0) {
					if (BaseFlow.pageModel.getCheckOutRadioDirecciones().size() == 1) {
						// TODO: Manejr solo componente radio no todo el elemento
						if (!BaseFlow.pageModel.getCheckOutRadioDirecciones().get(0).isSelected()) {
							BaseFlow.pageModel.getCheckOutRadioDirecciones().get(0).click();
						}
					} else {
						if (BaseFlow.pageModel.getCheckOutRadioDirecciones().get(0).isSelected()) {
							BaseFlow.pageModel.getCheckOutRadioDirecciones().get(1).click();
						} else {
							BaseFlow.pageModel.getCheckOutRadioDirecciones().get(0).click();
						}
					}
				}
			}
		}
	}

	public static void productoBonificacion(String agregarBonificacion) throws Exception {
		if (agregarBonificacion.equalsIgnoreCase("true")) {
			BaseFlow.pageModel.getFramePDP_SelectCantidadBonificacion().click();
			Thread.sleep(3000);
			if (BaseFlow.pageModel.getPdpBtnSeleccionarProBonificacion().size() != 0) {
				if (BaseFlow.pageModel.getPdpBtnSeleccionarProBonificacion().get(0).isSelected()) {
					BaseFlow.pageModel.getPdpBtnSeleccionarProBonificacion().get(1).click();// NO DA EL CLICK
					Thread.sleep(3000);
				} else {
					BaseFlow.pageModel.getPdpBtnSeleccionarProBonificacion().get(0).click();
					Thread.sleep(3000);
				}
				BaseFlow.pageModel.getPdpBtnAgregarProductoBonificado().click();
			}
		} else {
			BaseFlow.pageModel.getFramePDP_btnNoGracias().click();
		}
	}

	public static boolean datoPruebaValido(String valorPrueba) {
		boolean valid = false;
		if (valorPrueba == null || valorPrueba.equals("")) {
			valid = true;
		}
		return valid;
	}

	// manipulacion del dom dependiendo del tipo de producto: Standar,variation
	public static Boolean validarTipoProducto(String tipoProducto) {

		if (tipoProducto.equals(Constants.ProductoVariation)) {
			return true;
		} else {
			return false;
		}
	}

	public static void ingresarDatosMetodosPago(String metodoPago, String numeroTarjeta, String mesTarjeta,
			String anioTarjeta, String cvvTarjeta, String nombreTitularTarjeta, String apellidoTitularTarjeta,
			String rut, String codigoGiftCard, String claveGiftCard) throws Exception {
		try {
			String cuotas = "";
			String emisor = "TEST COMMERCE BANK";
			if (!codigoGiftCard.equals("")) {
				GenericMethods.scrollElement(BaseFlow.driver, BaseFlow.pageModel.getCheckoutBtnIngresaDatosGiftCard());
				BaseFlow.pageModel.getCheckoutBtnIngresaDatosGiftCard().click();
				BaseFlow.pageModel.getCheckoutTxtCodigoGiftcard().sendKeys(codigoGiftCard);
				BaseFlow.pageModel.getCheckoutTxtPasswordGiftcard().sendKeys(claveGiftCard);
				BaseFlow.pageModel.getCheckoutBtnAplicarGiftcard().click();
			}
			if (metodoPago.equalsIgnoreCase(Constants.TARJETA_CREDITO)) {
				BaseFlow.pageModel.getCheckOutTxtnumeroTarjetaCredito().sendKeys(numeroTarjeta);
				BaseFlow.pageModel.getCheckOutTxtMesTarjetaCredito().sendKeys(mesTarjeta);
				BaseFlow.pageModel.getCheckOutTxtAnioTarjetaCredito().sendKeys(anioTarjeta);
				BaseFlow.pageModel.getCheckOutTxtCvvTarjetaCredito().sendKeys(cvvTarjeta);
				BaseFlow.pageModel.getCheckOutTxtNombreTitularTarjetaCredito().sendKeys(nombreTitularTarjeta);
				BaseFlow.pageModel.getCheckOutTxtApellidoTitularTarjetaCredito().sendKeys(apellidoTitularTarjeta);
				Select cuotasCredito = new Select(BaseFlow.pageModel.getCheckOutSelectCuotasTarjetaCredito());
				for (WebElement option : cuotasCredito.getOptions()) {
					if (!option.getText().equalsIgnoreCase("Without installments")) {
						if (option.isEnabled()) {
							cuotas = option.getText();
							break;
						}
					}
				}
				cuotasCredito.selectByVisibleText(cuotas);
				GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutBtnRealizarPedidoCreditCard());
				GenericMethods.scrollElement(BaseFlow.driver,
						BaseFlow.pageModel.getCheckoutBtnRealizarPedidoCreditCard());
				BaseFlow.pageModel.getCheckoutBtnRealizarPedidoCreditCard().click();
			} else if (metodoPago.equalsIgnoreCase(Constants.TARJETA_CREDITO_CENCOSUD)) {
				GenericMethods.scrollElement(BaseFlow.driver,
						BaseFlow.pageModel.getCheckoutBtnRealizarPedidoCreditCard());
				BaseFlow.pageModel.getCheckOutTxtnumeroTarjetaCreditoCenco().sendKeys(numeroTarjeta);
				BaseFlow.pageModel.getCheckOutTxtMesTarjetaCreditoCenco().sendKeys(mesTarjeta);
				BaseFlow.pageModel.getCheckOutTxtAnioTarjetaCreditoCenco().sendKeys(anioTarjeta);
				BaseFlow.pageModel.getCheckOutTxtCvvTarjetaCreditoCenco().sendKeys(cvvTarjeta);
				BaseFlow.pageModel.getCheckOutTxtNombreTitularTarjetaCreditoCenco().sendKeys(nombreTitularTarjeta);
				BaseFlow.pageModel.getCheckOutTxtApellidoTitularTarjetaCreditoCenco().sendKeys(apellidoTitularTarjeta);
				Select cuotascenco = new Select(BaseFlow.pageModel.getCheckOutTxtCuotasTarjetaCreditoCenco());
				for (WebElement option : cuotascenco.getOptions()) {
					if (!option.getText().equalsIgnoreCase("Without installments")) {
						if (option.isEnabled()) {
							cuotas = option.getText();
							break;
						}
					}
				}
				cuotascenco.selectByVisibleText(cuotas);
				GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutBtnRealizarPedidoCencoCard());
				GenericMethods.scrollElement(BaseFlow.driver,BaseFlow.pageModel.getCheckoutBtnRealizarPedidoCencoCard());
				BaseFlow.pageModel.getCheckoutBtnRealizarPedidoCencoCard().click();
			} else if (metodoPago.equalsIgnoreCase(Constants.REDCOMPRA)) {
				GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutBtnRealizarPedidoRedCompra());
				BaseFlow.pageModel.getCheckoutBtnRealizarPedidoRedCompra().click();
				if (GenericMethods.existElement(By.id("wpcontenedor"))) {
					GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutBtnRadioWebPayRedCompra());
					WebElement radioRedCompra = GenericMethods.findElementReturnWebElement(
							By.xpath("//*[@id=\"TBK_TIPO_TARJETA\" and @value=\"DEBIT_CARD\"]"));
					radioRedCompra.click();
					GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutSelectWebPayEmisor());
					Select emisorWebPay = new Select(BaseFlow.pageModel.getCheckoutSelectWebPayEmisor());
					emisorWebPay.selectByVisibleText(emisor);
					BaseFlow.pageModel.getCheckoutInputNumTarjetaWebPay().sendKeys(numeroTarjeta);
					BaseFlow.pageModel.getCheckoutBtnPagarWebPay().click();
					BaseFlow.driver.switchTo().frame(BaseFlow.pageModel.getCheckoutFrameRedCompra());
					GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutTxtRutRedCompra());
					BaseFlow.pageModel.getCheckoutTxtRutRedCompra().sendKeys(rut);
					BaseFlow.pageModel.getCheckoutTxtClaveRedCompra().sendKeys(cvvTarjeta);
					BaseFlow.pageModel.getCheckoutPagarRedCompra().click();
					GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutContinuarRedCompra());
					BaseFlow.pageModel.getCheckoutContinuarRedCompra().click();
					Thread.sleep(3000);
				} else {
					throw new PSCException("NO SE HA DESPLEGADO EL CONTENEDOR WEBPAY");
				}
			} else if (metodoPago.equalsIgnoreCase(Constants.TMASCARD)) {

			} else if (metodoPago.equalsIgnoreCase(Constants.GIFTCARD)) {

			} else {
				throw new PSCException("EL VALOR DE METODO DE PAGO " + metodoPago
						+ " NO SE ENCUENTRA DENTRO DE LA TIPIFICACION,CONSULTAR FEATURE");
			}

		} catch (PSCException e) {
			log.info(e);
		} catch (Exception e) {
			log.error("Caida al seleccionar metodos de pago por : ", e);
		}
	}

	private static Boolean savedCardExists() throws Exception {
		Boolean valid = false;
		try {
			if (BaseFlow.pageModel.getCheckOutListTarjetas().size() != 0) {
				valid = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return valid;
	}

	public static void seleccionDocumento(String TipoDocumento, String numeroDocumento) {
		switch (TipoDocumento) {
		case "DNI":
			BaseFlow.pageModel.getCheckoutRadioBtnDni().click();
			BaseFlow.pageModel.getCheckoutInputDni().sendKeys(numeroDocumento);
			break;
		case "RUT":
			BaseFlow.pageModel.getCheckoutRadioBtnRut().click();
			BaseFlow.pageModel.getCheckoutInputRut().sendKeys(numeroDocumento);
			break;
		default:
			BaseFlow.pageModel.getCheckoutRadioBtnRut().click();
			BaseFlow.pageModel.getCheckoutInputRut().sendKeys(numeroDocumento);
			break;
		}
	}

	public static void ingresoDatosDespachoOrTienda(String tipoEntrega, String tipoUbicacion, String ubicacion,
			String direccion, String numeroCasa, String codigoPostal, String region, String comuna, String calle,
			String numeroCalle) throws Exception {
		switch (tipoEntrega) {
		case "domicilio":
			if (tipoUbicacion.equals("manual")) {
				ingresarDireccionAutomatica(direccion, numeroCasa, codigoPostal);
				ingresarDireccionManual(region, comuna, calle, numeroCalle);
			} else {
				BaseFlow.pageModel.getCheckoutInputIntroduceUbicacion().sendKeys(ubicacion);
				ingresarDireccionAutomatica(direccion, numeroCasa, codigoPostal);
			}
			BaseFlow.pageModel.getEntregaBtnFacturacion().click();

			break;

		case "retiroEnTienda":
			int i = 1;
			GenericMethods.scrollElement(BaseFlow.driver, BaseFlow.pageModel.getCheckoutSelectRegionRetiroTienda());
			Select regiones = new Select(BaseFlow.pageModel.getCheckoutSelectRegionRetiroTienda());
			List<WebElement> cantidadRegiones = regiones.getOptions();
			do {
				regiones.selectByIndex(i);
				Thread.sleep(1000);
				if (GenericMethods.existElement(By.className("js-select-store-link"))) {
					for (WebElement option : BaseFlow.pageModel.getCheckoutListDireccionesRetiroTienda()) {
						// if(i < 12) {
						if (option.isEnabled()) {
							option.click();
							i = i + 12;
						}
						// }
					}
				} else {
					i = i + 1;
				}
			} while (i <= cantidadRegiones.size());

			BaseFlow.pageModel.getEntregaBtnFacturacion().click();

			break;

		}
	}

	private static void ingresarDireccionManual(String region, String comuna, String calle, String numeroCalle)
			throws Exception {
		GenericMethods.scrollClickElement(BaseFlow.driver, BaseFlow.pageModel.getCheckoutBtnDireccionManual());
		GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutInputNumero());
		Select checkoutRegion = new Select(BaseFlow.pageModel.getCheckoutSelectRegion());
		checkoutRegion.selectByVisibleText(region);
		Select checkoutComuna = new Select(BaseFlow.pageModel.getCheckoutSelectComuna());
		checkoutComuna.selectByVisibleText(comuna);
		BaseFlow.pageModel.getCheckoutInputCalle().sendKeys(calle);
		BaseFlow.pageModel.getCheckoutInputNumero().sendKeys(numeroCalle);
	}

	private static void ingresarDireccionAutomatica(String direccion, String numeroCasa, String codigoPostal) {
		BaseFlow.pageModel.getCheckoutInputDireccionDespacho().sendKeys(direccion);
		BaseFlow.pageModel.getCheckoutInputNumCasaOrDepartamento().sendKeys(numeroCasa);
		BaseFlow.pageModel.getCheckoutInputCodPostal().sendKeys(codigoPostal);
	}

	public static void ingresoDatosFactura(String nomEmpresa, String razonSocial, String regionFactura,
			String calleFactura, String numCasaDeptoFactura, String personaContactoFactura, String rutFactura,
			String giro, String comunaFactura, String numeroFactura, String fonoFactura, String emailFactura)
			throws Exception {

		BaseFlow.pageModel.getCheckoutInputEmpresaFactura().sendKeys(nomEmpresa);
		BaseFlow.pageModel.getCheckoutInputRazonSocialFactura().sendKeys(razonSocial);
		Select checkoutRegionFactura = new Select(BaseFlow.pageModel.getCheckoutSelectRegionFactura());
		checkoutRegionFactura.selectByValue(regionFactura);
		GenericMethods.scrollElement(BaseFlow.driver, BaseFlow.pageModel.getCheckoutSelectComunaFactura());

		BaseFlow.pageModel.getCheckoutInputCalleFactura().sendKeys(calleFactura);
		BaseFlow.pageModel.getCheckoutInputNumCasaDeptoFactura().sendKeys(numCasaDeptoFactura);
		BaseFlow.pageModel.getCheckoutInputPersContactoFactura().sendKeys(personaContactoFactura);
		BaseFlow.pageModel.getCheckoutInputRutFactura().sendKeys(rutFactura);
		BaseFlow.pageModel.getCheckoutInputGiroFactura().sendKeys(giro);
		Select checkoutComunaFactura = new Select(BaseFlow.pageModel.getCheckoutSelectComunaFactura());
		checkoutComunaFactura.selectByValue(comunaFactura);

		GenericMethods.scrollElement(BaseFlow.driver, BaseFlow.pageModel.getCheckoutBtnGuardarDatosFactura());
		BaseFlow.pageModel.getCheckoutInputNumeroFactura().sendKeys(numeroFactura);
		BaseFlow.pageModel.getCheckoutInputFonoFactura().sendKeys(fonoFactura);
		BaseFlow.pageModel.getCheckoutInputEmailFactura().sendKeys(emailFactura);
		BaseFlow.pageModel.getCheckoutBtnGuardarDatosFactura().click();
	}
}
