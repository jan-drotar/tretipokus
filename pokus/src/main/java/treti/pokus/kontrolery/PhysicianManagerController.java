package treti.pokus.kontrolery;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import javax.swing.text.TabableView;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import treti.pokus.entity.Donation;
import treti.pokus.entity.Participant;
import treti.pokus.enumy.DonationType;
import treti.pokus.fxmodely.ParticipantFxModel;
import treti.pokus.fxmodely.PhysicianManagerFxModel;
import treti.pokus.interfaces.DonationDao;
import treti.pokus.interfaces.ParticipantDao;
import treti.pokus.memoryDao.DonationMemoryDao;
import treti.pokus.memoryDao.ParticipantMemoryDao;

public class PhysicianManagerController {
	//registruje darcu
	private List<Participant> donors = new ArrayList<>();
	private ParticipantDao donorDao = new ParticipantMemoryDao();		  	
	private PhysicianManagerFxModel registeredDonor = new PhysicianManagerFxModel();
	//registruje darovanie
	private List<Donation> donations = new ArrayList<>();
	private DonationDao donationDao = new DonationMemoryDao();		  	
	private PhysicianManagerFxModel registeredDonation = new PhysicianManagerFxModel();
	
	private List<Participant> searched = new ArrayList<>();
	
	private ObservableList<Donation> donationModel;
	private Map<String, BooleanProperty> columnsVisibility = new LinkedHashMap<>();
	private ObjectProperty<Donation> selectedDonation = new SimpleObjectProperty<>();
	
	// all log out buttons
	@FXML
    private Button pLogOutButton1a;
	@FXML
	private Button pLogOutButton1b;
	@FXML
	private Button pLogOutButton2a;
	@FXML
    private Button pLogOutButton2b;
	@FXML
    private Button pLogOutButton3a;
	@FXML
    private Button pLogOutButton3b;
	
	// Blood Donation Registration
	
	@FXML
    private Button findDonInDonListrButton;
	
	@FXML
    private Button regTypeOfBloodDonationRegisterButton;

    @FXML
    private Label pNameLabel1a;

    @FXML
    private Label pSurnameLabel1a;

    @FXML
    private TextField findDonByInsuranceIDTextField;

    @FXML
    private TextField donsNewNameTextField;

    @FXML
    private TextField donsNewSurnameTextField;

    @FXML
    private TextField donsNewInsuranceIDTextField;

    @FXML
    private ComboBox<String> donsNewBloodTypeCombobox;

    @FXML
    private DatePicker donsNewDateOfBirthDatePicker;

    @FXML
    private ComboBox<String> donsNewGenderCombo;

    @FXML
    private ComboBox<String> regTypeOfBloodDonationCombobox;

    @FXML
    private Label pNameLabel1b;

    @FXML
    private Label pSurnameLabel1b;

    @FXML
    private Label selectedDonNameLabel;

    @FXML
    private Label selectedDonSurnameLabel;

    @FXML
    private Label selectedDonBloodTypeLabel;
    
    // Donation Approval Manager
    @FXML
    private Button findUntestedDonationButton;
    
    @FXML
    private Button approveForDonationButton;

    @FXML
    private Button disapproveDonationButton;    

    @FXML
    private Label pNameLabel2a;

    @FXML
    private Label pSurnameLabel2a;

    @FXML
    private TextField findUntestedDonationByIDTextField;

    @FXML
    private TableView<Donation> untestedDonatinsTableview;

    @FXML
    private Label donationIDLabel;

    @FXML
    private Label pNameLabel2b;

    @FXML
    private Label pSurnameLabel2b;

    @FXML
    private Label donationBloodTypeLabel;

    // Patient Manager
    @FXML
    private Button findPatientInDonListButton;
    
    @FXML
    private Button markDonAsPatientConfirmButton;

    @FXML
    private Button clearlistOfDonsToPatientButton;
    
    @FXML
    private Button registerNewPatientButton;
    
