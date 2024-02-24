package tradearea.warehouse;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class GrpcServerConfig {

    @Bean(destroyMethod = "shutdown")
    public Server grpcServer() throws IOException {
        return ServerBuilder.forPort(50051)
                .addService(new WarehouseServiceImpl())
                .build()
                .start();
    }
}
