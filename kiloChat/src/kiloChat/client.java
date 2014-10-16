package kiloChat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JTextArea;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class client extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	protected String name, IP;
	protected int port;
	private JTextField txtMessageBox;
	private JTextArea txtrHistory;
	
	protected static Thread send;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	networking socket1 = new networking();
	
	public client(String name, String address, int port) {
		setTitle("Kilochat Client");
		

		
		this.name = name;
		this.IP = address;
		this.port = port;
		newWindow();
		console("Working...");
		console("Hello " + this.name + ", now attempting connection to " + address + ":" + port);
		String welcome = name + " has joined";
		boolean connected = socket1.connect(address);
		
		if(!connected){
			System.err.println("Connection failed! :( ");
			console("Connection failed!");
		}
		
	}
	
	

	
	
	private void newWindow(){
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{10, 570, 30, 10};
		gbl_contentPane.rowHeights = new int[]{50, 300, 100};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		txtrHistory = new JTextArea();
		GridBagConstraints scrollPar = new GridBagConstraints();
		txtrHistory.setEditable(false);
		JScrollPane scroll = new JScrollPane(txtrHistory);
		
		
		scrollPar.insets = new Insets(0, 0, 5, 5);
		scrollPar.fill = GridBagConstraints.BOTH;
		scrollPar.gridx = 0;
		scrollPar.gridy = 0;
		scrollPar.gridwidth = 3;
		scrollPar.gridheight = 2;
		scrollPar.insets = new Insets(20, 20, 20 ,20);
		contentPane.add(scroll, scrollPar);
		
		txtMessageBox = new JTextField();
		txtMessageBox.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					send(txtMessageBox.getText());
				}
				
			}
			
		});
		GridBagConstraints gbc_txtMessageBox = new GridBagConstraints();
		gbc_txtMessageBox.insets = new Insets(0, 0, 0, 5);
		gbc_txtMessageBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMessageBox.gridx = 1;
		gbc_txtMessageBox.gridy = 2;
		contentPane.add(txtMessageBox, gbc_txtMessageBox);
		txtMessageBox.setColumns(10);
		
		
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			send(txtMessageBox.getText());
				
			}
		});
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.insets = new Insets(0, 0, 0, 5);
		gbc_btnSend.gridx = 2;
		gbc_btnSend.gridy = 2;
		contentPane.add(btnSend, gbc_btnSend);
		
		requestFocus();
		txtMessageBox.requestFocus();
		
		setVisible(true);
		
		

	}
	
	private void send(String message){
		if (message.equals("")) return;
		message = name + ": " + message;
		console(message);
		socket1.send(message.getBytes());
		txtMessageBox.setText("");
		
		
	}
	
	
	
	public void console(String message){
		txtrHistory.append(message + "\n\r");
	}

}
