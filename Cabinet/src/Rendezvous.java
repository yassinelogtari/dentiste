
public class Rendezvous {
	
	String patient,date,heure,email;

	public Rendezvous(String patient, String date, String heure, String email) {
		super();
		this.patient = patient;
		this.date = date;
		this.heure = heure;
		this.email = email;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
