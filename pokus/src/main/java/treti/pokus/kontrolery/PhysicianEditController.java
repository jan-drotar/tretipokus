package treti.pokus.kontrolery;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.jdbc.core.JdbcTemplate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import treti.pokus.entity.Physician;
import treti.pokus.fxmodely.PhysicianFXModel;
import treti.pokus.persistent.MysqlPhysicianDao;
import treti.pokus.persistent.PhysicianDao;
import treti.pokus.persistent.PhysicianDaoFactory;
import treti.pokus.persistent.PhysicianMemoryDao;

public class PhysicianEditController {
	
//	private PhysicianMemoryDao physicianDao = new PhysicianMemoryDao();
	private PhysicianDao physicianDao = PhysicianDaoFactory.INSTANCE.getMysqlPhysicianDao();
//	private MysqlPhysicianDao physisicanDao = new MysqlPhysicianDao();
	
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
				
				System.out.println(newPhysician.toString());
			}
		});
    	signOutButton.setOnAction(new LogOutHandler());

		
	}
}