    @FXML
    private Button assignUnitsButton;

    @FXML
    private Label pNameLabel3a;

    @FXML
    private Label pSurnameLabel3a;

    @FXML
    private TextField findPatientInDonListByInsuranceIDTextField;

    @FXML
    private TextField findPatientInDonListBySurnameTextField;

    @FXML
    private TableView<?> listOfDonsToPatientTableView;

    @FXML
    private Label selectedPatientNameLabel;

    @FXML
    private Label selectedPatientSurnameLabel;

    @FXML
    private TextField patientNewNameTextField;

    @FXML
    private TextField patientNewSurnameTextField;

    @FXML
    private TextField patientNewInsuranceIDTextField;

    @FXML
    private ComboBox<String> patientNewBloodTypeCombobox;

    @FXML
    private DatePicker patientNewDateOfBirthDatePicker;

    @FXML
    private ComboBox<String> patientNewGenderCombobox;

    @FXML
    private ComboBox<String> typeOfTransFusionCombobox;

    @FXML
    private Label selectedPatientBloodTypeLabel;

    @FXML
    private TextField numberOfBloodUnitsTextField;

    @FXML
    private Label pNameLabel3b;

    @FXML
    private Label pSurnameLabel3b;
    
    @FXML
    private ListView<Participant> listOfDonorsLstView;
    
    @FXML
    private ListView<Participant> patientListview;

        
    private ParticipantDao participantDao = new ParticipantMemoryDao();
    
