package main;

public class Vehicule {
	private String immatriculation;
    private String marque;
    private String modele;
    private int kilometrage;
    private int boite_auto;
    private int climatisation;
    private String carburant;
    private int id_agence;
    private int id_categorie;
    
	public Vehicule(String immatriculation, String marque, String modele, int kilometrage, int boite_auto,
			int climatisation, String carburant, int id_agence, int id_categorie) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.kilometrage = kilometrage;
		this.boite_auto = boite_auto;
		this.climatisation = climatisation;
		this.carburant = carburant;
		this.id_agence = id_agence;
		this.id_categorie = id_categorie;
	}
	
	@Override
	public String toString() {
		return "Vehicule [immatriculation=" + immatriculation + ", marque=" + marque + ", modele=" + modele
				+ ", kilometrage=" + kilometrage + ", boite_auto=" + boite_auto + ", climatisation=" + climatisation
				+ ", carburant=" + carburant + ", id_agence=" + id_agence + ", id_categorie=" + id_categorie + "]";
	}

	public String getImmatriculation() {
		return immatriculation;
	}

    
}