package kiloChat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class client extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	private String name, IP;
	private int port;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public client(String name, String address, int port) {
		setTitle("Kilochat Client");
		
		
		this.name = name;
		this.IP = address;
		this.port = port;
		newWindow();
		
	}
	
	private void newWindow(){

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);

	}

}
