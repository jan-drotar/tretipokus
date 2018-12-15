package treti.pokus;


import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class DonorEditController {
	
	private List<Participant> donors = new ArrayList<>();
	
	public DonorEditController() {
		Participant p = new Participant();
		p.setRole(Role.DONOR);
		p.setBloodType(BloodType.O_POS);
		p.setName("Jano");
		p.setSurname("Drotar");
		p.setInsuranceID("123456");
		p.setEmail("jano.drotar@gmail.com");
		p.setPassword("123");
		////////////////////////////////////////////////////////p.setDateOfBirth(dateOfBirth);
		p.setGender(Gender.MALE);
		p.setWeight(115.5);
		///////////////////////////////////////////date of last donation
		donors.add(p);
	}
	
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
				for (Participant participant : donors) {
					System.out.println(participant.toString());
				}
				
			}
		});
        //odhlasenie spusti sa LoginPageController
        signOutButton.setOnAction(new LogOutHandler());
        
        bloodTypeCombobox.getItems().addAll("0+","0-","A+","A-","B+","B-","AB+","AB-");
        genderCombobox.getItems().addAll("male", "female");

    }
}
