package main;

abstract class Employe extends Personne{
    protected String login;
    protected String password;

	public Employe(String id_personne, String nom, String prenom, String email, String rue, String ville,
			String code_postal, String numero_telephone, String login, String password) {
		super(id_personne, nom, prenom, email, rue, ville, code_postal, numero_telephone);
		this.login = login;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employe [login=" + login + ", password=" + password + ", id_personne=" + id_personne + ", nom=" + nom
				+ ", prenom=" + prenom + ", email=" + email + ", rue=" + rue + ", ville=" + ville + ", code_postal="
				+ code_postal + ", numero_telephone=" + numero_telephone + "]";
	}
}
