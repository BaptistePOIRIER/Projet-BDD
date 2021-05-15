package main;

public class Agence {
	private int id_agence;
    private String nom;
    private String telephone;
    private String adresse;
    private String coordonnees_GPS;
    private int max_vehicule;
    
    
    public Agence(int id_agence, String nom, String telephone, String adresse, String coordonnees_GPS,
			int max_vehicule) {
		this.id_agence = id_agence;
		this.nom = nom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.coordonnees_GPS = coordonnees_GPS;
		this.max_vehicule = max_vehicule;
	}
}
