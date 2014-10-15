package kiloChat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JTextArea;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;

public class client extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	private String name, IP;
	private int port;
	private JTextField txtMessageBox;
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
		
		JTextArea txtrHistory = new JTextArea();
		GridBagConstraints gbc_txtrHistory = new GridBagConstraints();
		gbc_txtrHistory.insets = new Insets(0, 0, 5, 5);
		gbc_txtrHistory.fill = GridBagConstraints.BOTH;
		gbc_txtrHistory.gridx = 1;
		gbc_txtrHistory.gridy = 1;
		contentPane.add(txtrHistory, gbc_txtrHistory);
		
		txtMessageBox = new JTextField();
		GridBagConstraints gbc_txtMessageBox = new GridBagConstraints();
		gbc_txtMessageBox.insets = new Insets(0, 0, 0, 5);
		gbc_txtMessageBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMessageBox.gridx = 1;
		gbc_txtMessageBox.gridy = 2;
		contentPane.add(txtMessageBox, gbc_txtMessageBox);
		txtMessageBox.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.insets = new Insets(0, 0, 0, 5);
		gbc_btnSend.gridx = 2;
		gbc_btnSend.gridy = 2;
		contentPane.add(btnSend, gbc_btnSend);
		
		setVisible(true);

	}

}
