from datetime import datetime

class WarehouseData:
    def __init__(self):
        self.warehouse_id = None
        self.warehouse_name = None
        self.warehouse_country = None  # Added
        self.warehouse_city = None     # Added
        self.address = None    
        self.timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S.%f")
        self.product_data = []         # Added to hold product data

    @property
    def warehouse_id(self):
        return self._warehouse_id

    @warehouse_id.setter
    def warehouse_id(self, value):
        self._warehouse_id = value

    @property
    def warehouse_name(self):
        return self._warehouse_name

    @warehouse_name.setter
    def warehouse_name(self, value):
        self._warehouse_name = value

    @property
    def timestamp(self):
        return self._timestamp

    @timestamp.setter
    def timestamp(self, value):
        self._timestamp = value

    def __str__(self):
        return f"Warehouse Info: ID = {self.warehouse_id}, Name = {self.warehouse_name}, Timestamp = {self.timestamp}"

# Example usage:
warehouse_data = WarehouseData()
warehouse_data.warehouse_id = "WH123"
warehouse_data.warehouse_name = "Main Warehouse"
print(warehouse_data)
