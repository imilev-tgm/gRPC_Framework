package tradearea.warehouse;

import tradearea.model.ProductData;
import tradearea.model.WarehouseData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class WarehouseSimulation {

	public static WarehouseData generateRandomWarehouseData() {
		WarehouseData warehouseData = new WarehouseData();

		// Hardcoded
		warehouseData.setWarehouseName("Pandabuy Warehouse");
		warehouseData.setWarehouseCountry("China");
		warehouseData.setWarehouseCity("Shanghai");
		warehouseData.setAddress("Wing ding long xong");


		Random random = new Random();
		warehouseData.setWarehouseID(String.format("%03d", random.nextInt(1000))); // Random 3-digit ID

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		warehouseData.setTimestamp(dateFormat.format(new Date()));

		ProductData[] productData = new ProductData[4];
		productData[0] = generateRandomProductData();
		productData[1] = generateRandomProductData();
		productData[2] = generateRandomProductData();
		productData[3] = generateRandomProductData();

		warehouseData.setProductData(productData);

		return warehouseData;
	}

	public static ProductData generateRandomProductData() {
		ProductData productData = new ProductData();
		Random random = new Random();

		productData.setProductId(String.format("PD%03d", random.nextInt(1000))); // Random 3-digit product ID
		productData.setProductName(generateRandomProductName());
		productData.setProductCategory(assignProductCategory(productData.getProductName()));
		productData.setProductAmount(Integer.toString(random.nextInt(1000))); // Random product amount
		productData.setProductUnit("pcs"); // Fixed unit for simplicity

		return productData;
	}

	public static String generateRandomProductName() {
		// You can replace this with a list of actual product names
		String[] productNames = {"Coca-Cola", "Pepsi", "Orange Juice", "Apple Juice", "Water", "Coffee"};
		Random random = new Random();
		return productNames[random.nextInt(productNames.length)];
	}

	public static String assignProductCategory(String productName) {
		// Assign the category based on the product name
		if (productName.equals("Coca-Cola") || productName.equals("Pepsi")) {
			return "Soda";
		} else if (productName.equals("Orange Juice") || productName.equals("Apple Juice")) {
			return "Juice";
		} else if (productName.equals("Water")) {
			return "Water";
		} else if (productName.equals("Coffee")) {
			return "Coffee";
		} else {
			return "Unknown";
		}
	}
}
