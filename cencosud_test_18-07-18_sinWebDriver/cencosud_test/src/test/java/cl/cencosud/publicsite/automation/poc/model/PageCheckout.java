package cl.cencosud.publicsite.automation.poc.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageCheckout {
	
	//Detalles tipo de usuario
	@FindBy(how = How.NAME, using = "dwfrm_login_unregistered")
	private WebElement checkoutBtnInvitado;
	@FindBy(how = How.ID, using = "dwfrm_login_username_d0eghnpvyfin")
	private WebElement checkoutInputCorreoUsuario;
	@FindBy(how = How.ID, using = "dwfrm_login_password_d0dogbcxyhfq")
	private WebElement checkoutInputPasswordUsuario;
	@FindBy(how = How.NAME, using = "dwfrm_login_login")
	private WebElement checkoutBtnIniciarSesion;
	//Formulario compra como invitado
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_firstname")
	private WebElement checkoutInputNombre ;
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_lastname")
	private WebElement checkoutInputApellido;
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_email")
	private WebElement checkoutInputEmail;
	//Anexo de numero telefonico Ej: +569
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_phoneCode")
	private WebElement checkoutSelectAnexo;
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_phone")
	private WebElement checkoutInputTelefono;
	@FindBy(how = How.XPATH, using = "//*[@id=\"personal-details-form\"]/div[5]/div[1]/div/label[1]")
	private WebElement checkoutRadioBtnRut;
	@FindBy(how = How.XPATH, using = "//*[@id=\"personal-details-form\"]/div[5]/div[1]/div/label[2]")
	private WebElement checkoutRadioBtnDni;
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_rut")
	private WebElement checkoutInputRut;
	@FindBy(how = How.ID, using = "dwfrm_personaldetails_dni")
	private WebElement checkoutInputDni;
	@FindBy(how = How.NAME, using = "dwfrm_personaldetails_continue")
	private WebElement checkoutBtncontinuar;
	//Formulario Despacho a domicilio o Retiro en tienda
	@FindBy(how = How.ID, using = "shipping-method-select-1")
	private WebElement checkoutBtnDespachoDomicilio;
	@FindBy(how = How.ID, using = "shipping-method-select-4")
	private WebElement checkoutBtnRetiroEnTienda;	
	//Datos de despacho a domicilio
	@FindBy(how = How.ID, using = "searchTextField")
	private WebElement checkoutInputIntroduceUbicacion;
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_addressID")
	private WebElement checkoutInputDireccionDespacho;
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_address3")
	private WebElement checkoutInputNumCasaDepartamento;
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_postal")
	private WebElement checkoutInputCodPostal;
	@FindBy(how = How.XPATH, using = "//*[@id=\"shipping-method-types\"]/div/div/div/div/fieldset[1]/div[2]/div[9]/a")
	private WebElement checkoutBtnDireccionManual;
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_states_state")
	private WebElement checkoutSelectRegion;
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_city")
	private WebElement checkoutSelectComuna;
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_address1")
	private WebElement checkoutInputCalle;
	@FindBy(how = How.ID, using = "dwfrm_singleshipping_shippingAddress_addressFields_address2")
	private WebElement checkoutInputNumero;
	@FindBy(how = How.NAME, using = "dwfrm_singleshipping_shippingAddress_save")
	private WebElement checkoutBtnContinuarFacturacion;
	@FindBy(how = How.ID, using = "shipping-method-1")
	private WebElement checkoutRadioBtnStandardDespacho;
	@FindBy(how = How.ID, using = "shipping-method-2")
	private WebElement checkoutRadioBtnProgramDespacho;


	
	
	
	
	

}
