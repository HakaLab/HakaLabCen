package cl.cencosud.publicsite.automation.model;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import cl.cencosud.publicsite.automation.flow.BaseFlow;
import cl.cencosud.publicsite.automation.util.GenericMethods;


public class PageModelHome {

//HOMEPAGE

	//Busqueda en imagen 'Lupa' o solo con enter  sin ID
	@FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[4]/div[1]/form/div/input")
	private WebElement homeBtnBuscar;
	//Busqueda en Textbox 'Que estas buscando del homePage' ID = "q"
	@FindBy(how = How.XPATH, using = "//*[@id=\"q\"]")
	private WebElement homeTxtIngresobusqueda;
//	@FindBy(how = How.ID, using = "clickLogin")
	@FindBy(id = "clickLogin")
	private WebElement homeLblLogin;
	@FindBy(how = How.CLASS_NAME, using = "logueado")
	private WebElement homeLblUser;
	
//LOGIN

	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_login_username')]")
	private WebElement loginTxtUsuario;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_login_password')]")
	private WebElement loginTxtClave;
	@FindBy(how = How.NAME, using = "dwfrm_login_login")
	private WebElement loginBtnIniciarSesion;
	@FindBy(how = How.CLASS_NAME, using = "error-form")
	private WebElement loginLblError;
	
	@FindBy(how = How.ID, using = "dwfrm_login_rememberme")
	private WebElement loginTxtRecordarClave;
	
//PDP
	//seleccionar cantidad  del producto a comprar ID=Quantity
//	@FindBy(how = How.ID, using = "Quantity")
	@FindBy(id = "Quantity")
	private WebElement pdpCantidad;
	//Boton Agregar al carro de compras  ID add-to-cart
	@FindBy(how = How.ID, using = "add-to-cart")
	private WebElement pdpAgregarCarro;
//	@FindBy(how = How.XPATH, using = "//*[contains(@class,'mini-cart-link-cart')]")
	@FindBy(xpath = "//*[contains(@class,'mini-cart-link-cart')]")
	private WebElement pdpBtnVerCarro;
//	@FindBy(how = How.XPATH, using = "//*[contains(@class,'mini-cart-link-checkout')]")
	@FindBy(xpath = "//*[contains(@class,'mini-cart-link-checkout')]")
	private WebElement pdpBtnComprar;
	@FindBy(how = How.CLASS_NAME, using = "out-of-stock")
	private WebElement pdpLblVerificarStock;
	
	
//	@FindBy(how = How.XPATH, using = "//*[@id=\"product-content\"]/div[4]/ul/li[1]/div[2]/ul/li/a")  
//	private WebElement pdpRadioColor;
	@FindBy(how = How.XPATH, using = "//*[@id=\"3ba2f1f085fbb2b2428c1984d4\"]/div[2]/div[1]/a/img")
	private WebElement pdpSelectProduct;
	@FindBy(how = How.CLASS_NAME, using = "form-control  js-option-select js-product-option")
	private WebElement pdpSelectConArmado;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwopt_')]")
	private WebElement pdpSelectGarantia;

//HOME REGISTRO
	@FindBy(how = How.ID, using = "dwfrm_profile_customer_firstname")
	private WebElement loginTxtNombre;
	@FindBy(how = How.ID, using = "dwfrm_profile_customer_lastname")
	private WebElement loginTxtApellido;
	@FindBy(how = How.ID, using = "dwfrm_profile_customer_email")
	private WebElement loginTxtEmail;
	@FindBy(how = How.ID, using = "dwfrm_profile_customer_phoneCode")
	private WebElement loginComboCodTel;
	@FindBy(how = How.ID, using = "dwfrm_profile_customer_phone")
	private WebElement loginTxtTelefono;
	@FindBy(how = How.XPATH, using = "//*[@id=\"dwfrm_profile\"]/fieldset[2]/div[3]/div[1]/div/label[1]")
	private WebElement loginRadioBtnRut;
	@FindBy(how = How.XPATH, using = "//*[@id=\"dwfrm_profile\"]/fieldset[2]/div[3]/div[1]/div/label[2]")
	private WebElement loginRadioBtnDni;
	@FindBy(how = How.ID, using = "dwfrm_profile_customer_dni")
	private WebElement loginTxtDni;


	@FindBy(how = How.ID, using = "dwfrm_profile_customer_rut")
	private WebElement loginTxtRut;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_profile_login_password')]")
	private WebElement loginTxtClaveReg;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_profile_login_passwordconfirm')]")
	private WebElement loginTxtClaveRegconfirm;
	@FindBy(how = How.NAME, using = "dwfrm_profile_confirm")
	private WebElement loginBtnRegistrar;
	
	
	
//CARRO COMPRA
	@FindBy(how = How.NAME, using = "dwfrm_cart_checkoutCart")
	private WebElement carroBtnIrALaCaja;
	@FindBy(how = How.XPATH, using = "//*[@id=\"primary\"]/div[1]/div[2]/div/div/div[2]/div/form/div/button")
	private WebElement checkoutBtnCompraGuest;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'box-item-carro clearfix cart-row js-cart-lineitem')]")
	private List<WebElement> carroListProductosEnCarroCompras;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'js-cart-quantity-select')]")
	private List<WebElement> carroListCantidadProductoEnCarroCompras;
	@FindBy(how = How.ID, using = "dwfrm_cart_couponCode")
	private WebElement carroTxtCodigoDescuento;
	@FindBy(how = How.ID, using = "add-coupon")
	private WebElement carroBtnDescuento;
	@FindBy(how = How.CLASS_NAME, using = "error")
	private WebElement carroLblErrorCdgoDescuento;
	
	
	
	
//CHECKOUT
	//Formulario informacion de despacho
//	@FindBy(how = How.ID, using = "va-size")
	@FindBy(id = "va-size")
	private WebElement checkOutSelectTalla;
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_firstname")
	private WebElement checkoutTextNombre ;
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_lastname")
	private WebElement checkoutTextApellido;
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_email")
	private WebElement checkoutTextEmail;
	//Anexo de numero telefonico Ej: +569
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_phoneCode")
	private WebElement checkoutComboAnexo;
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_phone")
	private WebElement checkoutTextTelefono;
	@FindBy(how = How.XPATH, using = "//*[@id=\"personal-details-form\"]/div[5]/div[1]/div/label[1]")
	private WebElement checkoutRadioBtnRut;
	@FindBy(how = How.XPATH, using = "//*[@id=\"personal-details-form\"]/div[5]/div[1]/div/label[2]")
	private WebElement checkoutRadioBtnDni;
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_rut")
	private WebElement checkoutTextRut;
	@FindBy(how = How.XPATH, using = "//*[@id=\"personal-details-form\"]/fieldset/div/button")
	private WebElement checkoutBtnContinuar;	
//	@FindBy(how = How.ID, using = "shipping-method-select-1")
	@FindBy(id = "shipping-method-select-5")
	private WebElement checkoutBtnDespachoDomicilio;	
	
//	@FindBy(how = How.ID, using = "shipping-method-select-4")
	@FindBy(id = "shipping-method-select-6")
	private WebElement checkoutBtnRetiroTienda;
	@FindBy(how = How.ID, using = "dwfrm_storelocator_state")
	private WebElement checkoutSelectRegionRetiroTienda;
	@FindBy(className = "js-select-store-link")
	private List<WebElement> checkoutListDireccionesRetiroTienda;
	
	@FindBy(how = How.ID, using = "//*[contains(@class,'js-store-search-result-item')]")
	private List<WebElement> checkoutListUbicacionesRetiroTienda;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"shipping-method-types\"]/div/div/div/div/fieldset[1]/div[2]/div[9]/a")
	private WebElement checkoutBtnAddAddress;
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_states_state")
	private WebElement checkoutTextRegion;
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_city")
	private WebElement checkoutComboRegion;
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_address1")
	private WebElement checkoutTextDireccion;	
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'swatchanchor')]")
	private List<WebElement> checkOutRadioColores;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'form-row input-radio')]")
	private List<WebElement> CheckOutRadioDirecciones;
	@FindBy(how = How.NAME, using = "dwfrm_login_unregistered")//Rodolfo
	private WebElement checkoutBtnInvitado;
	
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_dni")
	private WebElement checkoutInputDni;//Cambio Nombre Rodolfo
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_rut")
	private WebElement checkoutInputRut;//Cambio Nombre Rodolfo
	@FindBy(how = How.NAME, using = "dwfrm_personaldetails_continue")
	private WebElement checkoutBtncontinuar;//Cambio Nombre Rodolfo
	
	@FindBy(className="js-date-entry-available")
	private List<WebElement> checkoutListRadioDespachoProgramado;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/div/div[2]/div[7]/div[2]/div[3]/h4/p/strong")
	private WebElement checkoutTotalCompra;
	
//CHECKOUT NUEVO REGISTRO DE USUARIO
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_profile_login_password')]")
	private WebElement CheckOutTextPass;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_profile_login_passwordconfirm')]")
	private WebElement CheckOutTextPassConfirm;
	@FindBy(how = How.NAME, using = "dwfrm_profile_confirm")
	private WebElement CheckOutBtnCrearCuenta;	
	
