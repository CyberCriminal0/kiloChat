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

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField textPort;

	/**
	 * Launch the application.
	 */
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
		
		textPort = new JTextField();
		textPort.setText("Address");
		textPort.setColumns(10);
		textPort.setBounds(80, 170, 134, 30);
		contentPane.add(textPort);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(131, 226, 31, 30);
		contentPane.add(lblPort);
		
		txtAddress = new JTextField();
		txtAddress.setText("Port");
		txtAddress.setColumns(10);
		txtAddress.setBounds(80, 267, 134, 30);
		contentPane.add(txtAddress);
	}
}
