package treti.pokus.apps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import treti.pokus.kontrolery.DonorProfileController;

public class AppDonorProfile extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		DonorProfileController profileController = new DonorProfileController();
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource("DonorProfile.fxml"));
		fxmlLoader.setController(profileController);
		Parent rootPane = fxmlLoader.load();
		Scene scene = new Scene(rootPane);
		stage.setTitle("Edit profile");
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}

	
	
}