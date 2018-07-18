package cl.cencosud.publicsite.automation.poc.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class PageComponentFooter {
	@FindBy(how = How.ID, using = "footer")
	private WebElement footerDiv;
	
	@FindBy(how = How.ID, using = "gtm-newsletter-footer")
	private WebElement newletter;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"footer\"]/div/div[1]/div[1]/div[2]/p[1]/strong/a")
	private WebElement numeroAtencionCliente;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"footer\"]/div/div[1]/div[1]/div[2]/p[2]/strong")
	private WebElement numeroVentaTelefonica;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"footer\"]/div/div[1]/div[1]/div[4]/ul/li[1]/a")
	private WebElement linkFacebook;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"footer\"]/div/div[1]/div[1]/div[4]/ul/li[2]/a")
	private WebElement linkTwiter;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"footer\"]/div/div[1]/div[1]/div[4]/ul/li[3]/a")
	private WebElement linkInstagram;
	
	@FindBy(how = How.ID, using = "contacto")
	private WebElement contactanos;
	
	@FindBy(how = How.ID, using = "beneficios_paris")
	private WebElement beneficiosParis;
	
	@FindBy(how = How.ID, using = "terminos_y_condiciones")
	private WebElement terminosCondiciones;
	
	@FindBy(how = How.ID, using = "politicas_prib")
	private WebElement politicaPrivacidad;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"recupera_bol\"]")
	private WebElement recuperaBoleta;
	
	@FindBy(how = How.XPATH, using = "//a[@href=\"http://w2.eol-paris.cl/paris/index.php?r=survey/index&sid=672252&lang=es-CL\"]")
	private WebElement encuestaOpinion;
	
	@FindBy(how = How.ID, using = "ppuntos_cenco")
	private WebElement puntosCencosud;
	
	@FindBy(how = How.ID, using = "tarjeta_cenco")
	private WebElement tarjetasCencosud;
	
	@FindBy(how = How.ID, using = "seguros_cenco")
	private WebElement segurosCencosud;
	
	@FindBy(how = How.ID, using = "venta_empresa")
	private WebElement ventaEmpresa;
	
	@FindBy(how = How.ID, using = "trabaja-paris")
	private WebElement trabajaNosotros;
	
	@FindBy(how = How.ID, using = "devoluciones_camb")
	private WebElement devolucionesCambios;
	
	@FindBy(how = How.ID, using = "despacho")
	private WebElement despacho;
	
	@FindBy(how = How.ID, using = "medios_pago")
	private WebElement mediosPago;
	
	@FindBy(how = How.ID, using = "tiendas_paris")
	private WebElement tiendasParis;
	
	@FindBy(how = How.ID, using = "garantia_extend")
	private WebElement garantiaExtend;
	
	@FindBy(how = How.ID, using = "easy")
	private WebElement easy;
	
	@FindBy(how = How.ID, using = "jumbo")
	private WebElement jumbo;
	
	@FindBy(how = How.ID, using = "johnson")
	private WebElement johnson;
	
	@FindBy(how = How.ID, using = "santa_isabel")
	private WebElement santaIsabel;
	
	@FindBy(how = How.ID, using = "umbralle")
	private WebElement umbralle;
	
	@FindBy(how = How.ID, using = "novios_paris")
	private WebElement noviosParis;
	
	@FindBy(how = How.ID, using = "bebe_paris")
	private WebElement bebeParis;
	
	@FindBy(how = How.ID, using = "casa_paris")
	private WebElement casaParis;

	public WebElement getFooterDiv() {
		return footerDiv;
	}

	public void setFooterDiv(WebElement footerDiv) {
		this.footerDiv = footerDiv;
	}

	public WebElement getNewletter() {
		return newletter;
	}

	public void setNewletter(WebElement newletter) {
		this.newletter = newletter;
	}

	public WebElement getNumeroAtencionCliente() {
		return numeroAtencionCliente;
	}

	public void setNumeroAtencionCliente(WebElement numeroAtencionCliente) {
		this.numeroAtencionCliente = numeroAtencionCliente;
	}

	public WebElement getNumeroVentaTelefonica() {
		return numeroVentaTelefonica;
	}

	public void setNumeroVentaTelefonica(WebElement numeroVentaTelefonica) {
		this.numeroVentaTelefonica = numeroVentaTelefonica;
	}

	public WebElement getLinkFacebook() {
		return linkFacebook;
	}

	public void setLinkFacebook(WebElement linkFacebook) {
		this.linkFacebook = linkFacebook;
	}

	public WebElement getLinkTwiter() {
		return linkTwiter;
	}

	public void setLinkTwiter(WebElement linkTwiter) {
		this.linkTwiter = linkTwiter;
	}

	public WebElement getLinkInstagram() {
		return linkInstagram;
	}

	public void setLinkInstagram(WebElement linkInstagram) {
		this.linkInstagram = linkInstagram;
	}

	public WebElement getContactanos() {
		return contactanos;
	}

	public void setContactanos(WebElement contactanos) {
		this.contactanos = contactanos;
	}

	public WebElement getBeneficiosParis() {
		return beneficiosParis;
	}

	public void setBeneficiosParis(WebElement beneficiosParis) {
		this.beneficiosParis = beneficiosParis;
	}

	public WebElement getTerminosCondiciones() {
		return terminosCondiciones;
	}

	public void setTerminosCondiciones(WebElement terminosCondiciones) {
		this.terminosCondiciones = terminosCondiciones;
	}

	public WebElement getPoliticaPrivacidad() {
		return politicaPrivacidad;
	}

	public void setPoliticaPrivacidad(WebElement politicaPrivacidad) {
		this.politicaPrivacidad = politicaPrivacidad;
	}

	public WebElement getRecuperaBoleta() {
		return recuperaBoleta;
	}

	public void setRecuperaBoleta(WebElement recuperaBoleta) {
		this.recuperaBoleta = recuperaBoleta;
	}

	public WebElement getEncuestaOpinion() {
		return encuestaOpinion;
	}

	public void setEncuestaOpinion(WebElement encuestaOpinion) {
		this.encuestaOpinion = encuestaOpinion;
	}

	public WebElement getPuntosCencosud() {
		return puntosCencosud;
	}

	public void setPuntosCencosud(WebElement puntosCencosud) {
		this.puntosCencosud = puntosCencosud;
	}

	public WebElement getTarjetasCencosud() {
		return tarjetasCencosud;
	}

	public void setTarjetasCencosud(WebElement tarjetasCencosud) {
		this.tarjetasCencosud = tarjetasCencosud;
	}

	public WebElement getSegurosCencosud() {
		return segurosCencosud;
	}

	public void setSegurosCencosud(WebElement segurosCencosud) {
		this.segurosCencosud = segurosCencosud;
	}

	public WebElement getVentaEmpresa() {
		return ventaEmpresa;
	}

	public void setVentaEmpresa(WebElement ventaEmpresa) {
		this.ventaEmpresa = ventaEmpresa;
	}

	public WebElement getTrabajaNosotros() {
		return trabajaNosotros;
	}

	public void setTrabajaNosotros(WebElement trabajaNosotros) {
		this.trabajaNosotros = trabajaNosotros;
	}

	public WebElement getDevolucionesCambios() {
		return devolucionesCambios;
	}

	public void setDevolucionesCambios(WebElement devolucionesCambios) {
		this.devolucionesCambios = devolucionesCambios;
	}

	public WebElement getDespacho() {
		return despacho;
	}

	public void setDespacho(WebElement despacho) {
		this.despacho = despacho;
	}

	public WebElement getMediosPago() {
		return mediosPago;
	}

	public void setMediosPago(WebElement mediosPago) {
		this.mediosPago = mediosPago;
	}

	public WebElement getTiendasParis() {
		return tiendasParis;
	}

	public void setTiendasParis(WebElement tiendasParis) {
		this.tiendasParis = tiendasParis;
	}

	public WebElement getGarantiaExtend() {
		return garantiaExtend;
	}

	public void setGarantiaExtend(WebElement garantiaExtend) {
		this.garantiaExtend = garantiaExtend;
	}

	public WebElement getEasy() {
		return easy;
	}

	public void setEasy(WebElement easy) {
		this.easy = easy;
	}

	public WebElement getJumbo() {
		return jumbo;
	}

	public void setJumbo(WebElement jumbo) {
		this.jumbo = jumbo;
	}

	public WebElement getJohnson() {
		return johnson;
	}

	public void setJohnson(WebElement johnson) {
		this.johnson = johnson;
	}

	public WebElement getSantaIsabel() {
		return santaIsabel;
	}

	public void setSantaIsabel(WebElement santaIsabel) {
		this.santaIsabel = santaIsabel;
	}

	public WebElement getUmbralle() {
		return umbralle;
	}

	public void setUmbralle(WebElement umbralle) {
		this.umbralle = umbralle;
	}

	public WebElement getNoviosParis() {
		return noviosParis;
	}

	public void setNoviosParis(WebElement noviosParis) {
		this.noviosParis = noviosParis;
	}

	public WebElement getBebeParis() {
		return bebeParis;
	}

	public void setBebeParis(WebElement bebeParis) {
		this.bebeParis = bebeParis;
	}

	public WebElement getCasaParis() {
		return casaParis;
	}

	public void setCasaParis(WebElement casaParis) {
		this.casaParis = casaParis;
	}
}
