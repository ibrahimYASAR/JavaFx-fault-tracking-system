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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FinansController {
public  FinansController() {
		
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
    private Button Ekle_btn1;

    @FXML
    private TableColumn<musteriBilgi, String> UrunBilgi;

    @FXML
    private TableColumn<musteriBilgi, String> adi;

    @FXML
    private TableColumn<musteriBilgi, String> alet;

    @FXML
    private Button btn_temizle;

    @FXML
    private Button btn_yenile;

    @FXML
    private TableColumn<musteriBilgi,Integer> id;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private Label lbl_ad;

    @FXML
    private Label lbl_alet;

    @FXML
    private Label lbl_id;

    @FXML
    private Label lbl_soyadi;

    @FXML
    private Label lbl_telefon;

    @FXML
    private TableColumn<musteriBilgi, Integer> masraf;

    @FXML
    private TableColumn<musteriBilgi, String> para;

    @FXML
    private TableColumn<musteriBilgi, String> soyadi;

    @FXML
    private TableView<musteriBilgi> table_musteri;

    @FXML
    private TableColumn<musteriBilgi, Integer> telefon;

    @FXML
    private Button temizle_btn;

    @FXML
    private TextField txt_UrunBilgi;

    @FXML
    private TextField txt_arama;

    @FXML
    private TextField txt_bakiye;

    @FXML
    private TextField txt_masraf;

    @FXML
    private TextField txt_para;
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    @FXML
    void Ekle_Btn_Click(ActionEvent event) {
    	sql="update  musteri set  M_id=?, M_masraf=?, M_Urun_bilgi=?, para=? where M_id=?";
        
        
        try {
     	   sorguifadesi=baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, lbl_id.getText().trim()) ;
            sorguifadesi.setString(2, txt_masraf.getText().trim());
            sorguifadesi.setString(3, txt_UrunBilgi.getText().trim());
            sorguifadesi.setString(4, txt_para.getText().trim());
            sorguifadesi.setString(5, lbl_id.getText());
            
            sorguifadesi.executeUpdate();
            
            AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Guncelleme Gerçekleþti...");
          
 	} catch (Exception e) {
 		  
 		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Guncelleme Gerçekleþmedi...\n"+e.getMessage().toString());
 	 		
 	}DegerleriGetir(table_musteri,sql);
 	txt_masraf.clear();
 	txt_para.clear();
 	txt_arama.clear();
 	txt_UrunBilgi.clear();
 	lbl_ad.setText("");
 	lbl_id.setText("");
 	lbl_soyadi.setText("");
 	lbl_alet.setText("");
 	lbl_telefon.setText("");
    }

    @FXML
    void btnTemizleClick(ActionEvent event) {
    	txt_bakiye.setText("");
    }

    @FXML
    void btnYenileClick(ActionEvent event) {
    	maasGetir();
    }

    @FXML
    void table_musteri_clicked(MouseEvent event) {
    	musteriBilgi kayit=new musteriBilgi();
    	kayit=(musteriBilgi) table_musteri.getItems().get(table_musteri.getSelectionModel().getSelectedIndex());
    	lbl_ad.setText(String.valueOf(kayit.getM_ad()));
    	lbl_id.setText(String.valueOf(kayit.getM_id()));
    	lbl_soyadi.setText(String.valueOf(kayit.getM_soy()));
    	lbl_alet.setText(String.valueOf(kayit.getM_alet()));
    	lbl_telefon.setText(String.valueOf(kayit.getM_tel()));
    	txt_masraf.setText(String.valueOf(kayit.getM_masraf()));
    	txt_para.setText(String.valueOf(kayit.getPara()));
    	txt_UrunBilgi.setText(String.valueOf(kayit.getM_Urun_bilgi()));
    	
    }

    @FXML
    void temizle_Btn_Click(ActionEvent event) {
    	
     	txt_masraf.clear();
     	txt_para.clear();
     	txt_arama.clear();
     	txt_UrunBilgi.clear();
     	lbl_ad.setText("");
     	lbl_id.setText("");
     	lbl_soyadi.setText("");
     	lbl_alet.setText("");
     	lbl_telefon.setText("");
     	DegerleriGetir(table_musteri,sql);
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
    public void DegerleriGetir(TableView tablo,String sql) {
    	sql="select * from musteri";
    	ObservableList<musteriBilgi> KayitlarListe=FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen =sorguifadesi.executeQuery();
    	    while(getirilen.next()) {
    	  KayitlarListe.add(new musteriBilgi(getirilen.getInt("M_id"),getirilen.getString("M_ad"),getirilen.getString("M_soy"),sql, getirilen.getString("M_tel"), sql, sql, getirilen.getString("M_alet"), getirilen.getString("M_Urun_bilgi"), sql, getirilen.getInt("M_masraf"), sql, sql, getirilen.getString("para"), sql,sql,sql));
    	    }
    	    adi.setCellValueFactory(new PropertyValueFactory<>("M_ad"));
    	    id.setCellValueFactory(new PropertyValueFactory<>("M_id"));
    	    soyadi.setCellValueFactory(new PropertyValueFactory<>("M_soy"));
    	    telefon.setCellValueFactory(new PropertyValueFactory<>("M_tel"));
    	    alet.setCellValueFactory(new PropertyValueFactory<>("M_alet"));
    	    masraf.setCellValueFactory(new PropertyValueFactory<>("M_masraf"));
    	    UrunBilgi.setCellValueFactory(new PropertyValueFactory<>("M_Urun_bilgi"));
    	    para.setCellValueFactory(new PropertyValueFactory<>("para"));
    	    
    	  
    	  
    	    table_musteri.setItems(KayitlarListe);
    	    
    	    
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		
    		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Hatalý Birþeyler Oldu...\n"+e.getMessage().toString());
 	 		
    	}
    }
    public void maasGetir() {
    	int maasToplam = 0;
      	String sqlString = "select sum(M_masraf) as masraf_toplam from musteri";
      	try {
			sorguifadesi=baglanti.prepareStatement(sqlString);
			ResultSet resultSet = sorguifadesi.executeQuery();
			while(resultSet.next()) {
				maasToplam+=resultSet.getInt("masraf_toplam");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
      	
      	txt_bakiye.setText(String.valueOf(maasToplam));
	}
    @FXML
    void initialize() {
    	sql="select * from musteri";
        DegerleriGetir(table_musteri,sql);
        lbl_ad.setText("");
      	lbl_id.setText("");
      	lbl_soyadi.setText("");
        lbl_alet.setText("");
      	lbl_telefon.setText("");
      	maasGetir();
      	
      	
    }

}