    public PhysicianManagerController() {
		
	}
    
    
    @FXML
    void initialize() {
    	
    	// Logout buttons odhlasi a spusti loginPageController
    	pLogOutButton1a.setOnAction(new LogOutHandler());
    	pLogOutButton1b.setOnAction(new LogOutHandler());
    	pLogOutButton2a.setOnAction(new LogOutHandler());
    	pLogOutButton2b.setOnAction(new LogOutHandler());
    	pLogOutButton3a.setOnAction(new LogOutHandler());
    	pLogOutButton3b.setOnAction(new LogOutHandler());
    	
    	//Comboboxes
    	donsNewBloodTypeCombobox.getItems().addAll("0+","0-","A+","A-","B+","B-","AB+","AB-");
        donsNewGenderCombo.getItems().addAll("male", "female");
        regTypeOfBloodDonationCombobox.getItems().addAll("Whole Blood","Plasma");
        patientNewBloodTypeCombobox.getItems().addAll("0+","0-","A+","A-","B+","B-","AB+","AB-");
        patientNewGenderCombobox.getItems().addAll("male", "female");
        typeOfTransFusionCombobox.getItems().addAll("Whole Blood","Plasma","Platelets","Red Cells");
        
        // bindBiderectionals
        // new donor
        donsNewNameTextField.textProperty().bindBidirectional(registeredDonor.nameProperty());
        donsNewInsuranceIDTextField.textProperty().bindBidirectional(registeredDonor.insuranceIDProperty());
        donsNewSurnameTextField.textProperty().bindBidirectional(registeredDonor.surnameProperty());
        donsNewBloodTypeCombobox.valueProperty().bindBidirectional(registeredDonor.bloodtypeProperty());
        donsNewDateOfBirthDatePicker.valueProperty().bindBidirectional(registeredDonor.dateOfBirthProperty());
        donsNewGenderCombo.valueProperty().bindBidirectional(registeredDonor.genderProperty());
		// new donation
        regTypeOfBloodDonationCombobox.valueProperty().bindBidirectional(registeredDonation.donationTypeProperty());
        
        patientNewNameTextField.textProperty().bindBidirectional(registeredDonor.nameProperty());
        patientNewSurnameTextField.textProperty().bindBidirectional(registeredDonor.surnameProperty());
        patientNewInsuranceIDTextField.textProperty().bindBidirectional(registeredDonor.insuranceIDProperty());
          	
    	// find donor by name or insuranceId
    	findDonInDonListrButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				
				if  
					(!findDonByInsuranceIDTextField.getText().trim().isEmpty() || 
					 !findDonByInsuranceIDTextField.getText().equals(null))  {
					String s = findDonByInsuranceIDTextField.getText(); 
					searched.addAll(donorDao.findPhysicianByInsuranceId(s));
					
					for (Participant participant : searched) {
						System.out.println(searched.toString());
					}
					listOfDonorsLstView.setItems(FXCollections.observableArrayList(searched));
					searched.clear();
					findDonByInsuranceIDTextField.setText("");
					
				}
			}
		});
    	    	
    	regTypeOfBloodDonationRegisterButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				/// zareg darovanie po vybrati druhu darovania 1 alebo 3

				Participant newDonor = registeredDonor.getUnregisteredDonor();
				donorDao.addParticipant(newDonor);
				
				donors = donorDao.getAll();
				System.out.println("Donor list  ###################################");
				for (Participant participant : donors) {
					System.out.println(participant.toString());
				}
				
				Donation newDonation = registeredDonation.getDonation(donorDao.getLastId());
				donationDao.addDonation(newDonation);
				
				donations = donationDao.getAll();
				System.out.println("Donation list -----------------------------------");
				for (Donation darovanie : donations) {
					System.out.println(darovanie.toString());
				}
			}
		});
    	
    	donationModel = FXCollections.observableArrayList(donationDao.getUntested());
    	TableColumn<Donation, Long> idCol = new TableColumn<>("ID");
    	idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    	untestedDonatinsTableview.getColumns().add(idCol);
    	columnsVisibility.put("ID", idCol.visibleProperty());
    	
    	TableColumn<Donation, DonationType> donationTypeCol = new TableColumn<>("TYPE");
    	donationTypeCol.setCellValueFactory(new PropertyValueFactory<>("donationType"));
    	untestedDonatinsTableview.getColumns().add(donationTypeCol);
    	columnsVisibility.put("TYPE", donationTypeCol.visibleProperty());
    	
    	TableColumn<Donation, Boolean> testedCol = new TableColumn<>("TESTED");
    	testedCol.setCellValueFactory(new PropertyValueFactory<>("tested"));
    	testedCol.setEditable(true);
    	untestedDonatinsTableview.getColumns().add(testedCol);
    	columnsVisibility.put("TESTED", testedCol.visibleProperty());
    	
    	TableColumn<Donation, Boolean> approvedCol = new TableColumn<>("APPROVAL");
    	approvedCol.setCellValueFactory(new PropertyValueFactory<>("approved"));
    	approvedCol.setEditable(true);
    	untestedDonatinsTableview.getColumns().add(approvedCol);
    	columnsVisibility.put("APPROVAL", approvedCol.visibleProperty());	
    	
    	untestedDonatinsTableview.setItems(donationModel);
    	untestedDonatinsTableview.setEditable(true);
    	
        /////////////////////////////////////////////////////   najdi participanta v findPartHandler
        findPatientInDonListButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub/////////////////////////////////////////
				System.out.println("find Patient");
			}
		});
        
        markDonAsPatientConfirmButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				////////////////////////////////////// nastavi z najdeneho donora pacienta + lable
				System.out.println("z donora je pacient");
			}
		});

        clearlistOfDonsToPatientButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// ////////////////////////////////////// opakuje sa vicisti tabulky
				System.out.println("clearne najdene");
			}
		});
        
        registerNewPatientButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// //////////////////////////////////////// zaregistruje vyplneneho patienta
				System.out.println("Patient patient = new Patient()");
			}
		});
        
        assignUnitsButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// ////////////////////////////////////////////  priradi ku pacientovi vybrane jednotky krvi
				System.out.println(patientNewBloodTypeCombobox.getValue());
				System.out.println(patientNewGenderCombobox.getValue());
				System.out.println(typeOfTransFusionCombobox.getValue());
				System.out.println("Assign  approved Blood");
				
			}
		});
        

    }
}
