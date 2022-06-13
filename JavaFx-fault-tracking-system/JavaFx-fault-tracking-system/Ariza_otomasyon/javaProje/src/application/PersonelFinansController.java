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

public class PersonelFinansController {
public  PersonelFinansController() {
		
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
    private TableColumn<PersonelBilgi, String> adi;

    @FXML
    private TableColumn<PersonelBilgi, String> adres;

    @FXML
    private TableColumn<PersonelBilgi, String> alan;

    @FXML
    private Button btn_temizle;

    @FXML
    private Button btn_yenile;

    @FXML
    private TableColumn<PersonelBilgi, Integer> id;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private Label lbl_ad;

    @FXML
    private Label lbl_adres;

    @FXML
    private Label lbl_alan;

    @FXML
    private Label lbl_id;

    @FXML
    private Label lbl_maas;

    @FXML
    private TableColumn<PersonelBilgi, Double> maas;

    @FXML
    private TableView<PersonelBilgi> table_personel;

    @FXML
    private Button temizle_btn;

    @FXML
    private TextField txt_arama;

    @FXML
    private TextField txt_bakiye;
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    @FXML
    void btnTemizleClick(ActionEvent event) {
    	txt_bakiye.setText("");
    }

    @FXML
    void btnYenileClick(ActionEvent event) {
    	maasgetir();
    }

    @FXML
    void table_personel_clicked(MouseEvent event) {
    	PersonelBilgi kayit=new PersonelBilgi();
    	kayit=(PersonelBilgi) table_personel.getItems().get(table_personel.getSelectionModel().getSelectedIndex());
    	lbl_ad.setText(String.valueOf(kayit.getPerad()));
    	lbl_id.setText(String.valueOf(kayit.getId()));
    	lbl_adres.setText(String.valueOf(kayit.getAdres()));
    	lbl_alan.setText(String.valueOf(kayit.getAlan()));
    	lbl_maas.setText(String.valueOf(kayit.getMaas()));
    	
    }

    @FXML
    void temizle_Btn_Click(ActionEvent event) {
    	
     	
     	lbl_ad.setText("");
     	lbl_id.setText("");
     	lbl_adres.setText("");
     	lbl_alan.setText("");
     	lbl_maas.setText("");
     	txt_arama.setText(" ");
     	DegerleriGetir(table_personel,sql);
    }

    @FXML
    void txt_arama_keyPressed(KeyEvent event) {
    	if(txt_arama.getText().equals("")) {
    		sql="select * from personel"; 
    	}else {
    		
    		
    		sql="select * from personel where per_alan like '%"+txt_arama.getText()+"%' or per_adSoy like '%"+txt_arama.getText()+"%' or per_adres like'%"+txt_arama.getText()+"%' ";
    		
		}
    	
         DegerleriGetir(table_personel, sql);
    }
 public void DegerleriGetir(TableView tablo, String sql) {
    	
    	ObservableList<PersonelBilgi> KayitlarListe=FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen =sorguifadesi.executeQuery();
    	    while(getirilen.next()) {
    	  KayitlarListe.addAll(new PersonelBilgi(getirilen.getInt("per_id"),getirilen.getString("per_adSoy"),getirilen.getString("per_alan"),getirilen.getString("per_adres"),getirilen.getDouble("per_maas"),getirilen.getDate("per_tarih")));
    	  
    	    }
    	    id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	    adi.setCellValueFactory(new PropertyValueFactory<>("perad"));
    	    alan.setCellValueFactory(new PropertyValueFactory<>("alan"));
    	    adres.setCellValueFactory(new PropertyValueFactory<>("adres"));
    	    maas.setCellValueFactory(new PropertyValueFactory<>("maas"));
    	   // pertarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
    	  
    	    table_personel.setItems(KayitlarListe);
    	    
    	    
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Hatalý Birþeyler Oldu...\n"+e.getMessage().toString());
 	 		
    	}
    }
 public void maasgetir() {
	 int maasToplam = 0;
   	String sqlString = "select sum(per_maas) as masraf_toplam from personel";
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
        
    	sql="select * from personel";
        DegerleriGetir(table_personel,sql);
        lbl_ad.setText("");
      	lbl_id.setText("");
      	lbl_adres.setText("");
        lbl_maas.setText("");
      	lbl_alan.setText("");
      	maasgetir();
      	
    }

}
