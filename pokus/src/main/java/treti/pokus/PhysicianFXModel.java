package treti.pokus;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PhysicianFXModel {
	private Long id;
	private Physician physician;
	private StringProperty name = new SimpleStringProperty();
	private StringProperty surname = new SimpleStringProperty();
	private StringProperty newPassword = new SimpleStringProperty();
	private StringProperty retypePassword = new SimpleStringProperty();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PhysicianFXModel() {
	}

	public PhysicianFXModel(Physician physician) {
		this.physician = physician;
		setName(physician.getName());
		setSurname(physician.getSurname());
		if (getNewPassword().equals(getRetypePassword())) {
			physician.setPassword(getNewPassword());
		}
	}

	public Physician getPhysician() {
		physician.setName(getName());
		physician.setSurname(getSurname());
		physician.setPassword(getNewPassword());
		return physician;
	}

	public String getNewPassword() {
		return newPassword.get();
	}

	public void setNewPassword(String newPassword) {
		this.newPassword.set(newPassword);
	}

	public StringProperty newPasswordProperty() {
		return this.newPassword;
	}
	
	public String getRetypePassword() {
		return retypePassword.get();
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword.set(retypePassword);
	}

	public StringProperty retypePasswordProperty() {
		return this.retypePassword;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public StringProperty nameProperty() {
		return name;
	}

	public String getSurname() {
		return surname.get();
	}

	public void setSurname(String surname) {
		this.surname.set(surname);
	}

	public StringProperty surnameProperty() {
		return surname;
	}
}
