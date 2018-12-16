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
import treti.pokus.Notifikation;
import treti.pokus.entity.Participant;
import treti.pokus.fxmodely.ParticipantFxModel;
import treti.pokus.persistent.ParticipantDAO;

public class DonorEditController {
	
	private List<Notifikation> notifikations = new ArrayList<>();
	
	private List<Participant> donors = new ArrayList<>();
	private ParticipantDAO pdao = new ParticipantDAO();		  	
	
	private ParticipantFxModel editedDonor = new ParticipantFxModel();
	
	public DonorEditController() {
		// T////////////////////////////////////////////// zatial to tu necham
		Notifikation n = new Notifikation();
		n.setId(1);
		n.setSprava("Prvy message");
		n.setLekar("LEKAR");
		notifikations.add(n);
		Notifikation n2 = new Notifikation();
		n2.setId(2);
		n2.setSprava("Druhy message");
		n2.setLekar("LEKAR 2");
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
				
				try {
					Participant donor = editedDonor.getDonor();
					pdao.addParticipant(donor);
					
					donors = pdao.getAll();
					
					for (Participant participant : donors) {
						System.out.println(participant.toString());
					}
					System.out.println("###################################");
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
        //odhlasenie spusti sa LoginPageController
        signOutButton.setOnAction(new LogOutHandler());
        
    }
    
    
    
}
