package treti.pokus.kontrolery;


import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import treti.pokus.Notifikation;

public class DonorProfileController {

	@FXML
    private Button editProfileButton;

    @FXML
    private Button signOutButton;

    @FXML
    private Label nameLabel;

    @FXML
    private Label surnameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label bloodTypeLabel;

    @FXML
    private Label donationsCountLabel;

    @FXML
    private Label daysTilNextDonationLabel;

    @FXML
    private ListView<Notifikation> messageFromPhysicianListView;


    @FXML
    private Label dateOfLastDonationLabel;

    @FXML
    void initialize() {
    	   	
    	editProfileButton.setOnAction(new EventHandler<ActionEvent>() {
			///////////////////////////////////////////////////////////////// edit spusti donor edit control s prednastavenymi udajmi ++ nazvy buttonov pomenit na update abo co
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Edit profile.");
				
			}
		});
    	// odhlasi a otvori login page controller
        signOutButton.setOnAction(new LogOutHandler());

    }
    
    public void setNameLabel (String n) {
        nameLabel.setText(n);
    }
    public void setSurnameLabel (String n) {
        surnameLabel.setText(n);
    }
    public void setEmailLabel (String n) {
        emailLabel.setText(n);
    }
    public void setBloodTypeLabel (String n) {
        bloodTypeLabel.setText(n);
    }
    public void setDonationsCountLabel (String n) {
        donationsCountLabel.setText(n);
    }
    public void setDaysTilNextDonations (String n) {
        daysTilNextDonationLabel.setText(n);
    }
    public void setMessagesFromPhysician(List n) {
    	messageFromPhysicianListView.setItems(FXCollections.observableArrayList(n));
    }
    
}