//CHECKOUT NOVIOS.
	@FindBy(id ="inputCodeNovios")
	private WebElement CheckOutTxtCodigoNovios;
	@FindBy(xpath="//*[@id=\"RegistrationPoints\"]/div/div/div[2]/button")
	private WebElement CheckOutBtnNovios;
	
//CHECKOUT METODOS PAGO
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'box-card')]")
	private List<WebElement> checkOutListTarjetasCredito;
	@FindBy(how = How.XPATH, using = "//*[@id=\"savedCencosudCards\"]/div")
	private WebElement checkOutListTarjetasCreditoCenco;
	@FindBy(how = How.XPATH, using = "//*[@id=\"CREDIT_CARD\"]/div/div[2]/div[1]/div/button")
	private WebElement checkoutBtnRealizarPedido;
	@FindBy(how = How.XPATH, using = "//*[@id=\"CENCOSUD_CARD\"]/div/div[2]/div[1]/div/button")
	private WebElement checkoutBtnRealizarPedidoCenco;
	@FindBy(how = How.XPATH, using = "//*[@id=\"WEBPAY\"]/div/div[3]/div[1]/div/button")
	private WebElement checkoutBtnRealizarPedidoRedCompra;
	@FindBy(how = How.XPATH, using = "//*[@id=\"dwfrm_billing\"]/div[2]/div/div[1]/ul/li[1]/a")
	private WebElement checkoutBtnCreditCard;
	@FindBy(xpath="//a[@class=\"no-collapse\"]")
	private WebElement checkouthrefMetodosPago;
	//Tarjeta Credito
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_billing_paymentMethods_creditCard_number')]")
	private WebElement checkOutTxtnumeroTarjetaCredito;
	@FindBy(how = How.ID, using = "dwfrm_billing_paymentMethods_creditCard_expiration_month")
	private WebElement checkOutTxtMesTarjetaCredito;
	@FindBy(how = How.ID, using = "dwfrm_billing_paymentMethods_creditCard_expiration_year")
	private WebElement checkOutTxtAnioTarjetaCredito;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_billing_paymentMethods_creditCard_cvn')]")
	private WebElement checkOutTxtCvvTarjetaCredito;
	@FindBy(how = How.ID, using = "dwfrm_billing_paymentMethods_creditCard_firstName")
	private WebElement checkOutTxtNombreTitularTarjetaCredito;
	@FindBy(how = How.ID, using = "dwfrm_billing_paymentMethods_creditCard_lastName")
	private WebElement checkOutTxtApellidoTitularTarjetaCredito;
	@FindBy(how = How.XPATH, using = "//*[contains(@href,'#CREDIT_CARD')]")
	private WebElement checkOutHrefTarjetaCredito;
	@FindBy(how = How.ID, using = "dwfrm_billing_paymentMethods_creditCard_installments")
	private WebElement checkOutSelectCuotasTarjetaCredito;
	@FindBy(how = How.XPATH, using = "//*[@id=\"CREDIT_CARD\"]/div/div[1]/div[1]/div[2]/div[1]/strong")
	private WebElement checkoutBtnNewCardCredit;
//Cenco Credito
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_billing_paymentMethods_cencosudCard_number')]")
	private WebElement checkOutTxtnumeroTarjetaCreditoCenco;
	@FindBy(how = How.ID, using = "dwfrm_billing_paymentMethods_cencosudCard_expiration_month")
	private WebElement checkOutTxtMesTarjetaCreditoCenco;
	@FindBy(how = How.ID, using = "dwfrm_billing_paymentMethods_cencosudCard_expiration_year")
	private WebElement checkOutTxtAnioTarjetaCreditoCenco;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_billing_paymentMethods_cencosudCard_cvn')]")
	private WebElement checkOutTxtCvvTarjetaCreditoCenco;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_billing_paymentMethods_cencosudCard_owner')]")
	private WebElement checkOutTxtNombreTitularTarjetaCreditoCenco;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_billing_paymentMethods_cencosudCard_lastName')]")
	private WebElement checkOutTxtApellidoTitularTarjetaCreditoCenco;
	@FindBy(how = How.XPATH, using = "//*[contains(@href,'#CENCOSUD_CARD')]")
	private WebElement checkOutHrefCencosudCredito;
	@FindBy(how = How.ID, using = "dwfrm_billing_paymentMethods_cencosudCard_installments")
	private WebElement checkOutTxtCuotasTarjetaCreditoCenco;
//REDCOMPRA
	@FindBy(how = How.XPATH, using = "//*[contains(@href,'#WEBPAY')]")
	private WebElement checkOutHrefRedCompra;
	@FindBy(id = "TBK_TIPO_TARJETA")
	private List<WebElement> checkoutRadioSeleccionRedCompra;
	@FindBy(id = "TBK_BANCO")
	private WebElement checkoutListBancosRedCompra;
	@FindBy(id = "TBK_NUMERO_TARJETA")
	private WebElement checkoutNumeroTarjetaRedCompra;
	@FindBy(id = "rutClient")
	private WebElement checkoutTxtRutRedCompra;
	@FindBy(id = "passwordClient")
	private WebElement checkoutTxtClaveRedCompra;
	@FindBy(id = "button")
	private WebElement checkoutBtnPagarRedCompra;
	@FindBy(xpath="/html/body/div/form/table/tbody/tr[9]/td/input[1]")
	private WebElement checkoutPagarRedCompra;
	@FindBy(xpath="/html/body/div/form/table/tbody/tr[4]/td/input")
	private WebElement checkoutContinuarRedCompra;
//GIFTCARD
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'dwfrm_giftcard_giftcardnumber')]")
	private WebElement checkoutCodigoGiftcard;
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'dwfrm_giftcard_giftcardpassword')]")
	private WebElement checkoutClaveGiftcard;
	@FindBy(name = "dwfrm_giftcard_apply")
	private WebElement checkoutAplicarGiftcard;
	@FindBy(xpath="//a[@href=\"#accordionGiftCard\"]")
	private WebElement checkourHrefGiftCard;
	
	@FindBy(name = "transicion")
	private WebElement checkoutFrameRedCompra;

//PDP MINICARRO
	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[2]/div[2]/a[2]")
	private WebElement checkOutBtnComprar;	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[2]/div[2]/a[1]")
	private WebElement checkOutBtnVerCarro;
	@FindBy(how = How.CLASS_NAME, using = "box-controles-mc clearfix")
	private WebElement checkOutFrameMiniCarro;	
	
	
//PDP FRAME BONIFICACION
	@FindBy(how = How.XPATH, using = "//*[@id=\"ext-gen44\"]/body/div[4]/div[3]/div/button[1]/span")
	private WebElement FramePDP_btnNoGracias;
//	
//	public WebElement isInPage(WebElement element) {
//		  return (element == document.body) ? false : document.body.contains(element);
//	}
	
//	function isInPage(node) {
//		  return (node === document.body) ? false : document.body.contains(node);
//		}
	@FindBy(how = How.XPATH, using = "//*[@id=\"ext-gen44\"]/body/div[4]/div[1]/button/span[1]")
	private WebElement FramePDP_btnCerrarFrame;
	@FindBy(how = How.CLASS_NAME, using = "ui-dialog ui-widget ui-widget-content ui-corner-all ui-front bonus-products-modal ui-dialog-buttons")
	private WebElement FramePDP_FrameBonificacion;
	@FindBy(how = How.CLASS_NAME, using = "select-bonus-product-btn ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only")
	private WebElement FramePDP_btnIrABonificacion;
	
	@FindBy(how = How.CLASS_NAME, using = "bonus-product-item")
	private List<WebElement> FramePDP_ListProductosBonificacion;
	@FindBy(how = How.CLASS_NAME, using = "bonus-products")
	private WebElement framePDP_FrameProductosBonificacion;
	@FindBy(how = How.CLASS_NAME, using = "qty-select form-control js-qty-bonus")
	private WebElement framePDP_SelectCantidadBonificacion;
//	@FindBy(how = How.CLASS_NAME, using = "select-bonus-item")
//	private WebElement framePDP_BtnAgregarProductoDeBonificacion;
	
	
	@FindBy(how = How.CLASS_NAME, using = "select-bonus-item")
	private List<WebElement> pdpBtnSeleccionarProBonificacion;//CAMBIO RECIENTE PDP boton Seleccionar producto bonificado
	@FindBy(how = How.CLASS_NAME, using = "qty-select form-control js-qty-bonus")
	private List<WebElement> pdpSelectCantidadProBonificacion;//CAMBIO RECIENTE PDP select cantidad de producto bonificado
	@FindBy(how = How.XPATH, using = "//*[@id=\"bonus-product-list\"]/div[3]/button")
	private WebElement pdpBtnAgregarProductoBonificado;//CAMBIO RECIENTE PDP botn de agregar productos bonificados
	
	
	
	
