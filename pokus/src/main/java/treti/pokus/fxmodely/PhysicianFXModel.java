package treti.pokus.fxmodely;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import treti.pokus.entity.Physician;

public class PhysicianFXModel {
	
	private Long id;
	private Physician physician;
	
	private StringProperty login = new SimpleStringProperty();
	private StringProperty name = new SimpleStringProperty();
	private StringProperty surname = new SimpleStringProperty();
	private StringProperty newPassword = new SimpleStringProperty();
	private StringProperty retypePassword = new SimpleStringProperty();


	public PhysicianFXModel() {
	}

	public PhysicianFXModel(Physician physician) {
		this.physician = physician;
		setLogin(physician.getName()+"."+physician.getSurname());
		setName(physician.getName());
		setSurname(physician.getSurname());
		setNewPassword(physician.getPassword());
		
	}

	public Physician getPhysician() {
		Physician physician = new Physician();
		physician.setLogin(physician.getName()+"."+physician.getSurname());
		physician.setName(getName());
		physician.setSurname(getSurname());
		physician.setPassword(getNewPassword());
		return physician;
	}
	
	public String getLogin() {
		return login.get();
	}

	public void setLogin(String login) {
		this.login.set(login);
	}

	public StringProperty loginProperty() {
		return this.login;
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
