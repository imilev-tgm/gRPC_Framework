from concurrent import futures
import grpc
import warehouse_pb2
import warehouse_pb2_grpc
from WarehouseSimulation import WarehouseSimulation  # Make sure to import your WarehouseSimulation module

class WarehouseServiceImpl(warehouse_pb2_grpc.WarehouseServiceServicer):
    def GetWarehouseData(self, request, context):
        # Use your WarehouseSimulation to generate data
        warehouse_data = WarehouseSimulation.generate_random_warehouse_data()
        return warehouse_pb2.WarehouseData(
            warehouse_id=warehouse_data.warehouse_id,
            warehouse_name=warehouse_data.warehouse_name,
            warehouse_country=warehouse_data.warehouse_country,
            warehouse_city=warehouse_data.warehouse_city,
            address=warehouse_data.address,
            timestamp=warehouse_data.timestamp,
            product_data=[warehouse_pb2.ProductData(
                product_id=product.product_id,
                product_name=product.product_name,
                product_category=product.product_category,
                product_amount=product.product_amount,
                product_unit=product.product_unit
            ) for product in warehouse_data.product_data]
        )

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    warehouse_pb2_grpc.add_WarehouseServiceServicer_to_server(WarehouseServiceImpl(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    server.wait_for_termination()

if __name__ == '__main__':
    serve()
