package cl.cencosud.publicsite.automation.poc.util;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cl.cencosud.publicsite.automation.poc.business.flow.BaseFlow;

public final class ComponentUtil {
	
	public static boolean sendGet1(WebElement element){
		
	       String href = element.getAttribute("href");
	       
	 boolean status;
	           HttpClient client = new DefaultHttpClient();
	           HttpGet request = new HttpGet(href);
	 
	           HttpResponse response = null;
	           try {
	               response = client.execute(request);
	           } catch (IOException e) {
	               e.printStackTrace();
	           }
	           int code = response.getStatusLine().getStatusCode();
	 
	           if (code == 200 || code == 401) {
				status=true;
			}else
			{
				
				status=false;
			}
	           
	           
	             return status;
	 
	   }
	
	public static boolean sendGet(WebElement element){
		
	       String href = element.getAttribute("href");
	       
	 boolean status;
	           HttpClient client = new DefaultHttpClient();
	           HttpGet request = new HttpGet(href);
	 
	           HttpResponse response = null;
	           try {
	               response = client.execute(request);
	           } catch (IOException e) {
	               e.printStackTrace();
	           }
	           int code = response.getStatusLine().getStatusCode();
	 
	           if (code == 200 ) {
				status=true;
			}else
			{
				
				status=false;
			}
	           
	           
	             return status;
	 
	   }
	
	private static WebElement element = null;
	 private static List<WebElement> elements = null; 
	
	 public static boolean returnOneElement (String categoria){
		    elements = BaseFlow.driver.findElements(By.className("top-category-nav"));
		    for (WebElement element : elements){
		        String myText = element.getText();
		        if (myText.contains(categoria)) {
		        	     return true ;
		        }
		    }
		    return false;
		}
	
}
