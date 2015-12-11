//package SocketCommunication;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiSocketServer {
	static int sum;

	public static void main(String[] s) {
		ServerSocket serverSocket = null;
		Socket client = null;
		while (true) {
			try {

				serverSocket = new ServerSocket(4444);

			} catch (Exception e) {
				System.out.println("Error:");
				System.exit(-1);
			}
			try {
				client = serverSocket.accept();
			} catch (Exception e) {
				System.out.println("Ω” ’«Î«Û ß∞‹.");
				System.exit(-1);
			}
			// System.out.println("Client["+MultiSocketServer.sum+"]µ«¬Ω......");

			ServerThread st = new ServerThread(client);

			SendButtonHandler buttonHandler = new SendButtonHandler(st);
			st.getfrm().send.addActionListener(buttonHandler);
			KeyHandler keyHandler = new KeyHandler(st);
			st.getfrm().input.addKeyListener(keyHandler);

			Thread t = new Thread(st);
			t.start();
			try {
				serverSocket.close();
			} catch (IOException e) {
				System.out.println("πÿ±’ ß∞‹.");
				MultiSocketServer.sum++;
			}
		}
	}

}
