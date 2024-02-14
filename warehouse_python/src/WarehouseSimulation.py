import random
from datetime import datetime
from WarehouseData import WarehouseData
from ProductData import ProductData

class WarehouseSimulation:
    @staticmethod
    def generate_random_warehouse_data():
        warehouse_data = WarehouseData()
        warehouse_data.warehouse_name = "Pandabuy Warehouse"
        warehouse_data.warehouse_country = "China"
        warehouse_data.warehouse_city = "Shanghai"
        warehouse_data.address = "Wing ding long xong"
        warehouse_data.warehouse_id = f"{random.randint(1, 999):03d}"
        warehouse_data.timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S.%f")
        warehouse_data.product_data = [WarehouseSimulation.generate_random_product_data() for _ in range(4)]
        return warehouse_data

    @staticmethod
    def generate_random_product_data():
        product_data = ProductData()
        product_data.product_id = f"PD{random.randint(1, 999):03d}"
        product_data.product_name = WarehouseSimulation.generate_random_product_name()
        product_data.product_category = WarehouseSimulation.assign_product_category(product_data.product_name)
        product_data.product_amount = str(random.randint(1, 999))
        product_data.product_unit = "pcs"
        return product_data

    @staticmethod
    def generate_random_product_name():
        product_names = ["Coca-Cola", "Pepsi", "Orange Juice", "Apple Juice", "Water", "Coffee"]
        return random.choice(product_names)

    @staticmethod
    def assign_product_category(product_name):
        categories = {
            ("Coca-Cola", "Pepsi"): "Soda",
            ("Orange Juice", "Apple Juice"): "Juice",
            "Water": "Water",
            "Coffee": "Coffee"
        }
        for key, value in categories.items():
            if product_name in key:
                return value
        return "Unknown"
