package kiloChat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class networking {

	protected DatagramSocket socket;
	protected InetAddress ip;
	protected int dataport;
	
	protected boolean connect(String address, int port){
		
		
		try {
			this.dataport = port;
			socket = new DatagramSocket(port);
			this.ip = InetAddress.getByName(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		} catch (SocketException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
		
	}
	
	protected String receive(){
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		
	try{	
		socket.receive(packet);
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	String message = new String(packet.getData());
	
	return message;
	
	}
	
	protected void send(final byte[] data){
		client.send = new Thread("Send"){
			public void run(){
		DatagramPacket packet = new DatagramPacket(data, data.length, ip, dataport);
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
			}
		};
	}
	
}
