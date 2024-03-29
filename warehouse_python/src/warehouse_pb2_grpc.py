# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

import warehouse_pb2 as warehouse__pb2


class WarehouseServiceStub(object):
    """Der Service bietet eine Methode, um Warehouse-Daten zu erhalten
    """

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.GetWarehouseData = channel.unary_unary(
                '/warehouse.WarehouseService/GetWarehouseData',
                request_serializer=warehouse__pb2.GetWarehouseDataRequest.SerializeToString,
                response_deserializer=warehouse__pb2.WarehouseData.FromString,
                )


class WarehouseServiceServicer(object):
    """Der Service bietet eine Methode, um Warehouse-Daten zu erhalten
    """

    def GetWarehouseData(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_WarehouseServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'GetWarehouseData': grpc.unary_unary_rpc_method_handler(
                    servicer.GetWarehouseData,
                    request_deserializer=warehouse__pb2.GetWarehouseDataRequest.FromString,
                    response_serializer=warehouse__pb2.WarehouseData.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'warehouse.WarehouseService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class WarehouseService(object):
    """Der Service bietet eine Methode, um Warehouse-Daten zu erhalten
    """

    @staticmethod
    def GetWarehouseData(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/warehouse.WarehouseService/GetWarehouseData',
            warehouse__pb2.GetWarehouseDataRequest.SerializeToString,
            warehouse__pb2.WarehouseData.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
