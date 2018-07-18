package cl.cencosud.publicsite.automation.poc.business.flow;

import org.junit.BeforeClass;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.cencosud.publicsite.automation.poc.stage.set.Components.ComponentFlowStageSet;


@SuiteClasses({ComponentFlowStageSet.class})
public class ComponentFlowTest extends BaseFlow{
	
	
	
//	BaseFlow.htmlReport = new HtmlReport(BaseFlow.d, "none", "Reporte Automatizacion Desktop", SuitesService.ICONOGRAFIA, "ReporteWS");
    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentFlowTest.class);

    @BeforeClass
    public static void flag() throws Exception {
        LOGGER.info("Ejecutando flujo componentes...");
    }
}
