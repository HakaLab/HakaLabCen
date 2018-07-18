package cl.cencosud.publicsite.automation.poc.business.flow;

import org.junit.BeforeClass;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.cencosud.publicsite.automation.poc.stage.set.Components.FlujoComponentesCarroCompraStageSet;

@SuiteClasses({FlujoComponentesCarroCompraStageSet.class})

public class FlujoComponentCart_RunTest extends BaseFlow{
    private static final Logger LOGGER = LoggerFactory.getLogger(FlujoComponentesCarroCompraStageSet.class);
    @BeforeClass
    public static void flag() throws Exception {
        LOGGER.info("Ejecutando flujo componentes cart");
    }
}
