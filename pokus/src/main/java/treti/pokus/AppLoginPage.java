package treti.pokus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLoginPage extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		LoginPageController loginController = new LoginPageController();
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource("LoginPage.fxml"));
		fxmlLoader.setController(loginController);
		Parent rootPane = fxmlLoader.load();
		Scene scene = new Scene(rootPane);
		stage.setTitle("Sign in");
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}

	
	
}
