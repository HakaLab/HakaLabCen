package cl.cencosud.publicsite.automation.poc.model;

public class CompraSingleton {
	
	public String sku;
	public String cantidadSku;
	public String armadoSku;
	public String garantiaSku;
	public String nombreSku;
	public String precioSku;
	
	
	private static CompraSingleton instance = null;
	
	
	
	public String getNombreSku() {
		return nombreSku;
	}

	public void setNombreSku(String nombreSku) {
		this.nombreSku = nombreSku;
	}

	public String getPrecioSku() {
		return precioSku;
	}

	public void setPrecioSku(String precioSku) {
		this.precioSku = precioSku;
	}

	public static void setInstance(CompraSingleton instance) {
		CompraSingleton.instance = instance;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getCantidadSku() {
		return cantidadSku;
	}

	public void setCantidadSku(String cantidadSku) {
		this.cantidadSku = cantidadSku;
	}

	public String getArmadoSku() {
		return armadoSku;
	}

	public void setArmadoSku(String armadoSku) {
		this.armadoSku = armadoSku;
	}

	public String getGarantiaSku() {
		return garantiaSku;
	}

	public void setGarantiaSku(String garantiaSku) {
		this.garantiaSku = garantiaSku;
	}
	
	

	public CompraSingleton() {
		
	}

	public static CompraSingleton getInstance() {
	      if(instance == null) {
	         instance = new CompraSingleton();
	      }
	      return instance;
	   }
	

}
