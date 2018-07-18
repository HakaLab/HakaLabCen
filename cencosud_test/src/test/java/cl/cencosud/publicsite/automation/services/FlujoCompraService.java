package cl.cencosud.publicsite.automation.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.cencosud.publicsite.automation.Exception.PSCException;
import cl.cencosud.publicsite.automation.constants.Constants;
import cl.cencosud.publicsite.automation.definition.FlujoCompraCompletoDefinition_UsuarioRegistrado;
import cl.cencosud.publicsite.automation.flow.BaseFlow;
import cl.cencosud.publicsite.automation.util.GenericMethods;

public final class FlujoCompraService {
	private static final Log log = LogFactory.getLog(FlujoCompraService.class);
	
	
	public static void createSheetForNameTestCase(String nombreHoja,String nombreCasoPrueba,List<String> datos) throws Exception {
		String[] tc = nombreCasoPrueba.split("\\-");
		
		if(nombreHoja== null) {
			FlujoCompraCompletoDefinition_UsuarioRegistrado.nombreHoja = tc[0];
			ManagementMicrosoftService.createNewSheet(FlujoCompraCompletoDefinition_UsuarioRegistrado.nombreHoja);
			ManagementMicrosoftService.WriteSheetExcel(FlujoCompraCompletoDefinition_UsuarioRegistrado.nombreHoja,datos);
		}else {
			if(!nombreHoja.equals(tc[0])) {
				FlujoCompraCompletoDefinition_UsuarioRegistrado.nombreHoja = tc[0];
				ManagementMicrosoftService.createNewSheet(FlujoCompraCompletoDefinition_UsuarioRegistrado.nombreHoja);
				ManagementMicrosoftService.WriteSheetExcel(FlujoCompraCompletoDefinition_UsuarioRegistrado.nombreHoja,datos);
			}else {
				ManagementMicrosoftService.WriteSheetExcel(FlujoCompraCompletoDefinition_UsuarioRegistrado.nombreHoja,datos);
			}
		}
	}

	public static List<String> createDataForExcel(String tc,String login,String usuario,String sku, String despacho, String despachoDomicilio, String metodoPago, String numeroTarjeta,String tipoProducto,String factura) {
//		Map<String, String> MapDatos = new LinkedHashMap<String, String>();
//		MapDatos.put("numOC", "");
		List<String> datos = new ArrayList<String>();
		datos.add("OC No generada");
		datos.add(usuario);
		String tipoOrden = factura.equals("true")?tipoProducto+" With Factura":tipoProducto+" No Factura"; 
		datos.add( tipoOrden);
		datos.add(sku);
		String tipoDelivery = despacho.equals("domicilio")?"Home Delivery":"Collect from store";
		datos.add(tipoDelivery);
		String subtypeDelivery = despachoDomicilio.equalsIgnoreCase("estandar")?"Standard":"Programmed";
		datos.add(subtypeDelivery);
		String[] paymentMethod = metodoPago.split("C"); 
		datos.add(paymentMethod[0]+" "+"Card" );
		datos.add(numeroTarjeta);
		return datos;
	}
	
	public static Boolean isValidLogin() throws Exception { 
		boolean valid = false; 
		if( BaseFlow.driver.findElements(By.className("error-form")).size() == 0) {
			valid = true;
		} else {
			valid = false;
		}  
		return valid;
	}
	
	public static Boolean isValidCdgoDescuento() throws Exception { 
		boolean valid = false; 
		if( BaseFlow.driver.findElements(By.className("error")).size() == 0) {
			valid = true;
		} else {
			valid = false;
		}  
		return valid;
	}
	
	public static void ingresarSkuAndSearch(String sku){
		try {
			BaseFlow.pageModel.getHomeTxtIngresobusqueda().sendKeys(sku);
			Thread.sleep(2000);
			BaseFlow.pageModel.getHomeBtnBuscar().click();
		} catch (Exception e) {
			log.info("",e);
		}
		
	}
	
