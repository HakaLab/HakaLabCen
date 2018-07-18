package cl.cencosud.publicsite.automation.poc.model;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class PageModel {

//HOMEPAGE
	//iniciar sesion
	@FindBy(how = How.ID, using = "clickLogin") //rodolfo
	private WebElement homeBtnInicioSesion;
	//Busqueda en imagen 'Lupa' o solo con enter  sin ID
	@FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[4]/div[1]/form/div/input")
	private WebElement homeBtnBuscar;
	//Busqueda en Textbox 'Que estas buscando del homePage' ID = "q"
	@FindBy(how = How.XPATH, using = "//*[@id=\"q\"]")
	private WebElement homeTxtIngresobusqueda;

	//PDP
	//seleccionar cantidad  del producto a comprar ID=Quantity
	@FindBy(how = How.ID, using = "Quantity")
	private WebElement pdpCantidad;
	//Boton Agregar al carro de compras  ID add-to-cart
	@FindBy(how = How.ID, using = "add-to-cart")
	private WebElement pdpAgregarCarro;
//	@FindBy(how = How.CLASS_NAME, using = "uno mini-cart-link-cart")
//	private WebElement pdpBtnVerCarro;
	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[2]/div[2]/a[1]")
	private WebElement pdpBtnVerCarro;
	@FindBy(how = How.XPATH, using = "//*[@id=\"mini-cart\"]/div[2]/div[2]/div[2]/a[2]")
	private WebElement pdpBtnComprar;
	@FindBy(how = How.XPATH, using = "//*[@id=\"ext-gen44\"]/body/div[4]/div[3]/div/button[1]")
	private WebElement pdpBtnNoGracias;//Ventana desplegada Producto bonificado boton no gracias Rodolfo
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'swatchanchor')]")
	private List<WebElement> checkOutRadioColores;//CAMBIO RECIENTE

	@FindBy(how = How.XPATH, using = "input-radio js-shipping-method-option")
	private List<WebElement> checkoutRadioBtnOptionDespacho;//CAMBIO RECIENTE
	@FindBy(how = How.XPATH, using = "//*[@id=\"shipping-method-types\"]/div/div/div/div/fieldset[2]/div/button")
	private WebElement checkoutBtnContinuarOpcionDespacho;//CAMBIO RECIENTE
	@FindBy(how = How.ID, using = "dwopt_123423-999-_696544-999-")
	private WebElement pdpAssembly;//Cambio reciente
	
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"shipping-method-1\"]")
	private WebElement checkoutRadioBtnStandardDespacho;//Rodolfo
	

	@FindBy(how = How.XPATH, using = "//*[@id=\"shipping-method-2\"]")
	private WebElement checkoutRadioBtnProgramDespacho;//Rodolfo
	
	
	
	@FindBy(how = How.ID, using = "va-size")
	private WebElement checkOutSelectTalla;
	
