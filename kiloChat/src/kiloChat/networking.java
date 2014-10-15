package kiloChat;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class networking {

	protected DatagramSocket socket;
	protected InetAddress ip;
	
	protected boolean connect(String address, int port){
		
		
		try {
			socket = new DatagramSocket();
			ip = InetAddress.getByName(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		} catch (SocketException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
		
	}
	
}
