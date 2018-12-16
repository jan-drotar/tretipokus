package treti.pokus.apps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import treti.pokus.kontrolery.DonorEditController;

public class AppDonorEdit extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		DonorEditController editController = new DonorEditController();
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource("DonorEdit.fxml"));
		fxmlLoader.setController(editController);
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