package tradearea.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WarehouseData {
	
	private String warehouseID;
	private String warehouseName;
	private String timestamp;
	private String warehouseCountry;
	private String warehouseCity;
	private String address;
	private ProductData[] productData;
	public ProductData[] getProductData() {
		return productData;
	}

	public void setProductData(ProductData[] productData) {
		this.productData = productData;
	}



	public String getWarehouseCountry() {
		return warehouseCountry;
	}

	public void setWarehouseCountry(String warehouseCountry) {
		this.warehouseCountry = warehouseCountry;
	}

	public String getWarehouseCity() {
		return warehouseCity;
	}

	public void setWarehouseCity(String warehouseCity) {
		this.warehouseCity = warehouseCity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * Constructor
	 */
	public WarehouseData() {
		
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

	}
	
	/**
	 * Setter and Getter Methods
	 */
	public String getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Methods
	 */
	@Override
	public String toString() {
		String info = String.format("Warehouse Info: ID = %s, timestamp = %s", warehouseID, timestamp );
		return info;
	}
}
