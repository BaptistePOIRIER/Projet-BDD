package main;

public class Client extends Personne{
	private boolean gold;

	public Client(String id_personne, String nom, String prenom, String email, String rue, String ville,
			String code_postal, String numero_telephone, boolean gold) {
		super(id_personne, nom, prenom, email, rue, ville, code_postal, numero_telephone);
		this.gold = gold;
	}
}
 