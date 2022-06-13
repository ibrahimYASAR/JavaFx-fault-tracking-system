package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MusteriSikayetTalepGorController {

public  MusteriSikayetTalepGorController() {
		
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
    private Button Ekle_btn;

    @FXML
    private TableColumn<musteriBilgi, String> adi;

    @FXML
    private TableColumn<musteriBilgi, Integer> id;

    @FXML
    private Label lbl_ad;

    @FXML
    private Label lbl_id;

    @FXML
    private Label lbl_soyad;

    @FXML
    private TableColumn<musteriBilgi, String> soyadi;

    @FXML
    private TableView<musteriBilgi> table_musteri;

    @FXML
    private TableColumn<musteriBilgi, Integer> telefon;

    @FXML
    private TextArea txt_sikayet;

    @FXML
    private TextArea txt_talep;
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    @FXML
    void Ekle_Btn_Click(ActionEvent event) {
    	sql="update  musteri set  M_id=?, M_sikayet=?, M_talep=? where M_id=?";
        
         
         try {
      	   sorguifadesi=baglanti.prepareStatement(sql);
             sorguifadesi.setString(1, lbl_id.getText().trim()) ;
             sorguifadesi.setString(2, txt_sikayet.getText().trim());
             sorguifadesi.setString(3, txt_talep.getText().trim());
             sorguifadesi.setString(4, lbl_id.getText());
             
             sorguifadesi.executeUpdate();
             AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Guncelleme Gerçekleþti...");
             
             
  		
  	} catch (Exception e) {
  		AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Guncelleme Gerçekleþmedi...\n"+e.getMessage().toString());
 		
  	}DegerleriGetir(table_musteri,sql);
  	txt_sikayet.clear();
  	txt_talep.clear();
  	lbl_ad.setText("");
  	lbl_id.setText("");
  	lbl_soyad.setText("");
  	
    }

    @FXML
    void Table_musteri_clicked(MouseEvent event) {
    	musteriBilgi kayit=new musteriBilgi();
    	kayit=(musteriBilgi) table_musteri.getItems().get(table_musteri.getSelectionModel().getSelectedIndex());
    	lbl_ad.setText(String.valueOf(kayit.getM_ad()));
    	lbl_id.setText(String.valueOf(kayit.getM_id()));
    	lbl_soyad.setText(String.valueOf(kayit.getM_soy()));
    	txt_sikayet.setText(String.valueOf(kayit.getM_sikayet()));
    	txt_talep.setText(String.valueOf(kayit.getM_talep()));
    }
    public void DegerleriGetir(TableView tablo,String sql) {
    	sql="select * from musteri";
    	ObservableList<musteriBilgi> KayitlarListe=FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen =sorguifadesi.executeQuery();
    	    while(getirilen.next()) {
    	  KayitlarListe.add(new musteriBilgi(getirilen.getInt("M_id"),getirilen.getString("M_ad"),getirilen.getString("M_soy"),getirilen.getString("M_mail"), getirilen.getString("M_tel"), getirilen.getString("M_sikayet"), sql, sql, sql, getirilen.getString("M_talep"), 0, sql, sql, sql, sql,sql,sql));
    	    }
    	    adi.setCellValueFactory(new PropertyValueFactory<>("M_ad"));
    	    id.setCellValueFactory(new PropertyValueFactory<>("M_id"));
    	    soyadi.setCellValueFactory(new PropertyValueFactory<>("M_soy"));
    	    telefon.setCellValueFactory(new PropertyValueFactory<>("M_tel"));
    	    
    	  
    	  
    	    table_musteri.setItems(KayitlarListe);
    	    
    	    
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Hatalý Birþeyler Oldu...\n"+e.getMessage().toString());
 	 		
    	}
    }
    @FXML
    private TextField txt_arama;
    @FXML
    void txt_arama_keyPressed(KeyEvent event) {
    	if(txt_arama.getText().equals("")) {
     		sql="select * from musteri"; 
     	}else {
     		
     		
     		sql="select * from musteri where M_id like '%"+txt_arama.getText()+"%' or M_ad like '%"+txt_arama.getText()+"%' or M_soy like'%"+txt_arama.getText()+"%' ";
     		
 		}
     	
          DegerleriGetir(table_musteri, sql);
    }
    @FXML
    void initialize() {
    	sql="select * from musteri";
        DegerleriGetir(table_musteri,sql);
        lbl_ad.setText("");
      	lbl_id.setText("");
      	lbl_soyad.setText("");

    }

}