// CHECKOUT_ENTREGA
	@FindBy(how = How.ID, using = "searchTextField")
	private WebElement checkoutInputIntroduceUbicacion;//Rodolfo
	@FindBy(how = How.ID, using ="dwfrm_singleshipping_shippingAddress_addressFields_addressID")
	private WebElement checkoutInputDireccionDespacho;
	@FindBy(how = How.ID, using ="dwfrm_singleshipping_shippingAddress_addressFields_address3")
	private WebElement checkoutInputNumCasaOrDepartamento;
	@FindBy(how = How.ID, using ="dwfrm_singleshipping_shippingAddress_addressFields_postal")
	private WebElement checkoutInputCodPostal;
	@FindBy(how = How.NAME, using ="dwfrm_singleshipping_shippingAddress_save")
	private WebElement EntregaBtnFacturacion;
//	@FindBy(how = How.ID, using ="shipping-method-1")
	@FindBy(id = "shipping-method-1")
	private WebElement EntregaRadioDespachoDomicilioStandar;
//	@FindBy(how = How.ID, using ="shipping-method-2")
	@FindBy(id = "shipping-method-2")
	private WebElement EntregaRadioDespachoDomicilioProgramada;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'input-radio')]")
	private List<WebElement> checkoutListRadioTipoDespachoProgramado;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'js-show-address')]")
	private WebElement checkoutBtnDireccionManual; //Rodolfo
	
	
	
	//Ingreso Direccion Manual
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_address2")
	private WebElement checkoutInputNumero;//Rodolfo
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_states_state")
	private WebElement checkoutSelectRegion;//Rodolfo
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_city")
	private WebElement checkoutSelectComuna;//Rodolfo
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_address1")
	private WebElement checkoutInputCalle;//Rodolfo
	
//CHECKOUT FACTURA 
	@FindBy(how = How.CLASS_NAME, using = "content-accordion-header")
	private WebElement checkoutBtnIngresaDatosFactura;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_factura_companyname')]")
	private WebElement checkoutInputEmpresaFactura;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_factura_companySocialReason')]")
	private WebElement checkoutInputRazonSocialFactura;
	@FindBy(how = How.ID, using = "dwfrm_factura_state")
	private WebElement checkoutSelectRegionFactura;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_factura_streetname')]")
	private WebElement checkoutInputCalleFactura;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_factura_apartmentnumber')]")
	private WebElement checkoutInputNumCasaDeptoFactura;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_factura_contactperson')]")
	private WebElement checkoutInputPersContactoFactura;
	@FindBy(how = How.ID, using = "dwfrm_factura_companyRUT")
	private WebElement checkoutInputRutFactura;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_factura_companyCommercialName')]")
	private WebElement checkoutInputGiroFactura;
	@FindBy(how = How.ID, using = "dwfrm_factura_city")
	private WebElement checkoutSelectComunaFactura;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_factura_streetnumber')]")
	private WebElement checkoutInputNumeroFactura;
	@FindBy(how = How.ID, using = "dwfrm_factura_phone")
	private WebElement checkoutInputFonoFactura;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'dwfrm_factura_companyemail')]")
	private WebElement checkoutInputEmailFactura;
	@FindBy(how = How.NAME, using = "dwfrm_factura_save")
	private WebElement checkoutBtnGuardarDatosFactura;
	@FindBy(how = How.XPATH, using = "//*[@id=\"dwfrm_factura\"]/div/div/div/div[13]/a")
	private WebElement checkoutBtnCancelarFactura;

	
	
	//Ver disponibilidad de despacho a domicilio
	@FindBy(how = How.XPATH,using ="//*[@id=\"product-content\"]/div[5]/div/a/strong")
	private WebElement disponibilidadDespachoADomicilio;
	
	//	Frame de disponibilidad de despacho
	@FindBy(how = How.XPATH, using="//*[@id=\"ext-gen44\"]/body/div[4]")
	private WebElement FrameDisponibilidadToDespacho;
	//Seleccionar Region para despacho a domicilio
	@FindBy(how = How.ID,using = "js-region-select")
	private WebElement regionDespacho; 
	//Seleccionar comuna para despacho
	@FindBy(how = How.ID,using = "js-comuna-select")
	private WebElement comunaDespacho;
	//Label error sindisponibilidad de despacho
	@FindBy(how = How.CLASS_NAME,using="message-availability no-availability")
	private WebElement errorSinDisponibilidadDespacho;
	//Cerrar Frame disponibilidad despacho
	@FindBy(how = How.XPATH,using="//*[@id=\"ext-gen44\"]/body/div[4]/div[1]/button")
	private WebElement cerrarFrameDespacho;
