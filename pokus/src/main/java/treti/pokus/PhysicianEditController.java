package treti.pokus;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PhysicianEditController {
	
	private PhysicianMemoryDao physicianDao = new PhysicianMemoryDao();
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label physicianRegistrationUpdateLabel;

	@FXML
	private Label physicianNameLabel;

	@FXML
	private TextField physicianNameTextField;

	@FXML
	private Label physicianSurnameLabel;

	@FXML
	private TextField physicianSurnameTextField;

	@FXML
	private Label physicianNewPasswordLable;

	@FXML
	private PasswordField physicianPasswordField;

	@FXML
	private Label physicianRetypePasswordLable;

	@FXML
	private PasswordField physicianRetypePasswordField;

	@FXML
	private Button physicianUpdateRegisterButton;

	@FXML
	private Button signOutButton;

	private PhysicianFXModel editedPhysician = new PhysicianFXModel();
//    private Physician selectedPhysician = null;

	
	@FXML
	void initialize() {
		
    	physicianNameTextField.textProperty().bindBidirectional(editedPhysician.nameProperty());
    	physicianSurnameTextField.textProperty().bindBidirectional(editedPhysician.surnameProperty());
//    	TODO: change password properties
    	physicianPasswordField.textProperty().bindBidirectional(editedPhysician.newPasswordProperty());
    	physicianRetypePasswordField.textProperty().bindBidirectional(editedPhysician.retypePasswordProperty());
    	
    	physicianUpdateRegisterButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
//				 ulozit noveho Lekara (Physician)
				Physician newPhysician = editedPhysician.getPhysician();
				physicianDao.add(newPhysician);
			}
		});
    	signOutButton.setOnAction(new LogOutHandler());

		
		
		/*
		assert physicianNameLabel != null : "fx:id=\"physicianNameLabel\" was not injected: check your FXML file 'PhysicianEdit.fxml'.";
		assert physicianNameTextField != null : "fx:id=\"physicianNameTextField\" was not injected: check your FXML file 'PhysicianEdit.fxml'.";
		assert physicianSurnameLabel != null : "fx:id=\"physicianSurnameLabel\" was not injected: check your FXML file 'PhysicianEdit.fxml'.";
		assert physicianSurnameTextField != null : "fx:id=\"physicianSurnameTextField\" was not injected: check your FXML file 'PhysicianEdit.fxml'.";
		assert physicianNewPasswordLable != null : "fx:id=\"physicianNewPasswordLable\" was not injected: check your FXML file 'PhysicianEdit.fxml'.";
		assert physicianPasswordField != null : "fx:id=\"physicianPasswordField\" was not injected: check your FXML file 'PhysicianEdit.fxml'.";
		assert physicianRetypePasswordLable != null : "fx:id=\"physicianRetypePasswordLable\" was not injected: check your FXML file 'PhysicianEdit.fxml'.";
		assert physicianRetypePasswordField != null : "fx:id=\"physicianRetypePasswordField\" was not injected: check your FXML file 'PhysicianEdit.fxml'.";
		assert physicianUpdateRegisterButton != null : "fx:id=\"physicianUpdateRegisterButton\" was not injected: check your FXML file 'PhysicianEdit.fxml'.";
		assert signOutButton != null : "fx:id=\"signOutButton\" was not injected: check your FXML file 'PhysicianEdit.fxml'.";
		*/
	}
}
