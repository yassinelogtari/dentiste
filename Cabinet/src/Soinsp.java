
public class Soinsp extends Patient {
	
	
	private String soins;

	public Soinsp(long cin, String nom, String prenom, String sexe, int telephone, String adresse,String soins) {
		super(cin, nom, prenom, sexe, telephone, adresse);
		this.soins=soins;
	}
	
	

}
