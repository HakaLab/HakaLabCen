package cl.cencosud.publicsite.automation.poc.business.flow;

import org.junit.BeforeClass;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.cencosud.publicsite.automation.poc.stage.set.FlujoCompraCompleto_UsuarioRegistrado_StageSet;

@SuiteClasses({FlujoCompraCompleto_UsuarioRegistrado_StageSet.class})

public class FlujoCompraCompleto_UsuarioRegistrado_RunTest extends BaseFlow{
    private static final Logger LOGGER = LoggerFactory.getLogger(FlujoCompraCompleto_UsuarioRegistrado_RunTest.class);
    @BeforeClass
    public static void flag() throws Exception {
        LOGGER.info("Ejecutando flujo Compra Completo TC212...");
    }
}

