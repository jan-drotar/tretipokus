package treti.pokus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PhysicianApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		PhysicianEditController controller = new PhysicianEditController();
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource("PhysicianEdit.fxml"));
		fxmlLoader.setController(controller);
		Parent rootPane = fxmlLoader.load();
		Scene scene = new Scene(rootPane);
		stage.setTitle("Physician Edit Menu");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
