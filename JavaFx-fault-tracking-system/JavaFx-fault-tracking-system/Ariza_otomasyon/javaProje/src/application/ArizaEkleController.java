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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ArizaEkleController {
public  ArizaEkleController() {
		
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
    private TableColumn<musteriBilgi, String> adi;

    @FXML
    private Button btn_kaydet;

    @FXML
    private TableColumn<musteriBilgi, Integer> id;

    @FXML
    private Label lbl_ad;

    @FXML
    private Label lbl_soy;

    @FXML
    private Label lbl_soy1;

    @FXML
    private TableColumn<musteriBilgi, String> soyadi;

    @FXML
    private TableView<musteriBilgi> tablo_ariza;

    @FXML
    private TableColumn<musteriBilgi, Integer> telefon;

    @FXML
    private TextArea txt_aciklama;

    @FXML
    private TextField txt_cihaz;
    @FXML
    private TextField txt_para;
    @FXML
    private TextField txt_durum;
    @FXML
    private Label lbl_id;
    @FXML
    private TextField txt_kod;

    @FXML
    private TextField txt_masraf;
   
    
    
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    
    @FXML
    void Tablo_Ariza_clicked(MouseEvent event) {
    	musteriBilgi kayit=new musteriBilgi();
    	kayit=(musteriBilgi) tablo_ariza.getItems().get(tablo_ariza.getSelectionModel().getSelectedIndex());
    	lbl_ad.setText(String.valueOf(kayit.getM_ad()));
    	lbl_id.setText(String.valueOf(kayit.getM_id()));
    	lbl_soy.setText(String.valueOf(kayit.getM_soy()));
    }

    @FXML
    void btn_kaydet_click(ActionEvent event) {
    	sql="update  musteri set  M_id=?, M_alet=?, M_aciklama=?,M_masraf=?,M_kod=?,para=?,M_urun_bilgi=? where M_id=?";
        
        
        try {
     	   sorguifadesi=baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, lbl_id.getText().trim()) ;
            sorguifadesi.setString(2, txt_cihaz.getText().trim());
            sorguifadesi.setString(3, txt_aciklama.getText().trim());
            sorguifadesi.setString(4, txt_masraf.getText().trim());
            sorguifadesi.setString(5, txt_kod.getText().trim());
            sorguifadesi.setString(6, txt_para.getText().trim());
            sorguifadesi.setString(7, txt_durum.getText().trim());
            sorguifadesi.setString(8, lbl_id.getText());
            
            sorguifadesi.executeUpdate();
            
            
            AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","guncelleme gerçekleþti...");
    		
        
            
            
 		
 	} catch (Exception e) {
 		
 		AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","guncelleme gerçekleþmedi...\n"+e.getMessage().toString());
		
 	}DegerleriGetir(tablo_ariza);
 	txt_aciklama.clear();
 	txt_cihaz.clear();
 	txt_durum.clear();
 	txt_kod.clear();
 	txt_para.clear();
 	txt_masraf.clear();
 	lbl_ad.setText("");
 	lbl_soy.setText("");
 	lbl_id.setText("");
    }
    void Table_musteri_clicked(MouseEvent event) {
    	musteriBilgi kayit=new musteriBilgi();
    	kayit=(musteriBilgi) tablo_ariza.getItems().get(tablo_ariza.getSelectionModel().getSelectedIndex());
    	lbl_ad.setText(String.valueOf(kayit.getM_ad()));
    	lbl_soy.setText(String.valueOf(kayit.getM_soy()));
    }
    public void DegerleriGetir(TableView tablo) {
    	sql="select * from musteri";
    	ObservableList<musteriBilgi> KayitlarListe=FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen =sorguifadesi.executeQuery();
    	    while(getirilen.next()) {
    	    	KayitlarListe.add(new musteriBilgi(getirilen.getInt("M_id"),getirilen.getString("M_ad"),getirilen.getString("M_soy"),sql, getirilen.getString("M_tel"), sql, getirilen.getString("M_aciklama"), getirilen.getString("M_alet"), getirilen.getString("M_Urun_bilgi"), sql,getirilen.getInt("M_masraf"), sql, sql, sql, getirilen.getString("PersonelAciklama"),sql,sql));
    	    }
    	    adi.setCellValueFactory(new PropertyValueFactory<>("M_ad"));
    	    id.setCellValueFactory(new PropertyValueFactory<>("M_id"));
    	    soyadi.setCellValueFactory(new PropertyValueFactory<>("M_soy"));
    	    telefon.setCellValueFactory(new PropertyValueFactory<>("M_tel"));
    	    
    	  
    	  
    	    tablo_ariza.setItems(KayitlarListe);
    	    
    	    
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		
    		AlertManager.Alert("hata!","Bilgilendirme Mesajý","hatalý birþeyler oldu...\n"+e.getMessage().toString());
    		
    	}
    }
    @FXML
    void initialize() {
        
    	DegerleriGetir(tablo_ariza);
    	lbl_ad.setText("");
     	lbl_soy.setText("");
     	lbl_id.setText("");
    }

}
