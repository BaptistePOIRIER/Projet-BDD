package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.DataAccess;
import main.Session;

public class DashboardConseiller {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardConseiller window = new DashboardConseiller();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DashboardConseiller() {
		initialize();
		
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				Exit();
			}
		});
	}
	
	void Exit() {
		int a = JOptionPane.showConfirmDialog(null, "Confirm you want to close the window", "Confirm closing", JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION) {
			frame.dispose();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu conseiller Rentcar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(191, 54, 228, 41);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Gestion des Ressources");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
			}
		});
		btnNewButton.setBounds(10, 125, 254, 75);
		panel.add(btnNewButton);
		
		JButton btnGestionDesClients = new JButton("Gestion des Clients");
		btnGestionDesClients.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGestionDesClients.setBounds(322, 125, 254, 75);
		panel.add(btnGestionDesClients);
		
		JLabel lblNewLabel_1_3 = new JLabel("Connect\u00E9 en tant que :");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(263, 10, 313, 23);
		panel.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setText("Connect\u00E9 en tant que : " + Session.prenom + " " + Session.nom);
	}
}
