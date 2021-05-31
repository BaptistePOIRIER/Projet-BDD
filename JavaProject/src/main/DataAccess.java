package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			
			if(rs.next()) {
				System.out.println("Login successfull!");
				Session.is_logged_in = true;
				Session.employe_id = rs.getInt("id_personne");
				Session.is_conseiller = rs.getInt("is_conseiller");
				Session.nom = rs.getString("nom");
				Session.prenom = rs.getString("prénom");
				return true;
			}else {
				System.out.println("Login failed!");
				return false;
			}
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return false;
	}
}
