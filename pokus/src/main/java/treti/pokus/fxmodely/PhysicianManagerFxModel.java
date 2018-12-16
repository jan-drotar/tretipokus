package treti.pokus.fxmodely;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import treti.pokus.entity.Donation;
import treti.pokus.entity.Participant;
import treti.pokus.enumy.BloodType;
import treti.pokus.enumy.DonationType;
import treti.pokus.enumy.Gender;
import treti.pokus.enumy.Role;

public class PhysicianManagerFxModel {
	
	private Participant participant;
	
	public PhysicianManagerFxModel() {
		
	}
	
	public PhysicianManagerFxModel(Participant p) {
		this.participant = p;
		setName(p.getName());
		setSurname(p.getSurname());
		setInsuranceID(p.getInsuranceID());
		setBloodtype(p.getBloodType().getText());
		setDateOfBirth(p.getDateOfBirth());
		setGender(p.getGender().getText());
		
	}
	
	///////////////// REGISTER NEW DONOR
	
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
		this.gender.set(n);
	}
	public StringProperty genderProperty() {
		return gender;
	}
	
	public Participant getUnregisteredDonor() {
		//	if (getName() == null || getName().trim().isEmpty() ||
		//			getSurname() == null || getSurname().trim().isEmpty() ||
		//			getInsuranceID() == null || getInsuranceID().trim().isEmpty() ||
		//			getBloodtype() == null|| getBloodtype().trim().isEmpty() ||
		//			getDateOfBirth() == null || getDateOfBirth().until(LocalDate.now()).getYears() < 18 //||
		//	      /*  getGender() == null || getGender().trim().isEmpty()*/) {
		//				return null;
		//	} else {
				Participant d = new Participant();
				d.setRole(Role.DONOR);
				d.setBloodType(BloodType.fromString(getBloodtype()));
				d.setName(getName());
				d.setSurname(getSurname());
				d.setInsuranceID(getInsuranceID());
				d.setDateOfBirth(getDateOfBirth());
				d.setGender(Gender.fromString(getGender()));
				
				return d;
		//	}
		}
	
	///////////////////////////////// REGISTER NEW DONATION
	//donationType
		StringProperty donationType = new SimpleStringProperty();
		
		public String getDonationType() {
			return donationType.get();
		}
		public void setDonationType(String n) {
			this.donationType.set(n);
		}
		public StringProperty donationTypeProperty() {
			return donationType;
		}

		public Donation getDonation() {
			if (getDonationType() == null|| getDonationType().trim().isEmpty()) {
				return null;
			} else {
				Donation d = new Donation();
				d.setDonationType(DonationType.fromString(getDonationType()));
				d.setRegistered(LocalDate.now());
				return d;
			}
		}


	

}
