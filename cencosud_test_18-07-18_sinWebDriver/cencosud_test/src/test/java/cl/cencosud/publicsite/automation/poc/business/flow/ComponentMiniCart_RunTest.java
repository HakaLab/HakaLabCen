package cl.cencosud.publicsite.automation.poc.business.flow;

import org.junit.BeforeClass;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.cencosud.publicsite.automation.poc.stage.set.Components.ComponentMiniCartStageSet;

@SuiteClasses({ComponentMiniCartStageSet.class})

public class ComponentMiniCart_RunTest extends BaseFlow{
    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentMiniCartStageSet.class);
    @BeforeClass
    public static void flag() throws Exception {
        LOGGER.info("Ejecutando flujo componentes mini cart");
    }
}
