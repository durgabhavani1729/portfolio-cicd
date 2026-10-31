package com.example.app;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8081), 0);

        server.createContext("/", exchange -> {

            String response = """
                    <html>
                    <head>
                        <title>Java Web Application</title>
                    </head>
                    <body>
                        <h1>Java Web Application</h1>
                        <h2>CI/CD Pipeline Demo</h2>
                        <p>Application is running successfully!</p>
                    </body>
                    </html>
                    """;

            exchange.getResponseHeaders()
                    .set("Content-Type", "text/html");

            exchange.sendResponseHeaders(
                    200, response.getBytes().length);

            OutputStream output = exchange.getResponseBody();
            output.write(response.getBytes());
            output.close();
        });

        server.start();

        System.out.println(
                "Java Web Application started on port 8081");
    }
}