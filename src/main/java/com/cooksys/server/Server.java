package com.cooksys.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	public static void main(String[] args) throws UnknownHostException, IOException {
		try (ServerSocket server = new ServerSocket(10501)) {
			System.out.println("Waiting for connection:");
			while (true) {
				Socket sock = server.accept();
				Thread clientHandler = new Thread(new ClientHandler(sock));
				clientHandler.start();
			}
		} catch (IOException e) {

			System.out.println(e);

		}

	}
}
