package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;

public class DataAccess {
	Connection conn;
	private String url = "JDBC:MYSQL://localhost/rentcar";
	private String username = "root";
	private String password = "secret";
	
	public DataAccess() {
		try {
			this.conn = DriverManager.getConnection(this.url,this.username , this.password);
			System.out.println("Connection successfull!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection failed!");
		}
	}
	
	public void close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean login(String login, String password) {
		try {
			Statement s = this.conn.createStatement();
			String sql = "SELECT employe.id_personne,is_conseiller,nom,prénom FROM EMPLOYE INNER JOIN personne ON employe.id_personne = personne.id_personne WHERE login='" + login + "' AND mot_de_passe='" + password + "';";
			
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Login successfull!");
				Session.is_logged_in = true;
				Session.employe_id = rs.getInt("id_personne");
				Session.is_conseiller = rs.getInt("is_conseiller");
				Session.nom = rs.getString("nom");
				Session.prenom = rs.getString("prénom");
				return true;
			}
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return false;
	}
	
	public DefaultListModel getRessources(String marque, int selectionType) {
		try {
			Statement s = this.conn.createStatement();
			String sql = "";
			if (selectionType == 1) {
				sql = "SELECT * FROM rentcar.vehicule LEFT JOIN CONTRAT ON VEHICULE.IMMATRICULATION=CONTRAT.IMMATRICULATION WHERE marque LIKE '%" + marque + "%' AND CONTRAT.immatriculation IS NULL ORDER BY id_categorie;";
			}else if (selectionType == 2) {
				sql = "SELECT * FROM rentcar.vehicule INNER JOIN CONTRAT ON VEHICULE.IMMATRICULATION=CONTRAT.IMMATRICULATION WHERE marque LIKE '%" + marque + "%' ORDER BY id_categorie;";
			}else {
				sql = "SELECT * FROM rentcar.vehicule WHERE marque LIKE '%" + marque + "%' ORDER BY id_categorie;";
			}
			ResultSet rs = s.executeQuery(sql);
			DefaultListModel DLM = new DefaultListModel();
			while(rs.next()) {
				Vehicule vehicule = new Vehicule(rs.getString("immatriculation"), rs.getString("marque"), rs.getString("modele"), rs.getInt("kilometrage"), rs.getInt("boite_auto"), rs.getInt("climatisation"), rs.getString("carburant"), rs.getInt("id_agence"), rs.getInt("id_categorie"));
				DLM.addElement(vehicule);
				System.out.println(vehicule.toString());
			}
			System.out.println(selectionType);
			return DLM;
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return null;
	}
	
	public void addRessource(String immatriculation, String marque, String modele, int kilometrage, int boite_auto,
		int climatisation, String carburant, int id_agence, int id_categorie) {
		try {
			Statement s = this.conn.createStatement();
			String sql = "INSERT INTO `rentcar`.`vehicule` (`immatriculation`, `marque`, `modele`, `kilometrage`, `boite_auto`, `climatisation`, `carburant`, `id_agence`, `id_categorie`) VALUES ('" + immatriculation + "', '" + marque + "', '" + modele + "', '" + kilometrage + "', '" + boite_auto + "', '" + climatisation + "', '" + carburant + "', '" + id_agence + "', '" + id_categorie + "');";
			ResultSet rs = s.executeQuery(sql);
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
}
