package org.example.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class TrainTicketServiceClient {

    private final TrainTicketServiceGrpc.TrainTicketServiceBlockingStub blockingStub;

    public TrainTicketServiceClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();

        this.blockingStub = TrainTicketServiceGrpc.newBlockingStub(channel);
    }

    public void purchaseTicket() {
        PurchaseTicketRequest request = PurchaseTicketRequest.newBuilder()
                .build();

        PurchaseTicketResponse response = blockingStub.purchaseTicket(request);
        // Process the response
    }
}

