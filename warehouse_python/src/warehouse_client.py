import grpc
import warehouse_pb2
import warehouse_pb2_grpc

def run():
    with grpc.insecure_channel('localhost:50051') as channel:
        stub = warehouse_pb2_grpc.WarehouseServiceStub(channel)
        response = stub.GetWarehouseData(warehouse_pb2.GetWarehouseDataRequest())
        print("Client received: ", response)

if __name__ == '__main__':
    run()
