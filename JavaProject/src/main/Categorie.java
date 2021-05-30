package main;

public class Categorie {
    private int id_categorie;
    private String categorie;
    private int tarif;
    private int caution;
    
	public Categorie(int id_categorie, String categorie, int tarif, int caution) {
		super();
		this.id_categorie = id_categorie;
		this.categorie = categorie;
		this.tarif = tarif;
		this.caution = caution;
	}
}