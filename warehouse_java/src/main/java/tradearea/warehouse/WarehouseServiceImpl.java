package tradearea.warehouse;

import io.grpc.stub.StreamObserver;
import tradearea.Warehouse.WarehouseRequest;
import tradearea.Warehouse.WarehouseData;
import tradearea.WarehouseServiceGrpc.WarehouseServiceImplBase;

public class WarehouseServiceImpl extends WarehouseServiceImplBase {

    @Override
    public void getWarehouseData(WarehouseRequest request, StreamObserver<WarehouseData> responseObserver) {
        // Hier können Sie die Logik hinzufügen, um die Daten zu generieren oder abzurufen
        // Zum Beispiel könnte es so aussehen:
        WarehouseData data = WarehouseData.newBuilder()
                .setWarehouseID(request.getWarehouseID())
                .setWarehouseName("Pandabuy Warehouse")
                .setWarehouseCity("Warehouse City")
                .setWarehouseCountry("Warehouse Country")
                .setAddress("Warehouse Address")
                .setTimestamp("Timestamp")
                .build();

        responseObserver.onNext(data);
        responseObserver.onCompleted();
    }
}
