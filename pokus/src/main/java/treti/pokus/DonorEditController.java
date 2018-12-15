package treti.pokus;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class DonorEditController {
	
	@FXML
    private Button updateRegisterButton;

    @FXML
    private Button signOutButton;

   

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField insuranceIDTextfield;

    @FXML
    private ComboBox<String> bloodTypeCombobox;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField retypePasswordField;

    @FXML
    private DatePicker dateOfBirthPicker;

    @FXML
    private ComboBox<String> genderCombobox;

    @FXML
    private TextField weightTextField;


    @FXML
    void initialize() {
        updateRegisterButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			//////////////////////////////////////////////////////ulozit noveho donora alebo update?????? a otvori donor profil controller
			public void handle(ActionEvent event) {
				System.out.println(bloodTypeCombobox.getValue());
				System.out.println(genderCombobox.getValue());
				System.out.println("Register or Update.");
				
			}
		});
        //odhlasenie spusti sa LoginPageController
        signOutButton.setOnAction(new LogOutHandler());
        
        bloodTypeCombobox.getItems().addAll("0+","0-","A+","A-","B+","B-","AB+","AB-");
        genderCombobox.getItems().addAll("male", "female");

    }
}
