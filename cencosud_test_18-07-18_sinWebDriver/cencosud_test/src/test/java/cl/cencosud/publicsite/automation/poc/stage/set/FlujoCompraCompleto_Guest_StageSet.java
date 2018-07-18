package cl.cencosud.publicsite.automation.poc.stage.set;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//		tags = {"@TC160-1,@TC160-2,@TC155-1,@TC155-2"}//preSALE
//		
//		tags = {"@TC160-100"}
		
//		tags = {"@TC173-1"}
		
		//@TC163-1,@TC163-13,

		//Producto estandar
//		tags = {"@TC153-1,@TC153-2,@TC153-3,@TC153-4,@TC155-1,@TC155-2,@TC155-3,@TC155-4,@TC156-1,@TC156-2,@TC156-3,@TC156-4"}//FlujoCompra_Guest_Credito_Domicilio_Standard  

//		tags = {"@TC153-1,@TC153-2,@TC153-3,@TC153-4"}//FlujoCompra_Guest_Cencosud_Domicilio_Standard
//		tags = {"@TC156-1,@TC156-2,@TC156-3,@TC156-4"}//FlujoCompra_Guest_RedCompra_Domicilio_Standard   
		
//		tags = {"@TC155-9,@TC155-10,@TC155-11,@TC155-12"}//FlujoCompra_Guest_Credito_Domicilio_Program  No probar 
//		tags = {"@TC153-9,@TC153-10,@TC153-11,@TC153-12"}//FlujoCompra_Guest_Cencosud_Domicilio_Program
//		tags = {"@TC156-9,@TC156-10,@TC156-11,@TC156-12"}//FlujoCompra_Guest_RedCompra_Domicilio_Program   
	
		//Producto Variation
		
// 		tags = {"@TC158-1,@TC158-2,@TC158-3,@TC158-4,@TC160-1,@TC160-2,@TC160-3,@TC160-4,@TC161-1,@TC161-2,@TC161-3,@TC161-4"} //variation_creditCard_cencosudCard_RedCompra
		
//		tags = {"@TC160-1,@TC160-2,@TC160-3,@TC160-4"}//FlujoCompra_Guest_Credito_Domicilio_Standard_Retiro_Tienda  
//		tags = {"@TC158-1,@TC158-2,@TC158-3,@TC158-4"}//FlujoCompra_Guest_Cencosud_Domicilio_Standard
//		tags = {"@TC161-1,@TC161-2,@TC161-3,@TC161-4"}//FlujoCompra_Guest_RedCompra_Domicilio_Standard  
		
//_______________________________________________________________________________________________________________________________________
		
//		tags = {"@TC163-1,@TC163-2,@TC163-3,@TC163-4,@TC165-1,@TC165-2,@TC165-3,@TC165-4,@TC166-1,@TC166-2,@TC166-3,@TC166-4,"
//			+ "@TC163-13,@TC163-14,@TC163-15,@TC163-16,@TC165-13,@TC165-14,@TC165-15,@TC165-16,@TC166-13,@TC166-14,@TC166-15,@TC166-16"} // Oprions_CreditCard_CencosudCard_RedCompra
		
		
		//Producto Option Con Armado
//		tags = {"@TC165-1,@TC165-2,@TC165-3,@TC165-4"}//FlujoCompra_Guest_Credito_Domicilio_Standard  
//		tags = {"@TC163-1,@TC163-2,@TC163-3,@TC163-4"}//FlujoCompra_Guest_Cencosud_Domicilio_Standard FALLO No genera OC
//		tags = {"@TC166-1,@TC166-2,@TC166-3,@TC166-4"}//FlujoCompra_Guest_RedCompra_Domicilio_Standard   
		
		//Producto Option Con Garantia
//		tags = {"@TC165-13,@TC165-14,@TC165-15,@TC165-16"}//FlujoCompra_Guest_Credito_Domicilio_Standard  
//		tags = {"@TC163-13,@TC163-14,@TC163-15,@TC163-16"}//FlujoCompra_Guest_Cencosud_Domicilio_Standard 
//		tags = {"@TC166-13,@TC166-14,@TC166-15,@TC166-16"}//FlujoCompra_Guest_RedCompra_Domicilio_Standard  
//_____________________________________________________________________________________________________________________________________	
		
		//Producto Bundle

//		tags = {"@TC168-1,@TC168-2,@TC168-3,@TC168-4, @TC170-1,@TC170-2,@TC170-3,@TC170-4,@TC171-1,@TC171-2,@TC171-3,@TC171-4"}

//		tags = {"@TC170-1,@TC170-2,@TC170-3,@TC170-4"}//FlujoCompra_Guest_Credito_Domicilio_Standard  
//		tags = {"@TC168-1,@TC168-2,@TC168-3,@TC168-4"}//FlujoCompra_Guest_Cencosud_Domicilio_Standard - FALLO
//		tags = {"@TC171-1,@TC171-2,@TC171-3,@TC171-4"}//FlujoCompra_Guest_RedCompra_Domicilio_Standard 

