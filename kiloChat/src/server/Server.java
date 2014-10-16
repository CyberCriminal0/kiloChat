package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable{
	
	
	//this needs explaining...
	private List<connClient> clients = new ArrayList<connClient>();

	
	
	
	
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
	
		
		run = new Thread(this, "Server");
		run.start();
	}


	public void run() {
		on = true;
		System.out.println("Started server on port " + port);
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
		manager.start();
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
					String string = new String(packet.getData());
					
					
					//how to get name?
					//clients.add(new connClient( , packet.getAddress(), packet.getPort(), ))
					System.out.println(string);
				}
			}
		};
		receive.start();
	}
}
