package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
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
import main.Vehicule;

import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.AbstractListModel;

public class DashboardRessources {

	public JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardRessources window = new DashboardRessources();
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
	public DashboardRessources() {
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
		
		JLabel lblNewLabel = new JLabel("Gestion des Ressources");
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
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Marque :");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(10, 124, 69, 23);
		panel.add(lblNewLabel_1_3_1);
		
		textField = new JTextField();
		textField.setBounds(76, 126, 74, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list.setBounds(178, 105, 398, 204);
		panel.add(list);
		DataAccess conn = new DataAccess();
		DefaultListModel DLM = conn.getRessources("", 3);
		list.setModel(DLM);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Vehicule disponible");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(22, 173, 147, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnTous = new JRadioButton("Tous");
		rdbtnTous.setSelected(true);
		rdbtnTous.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTous.setBounds(22, 226, 147, 23);
		panel.add(rdbtnTous);
		
		JRadioButton rdbtnEnLocation = new JRadioButton("En location");
		rdbtnEnLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnEnLocation.setBounds(22, 200, 147, 23);
		panel.add(rdbtnEnLocation);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnEnLocation);
		group.add(rdbtnTous);
		
		JButton btnNewButton = new JButton("Rechercher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataAccess conn = new DataAccess();
				String marque = textField.getText();
				int selectionType = 0;
				if (rdbtnNewRadioButton.isSelected()) {
					selectionType = 1;
				}
				if(rdbtnEnLocation.isSelected()) {
					selectionType = 2;
				}
				if(rdbtnTous.isSelected()) {
					selectionType = 3;
				}
				
				DefaultListModel DLM = conn.getRessources(marque, selectionType);
				list.setModel(DLM);
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 275, 158, 65);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRessources window = new AddRessources();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(191, 319, 97, 34);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Modifier");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(322, 319, 97, 34);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Supprimer");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(frame, "Please select a row");
				}
				else {
					Vehicule vehicule = (Vehicule) DLM.get(list.getSelectedIndex());
					DataAccess conn = new DataAccess();
					if(conn.removeRessources(vehicule.getImmatriculation())) {
						
					}else {
						JOptionPane.showMessageDialog(frame, "Cannot delete that ressource");
					}
				}
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1.setBounds(454, 319, 97, 34);
		panel.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_2 = new JButton("Pr\u00E9c\u00E9dent");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DashboardConseiller window = new DashboardConseiller();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(10, 10, 107, 34);
		panel.add(btnNewButton_2);
	}
}
