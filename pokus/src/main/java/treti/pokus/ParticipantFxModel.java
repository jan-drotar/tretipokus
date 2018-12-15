package treti.pokus;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ParticipantFxModel {
	//  id; //  asi netreba
	
	// role; //  /ENUM
	
	//  bloodType; // ENUM
	
//  name; //
	StringProperty name = new SimpleStringProperty();
	
	public String getName() {
		return name.get();
	}
	public void setName(String n) {
		this.setName(n);
	}
	public StringProperty nameProperty() {
		return name;
	}
	
//  surname; //
	StringProperty surname = new SimpleStringProperty();
	
	public String getSurname() {
		return surname.get();
	}
	public void setSurname(String n) {
		this.setSurname(n);
	}
	public StringProperty surnameProperty() {
		return surname;
	}
	
//  insuranceID; //
	StringProperty insuranceID = new SimpleStringProperty();
	
	public String getInsuranceID() {
		return insuranceID.get();
	}
	public void setInsuranceID(String n) {
		this.setInsuranceID(n);
	}
	public StringProperty insuranceIDProperty() {
		return insuranceID;
	}
	
//  email; //
	StringProperty email = new SimpleStringProperty();
	
	public String getEmail() {
		return email.get();
	}
	public void setEmail(String n) {
		this.setEmail(n);
	}
	public StringProperty emailProperty() {
		return email;
	}
	
//  password; //
	StringProperty password = new SimpleStringProperty();
	
	public String getPassword() {
		return password.get();
	}
	public void setPassword(String n) {
		this.setPassword(n);
	}
	public StringProperty passwordProperty() {
		return password;
	}
	
	//  dateOfBirth; // DatePicker
	
	//  gender; // ENUM
	
	//  weight; // integer
	
	//  dateOfLastDonation; // setuje lekar
	
	//  countOfDonations; // setuje lekar asi
	
	//  approved; // setuje lekar BOOLEAN
	
	//List<Notifikation> listOfNotifikations = new ArrayList<>(); TU NEVIEM
	
	public Participant getParticipant() {
		Participant p = new Participant();
		// id
		// rola
		// bloodtype
		p.setName(getName());
		p.setSurname(getSurname());
		p.setInsuranceID(getInsuranceID());
		p.setEmail(getEmail());
		p.setPassword(getPassword());
		//  dateOfBirth
		//  gender
		//  weight
		//  dateOfLastDonation
		//  countOfDonations
		//  approved
		//  list of notifikations
		
		return p;
	}

}
