package server;

public class ServerLogic {

	private static int port;
	
	public ServerLogic(int port){
		this.port = port;
		System.out.println(port);
	}
	
	public static void main(String[] args){
		if (args.length != 1){
			System.out.println("Usage: server.jar [port]");
			System.exit(0);
		}
		port = Integer.parseInt(args[0]);
		new ServerLogic(port);
	}
	
}
