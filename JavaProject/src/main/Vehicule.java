package main;

public class Vehicule {
    private String marque;
    private String modele;
    private int kilometrage;
    private String boite_auto;
    private boolean climatisation;
    private int carburant;
    
	public Vehicule(String marque, String modele, int kilometrage, String boite_auto, boolean climatisation,
			int carburant) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.kilometrage = kilometrage;
		this.boite_auto = boite_auto;
		this.climatisation = climatisation;
		this.carburant = carburant;
	}
}