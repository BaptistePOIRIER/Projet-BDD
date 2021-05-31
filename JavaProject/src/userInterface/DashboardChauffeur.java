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

public class DashboardChauffeur {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardChauffeur window = new DashboardChauffeur();
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
	public DashboardChauffeur() {
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
		
		JLabel lblNewLabel = new JLabel("Menu chauffeur Rentcar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(191, 54, 228, 41);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_3 = new JLabel("Connect\u00E9 en tant que :");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(263, 10, 313, 23);
		panel.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setText("Connect\u00E9 en tant que : " + Session.prenom + " " + Session.nom);
		
		JButton btnNewButton = new JButton("Obtenir circuit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(50, 174, 203, 105);
		panel.add(btnNewButton);
		
		JButton btnVhiculesDplacer = new JButton("V\u00E9hicules \u00E0 d\u00E9placer");
		btnVhiculesDplacer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVhiculesDplacer.setBounds(314, 174, 203, 105);
		panel.add(btnVhiculesDplacer);
		
		JButton btnNewButton_1 = new JButton("Se d\u00E9connecter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginForm window = new LoginForm();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(156, 289, 248, 42);
		panel.add(btnNewButton_1);
	}
}
