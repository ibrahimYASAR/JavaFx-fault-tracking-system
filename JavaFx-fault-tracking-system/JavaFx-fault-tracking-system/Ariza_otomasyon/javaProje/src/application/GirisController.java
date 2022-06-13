package application;

import java.net.URL;
import java.util.ResourceBundle;
import com.ProjeMySQL.Util.VeritabaniUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.sql.*;

public class GirisController {
	
	public  GirisController() {
		baglanti=VeritabaniUtil.Baglan(); 
		
	}
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_kapat;

    @FXML
    private Button btn_login;

   

    @FXML
    private TextField txt_kul;
    @FXML
    private Button btn_login2;
    @FXML
    private PasswordField txt_sifre1;

    @FXML
    private ImageView loginresim;
    @FXML
    private ImageView ust_resim;
    

    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    
    
    @FXML
    void btn_kapat1(ActionEvent event) {
    	Node  source = (Node)  event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
    @FXML
    void btn_login_click(ActionEvent event) {
sql="select*from login where kul_ad=? and sifre=?";
try {

sorguifadesi=baglanti.prepareStatement(sql);
sorguifadesi.setString(1, txt_kul.getText().trim());
sorguifadesi.setString(2, VeritabaniUtil.LoginSifre(txt_sifre1.getText().trim()));

ResultSet getirilen =sorguifadesi.executeQuery();

if(!getirilen.next()) {
	
	AlertManager.Alert("hatalý giriþ","Bilgilendirme Mesajý","Kullanýcý Adý Veya Þifre Hatalý !\nLütfen Bilgilerinizi Kontrol Ediniz...");
	
	
	
}else {
	
	FormManager FormOpn =new FormManager();
  	  FormOpn.FormOpen("AnaSayfa.fxml","ANA SAYFAYA HOÞGELDÝNÝZ","anasayfa1.png");          
  	Node  source = (Node)  event.getSource();
	    Stage stage = (Stage)source.getScene().getWindow();
	    stage.close();
}
	
} catch (Exception e) {
	// TODO: handle exception
	
	AlertManager.Alert("hata!","Bilgilendirme Mesajý","Teknik Bir Arýza Var !\nLütfen Yöneticinize Baþvurunuz...\n"+e.getMessage().toString());
	
}
    }

    
    @FXML
    void btn_login2_click(ActionEvent event) {
    	sql="select*from kullanici where k_user=? and k_pass=?";
    	try {

    	sorguifadesi=baglanti.prepareStatement(sql);
    	sorguifadesi.setString(1, txt_kul.getText().trim());
    	sorguifadesi.setString(2, VeritabaniUtil.LoginSifre(txt_sifre1.getText().trim()));

    	ResultSet getirilen =sorguifadesi.executeQuery();

    	if(!getirilen.next()) {
    		
    		AlertManager.Alert("hatalý giriþ","Bilgilendirme Mesajý","Kullanýcý Adý Veya Þifre Hatalý !\nLütfen Bilgilerinizi Kontrol Ediniz...");
    		
    		
    		
    	}else {
    		
    		FormManager FormOpn =new FormManager();
  	  	  FormOpn.FormOpen("AnaSayfa2.fxml","ANA SAYFAYA HOÞGELDÝNÝZ","anasayfa1.png");
  		
  	  	Node  source = (Node)  event.getSource();
  	    Stage stage = (Stage)source.getScene().getWindow();
  	    stage.close();
    	}
    	
    	} catch (Exception e) {
    		// TODO: handle exception
    		
    		AlertManager.Alert("hata!","Bilgilendirme Mesajý","Teknik Bir Arýza Var !\nLütfen Yöneticinize Baþvurunuz...\n"+e.getMessage().toString());
    		
    	}
    	
    	
    }
  
    @FXML
    void initialize() {
        
    	
    }

}
