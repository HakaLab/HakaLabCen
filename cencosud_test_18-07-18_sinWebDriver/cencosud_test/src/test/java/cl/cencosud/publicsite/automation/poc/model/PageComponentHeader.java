package cl.cencosud.publicsite.automation.poc.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageComponentHeader {

	@FindBy(how = How.CLASS_NAME, using = "huincha-promo")
	private WebElement topBanner;

	@FindBy(how = How.CLASS_NAME, using = "clearfix")
	private WebElement topNavigation;

	@FindBy(how = How.CLASS_NAME, using = "gtm-tiendas-header")
	private WebElement Tiendas;

	@FindBy(how = How.ID, using = "clickHelp")
	private WebElement ayuda;

	@FindBy(how = How.CLASS_NAME, using = "CA-logo")
	private WebElement logoCencosud;

	@FindBy(how = How.ID, using = "clickTraking")
	private WebElement ordenBuscar;

	@FindBy(how = How.ID, using = "gtm-tel-sac-header")
	private WebElement servicioCliente;

	@FindBy(how = How.ID, using = "gtm-tel-venta-header")
	private WebElement ventaTelefonica;

	@FindBy(how = How.ID, using = "q")
	private WebElement buscador;

	@FindBy(how = How.CLASS_NAME, using = "box-carro-header")
	private WebElement iconoCarroCompras;

	@FindBy(how = How.NAME, using = "dwfrm_storelocator_findbyposition")
	private WebElement iconoLocationTiendas;

	@FindBy(how = How.NAME, using = "dwfrm_storelocator_state")
	private WebElement selectRegion;

	@FindBy(how = How.CLASS_NAME, using = "js-user-location")
	private WebElement ubicacionActual;

	@FindBy(how = How.CLASS_NAME, using = "store-locatore")
	private WebElement listaTiendas;

	@FindBy(how = How.CLASS_NAME, using = "link-phone")
	private WebElement linkTelefono;

	@FindBy(how = How.CLASS_NAME, using = "google-map")
	private WebElement linkMapa;

	@FindBy(how = How.CLASS_NAME, using = "store-name")
	private WebElement direccionTienda;

	@FindBy(how = How.CLASS_NAME, using = "store-hours")
	private WebElement horarioTienda;

	@FindBy(how = How.CLASS_NAME, using = "contentWrapperTraking")
	private WebElement descripcionAyuda;

	@FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[3]/div/div[1]/div/div/h3")
	private WebElement tituloOrdenes;

	@FindBy(how = How.ID, using = "dwfrm_personaldetails_rut")
	private WebElement rutOrdenes;

	@FindBy(how = How.ID, using = "js-header-button-order-search")
	private WebElement btnBuscar;

	@FindBy(how = How.ID, using = "dwfrm_personaldetails_rut-error")
	private WebElement errorRut;

	@FindBy(how = How.XPATH, using = "//*[@id=\"accordion\"]/div/div[1]/div/div[1]/div[1]/strong")
	private WebElement ordenProducto;

	@FindBy(how = How.CLASS_NAME, using = "icon-minus")
	private WebElement minimizar;

	@FindBy(how = How.XPATH, using = "//*[@id=\"accordion\"]/div/div[1]/div/div[1]/div[2]")
	private WebElement fechaOrden;

	@FindBy(how = How.XPATH, using = "//*[@id=\"accordion\"]/div/div[1]/div/div[1]/div[3]")
	private WebElement total;

	@FindBy(how = How.XPATH, using = "//*[@id=\"order1search\"]/div[1]/div/div[4]")
	private WebElement statusPedido;

	@FindBy(how = How.XPATH, using = "//*[@id=\"order1search\"]/div[1]/div/div[1]")
	private WebElement imagenProducto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"order1search\"]/div[2]/dl[2]/dd")
	private WebElement metodoEntrega;

	@FindBy(how = How.XPATH, using = "//*[@id=\"order1search\"]/div[1]/div/div[2]")
	private WebElement descripcionProducto;

	@FindBy(how = How.CLASS_NAME, using = "cc-number")
	private WebElement metodoPago;

	@FindBy(how = How.XPATH, using = "//*[@id=\"order1search\"]/div[2]/dl[3]/dd")
	private WebElement direccionOrden;

	public WebElement getMetodoEntrega() {
		return metodoEntrega;
	}

	public void setMetodoEntrega(WebElement metodoEntrega) {
		this.metodoEntrega = metodoEntrega;
	}

	public WebElement getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(WebElement descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public WebElement getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(WebElement metodoPago) {
		this.metodoPago = metodoPago;
	}

	public WebElement getDireccionOrden() {
		return direccionOrden;
	}

	public void setDireccionOrden(WebElement direccionOrden) {
		this.direccionOrden = direccionOrden;
	}

	public WebElement getImagenProducto() {
		return imagenProducto;
	}

	public void setImagenProducto(WebElement imagenProducto) {
		this.imagenProducto = imagenProducto;
	}

	public WebElement getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(WebElement statusPedido) {
		this.statusPedido = statusPedido;
	}

	public WebElement getTotal() {
		return total;
	}

	public void setTotal(WebElement total) {
		this.total = total;
	}

	public WebElement getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(WebElement fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public WebElement getMinimizar() {
		return minimizar;
	}

	public void setMinimizar(WebElement minimizar) {
		this.minimizar = minimizar;
	}

	public WebElement getOrdenProducto() {
		return ordenProducto;
	}

	public void setOrdenProducto(WebElement ordenProducto) {
		this.ordenProducto = ordenProducto;
	}

	public WebElement getErrorRut() {
		return errorRut;
	}

	public void setErrorRut(WebElement errorRut) {
		this.errorRut = errorRut;
	}

	public WebElement getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(WebElement btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public WebElement getRutOrdenes() {
		return rutOrdenes;
	}

	public void setRutOrdenes(WebElement rutOrdenes) {
		this.rutOrdenes = rutOrdenes;
	}

	public WebElement getTituloOrdenes() {
		return tituloOrdenes;
	}

	public void setTituloOrdenes(WebElement tituloOrdenes) {
		this.tituloOrdenes = tituloOrdenes;
	}

	public WebElement getDescripcionAyuda() {
		return descripcionAyuda;
	}

	public void setDescripcionAyuda(WebElement descripcionAyuda) {
		this.descripcionAyuda = descripcionAyuda;
	}

	WebElement getTopBanner() {
		return topBanner;
	}

	public WebElement getIconoLocationTiendas() {
		return iconoLocationTiendas;
	}

	public void setIconoLocationTiendas(WebElement iconoLocationTiendas) {
		this.iconoLocationTiendas = iconoLocationTiendas;
	}

	public WebElement getSelectRegion() {
		return selectRegion;
	}

	public void setSelectRegion(WebElement selectRegion) {
		this.selectRegion = selectRegion;
	}

	public WebElement getUbicacionActual() {
		return ubicacionActual;
	}

	public void setUbicacionActual(WebElement ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}

	public WebElement getListaTiendas() {
		return listaTiendas;
	}

	public void setListaTiendas(WebElement listaTiendas) {
		this.listaTiendas = listaTiendas;
	}

	public WebElement getLinkTelefono() {
		return linkTelefono;
	}

	public void setLinkTelefono(WebElement linkTelefono) {
		this.linkTelefono = linkTelefono;
	}

	public WebElement getLinkMapa() {
		return linkMapa;
	}

	public void setLinkMapa(WebElement linkMapa) {
		this.linkMapa = linkMapa;
	}

	public WebElement getDireccionTienda() {
		return direccionTienda;
	}

	public void setDireccionTienda(WebElement direccionTienda) {
		this.direccionTienda = direccionTienda;
	}

	public WebElement getHorarioTienda() {
		return horarioTienda;
	}

	public void setHorarioTienda(WebElement horarioTienda) {
		this.horarioTienda = horarioTienda;
	}

	public void setTopBanner(WebElement topBanner) {
		this.topBanner = topBanner;
	}

	public WebElement getTopNavigation() {
		return topNavigation;
	}

	public void setTopNavigation(WebElement topNavigation) {
		this.topNavigation = topNavigation;
	}

	public WebElement getTiendas() {
		return Tiendas;
	}

	public void setTiendas(WebElement tiendas) {
		Tiendas = tiendas;
	}

	public WebElement getAyuda() {
		return ayuda;
	}

	public void setAyuda(WebElement ayuda) {
		this.ayuda = ayuda;
	}

	public WebElement getLogoCencosud() {
		return logoCencosud;
	}

	public void setLogoCencosud(WebElement logoCencosud) {
		this.logoCencosud = logoCencosud;
	}

	public WebElement getOrdenBuscar() {
		return ordenBuscar;
	}

	public void setOrdenBuscar(WebElement ordenBuscar) {
		this.ordenBuscar = ordenBuscar;
	}

	public WebElement getServicioCliente() {
		return servicioCliente;
	}

	public void setServicioCliente(WebElement servicioCliente) {
		this.servicioCliente = servicioCliente;
	}

	public WebElement getVentaTelefonica() {
		return ventaTelefonica;
	}

	public void setVentaTelefonica(WebElement ventaTelefonica) {
		this.ventaTelefonica = ventaTelefonica;
	}

	public WebElement getBuscador() {
		return buscador;
	}

	public void setBuscador(WebElement buscador) {
		this.buscador = buscador;
	}

	public WebElement getIconoCarroCompras() {
		return iconoCarroCompras;
	}

	public void setIconoCarroCompras(WebElement iconoCarroCompras) {
		this.iconoCarroCompras = iconoCarroCompras;
	}

}