//CARRO COMPRA
	@FindBy(how = How.NAME, using = "dwfrm_cart_checkoutCart")
	private WebElement carroBtnIrALaCaja;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"primary\"]/div[1]/div[2]/div/div/div[2]/div/form/div/button")
	private WebElement checkoutBtnCompraGuest;



	//CHECKOUT
	//Detalles tipo de usuario
	@FindBy(how = How.NAME, using = "dwfrm_login_unregistered")//Rodolfo
	private WebElement checkoutBtnInvitado;
	//Formulario informacion de despacho
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
	private WebElement checkoutInputRut;//Cambio Nombre Rodolfo
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_dni")
	private WebElement checkoutInputDni;//Cambio Nombre Rodolfo
	@FindBy(how = How.NAME, using = "dwfrm_personaldetails_continue")
	private WebElement checkoutBtncontinuar;//Cambio Nombre Rodolfo
	@FindBy(how = How.ID, using = "shipping-method-select-1")
	private WebElement checkoutBtnDespachoDomicilio;
	@FindBy(how = How.ID, using = "shipping-method-select-4")
	private WebElement checkoutBtnRetiroEnTienda;//Rodolfo 
	@FindBy(how = How.XPATH, using = "//*[@id=\"shipping-method-types\"]/div/div/div/div/fieldset[1]/div[2]/div[9]/a")
	private WebElement checkoutBtnDireccionManual; //Rodolfo
	
	//Datos de despacho a domicilio
	
	@FindBy(how = How.ID, using = "searchTextField")
	private WebElement checkoutInputIntroduceUbicacion;//Rodolfo
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_addressID")
	private WebElement checkoutInputDireccionDespacho;//Rodolfo
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_address3")
	private WebElement checkoutInputNumCasaDepartamento;//Rodolfo
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_postal")
	private WebElement checkoutInputCodPostal;//Rodolfo
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_states_state")
	private WebElement checkoutSelectRegion;//Rodolfo
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_city")
	private WebElement checkoutSelectComuna;//Rodolfo
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_address1")
	private WebElement checkoutInputCalle;//Rodolfo
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_address2")
	private WebElement checkoutInputNumero;//Rodolfo
	@FindBy(how = How.NAME, using = "dwfrm_singleshipping_shippingAddress_save")
	private WebElement checkoutBtnContinuarFacturacion;//Rodolfo
	@FindBy(how = How.XPATH, using = "//*[@id=\"shipping-method-types\"]/div/div/div/div/fieldset[1]/div[2]/div[9]/a")
	private WebElement checkoutBtnAddAddress;

	
	
	
