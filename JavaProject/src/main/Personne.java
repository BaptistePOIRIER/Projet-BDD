package main;

abstract class Personne {
    protected String id_personne;
    protected String nom;
    protected String prenom; 
    protected String email;
    protected String rue;
    protected String ville;
    protected String code_postal;
    protected String numero_telephone;
	
    
    public Personne(String id_personne, String nom, String prenom, String email, String rue, String ville,
			String code_postal, String numero_telephone) {
		this.id_personne = id_personne;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.rue = rue;
		this.ville = ville;
		this.code_postal = code_postal;
		this.numero_telephone = numero_telephone;
	}    
}
