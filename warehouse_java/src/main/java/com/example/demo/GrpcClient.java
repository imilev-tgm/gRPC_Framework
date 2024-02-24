package com.example.demo;

import grpc.GreetingServiceGrpc;
import grpc.Helloworld.HelloRequest;
import grpc.Helloworld.HelloReply;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class GrpcClient {

    private final GreetingServiceGrpc.GreetingServiceBlockingStub greetingServiceStub;

    public GrpcClient() {
        // Erstellen Sie einen Kanal zum gRPC-Server.
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext() // Deaktivieren Sie SSL für die Beispielanwendung.
                .build();

        // Erstellen Sie einen Stub zum Senden von Anfragen an den Server.
        this.greetingServiceStub = GreetingServiceGrpc.newBlockingStub(channel);
    }

    public String sayHello(String name) {
        // Erstellen Sie die Anfrage mit dem bereitgestellten Namen.
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();

        // Rufen Sie die Methode sayHello des Servers auf und erhalten Sie eine Antwort.
        HelloReply response = greetingServiceStub.sayHello(request);

        // Geben Sie die Antwortnachricht zurück.
        return response.getMessage();
    }
}
