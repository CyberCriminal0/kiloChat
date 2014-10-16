package server;

public class ServerLogic {

	private int port;
	private Server server;
	
	public ServerLogic(int port){
		this.port = port;
		server = new Server(port);
	}
	
	public static void main(String[] args){
		int port;
		if (args.length != 1){
			System.out.println("Usage: server.jar [port]");
			return;
		}
		port = Integer.parseInt(args[0]);
		new ServerLogic(port);
	}
	
}
