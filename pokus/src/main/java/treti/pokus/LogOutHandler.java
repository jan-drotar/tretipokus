package treti.pokus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;

public class LogOutHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		
		
		// odhlasenie a spusti loginpagecontroller
		System.out.println("Odhlass");
		((Node)(event.getSource())).getScene().getWindow().hide();
		AppLoginPage lp = new AppLoginPage();
		try {
			lp.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
