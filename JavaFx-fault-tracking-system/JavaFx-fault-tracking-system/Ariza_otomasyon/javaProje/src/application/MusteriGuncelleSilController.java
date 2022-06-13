package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.ProjeMySQL.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MusteriGuncelleSilController {
public  MusteriGuncelleSilController() {
		
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
    private TableColumn<musteriBilgi, String> adi;

    @FXML
    private Button btn_guncelle;

    @FXML
    private Button btn_sil;

    @FXML
    private TableColumn<musteriBilgi, Integer> id;
    @FXML
    private TableColumn<musteriBilgi, String> Email;
    @FXML
    private TableColumn<musteriBilgi, Integer> tc;
    @FXML
    private Label lbl_id;

    @FXML
    private TableColumn<musteriBilgi, String> soyadi;

    @FXML
    private TableView<musteriBilgi> table_musteri;

    @FXML
    private TableColumn<musteriBilgi, String> telefon;

    @FXML
    private TextField txt_adi;

    @FXML
    private TextField txt_arama;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_soyadi;

    @FXML
    private TextField txt_tc;

    @FXML
    private TextField txt_telefon;
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    @FXML
    void Table_musteri_clicked(MouseEvent event) {
    	musteriBilgi kayit=new musteriBilgi();
    	kayit=(musteriBilgi) table_musteri.getItems().get(table_musteri.getSelectionModel().getSelectedIndex());
    	lbl_id.setText(String.valueOf(kayit.getM_id()));
    	txt_adi.setText(kayit.getM_ad());
    	txt_soyadi.setText(String.valueOf(kayit.getM_soy()));
    	txt_email.setText((kayit.getM_mail()));
    	txt_telefon.setText(String.valueOf(kayit.getM_tel()));
    	txt_tc.setText(String.valueOf(kayit.getM_tc()));
    	
    }

    @FXML
    void btn_guncelle_click(ActionEvent event) {
    	sql="update  musteri set  M_id=?, M_ad=?, M_soy=?,M_tel=?,M_tc=?,M_mail=? where M_id=?";
        
         
         try {
      	   sorguifadesi=baglanti.prepareStatement(sql);
             sorguifadesi.setString(1, lbl_id.getText().trim()) ;
             sorguifadesi.setString(2, txt_adi.getText().trim());
             sorguifadesi.setString(3, txt_soyadi.getText().trim());
             sorguifadesi.setString(4, txt_telefon.getText().trim());
             sorguifadesi.setString(5, txt_tc.getText().trim());
             sorguifadesi.setString(6, txt_email.getText().trim());
             sorguifadesi.setString(7, lbl_id.getText());
             
             sorguifadesi.executeUpdate();
             
             AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Guncelleme Gerçekleþti...");
             
             
  		
  	} catch (Exception e) {
  		
  		AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Guncelleme Gerçekleþmedi...\n"+e.getMessage().toString());
 		
  	}DegerleriGetir(table_musteri,sql);
  	txt_adi.clear();
  	txt_email.clear();
  	txt_soyadi.clear();
  	txt_tc.clear();
  	txt_telefon.clear();
  	lbl_id.setText("");
    }

    @FXML
    void btn_sil_click(ActionEvent event) {
sql="delete from  musteri where M_id=? and M_ad=?";
        
        try {
     	   sorguifadesi=baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, (lbl_id.getText().trim()));
            sorguifadesi.setString(2, txt_adi.getText().trim());
            sorguifadesi.executeUpdate();
           
            AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Kullanici Silme Gerçekleþti...");
             
            
            
 		
 	} catch (Exception e) {
 		
 		AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Kullanici Silme Gerçekleþmedi...\n"+e.getMessage().toString());
 		
 	}
        DegerleriGetir(table_musteri,sql);
    }

    @FXML
    void txt_arama_action(ActionEvent event) {

    }

    @FXML
    void txt_arama_keyPressed(KeyEvent event) {
    	if(txt_arama.getText().equals("")) {
    		sql="select * from musteri"; 
    	}else {
    		sql="select * from musteri where M_soy like '%"+txt_arama.getText()+"%' or M_ad like '%"+txt_arama.getText()+"%'";
		}
    	
         DegerleriGetir(table_musteri, sql);
    }
          public void DegerleriGetir(TableView tablo, String sql) {
        	  sql="select * from musteri";
    	ObservableList<musteriBilgi> KayitlarListe=FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen =sorguifadesi.executeQuery();
    	    while(getirilen.next()) {
    	    	KayitlarListe.add(new musteriBilgi(getirilen.getInt("M_id"),getirilen.getString("M_ad"),getirilen.getString("M_soy"),getirilen.getString("M_mail"), getirilen.getString("M_tel"), sql, sql, sql, sql, sql, 0, getirilen.getString("M_tc"), sql, sql,  sql,sql,sql));
    	    }
    	    adi.setCellValueFactory(new PropertyValueFactory<>("M_ad"));
    	    id.setCellValueFactory(new PropertyValueFactory<>("M_id"));
    	    soyadi.setCellValueFactory(new PropertyValueFactory<>("M_soy"));
    	    telefon.setCellValueFactory(new PropertyValueFactory<>("M_tel"));
    	    Email.setCellValueFactory(new PropertyValueFactory<>("M_mail"));
    	    tc.setCellValueFactory(new PropertyValueFactory<>("M_tc"));
    	  
    	    table_musteri.setItems(KayitlarListe);
    	    
    	    
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		 
    		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Hatalý Birþeyler Oldu...\n"+e.getMessage().toString());
 	 		
    	}
    }
    @FXML
    void initialize() {
        
    	sql="select * from musteri";
        DegerleriGetir(table_musteri, sql);
        
    }

}
