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

public class AtolyeDurumGuncelleController {
public  AtolyeDurumGuncelleController() {
		
		baglanti=VeritabaniUtil.Baglan();
		 
		
	}
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
    private TableColumn<musteriBilgi, String> PersonelAciklama;

    @FXML
    private TableColumn<musteriBilgi, String> adi;

    @FXML
    private TableColumn<musteriBilgi, String> alet;

    @FXML
    private TableColumn<musteriBilgi, String> arizaAciklama;

    @FXML
    private Button btn_guncelle;

    @FXML
    private TableColumn<musteriBilgi, Integer> id;

    @FXML
    private Label lbl_adi;

    @FXML
    private Label lbl_id;

    @FXML
    private Label lbl_soyadi;

    @FXML
    private TableColumn<musteriBilgi, Integer> masraf;

    @FXML
    private TableColumn<musteriBilgi, String> soyadi;

    @FXML
    private TableView<musteriBilgi> table_musteri;

    @FXML
    private TextField txt_alet;

    @FXML
    private TextField txt_arama;

    @FXML
    private TextArea txt_arizaAciklama;

    @FXML
    private TextField txt_masraf;

    @FXML
    private TextArea txt_personelAciklama;

    @FXML
    private TextField txt_urunBilgi;
    @FXML
    private TableColumn<musteriBilgi, String> urunBilgi;
    
    
    
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    @FXML
    void btn_guncelle_click(ActionEvent event) {
    	sql="update  musteri set  M_id=?, M_aciklama=?, M_alet=?,M_masraf=?,M_Urun_bilgi=?,PersonelAciklama=? where M_id=?";
        
        
        try {
     	   sorguifadesi=baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, lbl_id.getText().trim()) ;
            sorguifadesi.setString(2, txt_arizaAciklama.getText().trim());
            sorguifadesi.setString(3, txt_alet.getText().trim());
            sorguifadesi.setString(4, txt_masraf.getText().trim());
            sorguifadesi.setString(5, txt_urunBilgi.getText().trim());
            sorguifadesi.setString(6, txt_personelAciklama.getText().trim());
            sorguifadesi.setString(7, lbl_id.getText());
            
            sorguifadesi.executeUpdate();
            
            AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Guncelleme Gerçekleþti...");
          
            
 	} catch (Exception e) {
 		  
 		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Guncelleme Gerçekleþmedi...\n"+e.getMessage().toString());
 		
 	}DegerleriGetir(table_musteri,sql);
 	txt_alet.clear();
 	txt_arizaAciklama.clear();
 	txt_masraf.clear();
 	txt_personelAciklama.clear();
 	txt_urunBilgi.clear();
 	lbl_id.setText("");
 	lbl_adi.setText("");
 	lbl_soyadi.setText("");
    }

    @FXML
    void table_musteri_clicked(MouseEvent event) {
    	musteriBilgi kayit=new musteriBilgi();
    	kayit=(musteriBilgi) table_musteri.getItems().get(table_musteri.getSelectionModel().getSelectedIndex());
    	lbl_id.setText(String.valueOf(kayit.getM_id()));
    	lbl_adi.setText(kayit.getM_ad());
    	lbl_soyadi.setText(String.valueOf(kayit.getM_soy()));
    	txt_arizaAciklama.setText((kayit.getM_aciklama()));
    	txt_alet.setText(String.valueOf(kayit.getM_alet()));
    	txt_masraf.setText(String.valueOf(kayit.getM_masraf()));
    	txt_urunBilgi.setText(String.valueOf(kayit.getM_Urun_bilgi()));
    	txt_personelAciklama.setText(String.valueOf(kayit.getPersonelAciklama()));
    }

    @FXML
    void txt_arama_keyPressed(KeyEvent event) {
    	
         if(txt_arama.getText().equals("")) {
     		sql="select * from musteri"; 
     	}else {
     		
     		
     		sql="select * from musteri where M_id like '%"+txt_arama.getText()+"%' or M_ad like '%"+txt_arama.getText()+"%' or M_soy like'%"+txt_arama.getText()+"%' ";
     		
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
	    	KayitlarListe.add(new musteriBilgi(getirilen.getInt("M_id"),getirilen.getString("M_ad"),getirilen.getString("M_soy"),sql, sql, sql, getirilen.getString("M_aciklama"), getirilen.getString("M_alet"), getirilen.getString("M_Urun_bilgi"), sql,getirilen.getInt("M_masraf"), sql, sql, sql, getirilen.getString("PersonelAciklama"),sql,sql));
	    }
	    adi.setCellValueFactory(new PropertyValueFactory<>("M_ad"));
	    id.setCellValueFactory(new PropertyValueFactory<>("M_id"));
	    soyadi.setCellValueFactory(new PropertyValueFactory<>("M_soy"));
	    arizaAciklama.setCellValueFactory(new PropertyValueFactory<>("M_aciklama"));
	    alet.setCellValueFactory(new PropertyValueFactory<>("M_alet"));
	    masraf.setCellValueFactory(new PropertyValueFactory<>("M_masraf"));
	    urunBilgi.setCellValueFactory(new PropertyValueFactory<>("M_Urun_bilgi"));
	    PersonelAciklama.setCellValueFactory(new PropertyValueFactory<>("PersonelAciklama"));
	  
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
        lbl_id.setText("");
     	lbl_adi.setText("");
     	lbl_soyadi.setText("");

    }

}
