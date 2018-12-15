package treti.pokus;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ParticipantFxModel {
	
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

// bloodtype//
	StringProperty bloodtype = new SimpleStringProperty();
	
	public String getBloodtype() {
		return bloodtype.get();
	}
	public void setBloodtype(String n) {
		this.setBloodtype(n);
	}
	public StringProperty bloodtypeProperty() {
		return bloodtype;
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
	
//   NEW password; //
	StringProperty newPassword = new SimpleStringProperty();
	
	public String getNewPassword() {
		return newPassword.get();
	}
	public void setNewPassword(String n) {
		this.setNewPassword(n);
	}
	public StringProperty newPasswordProperty() {
		return newPassword;
	}
	
//   RETYPE password; //
	StringProperty retypePassword = new SimpleStringProperty();
	
	public String getRetypePassword() {
		return retypePassword.get();
	}
	public void setRetypePassword(String n) {
		this.setRetypePassword(n);
	}
	public StringProperty retypePasswordProperty() {
		return retypePassword;
	}
	
	//  dateOfBirth; // DatePicker////////////////////////////////////////////////////////////////////////////
	
//  gender;
	StringProperty gender = new SimpleStringProperty();
	
	public String getGender() {
		return gender.get();
	}
	public void setGender(String n) {
		this.setGender(n);
	}
	public StringProperty genderProperty() {
		return gender;
	}

	
//  weight; //
	DoubleProperty weight = new SimpleDoubleProperty();
	
	public Double getWeight() {
		return weight.get();
	}
	public void setWeight(Double n) {
		this.setWeight(n);
	}
	public DoubleProperty weightProperty() {
		return weight;
	}
		
	public Participant getDonor() {
		
		Participant p = new Participant();
		// id
		p.setRole(Role.DONOR);
		// bloodtype
		p.setName(getName());
		p.setSurname(getSurname());
		p.setInsuranceID(getInsuranceID());
		p.setEmail(getEmail());
		if (getNewPassword().equals(getRetypePassword())) {
			p.setPassword(getNewPassword());
		}///////////////////////////////////////////////////////////// inac chyba
		//  dateOfBirth///////////////////////////////////////////////// datum narodenia
		//p.setGender(Gender(getGender());
		//  weight
		//  dateOfLastDonation
		//  countOfDonations
		//  approved
		//  list of notifikations
		
		return p;
	}

}
