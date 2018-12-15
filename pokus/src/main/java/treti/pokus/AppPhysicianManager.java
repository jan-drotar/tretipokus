package treti.pokus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppPhysicianManager extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		PhysicianManagerController managerController = new PhysicianManagerController();
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource("PhysicianManager.fxml"));
		fxmlLoader.setController(managerController);
		Parent rootPane = fxmlLoader.load();
		Scene scene = new Scene(rootPane);
		stage.setTitle("Physicians Manager");
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}

	
	
}