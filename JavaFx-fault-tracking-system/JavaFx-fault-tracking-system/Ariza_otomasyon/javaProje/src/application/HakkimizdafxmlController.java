package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HakkimizdafxmlController {

	 @FXML
     private Button btn_geri;

     @FXML
     private Button btn_kapat;
     
     @FXML
     void btn_geri1(ActionEvent event) {
    	 Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close();
    	FormManager FormOpn =new FormManager();
    	  FormOpn.FormOpen("AnaSayfa.fxml","Teslimat Ýþlemleri","teslim.png");
     }

     @FXML
     void btn_kapat1(ActionEvent event) {
    	 Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close();
     }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView alt_ResimImageview;

    @FXML
    private ImageView hakkimizdaPane;

    @FXML
    private ImageView logoImageview;

    @FXML
    void initialize() {
    	

    }

}