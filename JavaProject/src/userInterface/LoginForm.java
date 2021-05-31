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

public class LoginForm {

	public JFrame frame;
	private JTextField txtIdentifiant;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
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
	public LoginForm() {
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
		
		JLabel lblNewLabel = new JLabel("Connexion \u00E0 Rentcar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(212, 25, 185, 41);
		panel.add(lblNewLabel);
		
		txtIdentifiant = new JTextField();
		txtIdentifiant.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdentifiant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdentifiant.setBounds(212, 96, 185, 41);
		panel.add(txtIdentifiant);
		txtIdentifiant.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setHorizontalAlignment(SwingConstants.CENTER);
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPassword.setColumns(10);
		textPassword.setBounds(212, 147, 185, 41);
		panel.add(textPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Identifiant");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(71, 96, 131, 41);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Se connecter");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataAccess conn = new DataAccess();
					String username = txtIdentifiant.getText();
					String password = textPassword.getText();
					
					if(conn.login(username, password)) {
						frame.dispose();
						if(Session.is_conseiller == 1) {
							DashboardConseiller window = new DashboardConseiller();
							window.frame.setVisible(true);
						}else {
							DashboardChauffeur window = new DashboardChauffeur();
							window.frame.setVisible(true);
						}
					}else {
						JOptionPane.showMessageDialog(frame, "Invalid connection informations");
					}
			}
		});
		
		JLabel lblNewLabel_1_1 = new JLabel("Mot de passe");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(71, 147, 131, 41);
		panel.add(lblNewLabel_1_1);
		btnNewButton.setBounds(212, 206, 185, 41);
		panel.add(btnNewButton);
	}
}
