package treti.pokus.kontrolery;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPageController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField physicianlSignInTextField;

	@FXML
	private PasswordField physicianPasswordField;

	@FXML
	private Button physicianSignInButton;

	@FXML
	private TextField forgotPassEmailTextField;

	@FXML
	private Button sendNewPasswordButton;

	@FXML
	void initialize() {
		assert physicianlSignInTextField != null : "fx:id=\"physicianlSignInTextField\" was not injected: check your FXML file 'LoginPage.fxml'.";
		assert physicianPasswordField != null : "fx:id=\"physicianPasswordField\" was not injected: check your FXML file 'LoginPage.fxml'.";
		assert physicianSignInButton != null : "fx:id=\"physicianSignInButton\" was not injected: check your FXML file 'LoginPage.fxml'.";
		assert forgotPassEmailTextField != null : "fx:id=\"forgotPassEmailTextField\" was not injected: check your FXML file 'LoginPage.fxml'.";
		assert sendNewPasswordButton != null : "fx:id=\"sendNewPasswordButton\" was not injected: check your FXML file 'LoginPage.fxml'.";

	}
}
