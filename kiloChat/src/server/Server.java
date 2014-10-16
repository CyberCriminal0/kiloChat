package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server implements Runnable{

	private DatagramSocket socket;
	private int port;
	private boolean on = false;
	private Thread run, manager, sender, receive;

	public Server(int port){
		this.port = port;
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	
		
		run = new Thread(this, "Start");
	}


	public void run() {
		on = true;
		manageClients();
		receive();
	}
	
	private void manageClients(){
		
		manager = new Thread("Manage") { 
			public void run(){
				while (on){
					
				}
			}
		};
		
	}
	
	private void receive(){
		
		receive = new Thread("Receive") { 
			public void run(){
				while (on){
					byte[] data = new byte[1024];
					DatagramPacket packet = new DatagramPacket(data, data.length);
					try {
						socket.receive(packet);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
	}
}
