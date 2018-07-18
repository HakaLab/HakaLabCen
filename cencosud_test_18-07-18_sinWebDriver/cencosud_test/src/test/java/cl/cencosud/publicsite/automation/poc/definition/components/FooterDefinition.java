package cl.cencosud.publicsite.automation.poc.definition.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import cl.cencosud.publicsite.automation.poc.business.flow.BaseFlow;
import cl.cencosud.publicsite.automation.poc.util.ComponentUtil;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FooterDefinition {
		

	@When("^ingreso al homePage$")
	public void ingreso_al_homePage() throws Throwable {
		//BaseFlow.driver.get("https://storefront:cen_2018@dev10-na01-cencosud.demandware.net/s/Paris/404?lang=es_CL");
	}

	@Then("^Valido que esxista footer en pagina$")
	public void valido_que_esxista_footer_en_pagina() throws Throwable {
		assertTrue("footer no se visualiza en pagina",BaseFlow.componentFooter.getFooterDiv().isDisplayed());

	}

	@Then("^Validar link de subscripción de Newletter$")
	public void validar_link_de_subscripción_de_Newletter() throws Throwable {
		assertTrue("no se encuentra pagina Newletter",ComponentUtil.sendGet(BaseFlow.componentFooter.getNewletter()));
	}

	@Then("^valido numero servicio al cliente$")
	public void valido_numero_servicio_al_cliente() throws Throwable {
		assertEquals("numero de atencion al cliente erroneo","600 400 8000", BaseFlow.componentFooter.getNumeroAtencionCliente().getText());
	}

	@Then("^Valido numero venta telefonica$")
	public void valido_numero_venta_telefonica() throws Throwable {
		assertEquals("numero de venta telefonica erroneo","600 400 6400", BaseFlow.componentFooter.getNumeroVentaTelefonica().getText());
	}

	@Then("^valido link de facebook$")
	public void valido_link_de_facebook() throws Throwable {
		assertTrue("pagina de facebook no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getLinkFacebook()));
	}

	@Then("^Valido link twiter$")
	public void valido_link_twiter() throws Throwable {
		assertTrue("pagina de twiter no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getLinkTwiter()));
	}

	@Then("^valido link instagram$")
	public void valido_link_instagram() throws Throwable {
		assertTrue("pagina de instragram no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getLinkInstagram()));
	}

	@Then("^valido link contactanos footer$")
	public void valido_link_contactanos_footer() throws Throwable {
//		assertTrue("pagina ocntactanos no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getContactanos()));
		assertTrue("pagina contactanos no encontrada",false);
	}

	@Then("^valido link beneficios paris\\.cl$")
	public void valido_link_beneficios_paris_cl() throws Throwable {
		assertTrue("pagina beneficios paris no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getBeneficiosParis()));
	}

	@Then("^valido link terminos y condiciones$")
	public void valido_link_terminos_y_condiciones() throws Throwable {
		assertTrue("pagina termino y condiciones no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getTerminosCondiciones()));
	}

	@Then("^Valido link politicas de privacidad$")
	public void valido_link_politicas_de_privacidad() throws Throwable {
		assertTrue("pagina politicas de privacidad no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getPoliticaPrivacidad()));
	}

	@Then("^valido link Recupera tu boleta$")
	public void valido_link_Recupera_tu_boleta() throws Throwable {
		assertTrue("pagina recupera tu boleta no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getRecuperaBoleta()));
	}

	@Then("^valido link encuesta de opinion$")
	public void valido_link_encuesta_de_opinion() throws Throwable {
		assertTrue("pagina encuesta de opinion no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getEncuestaOpinion()));
	}

	@Then("^valido link puntos cencosud$")
	public void valido_link_puntos_cencosud() throws Throwable {
		assertTrue("pagina link puntos cencosud no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getPuntosCencosud()));
	}

	@Then("^valido link tarjetas cencosud$")
	public void valido_link_tarjetas_cencosud() throws Throwable {
		assertTrue("pagina tarjetas cencosud no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getTarjetasCencosud()));
	}

	@Then("^valido link seguros cencosud$")
	public void valido_link_seguros_cencosud() throws Throwable {
		assertTrue("pagina seguros cencosud no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getSegurosCencosud()));
	}

	@Then("^valido link venta empresas$")
	public void valido_link_venta_empresas() throws Throwable {
		assertTrue("pagina venta empresa no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getVentaEmpresa()));
	}

	@Then("^valido link Trabaja con nosotros$")
	public void valido_link_Trabaja_con_nosotros() throws Throwable {
		assertTrue("pagina trabaja con nosotros no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getTrabajaNosotros()));
	}

	@Then("^valido link devoluciones y cambios$")
	public void valido_link_devoluciones_y_cambios() throws Throwable {
		assertTrue("pagina devoluciones y cambios no enocntrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getDevolucionesCambios()));
	}

	@Then("^valido link despacho$")
	public void valido_link_despacho() throws Throwable {
		assertTrue("pagina despacho no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getDespacho()));
	}

	@Then("^valido link garantia extendida$")
	public void valido_link_garantia_extendida() throws Throwable {
		assertTrue("pagina garantia extendida no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getGarantiaExtend()));
	}

	@Then("^valido link medios de pago$")
	public void valido_link_medios_de_pago() throws Throwable {
		assertTrue("pagina medios de pago no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getMediosPago()));
	}

	@Then("^valido link tiendas paris$")
	public void valido_link_tiendas_paris() throws Throwable {
		assertTrue("pagina tiendas paris no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getTiendasParis()));
	}

	@Then("^valido link Easy$")
	public void valido_link_Easy() throws Throwable {
		assertTrue("pagina easy no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getEasy()));
	}

	@Then("^valido link Jumbo$")
	public void valido_link_Jumbo() throws Throwable {
		assertTrue("pagina jumbo no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getJumbo()));
	}

	@Then("^valido link Jhonson$")
	public void valido_link_Jhonson() throws Throwable {
		assertTrue("pagina jhonson no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getJohnson()));
	}

	@Then("^valido link Santa Isabel$")
	public void valido_link_Santa_Isabel() throws Throwable {
		assertTrue("pagina santa isabel no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getSantaIsabel()));
	}

	@Then("^valido link Umbrale$")
	public void valido_link_Umbrale() throws Throwable {
		assertTrue("pagina umbrale no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getUmbralle()));
	}

	@Then("^valido link novios paris$")
	public void valido_link_novios_paris() throws Throwable {
		assertTrue("pagina novios paris no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getNoviosParis()));
	}

	@Then("^valido link bebe paris$")
	public void valido_link_bebe_paris() throws Throwable {
		assertTrue("pagina bebe paris no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getBebeParis()));
	}

	@Then("^valido link casa paris$")
	public void valido_link_casa_paris() throws Throwable {
		assertTrue("pagina casa paris no encontrada",ComponentUtil.sendGet(BaseFlow.componentFooter.getCasaParis()));
	}
}
