package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class AlertManager {
	
	
	
		 public static void Alert(String baslik,String bilgi, String altBilgi) {
			 
			 Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle(baslik);
				alert.setHeaderText(bilgi);
				alert.setContentText(altBilgi);
				alert.showAndWait();
		 }
		
	
	}
