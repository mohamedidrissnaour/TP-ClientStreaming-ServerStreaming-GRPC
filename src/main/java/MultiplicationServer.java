import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.MultiplicationService;

import java.io.IOException;
import java.util.concurrent.Executors;

public class MultiplicationServer {
    public static void main(String[] args) throws IOException,
            InterruptedException {
        Server server = ServerBuilder.forPort(8889)
                .addService(new MultiplicationService())
                .executor(Executors.newFixedThreadPool(1000))
                .build();
        System.out.println("Serveur gRPC démarré sur le port 8889...");
        server.start();
        server.awaitTermination();
    }
}