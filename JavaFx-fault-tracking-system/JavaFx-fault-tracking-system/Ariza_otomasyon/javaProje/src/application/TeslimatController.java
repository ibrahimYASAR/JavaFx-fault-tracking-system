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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TeslimatController {
public  TeslimatController() {
		
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
    private Button CikisEkle;

    @FXML
    private TableColumn<musteriBilgi, String> ad;

    @FXML
    private TableColumn<musteriBilgi, String> alet;

    @FXML
    private Button btn_kaydet;

    @FXML
    private Button btn_sorgula;

    @FXML
    private RadioButton evet;

    @FXML
    private RadioButton hayýr;

    @FXML
    private TableColumn<musteriBilgi, Integer> id;

    @FXML
    private Label lbl_ad;

    @FXML
    private Label lbl_alet;

    @FXML
    private Label lbl_id;

    @FXML
    private Label lbl_soyad;

    @FXML
    private Label lbl_telefon;

    @FXML
    private TableColumn<musteriBilgi, String> soyad;

    @FXML
    private TableColumn<musteriBilgi, String> telefon;

    @FXML
    private TableColumn<musteriBilgi, String> teslimatDurum;

    @FXML
    private TextArea txt_ArizaAciklama;

    @FXML
    private TextArea txt_Yapilanislem;

    @FXML
    private TextField txt_arama;

    @FXML
    private TextField txt_durum;

    @FXML
    private TextField txt_para;

    @FXML
    private TextArea txt_personelAciklama;
    @FXML
    private TableView<musteriBilgi> table_teslimat;
    @FXML
    private TextField txt_urunBilgi;

    @FXML
    private TableColumn<musteriBilgi, String> urunbilgi;
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    @FXML
    void CikisEkle1(ActionEvent event) {
    	Node  source = (Node)  event.getSource();
	    Stage stage = (Stage)source.getScene().getWindow();
	    stage.close();
    	FormManager FormOpn =new FormManager();
  	  FormOpn.FormOpen("TeslimatCikis.fxml","Teslimat Ve Ürün Çýkýþ Bilgileri","arýza.png"); 
    }

    @FXML
    void btn_kaydet1(ActionEvent event) {
    	if (hayýr.isSelected()) {
    		AlertManager.Alert("Yanlýþ Ýþlem!","Para Ödenmedi Görünüyor...","Lütfen Para Ödendiðinden Emin Olmadan Teslimat Yapmayýnýz");
    		
    	}
    	else if (evet.isSelected()) {
    		sql="update  musteri set  M_id=?, M_aciklama=?, PersonelAciklama=?,yapilanislem=?,M_Urun_bilgi=?,teslimatdurum=?,para=? where M_id=?";
            
            
            try {
         	   sorguifadesi=baglanti.prepareStatement(sql);
                sorguifadesi.setString(1, lbl_id.getText().trim()) ;
                sorguifadesi.setString(2, txt_ArizaAciklama.getText().trim());
                sorguifadesi.setString(3, txt_personelAciklama.getText().trim());
                sorguifadesi.setString(4, txt_Yapilanislem.getText().trim());
                sorguifadesi.setString(5, txt_urunBilgi.getText().trim());
                sorguifadesi.setString(6, txt_durum.getText().trim());
                sorguifadesi.setString(7, txt_para.getText().trim());
                sorguifadesi.setString(8, lbl_id.getText());
                
                sorguifadesi.executeUpdate();
                
                AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Guncelleme Gerçekleþti...");
              
                
     	} catch (Exception e) {
     		  
     		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Guncelleme Gerçekleþmedi...\n"+e.getMessage().toString());
     		
     	}DegerleriGetir(table_teslimat,sql);
     	lbl_id.setText("");
     	lbl_ad.setText("");
     	lbl_soyad.setText("");
     	lbl_telefon.setText("");
     	lbl_alet.setText("");
     	txt_ArizaAciklama.clear();
     	txt_personelAciklama.clear();
     	txt_Yapilanislem.clear();
     	txt_urunBilgi.clear();
     	txt_durum.clear();
     	txt_para.setText("");
    	}
    else if(!evet.isSelected()&& !hayýr.isSelected()){
		AlertManager.Alert("Yanlýþ Ýþlem!","Lütfen Bütün Alanlarý Cevapladýðýnýzdan Emin olun...","Lütfen Para Ödendiðinden Emin Olmadan Teslimat Yapmayýnýz");
        
		
	}

    }

    @FXML
    void btn_sorgula1(ActionEvent event) {

        if(txt_arama.getText().equals("")) {
    		sql="select * from musteri"; 
    	}else {
    		
    		
    		sql="select * from musteri where M_id like '%"+txt_arama.getText()+"%' or M_ad like '%"+txt_arama.getText()+"%' or M_soy like'%"+txt_arama.getText()+"%' ";
    		
		}
    	
         DegerleriGetir(table_teslimat, sql);
    }
    @FXML
    void table_teslimat1(MouseEvent event) {
    	musteriBilgi kayit=new musteriBilgi();
    	kayit=(musteriBilgi) table_teslimat.getItems().get(table_teslimat.getSelectionModel().getSelectedIndex());
    	lbl_id.setText(String.valueOf(kayit.getM_id()));
    	lbl_ad.setText(kayit.getM_ad());
    	lbl_soyad.setText(String.valueOf(kayit.getM_soy()));
    	txt_ArizaAciklama.setText((kayit.getM_aciklama()));
    	lbl_alet.setText(String.valueOf(kayit.getM_alet()));
    	txt_personelAciklama.setText(String.valueOf(kayit.getPersonelAciklama()));
    	txt_Yapilanislem.setText(String.valueOf(kayit.getYapilanislem()));
    	txt_durum.setText(String.valueOf(kayit.getTeslimatdurum()));
    	txt_urunBilgi.setText(String.valueOf(kayit.getM_Urun_bilgi()));
    	lbl_telefon.setText(String.valueOf(kayit.getM_tel()));
    	txt_para.setText(String.valueOf(kayit.getPara()));
    
    }
    @FXML
    void txt_arama_keyPressed(KeyEvent event) {

        if(txt_arama.getText().equals("")) {
    		sql="select * from musteri"; 
    	}else {
    		
    		
    		sql="select * from musteri where M_id like '%"+txt_arama.getText()+"%' or M_ad like '%"+txt_arama.getText()+"%' or M_soy like'%"+txt_arama.getText()+"%' ";
    		
		}
    	
         DegerleriGetir(table_teslimat, sql);
    }
    public void DegerleriGetir(TableView tablo, String sql) {
    	  sql="select * from musteri";
  	ObservableList<musteriBilgi> KayitlarListe=FXCollections.observableArrayList();
  	try {
  		sorguifadesi=baglanti.prepareStatement(sql);
  		ResultSet getirilen =sorguifadesi.executeQuery();
  	    while(getirilen.next()) {
  	    	KayitlarListe.add(new musteriBilgi(getirilen.getInt("M_id"),getirilen.getString("M_ad"),getirilen.getString("M_soy"),sql, getirilen.getString("M_tel"), sql, getirilen.getString("M_aciklama"), getirilen.getString("M_alet"), getirilen.getString("M_Urun_bilgi"), sql,getirilen.getInt("M_masraf"), sql, sql, getirilen.getString("para"), getirilen.getString("PersonelAciklama"),getirilen.getString("yapilanislem"),getirilen.getString("teslimatdurum")));
  	    }
  	    ad.setCellValueFactory(new PropertyValueFactory<>("M_ad"));
  	    id.setCellValueFactory(new PropertyValueFactory<>("M_id"));
  	    soyad.setCellValueFactory(new PropertyValueFactory<>("M_soy"));
  	    telefon.setCellValueFactory(new PropertyValueFactory<>("M_tel"));
  	    alet.setCellValueFactory(new PropertyValueFactory<>("M_alet"));
  	    teslimatDurum.setCellValueFactory(new PropertyValueFactory<>("teslimatdurum"));
  	    urunbilgi.setCellValueFactory(new PropertyValueFactory<>("M_Urun_bilgi"));
  	    
  	  table_teslimat.setItems(KayitlarListe);
  	    
  	    
  	} catch (SQLException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		 
  		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Hatalý Birþeyler Oldu...\n"+e.getMessage().toString());
  	 		
  	
  	}
  }
    @FXML
    void initialize() {
    	sql="select * from musteri";
        DegerleriGetir(table_teslimat, sql);
        lbl_id.setText("");
     	lbl_ad.setText("");
     	lbl_soyad.setText("");
     	lbl_telefon.setText("");
     	lbl_alet.setText("");
     	
     	ToggleGroup grup1= new ToggleGroup();
        evet.setToggleGroup(grup1);
        hayýr.setToggleGroup(grup1);
    }

}
