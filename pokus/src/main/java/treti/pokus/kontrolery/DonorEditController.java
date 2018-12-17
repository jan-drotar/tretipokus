package treti.pokus.kontrolery;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import treti.pokus.entity.Notification;
import treti.pokus.entity.Participant;
import treti.pokus.fxmodely.ParticipantFxModel;
import treti.pokus.interfaces.ParticipantDao;
import treti.pokus.memoryDao.ParticipantMemoryDao;

public class DonorEditController {
	//TODO donor db connection
	private List<Notification> notifikations = new ArrayList<>();
	
	private List<Participant> donors = new ArrayList<>();
	private ParticipantDao dontDao = new ParticipantMemoryDao();		  	
	
	private ParticipantFxModel editedDonor = new ParticipantFxModel();
	
	public DonorEditController() {
//		FIXME upratat po sebe kod
		// T////////////////////////////////////////////// zatial to tu necham
		Notification n = new Notification();
		n.setId(1);
		n.setMessage("Prvy message");
		n.setPhysicianId(1);
		notifikations.add(n);
		Notification n2 = new Notification();
		n2.setId(2);
		n2.setMessage("Druhy message");
		n2.setPhysicianId(2);
		notifikations.add(n2);
	
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
    	bloodTypeCombobox.getItems().addAll("0+","0-","A+","A-","B+","B-","AB+","AB-");
        genderCombobox.getItems().addAll("male", "female");
    	
    	nameTextField.textProperty().bindBidirectional(editedDonor.nameProperty());
		surnameTextField.textProperty().bindBidirectional(editedDonor.surnameProperty());
		insuranceIDTextfield.textProperty().bindBidirectional(editedDonor.insuranceIDProperty());
		bloodTypeCombobox.valueProperty().bindBidirectional(editedDonor.bloodtypeProperty());
		emailTextField.textProperty().bindBidirectional(editedDonor.emailProperty());
		passwordField.textProperty().bindBidirectional(editedDonor.newPasswordProperty());
		retypePasswordField.textProperty().bindBidirectional(editedDonor.retypePasswordProperty());
		dateOfBirthPicker.valueProperty().bindBidirectional(editedDonor.dateOfBirthProperty());
		genderCombobox.valueProperty().bindBidirectional(editedDonor.genderProperty());
		weightTextField.textProperty().bindBidirectional(editedDonor.weightProperty(), new NumberStringConverter());
		
    	
        updateRegisterButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			//////////////////////////////////////////////////////ulozit noveho donora alebo update?????? a otvori donor profil controller
			public void handle(ActionEvent event) {
				
				Participant don = editedDonor.getDonor();
				dontDao.addParticipant(don);
				
				donors = dontDao.getAll();
				System.out.println("Donor list  ###################################");
				for (Participant participant : donors) {
					System.out.println(participant.toString());
				}
			}
		});
        //odhlasenie spusti sa LoginPageController
        signOutButton.setOnAction(new LogOutHandler());
        
    }
    
    
    
}
