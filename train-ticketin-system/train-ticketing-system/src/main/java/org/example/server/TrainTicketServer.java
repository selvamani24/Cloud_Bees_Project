package org.example.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class TrainTicketServer {
    private final int port;
    private final Server server;

    public TrainTicketServer(int port) {
        this.port = port;
        this.server = ServerBuilder.forPort(port)
                .addService(new TrainTicketServiceImpl())
                .build();
    }

    public void start() throws IOException {
        server.start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server since JVM is shutting down");
            TrainTicketServer.this.stop();
            System.out.println("Server shut down");
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        TrainTicketServer server = new TrainTicketServer(50051);
        server.start();
        server.blockUntilShutdown();
    }
}
