
public class Patient {

	private String nom,prenom,adresse,sexe;
	private long cin,telephone;
	public Patient(long cin, String nom, String prenom,String sexe,int telephone,String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.sexe = sexe;
		this.cin = cin;
		this.telephone = telephone;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public long getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
	
}
