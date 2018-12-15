package treti.pokus;


import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class DonorProfileController {
	
	private List<Notifikation> notifikations = new ArrayList<>();

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


    public DonorProfileController() {
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
    private Label dateOfLastDonationLabel;

    @FXML
    void initialize() {
    	messageFromPhysicianListView.setItems(FXCollections.observableArrayList(notifikations));
    	
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
}