//PDP FRAME BONIFICACIO
	@FindBy(how = How.XPATH, using = "//*[@id=\"ext-gen44\"]/body/div[4]/div[3]/div/button[1]/span")
	private WebElement FramePDP_btnNoGracias;
	@FindBy(how = How.XPATH, using = "//*[@id=\"ext-gen44\"]/body/div[4]/div[3]/div/button[2]/span")
	private WebElement FramePDP_selectSeleccioneBonificacion;
	@FindBy(how = How.XPATH, using = "//*[@id=\"ext-gen44\"]/body/div[4]/div[1]/button/span[1]")
	private WebElement FramePDP_btnCerrarFrame;
	
	//PDP CARRO DE COMPRA
	@FindBy(how = How.ID, using = "dwfrm_cart_couponCode")
	private WebElement pdpInputCuponCode;//Rodolfo
	@FindBy(how = How.ID, using = "add-coupon")
	private WebElement pdpBtnAplicar;//Rodolfo

	//Seleccionar producto por descripcion
	@FindBy(how = How.XPATH, using ="*[@id=\"753ac7d0fb9e3db2e3548c46c9\"]/div[3]/a/div/p")
	private WebElement seleccionDescripcionProducto;
	//Seleccionar producto por imagen
	@FindBy(how = How.XPATH, using = "//*[@id=\"753ac7d0fb9e3db2e3548c46c9\"]/div[2]/div[1]/a/img")
	private WebElement seleccionImagenProducto;
	//Ver disponibilidad de despacho a domicilio
	@FindBy(how = How.XPATH,using ="//*[@id=\"product-content\"]/div[5]/div/a/strong")
	private WebElement disponibilidadDespachoADomicilio;
	//Frame de disponibilidad de despacho
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

	@FindBy(how = How.ID, using = "dwfrm_personaldetails_rut")
	private WebElement rut;

	
	//RadioButton de seleccion de rut o DNI
	@FindBy(how = How.XPATH,using = "dwfrm_personaldetails_identityOption_RUT")
	private WebElement rutOrDni;

	@FindBy(how = How.ID, using = "crdName")
	private WebElement tipoDespacho;

	@FindBy(how = How.XPATH, using = "//*[@id=\"dwfrm_billing\"]/div/div[1]/a")
	private WebElement logoMetodoPago;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cart-items-form\"]/fieldset/div[1]")
	private WebElement objetoCart;
	
	
	
	public WebElement getPdpAssembly() {
		return pdpAssembly;
	}

	public void setPdpAssembly(WebElement pdpAssembly) {
		this.pdpAssembly = pdpAssembly;
	}

	public WebElement getCheckoutBtnContinuarOpcionDespacho() {
		return checkoutBtnContinuarOpcionDespacho;
	}

	public void setCheckoutBtnContinuarOpcionDespacho(WebElement checkoutBtnContinuarOpcionDespacho) {
		this.checkoutBtnContinuarOpcionDespacho = checkoutBtnContinuarOpcionDespacho;
	}
	
	public WebElement getCheckoutRadioBtnStandardDespacho() {
		return checkoutRadioBtnStandardDespacho;
	}

	public void setCheckoutRadioBtnStandardDespacho(WebElement checkoutRadioBtnStandardDespacho) {
		this.checkoutRadioBtnStandardDespacho = checkoutRadioBtnStandardDespacho;
	}

	public WebElement getCheckoutRadioBtnProgramDespacho() {
		return checkoutRadioBtnProgramDespacho;
	}

	public void setCheckoutRadioBtnProgramDespacho(WebElement checkoutRadioBtnProgramDespacho) {
		this.checkoutRadioBtnProgramDespacho = checkoutRadioBtnProgramDespacho;
	}

	public WebElement getCheckoutInputIntroduceUbicacion() {
		return checkoutInputIntroduceUbicacion;
	}

	public void setCheckoutInputIntroduceUbicacion(WebElement checkoutInputIntroduceUbicacion) {
		this.checkoutInputIntroduceUbicacion = checkoutInputIntroduceUbicacion;
	}

	public WebElement getCheckoutBtnDireccionManual() {
		return checkoutBtnDireccionManual;
	}

	public void setCheckoutBtnDireccionManual(WebElement checkoutBtnDireccionManual) {
		this.checkoutBtnDireccionManual = checkoutBtnDireccionManual;
	}

	public WebElement getCheckoutBtnRetiroEnTienda() {
		return checkoutBtnRetiroEnTienda;
	}

	public void setCheckoutBtnRetiroEnTienda(WebElement checkoutBtnRetiroEnTienda) {
		this.checkoutBtnRetiroEnTienda = checkoutBtnRetiroEnTienda;
	}

	public WebElement getPdpInputCuponCode() {
		return pdpInputCuponCode;
	}

	public void setPdpInputCuponCode(WebElement pdpInputCuponCode) {
		this.pdpInputCuponCode = pdpInputCuponCode;
	}

	public WebElement getPdpBtnAplicar() {
		return pdpBtnAplicar;
	}

	public void setPdpBtnAplicar(WebElement pdpBtnAplicar) {
		this.pdpBtnAplicar = pdpBtnAplicar;
	}

	public WebElement getPdpBtnNoGracias() {
		return pdpBtnNoGracias;
	}

	public void setPdpBtnNoGracias(WebElement pdpBtnNoGracias) {
		this.pdpBtnNoGracias = pdpBtnNoGracias;
	}

	public WebElement getHomeBtnBuscar() {
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

	public WebElement getCheckoutBtncontinuar() {
		return checkoutBtncontinuar;
	}

	public void setCheckoutBtncontinuar(WebElement checkoutBtncontinuar) {
		this.checkoutBtncontinuar = checkoutBtncontinuar;
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

	public WebElement getCheckoutInputDireccionDespacho() {
		return checkoutInputDireccionDespacho;
	}

	public void setCheckoutInputDireccionDespacho(WebElement checkoutInputDireccionDespacho) {
		this.checkoutInputDireccionDespacho = checkoutInputDireccionDespacho;
	}

	public WebElement getCheckoutInputNumCasaDepartamento() {
		return checkoutInputNumCasaDepartamento;
	}

	public void setCheckoutInputNumCasaDepartamento(WebElement checkoutInputNumCasaDepartamento) {
		this.checkoutInputNumCasaDepartamento = checkoutInputNumCasaDepartamento;
	}

	public WebElement getCheckoutInputCodPostal() {
		return checkoutInputCodPostal;
	}

	public void setCheckoutInputCodPostal(WebElement checkoutInputCodPostal) {
		this.checkoutInputCodPostal = checkoutInputCodPostal;
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

	public WebElement getCheckoutInputNumero() {
		return checkoutInputNumero;
	}

	public void setCheckoutInputNumero(WebElement checkoutInputNumero) {
		this.checkoutInputNumero = checkoutInputNumero;
	}

	public WebElement getCheckoutBtnContinuarFacturacion() {
		return checkoutBtnContinuarFacturacion;
	}

	public void setCheckoutBtnContinuarFacturacion(WebElement checkoutBtnContinuarFacturacion) {
		this.checkoutBtnContinuarFacturacion = checkoutBtnContinuarFacturacion;
	}

	public WebElement getFramePDP_btnNoGracias() {
		return FramePDP_btnNoGracias;
	}

	public void setFramePDP_btnNoGracias(WebElement framePDP_btnNoGracias) {
		FramePDP_btnNoGracias = framePDP_btnNoGracias;
	}

	public WebElement getFramePDP_selectSeleccioneBonificacion() {
		return FramePDP_selectSeleccioneBonificacion;
	}

	public void setFramePDP_selectSeleccioneBonificacion(WebElement framePDP_selectSeleccioneBonificacion) {
		FramePDP_selectSeleccioneBonificacion = framePDP_selectSeleccioneBonificacion;
	}

	public WebElement getFramePDP_btnCerrarFrame() {
		return FramePDP_btnCerrarFrame;
	}

	public void setFramePDP_btnCerrarFrame(WebElement framePDP_btnCerrarFrame) {
		FramePDP_btnCerrarFrame = framePDP_btnCerrarFrame;
	}

	public WebElement getSeleccionDescripcionProducto() {
		return seleccionDescripcionProducto;
	}

	public void setSeleccionDescripcionProducto(WebElement seleccionDescripcionProducto) {
		this.seleccionDescripcionProducto = seleccionDescripcionProducto;
	}

	public WebElement getSeleccionImagenProducto() {
		return seleccionImagenProducto;
	}

	public void setSeleccionImagenProducto(WebElement seleccionImagenProducto) {
		this.seleccionImagenProducto = seleccionImagenProducto;
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

	public WebElement getRut() {
		return rut;
	}

	public void setRut(WebElement rut) {
		this.rut = rut;
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

	public WebElement getTipoDespacho() {
		return tipoDespacho;
	}

	public void setTipoDespacho(WebElement tipoDespacho) {
		this.tipoDespacho = tipoDespacho;
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
	
	public WebElement getCheckoutBtnInvitado() {
		return checkoutBtnInvitado;
	}

	public void setCheckoutBtnInvitado(WebElement checkoutBtnInvitado) {
		this.checkoutBtnInvitado = checkoutBtnInvitado;
	}

	public WebElement getHomeBtnInicioSesion() {
		return homeBtnInicioSesion;
	}

	public List<WebElement> getCheckoutRadioBtnOptionDespacho() {
		return checkoutRadioBtnOptionDespacho;
	}

	public void setCheckoutRadioBtnOptionDespacho(List<WebElement> checkoutRadioBtnOptionDespacho) {
		this.checkoutRadioBtnOptionDespacho = checkoutRadioBtnOptionDespacho;
	}

	public void setHomeBtnInicioSesion(WebElement homeBtnInicioSesion) {
		this.homeBtnInicioSesion = homeBtnInicioSesion;
	}

	public List<WebElement> getCheckOutRadioColores() {
		return checkOutRadioColores;
	}

	public void setCheckOutRadioColores(List<WebElement> checkOutRadioColores) {
		this.checkOutRadioColores = checkOutRadioColores;
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

	public WebElement getCheckOutSelectTalla() {
		return checkOutSelectTalla;
	}

	public void setCheckOutSelectTalla(WebElement checkOutSelectTalla) {
		this.checkOutSelectTalla = checkOutSelectTalla;
	}
	
	
	
	
}