//______________________________________________________________________________________________________________________________________
		//Producto preSale
		
		tags = {"@TC173-1,@TC173-2,@TC173-3,@TC173-4,@TC175-1,@TC175-2,@TC175-3,@TC175-4, @TC176-1,@TC176-2,@TC176-3,@TC176-4"}
		
//		tags = {"@TC175-1,@TC175-2,@TC175-3,@TC175-4"}//FlujoCompra_Guest_Credito_Domicilio_Standard  
//		tags = {"@TC173-1,@TC173-2,@TC173-3,@TC173-4"}//FlujoCompra_Guest_Cencosud_Domicilio_Standard
//		tags = {"@TC176-1,@TC176-2,@TC176-3,@TC176-4"}//FlujoCompra_Guest_RedCompra_Domicilio_Standard  -FALLO

 
		//Producto Promotion

// 		tags = {"@TC178-1,@TC178-2,@TC178-3,@TC178-4,@TC180-1,@TC180-2,@TC180-3,@TC180-4,@TC181-1,@TC181-2,@TC181-3,@TC181-4"}
 
//		tags = {"@TC180-1,@TC180-2,@TC180-3,@TC180-4"}//FlujoCompra_Guest_Credito_Domicilio_Standard  
//		tags = {"@TC178-1,@TC178-2,@TC178-3,@TC178-4"}//FlujoCompra_Guest_Cencosud_Domicilio_Standard - FALLO
//		tags = {"@TC181-1,@TC181-2,@TC181-3,@TC181-4"}//FlujoCompra_Guest_RedCompra_Domicilio_Standard   
		
		
		
//		tags = {"@TC155-1,@TC155-2,@TC155-3,@TC155-4,"
//				+ "@TC160-1,@TC160-2,@TC160-3,@TC160-4,"
//				+ "@TC165-1,@TC165-2,@TC165-3,@TC165-4,"
//				+ "@TC165-13,@TC165-14,@TC165-15,@TC165-16,"
//				+ "@TC170-1,@TC170-2,@TC170-3,@TC170-4,"
//				+ "@TC175-1,@TC175-2,@TC175-3,@TC175-4,"
//				+ "@TC180-1,@TC180-2,@TC180-3,@TC180-4"
//			}//Se ejecuto el 29-06-18  FlujoCompraCompleto_Guess_Credito_Domicilio_Estandar
		
//		tags = {"@TC153-1,@TC153-2,@TC153-3,@TC153-4,"
//				+ "@TC158-1,@TC158-2,@TC158-3,@TC158-4,"
//				+ "@TC163-1,@TC163-2,@TC163-3,@TC163-4,"
//				+ "@TC163-13,@TC163-14,@TC163-15,@TC163-16,"
//				+ "@TC168-1,@TC168-2,@TC168-3,@TC168-4,"
//				+ "@TC173-1,@TC173-2,@TC173-3,@TC173-4,"
//				+ "@TC178-1,@TC178-2,@TC178-3,@TC178-4"
//			}//Se ejecuto el 29-06-18  FlujoCompraCompleto_Guess_CencosudCard_Domicilio_Estandar
		
		
//		tags = {"@TC155-1,@TC155-2,@TC155-3,@TC155-4,@TC155-9,@TC155-10,@TC155-11,@TC155-12,"
//				+ "@TC160-1,@TC160-2,@TC160-3,@TC160-4,@TC160-9,@TC160-10,@TC160-11,@TC160-12,"
//				+ "@TC165-1,@TC165-2,@TC165-3,@TC165-4,@TC165-9,@TC165-10,@TC165-11,@TC165-12,"
//				+ "@TC165-13,@TC165-14,@TC165-15,@TC165-16,@TC165-21,@TC165-22,@TC165-23,@TC165-24,"
//				+ "@TC170-1,@TC170-2,@TC170-3,@TC170-4,@TC170-9,@TC170-10,@TC170-11,@TC170-12,"
//				+ "@TC175-1,@TC175-2,@TC175-3,@TC175-4,@TC175-9,@TC175-10,@TC175-11,@TC175-12,"
//				+ "@TC180-1,@TC180-2,@TC180-3,@TC180-4,@TC180-9,@TC180-10,@TC180-11,@TC180-12"
//			}//Se ejecuto el 26-06-18  FlujoCompraCompleto_Guess_Credito_Domicilio_Estandar_Programado
		
//		tags = {"@TC165-13,@TC165-14,@TC165-15,@TC165-16,"
//				+ "@TC170-1,@TC170-2,@TC170-3,@TC170-4,"
//				+ "@TC175-1,@TC175-2,@TC175-3,@TC175-4,"
//				+ "@TC180-1,@TC180-2,@TC180-3,@TC180-4"
//				}
		
		
		
		,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/Guest_.html" }

		
)

public class FlujoCompraCompleto_Guest_StageSet extends StageSet{

}
