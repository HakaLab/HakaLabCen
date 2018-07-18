package cl.cencosud.publicsite.automation.poc.definition.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import cl.cencosud.publicsite.automation.poc.business.flow.BaseFlow;
import cl.cencosud.publicsite.automation.poc.util.ComponentUtil;
import cl.cencosud.publicsite.automation.poc.util.GenericMethods;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HeaderDefinition {
	@When("^Ingreso a HomePage$")
	public void ingreso_a_HomePage() throws Throwable {
		BaseFlow.driver.get("https://storefront:cen_2018@dev10-na01-cencosud.demandware.net/s/Paris/404?lang=es_CL");
	}

	@Then("^Valido redireccionamiento de TopBanner$")
	public void valido_redireccionamiento_de_TopBanner() throws Throwable {
		// assertTrue(ComponentUtil.sendGet(BaseFlow.componentHeader.getTopBanner()));
	}

	@Then("^Valido redireccionamiento Top Navigation$")
	public void valido_redireccionamiento_Top_Navigation() throws Throwable {
		assertTrue("redireccionamiento erroneo top Navigation",
				BaseFlow.componentHeader.getTopNavigation().isDisplayed());
	}

	@When("^doy click en tiendas$")
	public void doy_click_en_tiendas() throws Throwable {
		BaseFlow.componentHeader.getTiendas().click();
	}

	@Then("^valido icono de ubicacion de tiendas$")
	public void valido_icono_de_ubicacion_de_tiendas() throws Throwable {
		assertTrue("icono de geolocalizacion no visualizado",
				BaseFlow.componentHeader.getIconoLocationTiendas().isDisplayed());
	}

	@Then("^valido como accion pre marcada \"(.*?)\"$")
	public void valido_como_accion_pre_marcada(String region) throws Throwable {
		BaseFlow.componentHeader.getSelectRegion().isDisplayed();
		Select regiones = new Select(BaseFlow.componentHeader.getSelectRegion());
		assertEquals("no se visualiza " + region + " como opcion por defecto", region,
				regiones.getFirstSelectedOption().getText());
	}

	@When("^doy click en icono de locacion$")
	public void doy_click_en_icono_de_locacion() throws Throwable {
		BaseFlow.componentHeader.getIconoLocationTiendas().click();
		Thread.sleep(2000);
	}

	@Then("^valido que muestre ubicacion actual con formato nombre numero y comuna$")
	public void valido_que_muestre_ubicacion_actual_con_formato_nombre_numero_y_comuna() throws Throwable {
		Thread.sleep(2000);
		//Alert alert = BaseFlow.driver.switchTo().alert();
		// alertText = alert.getText();

		assertTrue("no se logra visualizar ubicacion actual",
				BaseFlow.componentHeader.getUbicacionActual().isDisplayed());
	}

	@Then("^valido que por defecto se visualice region \"(.*?)\"$")
	public void valido_que_por_defecto_se_visualice_region(String region) throws Throwable {
		Select regions = new Select(BaseFlow.componentHeader.getSelectRegion());
		assertEquals("no se visualiza " + region + " como opcion por defecto", region, regions.getFirstSelectedOption().getText());
	}

	@Then("^Valido tiendas segun busqueda$")
	public void valido_tiendas_segun_busqueda() throws Throwable {
		assertTrue("no se visualizan tiendas por busqueda", BaseFlow.componentHeader.getListaTiendas().isDisplayed());
	}

	@Then("^valido numero telefonico$")
	public void valido_numero_telefonico() throws Throwable {
		assertTrue("no se visualiza numero telefonico de tienda",
				BaseFlow.componentHeader.getLinkTelefono().isDisplayed());
	}

	@Then("^valido link mapa$")
	public void valido_link_mapa() throws Throwable {
		assertTrue("no se visualiza link mapa", BaseFlow.componentHeader.getLinkMapa().isDisplayed());
	}

	@Then("^valido direccion$")
	public void valido_direccion() throws Throwable {
		assertTrue("no se visualiza direccion de tienda", BaseFlow.componentHeader.getDireccionTienda().isDisplayed());
	}

	@Then("^valido horario$")
	public void valido_horario() throws Throwable {
		assertTrue("no se visualiza horario de atencion", BaseFlow.componentHeader.getHorarioTienda().isDisplayed());
	}

	@Then("^Valido link ayuda$")
	public void valido_link_ayuda() throws Throwable {
		BaseFlow.componentHeader.getAyuda().click();
		assertTrue("no se visualizan opciones de ayuda", BaseFlow.componentHeader.getDescripcionAyuda().isDisplayed());
	}

	@Then("^Valido link ayuda-llamanos$")
	public void valido_link_ayuda_llamanos() throws Throwable {
		// assertTrue(ComponentUtil.sendGet(BaseFlow.componentHeader.getTopBanner()));
	}

	@Then("^valido link imagen cencosud$")
	public void valido_link_imagen_cencosud() throws Throwable {
		assertTrue("no se visualiza imagen logo cencosud", BaseFlow.componentHeader.getLogoCencosud().isDisplayed());
	}

	@When("^click en link ordenes$")
	public void click_en_link_ordenes() throws Throwable {
		BaseFlow.componentHeader.getOrdenBuscar().click();
	}

	@Then("^Validar se muestra el título \"(.*?)\"$")
	public void validar_se_muestra_el_título(String titulo) throws Throwable {
		assertEquals("no se visualiza titulo de ordenes " + titulo, titulo,
				BaseFlow.componentHeader.getTituloOrdenes().getText());
	}

	@Then("^Validar que se despliega campo rut$")
	public void validar_que_se_despliega_campo_rut() throws Throwable {
		assertTrue("no se visualiza campo rut", BaseFlow.componentHeader.getRutOrdenes().isDisplayed());
	}

	@Then("^Validar que se encuentre tilde en boton Búscar$")
	public void validar_que_se_encuentre_tilde_en_boton_Búscar() throws Throwable {
		assertTrue("no se encuentra tilde en boton búscar",
				BaseFlow.componentHeader.getBtnBuscar().getText().contains("Ú"));
	}

	@When("^ingreso rut ordenes\"(.*?)\"$")
	public void ingreso_rut_ordenes(String rut) throws Throwable {
		BaseFlow.componentHeader.getRutOrdenes().sendKeys(rut);
		BaseFlow.componentHeader.getRutOrdenes().sendKeys(Keys.TAB);
	}

	@Then("^Validar respuesta segun rut ingresado\"(.*?)\"$")
	public void validar_respuesta_segun_rut_ingresado(String mensaje) throws Throwable {
		assertEquals("no se visualiza mensaje de error", mensaje, BaseFlow.componentHeader.getErrorRut().getText());
	}

	@When("^ingreso rut \"(.*?)\"$")
	public void ingreso_rut(String rut) throws Throwable {
		BaseFlow.componentHeader.getRutOrdenes().clear();
		BaseFlow.componentHeader.getRutOrdenes().sendKeys(rut);
		BaseFlow.componentHeader.getBtnBuscar().click();
	}

	@Then("^Validar orden de muestra de los pedidos$")
	public void validar_orden_de_muestra_de_los_pedidos() throws Throwable {
		// GenericMethods.waitTime(BaseFlow.componentHeader.getOrdenProducto());
		Thread.sleep(5000);
		assertTrue("no se visualiza numero de orden por pedido",
				BaseFlow.componentHeader.getOrdenProducto().isDisplayed());
	}

	@Then("^Validar boton para colapsar producto$")
	public void validar_boton_para_colapsar_producto() throws Throwable {
		BaseFlow.componentHeader.getMinimizar().click();
		assertFalse(BaseFlow.componentHeader.getOrdenProducto().isSelected());
		BaseFlow.componentHeader.getMinimizar().click();
		Thread.sleep(2000);
		assertTrue(BaseFlow.componentHeader.getOrdenProducto().isDisplayed());
	}

	@Then("^validar fecha visualizada en formato dd/mm/aa$")
	public void validar_fecha_visualizada_en_formato_dd_mm_aa() throws Throwable {
		assertTrue("no se visualiza fecha con formato solicitado",
				BaseFlow.componentHeader.getFechaOrden().getText().contains("/"));
	}

	@Then("^validar total del pedido con separadores de mil$")
	public void validar_total_del_pedido_con_separadores_de_mil() throws Throwable {
		assertTrue("no se visualiza precio total con formato solicitado",
				BaseFlow.componentHeader.getTotal().getText().contains("."));
	}

	@Then("^Validar estado del pedido$")
	public void validar_estado_del_pedido() throws Throwable {
		// if (BaseFlow.componentHeader.getStatusPedido().getText().contains("NOT
		// AVAILABLE")) {
		// assertTrue("status del pedido no disponible",false);
		// }else {
		// assertTrue("status del producto no
		// visible",BaseFlow.componentHeader.getStatusPedido().isDisplayed());
		// }
	}

	@Then("^Validar imagen$")
	public void validar_imagen() throws Throwable {
		assertTrue("imagen del producto no encontrada", BaseFlow.componentHeader.getImagenProducto().isDisplayed());
	}

	@Then("^validar metodo de entrega$")
	public void validar_metodo_de_entrega() throws Throwable {
		assertTrue("no se visualiza metodo de entrega", BaseFlow.componentHeader.getMetodoEntrega().isDisplayed());
	}

	@Then("^validar descripcion del producto$")
	public void validar_descripcion_del_producto() throws Throwable {
		assertTrue("no se visualiza descripcion y detalle del producto",
				BaseFlow.componentHeader.getDescripcionProducto().isDisplayed());
	}

	@Then("^Validar metodo de pago$")
	public void validar_metodo_de_pago() throws Throwable {
		assertTrue("no se visualiza metodo de pago con el que se realizo la compra",
				BaseFlow.componentHeader.getMetodoPago().isDisplayed());
	}

	@Then("^Validar direccion$")
	public void validar_direccion() throws Throwable {
		assertTrue("no se visualiza direccion ingresa en compra",
				BaseFlow.componentHeader.getDireccionOrden().isDisplayed());
	}

	@Then("^valido la paginacion de las paginas$")
	public void valido_la_paginacion_de_las_paginas() throws Throwable {

	}

	@When("^selecciono el numero de pagina \"(.*?)\"$")
	public void selecciono_el_numero_de_pagina(String arg1) throws Throwable {

	}

	@Then("^valido la navegacion entre paginas$")
	public void valido_la_navegacion_entre_paginas() throws Throwable {

	}

	@Then("^valido link servicio al cliente$")
	public void valido_link_servicio_al_cliente() throws Throwable {
		assertTrue(BaseFlow.componentHeader.getServicioCliente().isDisplayed());
	}

	@Then("^valido link venta telefonica$")
	public void valido_link_venta_telefonica() throws Throwable {
		assertTrue(BaseFlow.componentHeader.getVentaTelefonica().isDisplayed());
	}

	@Then("^valido buscador$")
	public void valido_buscador() throws Throwable {
		assertTrue(BaseFlow.componentHeader.getBuscador().isDisplayed());
	}

	@Then("^valido icono carro de compras$")
	public void valido_icono_carro_de_compras() throws Throwable {
		assertTrue(BaseFlow.componentHeader.getIconoCarroCompras().isDisplayed());
	}

	@Then("^valido productos en el icono del carro$")
	public void valido_productos_en_el_icono_del_carro() throws Throwable {

	}
}
