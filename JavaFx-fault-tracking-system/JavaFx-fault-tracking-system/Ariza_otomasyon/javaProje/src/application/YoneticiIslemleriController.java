package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.ProjeMySQL.Util.VeritabaniUtil;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class YoneticiIslemleriController {
	public  YoneticiIslemleriController() {
		baglanti=VeritabaniUtil.Baglan();
		
	} @FXML
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
    private TableView<LoginBilgi> TableLogin;

    @FXML
    private TableColumn<LoginBilgi, String> adi;

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private Button btn_guncelle;

    @FXML
    private Button btn_kaydet;

    @FXML
    private Button btn_login;
    @FXML
    private Button btn_menu;
    @FXML
    private Button btn_sil;
    @FXML
    private AnchorPane anckorpane2;
    @FXML
    private Button btn_temizle;

    @FXML
    private TableColumn<LoginBilgi, Integer> id;

    @FXML
    private Label lblid;

    @FXML
    private TableColumn<LoginBilgi, String> sifre;

    @FXML
    private TextField txt_arama;

    @FXML
    private TextField txtkul;

    @FXML
    private TextField txtsifre;
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    int durum=0;
    @FXML
    void btn_menu1(ActionEvent event) {
    	if(durum==0) {
    		FadeTransition fd1= new FadeTransition(Duration.seconds(0.5), anckorpane2);
    		fd1.setFromValue(0);
    	fd1.setToValue(0.5);
    		fd1.play();
    		
    		TranslateTransition tt1 =new TranslateTransition(Duration.seconds(1),anckorpane2);
    		tt1.setByX(-495);
    		tt1.play();
    		durum=1;
    	}else {
    		FadeTransition fd1= new FadeTransition(Duration.seconds(0.5), anckorpane2);
    		fd1.setFromValue(1);
    	fd1.setToValue(1);
    		fd1.play();
    		
    		TranslateTransition tt1 =new TranslateTransition(Duration.seconds(1),anckorpane2);
    		tt1.setByX(+495);
    		tt1.play();
    		durum=0;

    	}
    }
    @FXML
    void btn_guncelle1(ActionEvent event) {
    	 sql="update  login set  Kid=?, Kul_ad=?, sifre=? where Kid=?";
         
         
         try {
      	   sorguifadesi=baglanti.prepareStatement(sql);
             sorguifadesi.setString(1, lblid.getText().trim()) ;
             sorguifadesi.setString(2, txtkul.getText().trim());
             sorguifadesi.setString(3, VeritabaniUtil.LoginSifre(txtsifre.getText().trim()));
             sorguifadesi.setString(4, lblid.getText().trim());
             
             sorguifadesi.executeUpdate();
             AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Guncelleme Gerçekleþti...");
             
             
             
  		
  	} catch (Exception e) {
  		AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Guncelleme Gerçekleþmedi...\n"+e.getMessage().toString());
  		
  	}sql="select * from login";
         DegerleriGetir(TableLogin,sql);
    }

    @FXML
    void btn_kaydet1(ActionEvent event) {
sql="insert into login(kul_ad,sifre) values(?,?)";
        
        try {
     	   sorguifadesi=baglanti.prepareStatement(sql);
           // sorguifadesi.setString(1, lblid.getText().trim());
            sorguifadesi.setString(1, txtkul.getText().trim());
            sorguifadesi.setString(2, VeritabaniUtil.LoginSifre(txtsifre.getText().trim()));
            sorguifadesi.executeUpdate();
            AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Kullanýcý Ekleme iþlemi Gerçekleþti...");
            
            
 		
 	} catch (Exception e) {
 		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Kullanýcý Ekleme iþlemi Gerçekleþmedi...\n"+e.getMessage().toString());
  		
 	}sql="select * from login";
 	DegerleriGetir(TableLogin,sql);
    }
   
    @FXML
    void btn_login1(ActionEvent event) {
    	try {
    		AnchorPane panel=(AnchorPane)FXMLLoader.load(getClass().getResource("giris.fxml"));
    		anckorpane2.getChildren().setAll(panel);
    	} catch (Exception e) {
    		// TODO: handle exception
    		e.printStackTrace();
    	}
    	
    }

    @FXML
    void btn_sil1(ActionEvent event) {
sql="delete from  login where Kid=? and kul_ad=?";
        
        try {
     	   sorguifadesi=baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, (lblid.getText().trim()));
            sorguifadesi.setString(2, (txtkul.getText().trim()));
            sorguifadesi.executeUpdate();
            AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Kullanýcý Silme Gerçekleþti...");
            
            
            
 		
 	} catch (Exception e) {
 		AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Kullanýcý Silme Gerçekleþmedi...\n"+e.getMessage().toString());
 		
 		
 	}sql="select * from login";
        DegerleriGetir(TableLogin,sql);
    }

    @FXML
    void btn_temizle1(ActionEvent event) {
        lblid.setText("");
        txtkul.setText("");
        txtsifre.setText("");
        txt_arama.setText("");
    }

    @FXML
    void tableLogin1(MouseEvent event) {
    	LoginBilgi kayit=new LoginBilgi();
    	kayit=(LoginBilgi) TableLogin.getItems().get(TableLogin.getSelectionModel().getSelectedIndex());
    	lblid.setText(String.valueOf(kayit.getKid()));
    	txtkul.setText(String.valueOf(kayit.getKul_ad()));
    	txtsifre.setText(String.valueOf(kayit.getSifre()));
    	
    }

    @FXML
    void txt_arama_action(ActionEvent event) {

    }

    @FXML
    void txt_arama_keyPressed(KeyEvent event) {
    	if(txt_arama.getText().equals("")) {
    		sql="select * from login"; 
    	}else {
    		
    		
    		sql="select * from login where Kid like '%"+txt_arama.getText()+"%' or kul_ad like '%"+txt_arama.getText()+"%' or sifre like'%"+txt_arama.getText()+"%' ";
    		
		}
    	
         DegerleriGetir(TableLogin, sql);
    }
 public void DegerleriGetir(TableView tablo, String sql) {
    	
    	ObservableList<LoginBilgi> KayitlarListe=FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen =sorguifadesi.executeQuery();
    	    while(getirilen.next()) {
    	  KayitlarListe.addAll(new LoginBilgi(getirilen.getInt("Kid"),getirilen.getString("kul_ad"),getirilen.getString("sifre")));
    	  
    	    }
    	    id.setCellValueFactory(new PropertyValueFactory<>("Kid"));
    	    adi.setCellValueFactory(new PropertyValueFactory<>("kul_ad"));
    	    sifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));
    	   
    	  
    	    TableLogin.setItems(KayitlarListe);
    	    
    	    
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Hatalý Birþeyler Oldu...\n"+e.getMessage().toString());
 	 		
    	}
    }
    @FXML
    void initialize() {
    	 sql="select * from login";
         DegerleriGetir(TableLogin, sql);
         lblid.setText("");
    }

}