//CHECKOUT OC
//	@FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/div/div[1]/div[5]/div[2]/dl[1]/dd")
	@FindBy(xpath = "//*[@id=\"main\"]/div/div/div[1]/div[5]/div[2]/dl[1]/dd")
	private WebElement checkoutDivNumOrdenCompra;
	//Boton comprar producto
	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[2]/div[2]/a[2]")
	private WebElement botonComprar;

	@FindBy(how = How.ID, using = "dwfrm_personaldetails_firstname")
	private WebElement nombre;

	@FindBy(how = How.ID, using = "dwfrm_personaldetails_lastname")
	private WebElement apellido;

	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_firstName")
	private WebElement nombreSegundo;

	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_lastName")
	private WebElement apellidoSegundo;

	@FindBy(how = How.ID, using = "dwfrm_personaldetails_email")
	private WebElement correo;

	@FindBy(how = How.ID, using = "dwfrm_personaldetails_phone")
	private WebElement telefono;
	
	//RadioButton de seleccion de rut o DNI
	@FindBy(how = How.XPATH,using = "dwfrm_personaldetails_identityOption_RUT")
	private WebElement rutOrDni;

	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_address1")
	private WebElement direccion;

	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_states_state")
	private WebElement comuna;

	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_city")
	private WebElement ciudad;

	@FindBy(how = How.ID, using = "crdName")
	private WebElement tipoDespacho;


	@FindBy(how = How.XPATH, using = "//*[@id=\"dwfrm_billing\"]/div/div[1]/a")
	private WebElement logoMetodoPago;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cart-items-form\"]/fieldset/div[1]")
	private WebElement objetoCart;
	
	public WebElement getHomeBtnBuscar(){
		return homeBtnBuscar;
	}

	public void setHomeBtnBuscar(WebElement homeBtnBuscar) {
		this.homeBtnBuscar = homeBtnBuscar;
	}

	public WebElement getHomeTxtIngresobusqueda() {
		return homeTxtIngresobusqueda;
	}

	public void setHomeTxtIngresobusqueda(WebElement homeTxtIngresobusqueda) {
		this.homeTxtIngresobusqueda = homeTxtIngresobusqueda;
	}

	public WebElement getPdpCantidad() {
		return pdpCantidad;
	}

	public void setCantidad(WebElement pdpCantidad) {
		this.pdpCantidad = pdpCantidad;
	}

	public WebElement getPdpAgregarCarro() {
		return pdpAgregarCarro;
	}

	public void setAgregarCarro(WebElement pdpAgregarCarro) {
		this.pdpAgregarCarro = pdpAgregarCarro;
	}

	public WebElement getPdpBtnVerCarro() {
		return pdpBtnVerCarro;
	}

	public void setPdpBtnVerCarro(WebElement pdpBtnVerCarro) {
		this.pdpBtnVerCarro = pdpBtnVerCarro;
	}

	public WebElement getPdpBtnComprar() {
		return pdpBtnComprar;
	}

	public void setPdpBtnComprar(WebElement pdpBtnComprar) {
		this.pdpBtnComprar = pdpBtnComprar;
	}

	public WebElement getCarroBtnIrALaCaja() {
		return carroBtnIrALaCaja;
	}

	public void setCarroBtnIrALaCaja(WebElement carroBtnIrALaCaja) {
		this.carroBtnIrALaCaja = carroBtnIrALaCaja;
	}

	public WebElement getCheckoutBtnCompraGuest() {
		return checkoutBtnCompraGuest;
	}

	public void setCheckoutBtnCompraGuest(WebElement checkoutBtnCompraGuest) {
		this.checkoutBtnCompraGuest = checkoutBtnCompraGuest;
	}

	public WebElement getCheckoutTextNombre() {
		return checkoutTextNombre;
	}

	public void setCheckoutTextNombre(WebElement checkoutTextNombre) {
		this.checkoutTextNombre = checkoutTextNombre;
	}

	public WebElement getCheckoutTextApellido() {
		return checkoutTextApellido;
	}

	public void setCheckoutTextApellido(WebElement checkoutTextApellido) {
		this.checkoutTextApellido = checkoutTextApellido;
	}

	public WebElement getCheckoutTextEmail() {
		return checkoutTextEmail;
	}

	public void setCheckoutTextEmail(WebElement checkoutTextEmail) {
		this.checkoutTextEmail = checkoutTextEmail;
	}

	public WebElement getCheckoutComboAnexo() {
		return checkoutComboAnexo;
	}

	public void setCheckoutComboAnexo(WebElement checkoutComboAnexo) {
		this.checkoutComboAnexo = checkoutComboAnexo;
	}

	public WebElement getCheckoutTextTelefono() {
		return checkoutTextTelefono;
	}

	public void setCheckoutTextTelefono(WebElement checkoutTextTelefono) {
		this.checkoutTextTelefono = checkoutTextTelefono;
	}

	public WebElement getCheckoutRadioBtnRut() {
		return checkoutRadioBtnRut;
	}

	public void setCheckoutRadioBtnRut(WebElement checkoutRadioBtnRut) {
		this.checkoutRadioBtnRut = checkoutRadioBtnRut;
	}

	public WebElement getCheckoutRadioBtnDni() {
		return checkoutRadioBtnDni;
	}

	public void setCheckoutRadioBtnDni(WebElement checkoutRadioBtnDni) {
		this.checkoutRadioBtnDni = checkoutRadioBtnDni;
	}

	public WebElement getCheckoutTextRut() {
		return checkoutTextRut;
	}

	public void setCheckoutTextRut(WebElement checkoutTextRut) {
		this.checkoutTextRut = checkoutTextRut;
	}

	public WebElement getCheckoutBtnContinuar() {
		return checkoutBtnContinuar;
	}

	public void setCheckoutBtnContinuar(WebElement checkoutBtnContinuar) {
		this.checkoutBtnContinuar = checkoutBtnContinuar;
	}

	public WebElement getCheckoutBtnDespachoDomicilio() {
		return checkoutBtnDespachoDomicilio;
	}

	public void setCheckoutBtnDespachoDomicilio(WebElement checkoutBtnDespachoDomicilio) {
		this.checkoutBtnDespachoDomicilio = checkoutBtnDespachoDomicilio;
	}

	public WebElement getCheckoutBtnAddAddress() {
		return checkoutBtnAddAddress;
	}

	public void setCheckoutBtnAddAddress(WebElement checkoutBtnAddAddress) {
		this.checkoutBtnAddAddress = checkoutBtnAddAddress;
	}

	public WebElement getCheckoutTextRegion() {
		return checkoutTextRegion;
	}

	public void setCheckoutTextRegion(WebElement checkoutTextRegion) {
		this.checkoutTextRegion = checkoutTextRegion;
	}

	public WebElement getCheckoutComboRegion() {
		return checkoutComboRegion;
	}

	public void setCheckoutComboRegion(WebElement checkoutComboRegion) {
		this.checkoutComboRegion = checkoutComboRegion;
	}

	public WebElement getCheckoutTextDireccion() {
		return checkoutTextDireccion;
	}

	public void setCheckoutTextDireccion(WebElement checkoutTextDireccion) {
		this.checkoutTextDireccion = checkoutTextDireccion;
	}

	public WebElement getFramePDP_btnNoGracias() {
		return FramePDP_btnNoGracias;
	}

	public void setFramePDP_btnNoGracias(WebElement framePDP_btnNoGracias) {
		FramePDP_btnNoGracias = framePDP_btnNoGracias;
	}


	public WebElement getFramePDP_btnCerrarFrame() {
		return FramePDP_btnCerrarFrame;
	}

	public void setFramePDP_btnCerrarFrame(WebElement framePDP_btnCerrarFrame) {
		FramePDP_btnCerrarFrame = framePDP_btnCerrarFrame;
	}

	public WebElement getDisponibilidadDespachoADomicilio() {
		return disponibilidadDespachoADomicilio;
	}

	public void setDisponibilidadDespachoADomicilio(WebElement disponibilidadDespachoADomicilio) {
		this.disponibilidadDespachoADomicilio = disponibilidadDespachoADomicilio;
	}

	public WebElement getFrameDisponibilidadToDespacho() {
		return FrameDisponibilidadToDespacho;
	}

	public void setFrameDisponibilidadToDespacho(WebElement frameDisponibilidadToDespacho) {
		FrameDisponibilidadToDespacho = frameDisponibilidadToDespacho;
	}

	public WebElement getRegionDespacho() {
		return regionDespacho;
	}

	public void setRegionDespacho(WebElement regionDespacho) {
		this.regionDespacho = regionDespacho;
	}

	public WebElement getComunaDespacho() {
		return comunaDespacho;
	}

	public void setComunaDespacho(WebElement comunaDespacho) {
		this.comunaDespacho = comunaDespacho;
	}

	public WebElement getErrorSinDisponibilidadDespacho() {
		return errorSinDisponibilidadDespacho;
	}

	public void setErrorSinDisponibilidadDespacho(WebElement errorSinDisponibilidadDespacho) {
		this.errorSinDisponibilidadDespacho = errorSinDisponibilidadDespacho;
	}

	public WebElement getCerrarFrameDespacho() {
		return cerrarFrameDespacho;
	}

	public void setCerrarFrameDespacho(WebElement cerrarFrameDespacho) {
		this.cerrarFrameDespacho = cerrarFrameDespacho;
	}

	public WebElement getBotonComprar() {
		return botonComprar;
	}

	public void setBotonComprar(WebElement botonComprar) {
		this.botonComprar = botonComprar;
	}

	public WebElement getCheckoutBtnInvitado() {
		return checkoutBtnInvitado;
	}

	public void setCheckoutBtnInvitado(WebElement checkoutBtnInvitado) {
		this.checkoutBtnInvitado = checkoutBtnInvitado;
	}

	public WebElement getNombre() {
		return nombre;
	}

	public void setNombre(WebElement nombre) {
		this.nombre = nombre;
	}

	public WebElement getApellido() {
		return apellido;
	}

	public void setApellido(WebElement apellido) {
		this.apellido = apellido;
	}

	public WebElement getNombreSegundo() {
		return nombreSegundo;
	}

	public void setNombreSegundo(WebElement nombreSegundo) {
		this.nombreSegundo = nombreSegundo;
	}

	public WebElement getApellidoSegundo() {
		return apellidoSegundo;
	}

	public void setApellidoSegundo(WebElement apellidoSegundo) {
		this.apellidoSegundo = apellidoSegundo;
	}

	public WebElement getCorreo() {
		return correo;
	}

	public void setCorreo(WebElement correo) {
		this.correo = correo;
	}

	public WebElement getTelefono() {
		return telefono;
	}

	public void setTelefono(WebElement telefono) {
		this.telefono = telefono;
	}



	public WebElement getCheckoutInputRut() {
		return checkoutInputRut;
	}

	public void setCheckoutInputRut(WebElement checkoutInputRut) {
		this.checkoutInputRut = checkoutInputRut;
	}

	public WebElement getCheckoutInputDni() {
		return checkoutInputDni;
	}

	public void setCheckoutInputDni(WebElement checkoutInputDni) {
		this.checkoutInputDni = checkoutInputDni;
	}

	public WebElement getRutOrDni() {
		return rutOrDni;
	}

	public void setRutOrDni(WebElement rutOrDni) {
		this.rutOrDni = rutOrDni;
	}

	public WebElement getDireccion() {
		return direccion;
	}

	public void setDireccion(WebElement direccion) {
		this.direccion = direccion;
	}

	public WebElement getComuna() {
		return comuna;
	}

	public void setComuna(WebElement comuna) {
		this.comuna = comuna;
	}

	public WebElement getCiudad() {
		return ciudad;
	}

	public void setCiudad(WebElement ciudad) {
		this.ciudad = ciudad;
	}

	public WebElement getTipoDespacho() {
		return tipoDespacho;
	}

	public void setTipoDespacho(WebElement tipoDespacho) {
		this.tipoDespacho = tipoDespacho;
	}


	public WebElement getCheckoutBtncontinuar() {
		return checkoutBtncontinuar;
	}

	public void setCheckoutBtncontinuar(WebElement checkoutBtncontinuar) {
		this.checkoutBtncontinuar = checkoutBtncontinuar;
	}

	
	public WebElement getLogoMetodoPago() {
		return logoMetodoPago;
	}


	public WebElement getObjetoCart() {
		return objetoCart;
	}

	public void setObjetoCart(WebElement objetoCart) {
		this.objetoCart = objetoCart;
	}


	public WebElement getCheckOutSelectTalla() {
		return checkOutSelectTalla;
	}

	public void setCheckOutSelectTalla(WebElement checkOutSelectTalla) {
		this.checkOutSelectTalla = checkOutSelectTalla;
	}

	public void setPdpCantidad(WebElement pdpCantidad) {
		this.pdpCantidad = pdpCantidad;
	}

	public void setPdpAgregarCarro(WebElement pdpAgregarCarro) {
		this.pdpAgregarCarro = pdpAgregarCarro;
	}

	public void setLogoMetodoPago(WebElement logoMetodoPago) {
		this.logoMetodoPago = logoMetodoPago;
	}

	
	
	public WebElement getHomeLblLogin() {
		return homeLblLogin;
	}

	public void setHomeLblLogin(WebElement homeLblLogin) {
		this.homeLblLogin = homeLblLogin;
	}

	public WebElement getLoginBtnIniciarSesion() {
		return loginBtnIniciarSesion;
	}

	public void setLoginBtnIniciarSesion(WebElement loginBtnIniciarSesion) {
		this.loginBtnIniciarSesion = loginBtnIniciarSesion;
	}


	public WebElement getPdpSelectProduct() {
		return pdpSelectProduct;
	}

	public void setPdpSelectProduct(WebElement pdpSelectProduct) {
		this.pdpSelectProduct = pdpSelectProduct;
	}

	public WebElement getCheckOutBtnComprar() {
		return checkOutBtnComprar;
	}

	public void setCheckOutBtnComprar(WebElement checkOutBtnComprar) {
		this.checkOutBtnComprar = checkOutBtnComprar;
	}

	public WebElement getCheckOutBtnVerCarro() {
		return checkOutBtnVerCarro;
	}

	public void setCheckOutBtnVerCarro(WebElement checkOutBtnVerCarro) {
		this.checkOutBtnVerCarro = checkOutBtnVerCarro;
	}

	public WebElement getFramePDP_FrameBonificacion() {
		return FramePDP_FrameBonificacion;
	}

	public void setFramePDP_FrameBonificacion(WebElement framePDP_FrameBonificacion) {
		FramePDP_FrameBonificacion = framePDP_FrameBonificacion;
	}

	public WebElement getCheckOutFrameMiniCarro() {
		return checkOutFrameMiniCarro;
	}

	public void setCheckOutFrameMiniCarro(WebElement checkOutFrameMiniCarro) {
		this.checkOutFrameMiniCarro = checkOutFrameMiniCarro;
	}

	

	public WebElement getCheckoutInputIntroduceUbicacion() {
		return checkoutInputIntroduceUbicacion;
	}

	public void setCheckoutInputIntroduceUbicacion(WebElement checkoutInputIntroduceUbicacion) {
		this.checkoutInputIntroduceUbicacion = checkoutInputIntroduceUbicacion;
	}

	public WebElement getCheckoutInputDireccionDespacho() {
		return checkoutInputDireccionDespacho;
	}

	public void setCheckoutInputDireccionDespacho(WebElement checkoutInputDireccionDespacho) {
		this.checkoutInputDireccionDespacho = checkoutInputDireccionDespacho;
	}

	public WebElement getCheckoutInputNumCasaOrDepartamento() {
		return checkoutInputNumCasaOrDepartamento;
	}

	public void setCheckoutInputNumCasaOrDepartamento(WebElement checkoutInputNumCasaOrDepartamento) {
		this.checkoutInputNumCasaOrDepartamento = checkoutInputNumCasaOrDepartamento;
	}

	public WebElement getCheckoutInputCodPostal() {
		return checkoutInputCodPostal;
	}

	public void setCheckoutInputCodPostal(WebElement checkoutInputCodPostal) {
		this.checkoutInputCodPostal = checkoutInputCodPostal;
	}

	public WebElement getCheckoutBtnDireccionManual() {
		return checkoutBtnDireccionManual;
	}

	public void setCheckoutBtnDireccionManual(WebElement checkoutBtnDireccionManual) {
		this.checkoutBtnDireccionManual = checkoutBtnDireccionManual;
	}

	public WebElement getEntregaBtnFacturacion() {
		return EntregaBtnFacturacion;
	}

	public void setEntregaBtnFacturacion(WebElement entregaBtnFacturacion) {
		EntregaBtnFacturacion = entregaBtnFacturacion;
	}

	public WebElement getEntregaRadioDespachoDomicilioStandar() {
		return EntregaRadioDespachoDomicilioStandar;
	}

	public void setEntregaRadioDespachoDomicilioStandar(WebElement entregaRadioDespachoDomicilioStandar) {
		EntregaRadioDespachoDomicilioStandar = entregaRadioDespachoDomicilioStandar;
	}

	public WebElement getEntregaRadioDespachoDomicilioProgramada() {
		return EntregaRadioDespachoDomicilioProgramada;
	}

	public void setEntregaRadioDespachoDomicilioProgramada(WebElement entregaRadioDespachoDomicilioProgramada) {
		EntregaRadioDespachoDomicilioProgramada = entregaRadioDespachoDomicilioProgramada;
	}

	public WebElement getLoginTxtUsuario() {
		return loginTxtUsuario;
	}

	public void setLoginTxtUsuario(WebElement loginTxtUsuario) {
		this.loginTxtUsuario = loginTxtUsuario;
	}

	public WebElement getLoginTxtClave() {
		return loginTxtClave;
	}

	public void setLoginTxtClave(WebElement loginTxtClave) {
		this.loginTxtClave = loginTxtClave;
	}

	public WebElement getLoginLblError() {
		return loginLblError;
	}

	public void setLoginLblError(WebElement loginLblError) {
		this.loginLblError = loginLblError;
	}

	public List<WebElement> getCheckOutRadioColores() {
		return checkOutRadioColores;
	}

	public void setCheckOutRadioColores(List<WebElement> checkOutRadioColores) {
		this.checkOutRadioColores = checkOutRadioColores;
	}

	public List<WebElement> getCheckOutRadioDirecciones() {
		return CheckOutRadioDirecciones;
	}

	public void setCheckOutRadioDirecciones(List<WebElement> checkOutRadioDirecciones) {
		CheckOutRadioDirecciones = checkOutRadioDirecciones;
	}

	public WebElement getCheckOutTxtCodigoNovios() {
		return CheckOutTxtCodigoNovios;
	}

	public void setCheckOutTxtCodigoNovios(WebElement checkOutTxtCodigoNovios) {
		CheckOutTxtCodigoNovios = checkOutTxtCodigoNovios;
	}

	public WebElement getCheckOutBtnNovios() {
		return CheckOutBtnNovios;
	}

	public void setCheckOutBtnNovios(WebElement checkOutBtnNovios) {
		CheckOutBtnNovios = checkOutBtnNovios;
	}

	public WebElement getFramePDP_btnIrABonificacion() {
		return FramePDP_btnIrABonificacion;
	}

	public void setFramePDP_btnIrABonificacion(WebElement framePDP_btnIrABonificacion) {
		FramePDP_btnIrABonificacion = framePDP_btnIrABonificacion;
	}

	public List<WebElement> getFramePDP_ListProductosBonificacion() {
		return FramePDP_ListProductosBonificacion;
	}

	public void setFramePDP_ListProductosBonificacion(List<WebElement> framePDP_ListProductosBonificacion) {
		FramePDP_ListProductosBonificacion = framePDP_ListProductosBonificacion;
	}

	public WebElement getFramePDP_FrameProductosBonificacion() {
		return framePDP_FrameProductosBonificacion;
	}

	public void setFramePDP_FrameProductosBonificacion(WebElement framePDP_FrameProductosBonificacion) {
		this.framePDP_FrameProductosBonificacion = framePDP_FrameProductosBonificacion;
	}

	public WebElement getFramePDP_SelectCantidadBonificacion() {
		return framePDP_SelectCantidadBonificacion;
	}

	public void setFramePDP_SelectCantidadBonificacion(WebElement framePDP_SelectCantidadBonificacion) {
		this.framePDP_SelectCantidadBonificacion = framePDP_SelectCantidadBonificacion;
	}

	

	public List<WebElement> getPdpBtnSeleccionarProBonificacion() {
		return pdpBtnSeleccionarProBonificacion;
	}

	public void setPdpBtnSeleccionarProBonificacion(List<WebElement> pdpBtnSeleccionarProBonificacion) {
		this.pdpBtnSeleccionarProBonificacion = pdpBtnSeleccionarProBonificacion;
	}

	public List<WebElement> getPdpSelectCantidadProBonificacion() {
		return pdpSelectCantidadProBonificacion;
	}

	public void setPdpSelectCantidadProBonificacion(List<WebElement> pdpSelectCantidadProBonificacion) {
		this.pdpSelectCantidadProBonificacion = pdpSelectCantidadProBonificacion;
	}

	public WebElement getPdpBtnAgregarProductoBonificado() {
		return pdpBtnAgregarProductoBonificado;
	}

	public void setPdpBtnAgregarProductoBonificado(WebElement pdpBtnAgregarProductoBonificado) {
		this.pdpBtnAgregarProductoBonificado = pdpBtnAgregarProductoBonificado;
	}

	public WebElement getHomeLblUser() {
		return homeLblUser;
	}

	public void setHomeLblUser(WebElement homeLblUser) {
		this.homeLblUser = homeLblUser;
	}

	
	

	public WebElement getPdpSelectConArmado() {
		return pdpSelectConArmado;
	}

	public void setPdpSelectConArmado(WebElement pdpSelectConArmado) {
		this.pdpSelectConArmado = pdpSelectConArmado;
	}

	public List<WebElement> getCarroListProductosEnCarroCompras() {
		return carroListProductosEnCarroCompras;
	}

	public void setCarroListProductosEnCarroCompras(List<WebElement> carroListProductosEnCarroCompras) {
		this.carroListProductosEnCarroCompras = carroListProductosEnCarroCompras;
	}

	public List<WebElement> getCarroListCantidadProductoEnCarroCompras() {
		return carroListCantidadProductoEnCarroCompras;
	}

	public void setCarroListCantidadProductoEnCarroCompras(List<WebElement> carroListCantidadProductoEnCarroCompras) {
		this.carroListCantidadProductoEnCarroCompras = carroListCantidadProductoEnCarroCompras;
	}

	public WebElement getCheckOutTxtnumeroTarjetaCredito() {
		return checkOutTxtnumeroTarjetaCredito;
	}

	public void setCheckOutTxtnumeroTarjetaCredito(WebElement checkOutTxtnumeroTarjetaCredito) {
		this.checkOutTxtnumeroTarjetaCredito = checkOutTxtnumeroTarjetaCredito;
	}

	public WebElement getCheckOutTxtMesTarjetaCredito() {
		return checkOutTxtMesTarjetaCredito;
	}

	public void setCheckOutTxtMesTarjetaCredito(WebElement checkOutTxtMesTarjetaCredito) {
		this.checkOutTxtMesTarjetaCredito = checkOutTxtMesTarjetaCredito;
	}

	public WebElement getCheckOutTxtAnioTarjetaCredito() {
		return checkOutTxtAnioTarjetaCredito;
	}

	public void setCheckOutTxtAnioTarjetaCredito(WebElement checkOutTxtAnioTarjetaCredito) {
		this.checkOutTxtAnioTarjetaCredito = checkOutTxtAnioTarjetaCredito;
	}

	public WebElement getCheckOutTxtCvvTarjetaCredito() {
		return checkOutTxtCvvTarjetaCredito;
	}

	public void setCheckOutTxtCvvTarjetaCredito(WebElement checkOutTxtCvvTarjetaCredito) {
		this.checkOutTxtCvvTarjetaCredito = checkOutTxtCvvTarjetaCredito;
	}

	public WebElement getCheckOutTxtNombreTitularTarjetaCredito() {
		return checkOutTxtNombreTitularTarjetaCredito;
	}

	public void setCheckOutTxtNombreTitularTarjetaCredito(WebElement checkOutTxtNombreTitularTarjetaCredito) {
		this.checkOutTxtNombreTitularTarjetaCredito = checkOutTxtNombreTitularTarjetaCredito;
	}

	public WebElement getCheckOutTxtnumeroTarjetaCreditoCenco() {
		return checkOutTxtnumeroTarjetaCreditoCenco;
	}

	public void setCheckOutTxtnumeroTarjetaCreditoCenco(WebElement checkOutTxtnumeroTarjetaCreditoCenco) {
		this.checkOutTxtnumeroTarjetaCreditoCenco = checkOutTxtnumeroTarjetaCreditoCenco;
	}

	public WebElement getCheckOutTxtMesTarjetaCreditoCenco() {
		return checkOutTxtMesTarjetaCreditoCenco;
	}

	public void setCheckOutTxtMesTarjetaCreditoCenco(WebElement checkOutTxtMesTarjetaCreditoCenco) {
		this.checkOutTxtMesTarjetaCreditoCenco = checkOutTxtMesTarjetaCreditoCenco;
	}

	public WebElement getCheckOutTxtAnioTarjetaCreditoCenco() {
		return checkOutTxtAnioTarjetaCreditoCenco;
	}

	public void setCheckOutTxtAnioTarjetaCreditoCenco(WebElement checkOutTxtAnioTarjetaCreditoCenco) {
		this.checkOutTxtAnioTarjetaCreditoCenco = checkOutTxtAnioTarjetaCreditoCenco;
	}

	public WebElement getCheckOutTxtCvvTarjetaCreditoCenco() {
		return checkOutTxtCvvTarjetaCreditoCenco;
	}

	public void setCheckOutTxtCvvTarjetaCreditoCenco(WebElement checkOutTxtCvvTarjetaCreditoCenco) {
		this.checkOutTxtCvvTarjetaCreditoCenco = checkOutTxtCvvTarjetaCreditoCenco;
	}

	public WebElement getCheckOutTxtNombreTitularTarjetaCreditoCenco() {
		return checkOutTxtNombreTitularTarjetaCreditoCenco;
	}

	public void setCheckOutTxtNombreTitularTarjetaCreditoCenco(WebElement checkOutTxtNombreTitularTarjetaCreditoCenco) {
		this.checkOutTxtNombreTitularTarjetaCreditoCenco = checkOutTxtNombreTitularTarjetaCreditoCenco;
	}

	

	public WebElement getCheckoutBtnRealizarPedido() {
		return checkoutBtnRealizarPedido;
	}

	public void setCheckoutBtnRealizarPedido(WebElement checkoutBtnRealizarPedido) {
		this.checkoutBtnRealizarPedido = checkoutBtnRealizarPedido;
	}

	public WebElement getCheckOutHrefTarjetaCredito() {
		return checkOutHrefTarjetaCredito;
	}

	public void setCheckOutHrefTarjetaCredito(WebElement checkOutHrefTarjetaCredito) {
		this.checkOutHrefTarjetaCredito = checkOutHrefTarjetaCredito;
	}

	public WebElement getCheckOutHrefCencosudCredito() {
		return checkOutHrefCencosudCredito;
	}

	public void setCheckOutHrefCencosudCredito(WebElement checkOutHrefCencosudCredito) {
		this.checkOutHrefCencosudCredito = checkOutHrefCencosudCredito;
	}

	public WebElement getCarroTxtCodigoDescuento() {
		return carroTxtCodigoDescuento;
	}

	public void setCarroTxtCodigoDescuento(WebElement carroTxtCodigoDescuento) {
		this.carroTxtCodigoDescuento = carroTxtCodigoDescuento;
	}

	public WebElement getCarroBtnDescuento() {
		return carroBtnDescuento;
	}

	public void setCarroBtnDescuento(WebElement carroBtnDescuento) {
		this.carroBtnDescuento = carroBtnDescuento;
	}

	public WebElement getCarroLblErrorCdgoDescuento() {
		return carroLblErrorCdgoDescuento;
	}

	public void setCarroLblErrorCdgoDescuento(WebElement carroLblErrorCdgoDescuento) {
		this.carroLblErrorCdgoDescuento = carroLblErrorCdgoDescuento;
	}

	public WebElement getLoginTxtRecordarClave() {
		return loginTxtRecordarClave;
	}

	public void setLoginTxtRecordarClave(WebElement loginTxtRecordarClave) {
		this.loginTxtRecordarClave = loginTxtRecordarClave;
	}

	public WebElement getPdpSelectGarantia() {
		return pdpSelectGarantia;
	}

	public void setPdpSelectGarantia(WebElement pdpSelectGarantia) {
		this.pdpSelectGarantia = pdpSelectGarantia;
	}


	public List<WebElement> getCheckOutListTarjetasCredito() {
		return checkOutListTarjetasCredito;
	}

	public void setCheckOutListTarjetasCredito(List<WebElement> checkOutListTarjetasCredito) {
		this.checkOutListTarjetasCredito = checkOutListTarjetasCredito;
	}

	public WebElement getCheckOutListTarjetasCreditoCenco() {
		return checkOutListTarjetasCreditoCenco;
	}

	public void setCheckOutListTarjetasCreditoCenco(WebElement checkOutListTarjetasCreditoCenco) {
		this.checkOutListTarjetasCreditoCenco = checkOutListTarjetasCreditoCenco;
	}

	

	public WebElement getCheckoutInputNumero() {
		return checkoutInputNumero;
	}

	public void setCheckoutInputNumero(WebElement checkoutInputNumero) {
		this.checkoutInputNumero = checkoutInputNumero;
	}

	public WebElement getCheckoutSelectRegion() {
		return checkoutSelectRegion;
	}

	public void setCheckoutSelectRegion(WebElement checkoutSelectRegion) {
		this.checkoutSelectRegion = checkoutSelectRegion;
	}

	public WebElement getCheckoutSelectComuna() {
		return checkoutSelectComuna;
	}

	public void setCheckoutSelectComuna(WebElement checkoutSelectComuna) {
		this.checkoutSelectComuna = checkoutSelectComuna;
	}

	public WebElement getCheckoutInputCalle() {
		return checkoutInputCalle;
	}

	public void setCheckoutInputCalle(WebElement checkoutInputCalle) {
		this.checkoutInputCalle = checkoutInputCalle;
	}

	public WebElement getCheckoutBtnCreditCard() {
		return checkoutBtnCreditCard;
	}

	public void setCheckoutBtnCreditCard(WebElement checkoutBtnCreditCard) {
		this.checkoutBtnCreditCard = checkoutBtnCreditCard;
	}

	public WebElement getCheckoutBtnIngresaDatosFactura() {
		return checkoutBtnIngresaDatosFactura;
	}

	public void setCheckoutBtnIngresaDatosFactura(WebElement checkoutBtnIngresaDatosFactura) {
		this.checkoutBtnIngresaDatosFactura = checkoutBtnIngresaDatosFactura;
	}

	public WebElement getCheckoutInputEmpresaFactura() {
		return checkoutInputEmpresaFactura;
	}

	public void setCheckoutInputEmpresaFactura(WebElement checkoutInputEmpresaFactura) {
		this.checkoutInputEmpresaFactura = checkoutInputEmpresaFactura;
	}

	public WebElement getCheckoutInputRazonSocialFactura() {
		return checkoutInputRazonSocialFactura;
	}

	public void setCheckoutInputRazonSocialFactura(WebElement checkoutInputRazonSocialFactura) {
		this.checkoutInputRazonSocialFactura = checkoutInputRazonSocialFactura;
	}

	public WebElement getCheckoutSelectRegionFactura() {
		return checkoutSelectRegionFactura;
	}

	public void setCheckoutSelectRegionFactura(WebElement checkoutSelectRegionFactura) {
		this.checkoutSelectRegionFactura = checkoutSelectRegionFactura;
	}

	public WebElement getCheckoutInputCalleFactura() {
		return checkoutInputCalleFactura;
	}

	public void setCheckoutInputCalleFactura(WebElement checkoutInputCalleFactura) {
		this.checkoutInputCalleFactura = checkoutInputCalleFactura;
	}

	public WebElement getCheckoutInputNumCasaDeptoFactura() {
		return checkoutInputNumCasaDeptoFactura;
	}

	public void setCheckoutInputNumCasaDeptoFactura(WebElement checkoutInputNumCasaDeptoFactura) {
		this.checkoutInputNumCasaDeptoFactura = checkoutInputNumCasaDeptoFactura;
	}

	public WebElement getCheckoutInputPersContactoFactura() {
		return checkoutInputPersContactoFactura;
	}

	public void setCheckoutInputPersContactoFactura(WebElement checkoutInputPersContactoFactura) {
		this.checkoutInputPersContactoFactura = checkoutInputPersContactoFactura;
	}

	public WebElement getCheckoutInputRutFactura() {
		return checkoutInputRutFactura;
	}

	public void setCheckoutInputRutFactura(WebElement checkoutInputRutFactura) {
		this.checkoutInputRutFactura = checkoutInputRutFactura;
	}

	public WebElement getCheckoutInputGiroFactura() {
		return checkoutInputGiroFactura;
	}

	public void setCheckoutInputGiroFactura(WebElement checkoutInputGiroFactura) {
		this.checkoutInputGiroFactura = checkoutInputGiroFactura;
	}

	public WebElement getCheckoutSelectComunaFactura() {
		return checkoutSelectComunaFactura;
	}

	public void setCheckoutSelectComunaFactura(WebElement checkoutSelectComunaFactura) {
		this.checkoutSelectComunaFactura = checkoutSelectComunaFactura;
	}

	public WebElement getCheckoutInputNumeroFactura() {
		return checkoutInputNumeroFactura;
	}

	public void setCheckoutInputNumeroFactura(WebElement checkoutInputNumeroFactura) {
		this.checkoutInputNumeroFactura = checkoutInputNumeroFactura;
	}

	public WebElement getCheckoutInputFonoFactura() {
		return checkoutInputFonoFactura;
	}

	public void setCheckoutInputFonoFactura(WebElement checkoutInputFonoFactura) {
		this.checkoutInputFonoFactura = checkoutInputFonoFactura;
	}

	public WebElement getCheckoutInputEmailFactura() {
		return checkoutInputEmailFactura;
	}

	public void setCheckoutInputEmailFactura(WebElement checkoutInputEmailFactura) {
		this.checkoutInputEmailFactura = checkoutInputEmailFactura;
	}

	public WebElement getCheckoutBtnGuardarDatosFactura() {
		return checkoutBtnGuardarDatosFactura;
	}

	public void setCheckoutBtnGuardarDatosFactura(WebElement checkoutBtnGuardarDatosFactura) {
		this.checkoutBtnGuardarDatosFactura = checkoutBtnGuardarDatosFactura;
	}

	public WebElement getCheckoutBtnCancelarFactura() {
		return checkoutBtnCancelarFactura;
	}

	public void setCheckoutBtnCancelarFactura(WebElement checkoutBtnCancelarFactura) {
		this.checkoutBtnCancelarFactura = checkoutBtnCancelarFactura;
	}

	public WebElement getCheckOutTxtApellidoTitularTarjetaCredito() {
		return checkOutTxtApellidoTitularTarjetaCredito;
	}

	public void setCheckOutTxtApellidoTitularTarjetaCredito(WebElement checkOutTxtApellidoTitularTarjetaCredito) {
		this.checkOutTxtApellidoTitularTarjetaCredito = checkOutTxtApellidoTitularTarjetaCredito;
	}

	public WebElement getCheckOutSelectCuotasTarjetaCredito() {
		return checkOutSelectCuotasTarjetaCredito;
	}

	public void setCheckOutSelectCuotasTarjetaCredito(WebElement checkOutSelectCuotasTarjetaCredito) {
		this.checkOutSelectCuotasTarjetaCredito = checkOutSelectCuotasTarjetaCredito;
	}

	public List<WebElement> getCheckoutListRadioTipoDespachoProgramado() {
		return checkoutListRadioTipoDespachoProgramado;
	}

	public void setCheckoutListRadioTipoDespachoProgramado(List<WebElement> checkoutListRadioTipoDespachoProgramado) {
		this.checkoutListRadioTipoDespachoProgramado = checkoutListRadioTipoDespachoProgramado;
	}

	public WebElement getCheckOutHrefRedCompra() {
		return checkOutHrefRedCompra;
	}

	public void setCheckOutHrefRedCompra(WebElement checkOutHrefRedCompra) {
		this.checkOutHrefRedCompra = checkOutHrefRedCompra;
	}

	public WebElement getLoginTxtNombre() {
		return loginTxtNombre;
	}

	public void setLoginTxtNombre(WebElement loginTxtNombre) {
		this.loginTxtNombre = loginTxtNombre;
	}

	public WebElement getLoginTxtApellido() {
		return loginTxtApellido;
	}

	public void setLoginTxtApellido(WebElement loginTxtApellido) {
		this.loginTxtApellido = loginTxtApellido;
	}

	public WebElement getLoginTxtEmail() {
		return loginTxtEmail;
	}

	public void setLoginTxtEmail(WebElement loginTxtEmail) {
		this.loginTxtEmail = loginTxtEmail;
	}

	public WebElement getLoginComboCodTel() {
		return loginComboCodTel;
	}

	public void setLoginComboCodTel(WebElement loginComboCodTel) {
		this.loginComboCodTel = loginComboCodTel;
	}

	public WebElement getLoginTxtTelefono() {
		return loginTxtTelefono;
	}

	public void setLoginTxtTelefono(WebElement loginTxtTelefono) {
		this.loginTxtTelefono = loginTxtTelefono;
	}

	public WebElement getLoginRadioBtnRut() {
		return loginRadioBtnRut;
	}

	public void setLoginRadioBtnRut(WebElement loginRadioBtnRut) {
		this.loginRadioBtnRut = loginRadioBtnRut;
	}

	public WebElement getLoginRadioBtnDni() {
		return loginRadioBtnDni;
	}

	public void setLoginRadioBtnDni(WebElement loginRadioBtnDni) {
		this.loginRadioBtnDni = loginRadioBtnDni;
	}

	public WebElement getLoginTxtDni() {
		return loginTxtDni;
	}

	public void setLoginTxtDni(WebElement loginTxtDni) {
		this.loginTxtDni = loginTxtDni;
	}

	public WebElement getLoginTxtRut() {
		return loginTxtRut;
	}

	public void setLoginTxtRut(WebElement loginTxtRut) {
		this.loginTxtRut = loginTxtRut;
	}

	public WebElement getLoginTxtClaveReg() {
		return loginTxtClaveReg;
	}

	public void setLoginTxtClaveReg(WebElement loginTxtClaveReg) {
		this.loginTxtClaveReg = loginTxtClaveReg;
	}

	public WebElement getLoginTxtClaveRegconfirm() {
		return loginTxtClaveRegconfirm;
	}

	public void setLoginTxtClaveRegconfirm(WebElement loginTxtClaveRegconfirm) {
		this.loginTxtClaveRegconfirm = loginTxtClaveRegconfirm;
	}

	public WebElement getLoginBtnRegistrar() {
		return loginBtnRegistrar;
	}

	public void setLoginBtnRegistrar(WebElement loginBtnRegistrar) {
		this.loginBtnRegistrar = loginBtnRegistrar;
	}

	public WebElement getCheckOutTextPass() {
		return CheckOutTextPass;
	}

	public void setCheckOutTextPass(WebElement checkOutTextPass) {
		CheckOutTextPass = checkOutTextPass;
	}

	public WebElement getCheckOutTextPassConfirm() {
		return CheckOutTextPassConfirm;
	}

	public void setCheckOutTextPassConfirm(WebElement checkOutTextPassConfirm) {
		CheckOutTextPassConfirm = checkOutTextPassConfirm;
	}

	public WebElement getCheckOutBtnCrearCuenta() {
		return CheckOutBtnCrearCuenta;
	}

	public void setCheckOutBtnCrearCuenta(WebElement checkOutBtnCrearCuenta) {
		CheckOutBtnCrearCuenta = checkOutBtnCrearCuenta;
	}

	public WebElement getCheckoutBtnRetiroTienda() {
		return checkoutBtnRetiroTienda;
	}

	public void setCheckoutBtnRetiroTienda(WebElement checkoutBtnRetiroTienda) {
		this.checkoutBtnRetiroTienda = checkoutBtnRetiroTienda;
	}



	public List<WebElement> getCheckoutListUbicacionesRetiroTienda() {
		return checkoutListUbicacionesRetiroTienda;
	}

	public void setCheckoutListUbicacionesRetiroTienda(List<WebElement> checkoutListUbicacionesRetiroTienda) {
		this.checkoutListUbicacionesRetiroTienda = checkoutListUbicacionesRetiroTienda;
	}

	public WebElement getCheckoutDivNumOrdenCompra() {
		return checkoutDivNumOrdenCompra;
	}

	public void setCheckoutDivNumOrdenCompra(WebElement checkoutDivNumOrdenCompra) {
		this.checkoutDivNumOrdenCompra = checkoutDivNumOrdenCompra;
	}

	public WebElement getPdpLblVerificarStock() {
		return pdpLblVerificarStock;
	}

	public void setPdpLblVerificarStock(WebElement pdpLblVerificarStock) {
		this.pdpLblVerificarStock = pdpLblVerificarStock;
	}

	public WebElement getCheckOutTxtApellidoTitularTarjetaCreditoCenco() {
		return checkOutTxtApellidoTitularTarjetaCreditoCenco;
	}

	public void setCheckOutTxtApellidoTitularTarjetaCreditoCenco(WebElement checkOutTxtApellidoTitularTarjetaCreditoCenco) {
		this.checkOutTxtApellidoTitularTarjetaCreditoCenco = checkOutTxtApellidoTitularTarjetaCreditoCenco;
	}

	public WebElement getCheckoutBtnNewCardCredit() {
		return checkoutBtnNewCardCredit;
	}

	public void setCheckoutBtnNewCardCredit(WebElement checkoutBtnNewCardCredit) {
		this.checkoutBtnNewCardCredit = checkoutBtnNewCardCredit;
	}

	public WebElement getCheckOutTxtCuotasTarjetaCreditoCenco() {
		return checkOutTxtCuotasTarjetaCreditoCenco;
	}

	public void setCheckOutTxtCuotasTarjetaCreditoCenco(WebElement checkOutTxtCuotasTarjetaCreditoCenco) {
		this.checkOutTxtCuotasTarjetaCreditoCenco = checkOutTxtCuotasTarjetaCreditoCenco;
	}

	public WebElement getCheckoutBtnRealizarPedidoCenco() {
		return checkoutBtnRealizarPedidoCenco;
	}

	public void setCheckoutBtnRealizarPedidoCenco(WebElement checkoutBtnRealizarPedidoCenco) {
		this.checkoutBtnRealizarPedidoCenco = checkoutBtnRealizarPedidoCenco;
	}

	

	public List<WebElement> getCheckoutRadioSeleccionRedCompra() {
		return checkoutRadioSeleccionRedCompra;
	}

	public void setCheckoutRadioSeleccionRedCompra(List<WebElement> checkoutRadioSeleccionRedCompra) {
		this.checkoutRadioSeleccionRedCompra = checkoutRadioSeleccionRedCompra;
	}

	

	public WebElement getCheckoutListBancosRedCompra() {
		return checkoutListBancosRedCompra;
	}

	public void setCheckoutListBancosRedCompra(WebElement checkoutListBancosRedCompra) {
		this.checkoutListBancosRedCompra = checkoutListBancosRedCompra;
	}

	public WebElement getCheckoutNumeroTarjetaRedCompra() {
		return checkoutNumeroTarjetaRedCompra;
	}

	public void setCheckoutNumeroTarjetaRedCompra(WebElement checkoutNumeroTarjetaRedCompra) {
		this.checkoutNumeroTarjetaRedCompra = checkoutNumeroTarjetaRedCompra;
	}

	public WebElement getCheckoutTxtRutRedCompra() {
		return checkoutTxtRutRedCompra;
	}

	public void setCheckoutTxtRutRedCompra(WebElement checkoutTxtRutRedCompra) {
		this.checkoutTxtRutRedCompra = checkoutTxtRutRedCompra;
	}

	public WebElement getCheckoutTxtClaveRedCompra() {
		return checkoutTxtClaveRedCompra;
	}

	public void setCheckoutTxtClaveRedCompra(WebElement checkoutTxtClaveRedCompra) {
		this.checkoutTxtClaveRedCompra = checkoutTxtClaveRedCompra;
	}

	public WebElement getCheckoutBtnPagarRedCompra() {
		return checkoutBtnPagarRedCompra;
	}

	public void setCheckoutBtnPagarRedCompra(WebElement checkoutBtnPagarRedCompra) {
		this.checkoutBtnPagarRedCompra = checkoutBtnPagarRedCompra;
	}

	public WebElement getCheckoutBtnRealizarPedidoRedCompra() {
		return checkoutBtnRealizarPedidoRedCompra;
	}

	public void setCheckoutBtnRealizarPedidoRedCompra(WebElement checkoutBtnRealizarPedidoRedCompra) {
		this.checkoutBtnRealizarPedidoRedCompra = checkoutBtnRealizarPedidoRedCompra;
	}

	public List<WebElement> getCheckoutListDireccionesRetiroTienda() {
		return checkoutListDireccionesRetiroTienda;
	}

	public void setCheckoutListDireccionesRetiroTienda(List<WebElement> checkoutListDireccionesRetiroTienda) {
		this.checkoutListDireccionesRetiroTienda = checkoutListDireccionesRetiroTienda;
	}

	public WebElement getCheckoutSelectRegionRetiroTienda() {
		return checkoutSelectRegionRetiroTienda;
	}

	public void setCheckoutSelectRegionRetiroTienda(WebElement checkoutSelectRegionRetiroTienda) {
		this.checkoutSelectRegionRetiroTienda = checkoutSelectRegionRetiroTienda;
	}

	public WebElement getCheckoutFrameRedCompra() {
		return checkoutFrameRedCompra;
	}

	public void setCheckoutFrameRedCompra(WebElement checkoutFrameRedCompra) {
		this.checkoutFrameRedCompra = checkoutFrameRedCompra;
	}

	public WebElement getCheckoutPagarRedCompra() {
		return checkoutPagarRedCompra;
	}

	public void setCheckoutPagarRedCompra(WebElement checkoutPagarRedCompra) {
		this.checkoutPagarRedCompra = checkoutPagarRedCompra;
	}

	public WebElement getCheckoutContinuarRedCompra() {
		return checkoutContinuarRedCompra;
	}

	public void setCheckoutContinuarRedCompra(WebElement checkoutContinuarRedCompra) {
		this.checkoutContinuarRedCompra = checkoutContinuarRedCompra;
	}

	public List<WebElement> getCheckoutListRadioDespachoProgramado() {
		return checkoutListRadioDespachoProgramado;
	}

	public void setCheckoutListRadioDespachoProgramado(List<WebElement> checkoutListRadioDespachoProgramado) {
		this.checkoutListRadioDespachoProgramado = checkoutListRadioDespachoProgramado;
	}

	public WebElement getCheckoutTotalCompra() {
		return checkoutTotalCompra;
	}

	public void setCheckoutTotalCompra(WebElement checkoutTotalCompra) {
		this.checkoutTotalCompra = checkoutTotalCompra;
	}

	public WebElement getCheckoutCodigoGiftcard() {
		return checkoutCodigoGiftcard;
	}

	public void setCheckoutCodigoGiftcard(WebElement checkoutCodigoGiftcard) {
		this.checkoutCodigoGiftcard = checkoutCodigoGiftcard;
	}

	public WebElement getCheckoutClaveGiftcard() {
		return checkoutClaveGiftcard;
	}

	public void setCheckoutClaveGiftcard(WebElement checkoutClaveGiftcard) {
		this.checkoutClaveGiftcard = checkoutClaveGiftcard;
	}

	public WebElement getCheckoutAplicarGiftcard() {
		return checkoutAplicarGiftcard;
	}

	public void setCheckoutAplicarGiftcard(WebElement checkoutAplicarGiftcard) {
		this.checkoutAplicarGiftcard = checkoutAplicarGiftcard;
	}

	public WebElement getCheckourHrefGiftCard() {
		return checkourHrefGiftCard;
	}

	public void setCheckourHrefGiftCard(WebElement checkourHrefGiftCard) {
		this.checkourHrefGiftCard = checkourHrefGiftCard;
	}

	public WebElement getCheckouthrefMetodosPago() {
		return checkouthrefMetodosPago;
	}

	public void setCheckouthrefMetodosPago(WebElement checkouthrefMetodosPago) {
		this.checkouthrefMetodosPago = checkouthrefMetodosPago;
	}


}