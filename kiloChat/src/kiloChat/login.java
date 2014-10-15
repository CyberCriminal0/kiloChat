package kiloChat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	protected JTextField txtName;
	protected JTextField textPort;
	protected JTextField txtAddress;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public login() {
		/**try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		**/
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(131, 45, 56, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(80, 70, 134, 30);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblIpAddress = new JLabel("IP Address:");
		lblIpAddress.setBounds(111, 129, 82, 30);
		contentPane.add(lblIpAddress);
		
		txtAddress = new JTextField();
		txtAddress.setText("Address");
		txtAddress.setColumns(10);
		txtAddress.setBounds(80, 170, 134, 30);
		contentPane.add(txtAddress);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(131, 226, 31, 30);
		contentPane.add(lblPort);
		
		textPort = new JTextField();
		textPort.setText("Port");
		textPort.setColumns(10);
		textPort.setBounds(80, 267, 134, 30);
		contentPane.add(textPort);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Logging in...");
				String name = txtName.getText();
				String address = txtAddress.getText();
				int port = Integer.parseInt(textPort.getText());
				login(name, address, port);
			}
		});
		btnNewButton.setBounds(104, 338, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	private void login (String name, String IP, int port){
		dispose();
		System.out.println(name + IP + port + "");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