	public static void seleccionarCantidad(String cantidad) {
		try {
			GenericMethods.waitTime(BaseFlow.pageModel.getPdpCantidad());
			GenericMethods.scrollElement(BaseFlow.pageModel.getPdpCantidad());
			Select pdpCantidad = new Select(BaseFlow.pageModel.getPdpCantidad());
			pdpCantidad.selectByVisibleText(cantidad);
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public static void seleccionarColor(String tipoProducto) throws Exception {
		if(!tipoProducto.equalsIgnoreCase(Constants.productoOption) && !tipoProducto.equalsIgnoreCase(Constants.productoStandard)){
			if(BaseFlow.pageModel.getCheckOutRadioColores().size() != 0) {
				if(BaseFlow.pageModel.getCheckOutRadioColores().get(0).isSelected()){
					BaseFlow.pageModel.getCheckOutRadioColores().get(1).click();
				}else {
					BaseFlow.pageModel.getCheckOutRadioColores().get(0).click();
					Thread.sleep(1000);
				}
			}	
		}
	}
	
//	public static void seleccionarCantidadEnCarroCompra(String cantidadEnCarro) {
//		try {
//			if(!cantidadEnCarro.equals("")) {
//				 if(BaseFlow.pageModel.getCarroListCantidadProductoEnCarroCompras().size()==0) {
//					 Select pdpCantidad = new Select(BaseFlow.pageModel.getCarroListCantidadProductoEnCarroCompras().get(0));
//					pdpCantidad.selectByVisibleText(cantidadEnCarro);
//				 }else {
//					 Select pdpCantidad = new Select(BaseFlow.pageModel.getCarroListCantidadProductoEnCarroCompras().get(1));
//					 pdpCantidad.selectByVisibleText(cantidadEnCarro);
//				 }
//			 }
//		} catch (Exception e) {
//		}
//	}
	
	public static void seleccionarTalla(String tipoProducto) {
		try {
			String talla = "";
			if(!tipoProducto.equalsIgnoreCase(Constants.productoOption) && !tipoProducto.equalsIgnoreCase(Constants.productoStandard)){
				if(GenericMethods.existElement(By.id("va-size"))) {
					GenericMethods.waitTime(BaseFlow.pageModel.getCheckOutSelectTalla());
					Select pdpSelectTalla = new Select(BaseFlow.pageModel.getCheckOutSelectTalla());
					if(pdpSelectTalla.getOptions().size()!=0) {
						for(WebElement option:pdpSelectTalla.getOptions()) {
							if(!option.getText().equalsIgnoreCase("Seleccionar Talla")) {
								if(option.isEnabled()) {
									talla = option.getText();
									break;
								}
							}
						}
						pdpSelectTalla.selectByVisibleText(talla);
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	
	public static void seleccionarProductoConArmadoOrGarantia(String conArmado,String conGarantia, String tipoProducto) {
		try {
			if(!tipoProducto.equalsIgnoreCase(Constants.productoStandard) && !tipoProducto.equalsIgnoreCase(Constants.ProductoVariation)) {
				if(!conArmado.equals("")) {
					WebElement selectConArmado = GenericMethods.findElementReturnWebElement(By.xpath("//*[contains(@id,'dwopt_')]"));
					Select pdpSelectConArmado = new Select(selectConArmado);
					if(pdpSelectConArmado.getOptions().size()!=0) {
						if(conArmado.equals("true")) {
							pdpSelectConArmado.selectByValue("123");
						}else if (conArmado.equals("false")){ 
							pdpSelectConArmado.selectByValue("0");
						}else {
							throw new PSCException("el valor de  dato 'conArmado'es :"+conArmado+" el cual no es soportado por el set de pruebas, consulte la tipificacion en el feature");
						}
					}
				}else if(!conGarantia.equals("")) {
					String garantia = "";
					GenericMethods.waitTime(BaseFlow.pageModel.getPdpSelectGarantia());
					Select pdpSelectgarantia = new Select(BaseFlow.pageModel.getPdpSelectGarantia());
					if(pdpSelectgarantia.getOptions().size()!=0) {
						if(conGarantia.equals("true")) {
							for(WebElement option:pdpSelectgarantia.getOptions()) {
								if(!option.getText().equalsIgnoreCase("Seleccione Extended Warranty") && !option.getText().equalsIgnoreCase("None")) {
									if(option.isEnabled()) {
										garantia = option.getText();
										break;
									}
								}
							}
						}else if(conGarantia.equals("false")) {
							for(WebElement option:pdpSelectgarantia.getOptions()) {
								if(option.getText().equalsIgnoreCase("None")) {
									if(option.isEnabled()) {
										garantia = option.getText();
										break;
									}
								}
							}
						}else {
							throw new PSCException("el valor de  dato 'conGarantia'es :"+conArmado+" el cual no es soportado por el set de pruebas, consulte la tipificacion en el feature");
						}
						pdpSelectgarantia.selectByVisibleText(garantia);
					}
				}
			}
		} catch (PSCException e) {
			log.info(e);
		}catch (Exception e) {
			log.error(e);
		}
	}
	
	public static void ingresarRetiroEnTienda(String despacho) throws Exception {
		if(despacho.equals(Constants.TIPODESPACHO_RETIRO_EN_TIENDA)) {
			int i = 1;
			 Select regiones = new Select(BaseFlow.pageModel.getCheckoutSelectRegionRetiroTienda());
			 List<WebElement> cantidadRegiones = regiones.getOptions(); 
			do {
				 regiones.selectByIndex(i);
				 Thread.sleep(1000);
				 if(GenericMethods.existElement(By.className("js-select-store-link"))) {
					 for(WebElement option:BaseFlow.pageModel.getCheckoutListDireccionesRetiroTienda()) {
							if(option.isEnabled()) {
								option.click();
								i = i+12;
							}
						}
				 }else {
					 i = i+1;
				 }
			} while (i<= cantidadRegiones.size());
			
		}
	}

	public static void ingresarDireccion(String despacho,String direccionCompleta,String calle,String numeroCasa,String codigoPostal) {
		if(despacho.equals(Constants.TIPODESPACHO_DOMICILIO)) {
			if(BaseFlow.pageModel.getCheckoutInputIntroduceUbicacion().isDisplayed()) {

		    }else {
		    	//capturar n direcciones
		    	if(BaseFlow.pageModel.getCheckOutRadioDirecciones().size() != 0) {
		    		if(BaseFlow.pageModel.getCheckOutRadioDirecciones().size()==1) {
		    			//TODO: Manejr solo componente radio no todo el elemento
		    			if(!BaseFlow.pageModel.getCheckOutRadioDirecciones().get(0).isSelected()) {
		    				BaseFlow.pageModel.getCheckOutRadioDirecciones().get(0).click();
		    			}
		    		}else {
		    			if(BaseFlow.pageModel.getCheckOutRadioDirecciones().get(0).isSelected()){
							BaseFlow.pageModel.getCheckOutRadioDirecciones().get(1).click();
		    			}else {
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
			if(BaseFlow.pageModel.getPdpBtnSeleccionarProBonificacion().size() != 0) {
				if(BaseFlow.pageModel.getPdpBtnSeleccionarProBonificacion().get(0).isSelected()){
					BaseFlow.pageModel.getPdpBtnSeleccionarProBonificacion().get(1).click();// NO DA EL CLICK
					Thread.sleep(3000);
				}else {
					BaseFlow.pageModel.getPdpBtnSeleccionarProBonificacion().get(0).click();
					Thread.sleep(3000);
				}
				BaseFlow.pageModel.getPdpBtnAgregarProductoBonificado().click();
			}	
		}else {
			BaseFlow.pageModel.getFramePDP_btnNoGracias().click();
		}
	}
	
	public static boolean datoPruebaIsValid(String valorPrueba) {
		boolean valid = false;
		if(valorPrueba != null && !valorPrueba.equals("")) {
			valid = true;
		}
		return valid;
	}
	
	public static void ingresarDatosMetodosPago(String metodoPago,String codigoGiftCard, String claveGiftCard,String numeroTarjeta,String mesTarjeta,String anioTarjeta,String cvvTarjeta,String nombreTitularTarjeta,String apellidoTitularTarjeta, String rut, String claveRedCompra) throws Exception{
		try {
			String cuotas = "";
			if(!codigoGiftCard.equals("")) {
				aplicarCodigoGiftCard(codigoGiftCard,claveGiftCard);
			}
			if(GenericMethods.existElement(By.xpath("//a[@class=\"no-collapse\"]"))) {
				if (metodoPago.equalsIgnoreCase(Constants.TARJETA_CREDITO)) {
//					 TODO para flujo de francisco y rodo esta opcion se cae ARREGLAR
					if (GenericMethods.existElement(By.xpath("//div[@id='savedCreditCards']"))) {
						BaseFlow.pageModel.getCheckOutListTarjetasCredito().get(0).click();
					} else {
						BaseFlow.pageModel.getCheckOutTxtnumeroTarjetaCredito().sendKeys(numeroTarjeta);
						BaseFlow.pageModel.getCheckOutTxtMesTarjetaCredito().sendKeys(mesTarjeta);
						BaseFlow.pageModel.getCheckOutTxtAnioTarjetaCredito().sendKeys(anioTarjeta);
						BaseFlow.pageModel.getCheckOutTxtNombreTitularTarjetaCredito().sendKeys(nombreTitularTarjeta);
						BaseFlow.pageModel.getCheckOutTxtApellidoTitularTarjetaCredito().sendKeys(apellidoTitularTarjeta);
					}
					GenericMethods.waitTime(BaseFlow.pageModel.getCheckOutTxtCvvTarjetaCredito());
					BaseFlow.pageModel.getCheckOutTxtCvvTarjetaCredito().sendKeys(cvvTarjeta);
					Select cuotasCredito = new Select(BaseFlow.pageModel.getCheckOutSelectCuotasTarjetaCredito());
					for (WebElement option : cuotasCredito.getOptions()) {
						if (!option.getText().equalsIgnoreCase(Constants.SIN_CUOTAS)) {
							if (option.isEnabled()) {
								cuotas = option.getText();
								break;
							}
						}
					}
					cuotasCredito.selectByVisibleText(cuotas);
					GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutBtnRealizarPedido());
					GenericMethods.scrollElement(BaseFlow.pageModel.getCheckoutBtnRealizarPedido());
					BaseFlow.pageModel.getCheckoutBtnRealizarPedido().click();
	            }else if (metodoPago.equalsIgnoreCase(Constants.TARJETA_CREDITO_CENCOSUD)) {
					if (GenericMethods.existElement(By.xpath("//div[@id='savedCencosudCards']"))) {
						BaseFlow.pageModel.getCheckOutListTarjetasCreditoCenco().click();
					} else {
						GenericMethods.scrollElement(BaseFlow.pageModel.getCheckoutBtnRealizarPedido());
						BaseFlow.pageModel.getCheckOutTxtnumeroTarjetaCreditoCenco().sendKeys(numeroTarjeta);
						BaseFlow.pageModel.getCheckOutTxtMesTarjetaCreditoCenco().sendKeys(mesTarjeta);
						BaseFlow.pageModel.getCheckOutTxtAnioTarjetaCreditoCenco().sendKeys(anioTarjeta);
						BaseFlow.pageModel.getCheckOutTxtNombreTitularTarjetaCreditoCenco().sendKeys(nombreTitularTarjeta);
						BaseFlow.pageModel.getCheckOutTxtApellidoTitularTarjetaCreditoCenco().sendKeys(apellidoTitularTarjeta);
					}
					BaseFlow.pageModel.getCheckOutTxtCvvTarjetaCreditoCenco().sendKeys(cvvTarjeta);
	                Select cuotascenco = new Select(BaseFlow.pageModel.getCheckOutTxtCuotasTarjetaCreditoCenco());
	                for(WebElement option:cuotascenco.getOptions()) {
	                    if(!option.getText().equalsIgnoreCase(Constants.SIN_CUOTAS)) {
	                        if(option.isEnabled()) {
	                            cuotas = option.getText();
	                            break;
	                        }
	                    }
	                } 
	                cuotascenco.selectByVisibleText(cuotas);
	                GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutBtnRealizarPedidoCenco());
	                GenericMethods.scrollElement(BaseFlow.pageModel.getCheckoutBtnRealizarPedidoCenco());
	                BaseFlow.pageModel.getCheckoutBtnRealizarPedidoCenco().click();
	            }else if(metodoPago.equalsIgnoreCase(Constants.REDCOMPRA)) {
	                BaseFlow.pageModel.getCheckOutHrefRedCompra().click();
	                GenericMethods.scrollClickElement(BaseFlow.pageModel.getCheckoutBtnRealizarPedidoRedCompra());
	                Thread.sleep(2000);
	                for(WebElement option:BaseFlow.pageModel.getCheckoutRadioSeleccionRedCompra()) {
	                	if(option.getAttribute("value").equals("DEBIT_CARD")) {
	                		option.click();
	                	}
	                }
	                //seleccionar primer banco disponible
	                Select bancos = new Select(BaseFlow.pageModel.getCheckoutListBancosRedCompra());
	                bancos.selectByValue("2");
	                
	                BaseFlow.pageModel.getCheckoutNumeroTarjetaRedCompra().sendKeys(numeroTarjeta);
	                BaseFlow.pageModel.getCheckoutBtnPagarRedCompra().click();
	                GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutFrameRedCompra());
	                BaseFlow.driver.switchTo().frame(BaseFlow.pageModel.getCheckoutFrameRedCompra());
	            	BaseFlow.pageModel.getCheckoutTxtRutRedCompra().sendKeys(rut);
	                BaseFlow.pageModel.getCheckoutTxtClaveRedCompra().sendKeys(claveRedCompra);
	                BaseFlow.pageModel.getCheckoutPagarRedCompra().click();
	                GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutContinuarRedCompra());
	                BaseFlow.pageModel.getCheckoutContinuarRedCompra().click();
	                Thread.sleep(4000);
	            }else if(metodoPago.equalsIgnoreCase(Constants.TMASCARD)) {
	                
	            }else {
	                throw new PSCException("EL VALOR DE METODO DE PAGO "+metodoPago+" NO SE ENCUENTRA DENTRO DE LA TIPIFICACION,CONSULTAR FEATURE");
	            }
			}else {
				//validar codigo de novios 
//				hacer click en btoton finalizar compra con giftcard
			}
        } catch (PSCException e) {
            log.info(e);
        }catch (Exception e) {
            log.error("Caida al seleccionar metodos de pago por : ",e);
        }
	}
	
	//RODOLFO
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
	
	public static void ingresoDatosDespachoOrTienda(String tipoEntrega,String tipoUbicacion, String ubicacion,String direccion, String numeroCasa, String codigoPostal, String region, String comuna, String calle,String numeroCalle) throws Exception{
		switch (tipoEntrega) {
			case Constants.TIPODESPACHO_DOMICILIO:
				if (tipoUbicacion.equals(Constants.INGRESODIRECCION_MANUAL)) {
					ingresarDireccionAutomatica(direccion, numeroCasa, codigoPostal);
					ingresarDireccionManual(region,comuna,calle,numeroCalle);
				} else {
					BaseFlow.pageModel.getCheckoutInputIntroduceUbicacion().sendKeys(ubicacion);
					ingresarDireccionAutomatica(direccion, numeroCasa, codigoPostal);
				}
				BaseFlow.pageModel.getEntregaBtnFacturacion().click();
				
				break;
		}
	}
	
	private static void ingresarDireccionManual(String region, String comuna,String calle,String numeroCalle) throws Exception {
		GenericMethods.scrollClickElement(BaseFlow.pageModel.getCheckoutBtnDireccionManual());
		GenericMethods.waitTime(BaseFlow.pageModel.getCheckoutInputNumero());
		Select checkoutRegion = new Select(BaseFlow.pageModel.getCheckoutSelectRegion());
		checkoutRegion.selectByVisibleText(region);
		Select checkoutComuna = new Select(BaseFlow.pageModel.getCheckoutSelectComuna());
		checkoutComuna.selectByVisibleText(comuna);
		BaseFlow.pageModel.getCheckoutInputCalle().sendKeys(calle);
		BaseFlow.pageModel.getCheckoutInputNumero().sendKeys(numeroCalle);
	}
	
	private static void ingresarDireccionAutomatica(String direccion,String numeroCasa,String codigoPostal) {
		BaseFlow.pageModel.getCheckoutInputDireccionDespacho().sendKeys(direccion);
		BaseFlow.pageModel.getCheckoutInputNumCasaOrDepartamento().sendKeys(numeroCasa);
		BaseFlow.pageModel.getCheckoutInputCodPostal().sendKeys(codigoPostal);
	}
	
	
	public static void ingresoDatosFactura(String nomEmpresa, String razonSocial, String regionFactura, String calleFactura, String numCasaDeptoFactura, 
			String personaContactoFactura, String rutFactura, String giro, String comunaFactura, String numeroFactura, String fonoFactura, String emailFactura) throws Exception {
		
			BaseFlow.pageModel.getCheckoutInputEmpresaFactura().sendKeys(nomEmpresa);
			BaseFlow.pageModel.getCheckoutInputRazonSocialFactura().sendKeys(razonSocial);
			Select checkoutRegionFactura = new Select(BaseFlow.pageModel.getCheckoutSelectRegionFactura());
			checkoutRegionFactura.selectByValue(regionFactura);
			GenericMethods.scrollElement(BaseFlow.pageModel.getCheckoutSelectComunaFactura());

			BaseFlow.pageModel.getCheckoutInputCalleFactura().sendKeys(calleFactura);
			BaseFlow.pageModel.getCheckoutInputNumCasaDeptoFactura().sendKeys(numCasaDeptoFactura);
			BaseFlow.pageModel.getCheckoutInputPersContactoFactura().sendKeys(personaContactoFactura);
			BaseFlow.pageModel.getCheckoutInputRutFactura().sendKeys(rutFactura);
			BaseFlow.pageModel.getCheckoutInputGiroFactura().sendKeys(giro);
			Select checkoutComunaFactura = new Select(BaseFlow.pageModel.getCheckoutSelectComunaFactura());
			checkoutComunaFactura.selectByValue(comunaFactura);
			
			GenericMethods.scrollElement(BaseFlow.pageModel.getCheckoutBtnGuardarDatosFactura());
			BaseFlow.pageModel.getCheckoutInputNumeroFactura().sendKeys(numeroFactura);
			BaseFlow.pageModel.getCheckoutInputFonoFactura().sendKeys(fonoFactura);
			BaseFlow.pageModel.getCheckoutInputEmailFactura().sendKeys(emailFactura);
			BaseFlow.pageModel.getCheckoutBtnGuardarDatosFactura().click();
	}
	
	public static void ingresarDatosNuevoRegistro(String nombre,String apellido,String usuario,String codTel,String telefono,String tipoDocumento,String nDocumento,String clave,String tipoRegistro,String step) throws Exception {
		if (tipoRegistro.equals(Constants.TIPOLOGIN_HOME) && step.equals("ingreso_al_registro")) {
			GenericMethods.waitTime(BaseFlow.pageModel.getHomeLblLogin());
			BaseFlow.pageModel.getHomeLblLogin().click();
			//ingreso información de registro
			BaseFlow.pageModel.getLoginTxtNombre().sendKeys(nombre);
			BaseFlow.pageModel.getLoginTxtApellido().sendKeys(apellido);
			BaseFlow.pageModel.getLoginTxtEmail().sendKeys(usuario);
			BaseFlow.pageModel.getLoginComboCodTel().sendKeys(codTel);
			BaseFlow.pageModel.getLoginTxtTelefono().sendKeys(telefono);
			if (tipoDocumento.equals(Constants.TIPODOCUMENTO_RUT)) {
				BaseFlow.pageModel.getLoginRadioBtnRut().click();
				BaseFlow.pageModel.getLoginTxtRut().sendKeys(nDocumento);
			}else if (tipoDocumento.equals(Constants.TIPODOCUMENTO_DNI)){
				BaseFlow.pageModel.getLoginRadioBtnDni().click();
				BaseFlow.pageModel.getLoginTxtDni().sendKeys(nDocumento);
			}
			BaseFlow.pageModel.getLoginTxtClaveReg().sendKeys(clave);
			BaseFlow.pageModel.getLoginTxtClaveRegconfirm().sendKeys(clave);
			BaseFlow.pageModel.getLoginBtnRegistrar().click();
		} else if(tipoRegistro.equals(Constants.TIPOLOGIN_CHECKOUT) && step.equals("ingreso_al_carro_de_compras_o_comprar_directamente_registro")) {
			BaseFlow.pageModel.getCheckoutTextNombre().sendKeys(nombre);
			BaseFlow.pageModel.getCheckoutTextApellido().sendKeys(apellido);
			BaseFlow.pageModel.getCheckoutTextEmail().sendKeys(usuario);
			BaseFlow.pageModel.getCheckoutComboAnexo().sendKeys(codTel);
			BaseFlow.pageModel.getCheckoutTextTelefono().sendKeys(telefono);
			if (tipoDocumento.equals(Constants.TIPODOCUMENTO_RUT)) {
				BaseFlow.pageModel.getCheckoutRadioBtnRut().click();
			} else if (tipoDocumento.equals(Constants.TIPODOCUMENTO_DNI)) {
				BaseFlow.pageModel.getCheckoutRadioBtnDni().click();
			}
			BaseFlow.pageModel.getCheckoutTextRut().sendKeys(nDocumento);
		}else {
			//TODO validar tipo de dato erroneo
		}
	}
	
	private static Boolean aplicarCodigoGiftCard(String codigoGiftCard,String claveGiftCard) {
		GenericMethods.scrollClickElement(BaseFlow.pageModel.getCheckourHrefGiftCard());
		BaseFlow.pageModel.getCheckoutCodigoGiftcard().sendKeys(codigoGiftCard);
		BaseFlow.pageModel.getCheckoutClaveGiftcard().sendKeys(claveGiftCard);
		BaseFlow.pageModel.getCheckoutAplicarGiftcard().click();
		return true;
	}
}
