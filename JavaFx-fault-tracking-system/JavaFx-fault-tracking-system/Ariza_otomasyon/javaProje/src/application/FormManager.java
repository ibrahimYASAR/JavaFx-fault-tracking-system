package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FormManager {
	public  void FormOpen(String FormName, String FormTitle, String Png) {
		
		try {
    		Stage stage=new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(FormName));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle(FormTitle);
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED); 
			stage.getIcons().add(new Image(getClass().getResourceAsStream(Png)));
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	
}
}
