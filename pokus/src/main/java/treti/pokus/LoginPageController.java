package treti.pokus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPageController {
	
	@FXML
    private Button donorSignInButton;
	
	@FXML
	private Button physicianSignInButton;

	@FXML
	private Button createNewAccountButton;
	
	@FXML
    private Button sendNewPasswordButton;
	

    @FXML
    private TextField donorEmailSignInTextField;

    @FXML
    private PasswordField donorPasswordField;

    

    @FXML
    private TextField physicianlSignInTextField;

    @FXML
    private PasswordField physicianPasswordField;

   

    @FXML
    private TextField forgotPassEmailTextField;

    

    @FXML
    void initialize() {
        donorSignInButton.setOnAction(new EventHandler<ActionEvent>() {
			/////////////////////////////////////////////////////////////////////////// prihlasenie donora
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Donor Sign In Button.");
				
			}
		});
        physicianSignInButton.setOnAction(new EventHandler<ActionEvent>() {
			///////////////////////////////////////////////////////////////////////// prihlasenie lekara
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Physician Sign In Button.");
				
			}
		});
        createNewAccountButton.setOnAction(new EventHandler<ActionEvent>() {
			////////////////////////////////////////////////////////////////////// spustit DonorEditControl
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Create New Account.");
				
			}
		});
        sendNewPasswordButton.setOnAction(new EventHandler<ActionEvent>() {
			////////////////////////////////////////////////////////////////////////poslat mail s novym heslom??? alebo reset????
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Send New Password.");
				
			}
		});
    }
}
