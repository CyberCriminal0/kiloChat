package server;

import java.net.InetAddress;

public class connClient {

	public String name;
	public InetAddress address;
	public int port;
	public final int ID;
	public int timeout = 0;
	
	public connClient(String name, InetAddress address, int port, final int ID){
		
		this.address = address;
		this.port = port;
		this.name = name;
		this.ID = ID;
	}
	
	public int getID() {
		return ID;
	}

	
}
