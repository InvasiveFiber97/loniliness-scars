package com.legerito.practice.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Create a server socket
            serverSocket = new ServerSocket(9999);
            System.out.println("Server started");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Read the HTTP request
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                StringBuilder requestBody = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null && !line.isEmpty()) {
                    requestBody.append(line).append("\n");
                }

                // Print the received text from the HTTP request
                System.out.print("Received text from HTTP request: ");
                System.out.println(requestBody.toString());

                // Send an HTTP response
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/plain");
                out.println();
                out.println("Text received and printed successfully!");
                out.flush();

                // Close the streams and the client socket
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    // Close the server socket
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
