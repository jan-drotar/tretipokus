package treti.pokus.fxmodely;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import treti.pokus.entity.Participant;
import treti.pokus.enumy.BloodType;
import treti.pokus.enumy.Gender;
import treti.pokus.enumy.Role;

public class ParticipantFxModel { // v poriadku
	
//  name //
	StringProperty name = new SimpleStringProperty();
	
	public String getName() {
		return name.get();
	}
	public void setName(String n) {
		this.name.set(n);
	}
	public StringProperty nameProperty() {
		return name;
	}
	
//  surname //
	StringProperty surname = new SimpleStringProperty();
	
	public String getSurname() {
		return surname.get();
	}
	public void setSurname(String n) {
		this.surname.set(n);
	}
	public StringProperty surnameProperty() {
		return surname;
	}
	
//  insuranceID //
	StringProperty insuranceID = new SimpleStringProperty();
	
	public String getInsuranceID() {
		return insuranceID.get();
	}
	public void setInsuranceID(String n) {
		this.insuranceID.set(n);
	}
	public StringProperty insuranceIDProperty() {
		return insuranceID;
	}

// bloodtype //
	StringProperty bloodtype = new SimpleStringProperty();
	
	public String getBloodtype() {
		return bloodtype.get();
	}
	public void setBloodtype(String n) {
		this.bloodtype.set(n);
	}
	public StringProperty bloodtypeProperty() {
		return bloodtype;
	}
	
//  email  //
	StringProperty email = new SimpleStringProperty();
	
	public String getEmail() {
		return email.get();
	}
	public void setEmail(String n) {
		this.email.set(n);
	}
	public StringProperty emailProperty() {
		return email;
	}
	
//   NEW password  //
	StringProperty newPassword = new SimpleStringProperty();
	
	public String getNewPassword() {
		return newPassword.get();
	}
	public void setNewPassword(String n) {
		this.newPassword.set(n);
	}
	public StringProperty newPasswordProperty() {
		return newPassword;
	}
	
//   RETYPE password  //
	StringProperty retypePassword = new SimpleStringProperty();
	
	public String getRetypePassword() {
		return retypePassword.get();
	}
	public void setRetypePassword(String n) {
		this.retypePassword.set(n);
	}
	public StringProperty retypePasswordProperty() {
		return retypePassword;
	}
	
//  dateOfBirth //
	ObjectProperty<LocalDate> dateOfBirth = new SimpleObjectProperty<>();
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth.get();
	}
	public void setDateOfBirth(LocalDate n) {
		this.dateOfBirth.set(n);
	}
	public ObjectProperty dateOfBirthProperty() {
		return dateOfBirth;
	}
	
//  gender  //
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
		
		//if (getName() == null || getName().trim().isEmpty() ||
		//		getSurname() == null || getSurname().trim().isEmpty() ||
		//		getInsuranceID() == null || getInsuranceID().trim().isEmpty() ||
		//		getBloodtype() == null|| getBloodtype().trim().isEmpty() ||
		//		getEmail() == null || getEmail().trim().isEmpty() ||
		//		getNewPassword() == null || getNewPassword().trim().isEmpty() || 
		//		getRetypePassword() == null || getRetypePassword().trim().isEmpty() ||
		 //       getDateOfBirth() == null || getDateOfBirth().until(LocalDate.now()).getYears() < 18 ||
		//        /*getGender() == null || getGender().trim().isEmpty() ||*/ 
		//        getWeight() == null || getWeight() < 60) {
		//			return null;
		//} else {
			Participant d = new Participant();
			d.setRole(Role.DONOR);
			d.setBloodType(BloodType.fromString(getBloodtype()));
			d.setName(getName());
			d.setSurname(getSurname());
			d.setInsuranceId(getInsuranceID());
			d.setEmail(getEmail());
	//		if (getNewPassword().equals(getRetypePassword())) {
	//			d.setPassword(getNewPassword());
	//		}///////////////////////////////////////////////////////////// inac chyba
			d.setDateOfBirth(getDateOfBirth());
			d.setGender(Gender.fromString(getGender()));
			d.setWeight(getWeight());
			
			return d;
	//	}
	}
}
