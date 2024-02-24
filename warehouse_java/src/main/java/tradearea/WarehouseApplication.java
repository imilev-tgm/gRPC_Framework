package tradearea;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tradearea.Warehouse.WarehouseRequest;
import tradearea.Warehouse.WarehouseData;
import tradearea.Warehouse.ProductData;
import tradearea.WarehouseServiceGrpc.WarehouseServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@SpringBootApplication
public class WarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                    .usePlaintext()
                    .build();

            try {
                WarehouseServiceBlockingStub stub = WarehouseServiceGrpc.newBlockingStub(channel);
                WarehouseRequest request = WarehouseRequest.newBuilder().setWarehouseID("001").build();
                WarehouseData response = stub.getWarehouseData(request);

                // Ausgabe der Antwort mit mehr Details
                System.out.println("Response from Warehouse gRPC server:");
                System.out.println("Warehouse ID: " + response.getWarehouseID());
                System.out.println("Warehouse Name: " + response.getWarehouseName());
                System.out.println("Warehouse Country: " + response.getWarehouseCountry());
                System.out.println("Warehouse City: " + response.getWarehouseCity());
                System.out.println("Warehouse Address: " + response.getAddress());
                System.out.println("Timestamp: " + response.getTimestamp());

                // Ausgabe der Produktdaten
                for (ProductData product : response.getProductDataList()) {
                    System.out.println("Product ID: " + product.getProductId());
                    System.out.println("Product Name: " + product.getProductName());
                    System.out.println("Product Category: " + product.getProductCategory());
                    System.out.println("Product Amount: " + product.getProductAmount());
                    System.out.println("Product Unit: " + product.getProductUnit());
                }
            } finally {
                channel.shutdownNow();
            }
        };
    }
}
