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
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.AbstractListModel;

public class AddRessources {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRessources window = new AddRessources();
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
	public AddRessources() {
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
		
		JLabel lblNewLabel = new JLabel("Ajout de ressource");
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
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Immatriculation :");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(10, 124, 123, 23);
		panel.add(lblNewLabel_1_3_1);
		
		textField = new JTextField();
		textField.setBounds(147, 124, 107, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		ButtonGroup group = new ButtonGroup();
		
		JButton btnNewButton_1_1 = new JButton("Annuler");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(303, 302, 97, 34);
		panel.add(btnNewButton_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 157, 107, 23);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Marque :");
		lblNewLabel_1_3_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1_1.setBounds(10, 157, 123, 23);
		panel.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("Modele :");
		lblNewLabel_1_3_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1_1_1.setBounds(10, 192, 123, 23);
		panel.add(lblNewLabel_1_3_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 192, 107, 23);
		panel.add(textField_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Climatisation");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(194, 275, 123, 21);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnBoiteAuto = new JRadioButton("Boite auto");
		rdbtnBoiteAuto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnBoiteAuto.setBounds(319, 275, 103, 21);
		panel.add(rdbtnBoiteAuto);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(428, 192, 107, 23);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(428, 157, 107, 23);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(428, 124, 107, 23);
		panel.add(textField_5);
		
		JLabel lblNewLabel_1_3_1_1_1_1 = new JLabel("Categorie ID :");
		lblNewLabel_1_3_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1_1_1_1.setBounds(291, 192, 123, 23);
		panel.add(lblNewLabel_1_3_1_1_1_1);
		
		JLabel lblNewLabel_1_3_1_1_2 = new JLabel("Agence ID :");
		lblNewLabel_1_3_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1_1_2.setBounds(291, 157, 123, 23);
		panel.add(lblNewLabel_1_3_1_1_2);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("Carburant :");
		lblNewLabel_1_3_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1_2.setBounds(291, 124, 123, 23);
		panel.add(lblNewLabel_1_3_1_2);

		JLabel lblNewLabel_1_3_1_1_1_1_1 = new JLabel("Kilometrage :");
		lblNewLabel_1_3_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1_1_1_1_1.setBounds(166, 235, 123, 23);
		panel.add(lblNewLabel_1_3_1_1_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(303, 235, 107, 23);
		panel.add(textField_6);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataAccess conn = new DataAccess();
				String immatriculation = textField.getText();
			    String marque = textField_1.getText();
			    String modele = textField_2.getText();
			    int kilometrage = Integer.parseInt(textField_6.getText().trim());
			    int boite_auto = 0;
			    if(rdbtnBoiteAuto.isSelected()) {
			    	boite_auto = 1;
			    }
			    int climatisation = 0;
			    if(rdbtnBoiteAuto.isSelected()) {
			    	climatisation = 1;
			    }
			    String carburant = textField_5.getText();
			    int id_agence = Integer.parseInt(textField_4.getText().trim());
			    int id_categorie = Integer.parseInt(textField_3.getText().trim());
			    if(conn.addRessource(immatriculation, marque, modele, kilometrage, boite_auto, climatisation, carburant, id_agence, id_categorie)) {
			    	frame.dispose();
			    }else {
			    	JOptionPane.showMessageDialog(frame, "Invalid informations");
			    }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(191, 302, 97, 34);
		panel.add(btnNewButton_1);
		
	}
}
