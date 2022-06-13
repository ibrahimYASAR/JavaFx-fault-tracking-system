package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class YeniPersonelGuncelle {
	public  YeniPersonelGuncelle() {
	
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
    private Button btn_guncel;

    @FXML
    private Label lbl_id;

    @FXML
    private Label ldl_ad;

    @FXML
    private TableColumn<PersonelBilgi, String> per_ad;

    @FXML
    private TableColumn<PersonelBilgi, String> per_adres;

    @FXML
    private TableColumn<PersonelBilgi, String> per_alan;

    @FXML
    private TableColumn<PersonelBilgi, Integer> per_id;

    @FXML
    private TableColumn<PersonelBilgi, Double> per_maas;

    @FXML
    private TableColumn<PersonelBilgi, Date> per_tarih;

    @FXML
    private TableView<PersonelBilgi> table_personel;

    @FXML
    private TextField txt_adres;

    @FXML
    private TextField txt_alan;

    @FXML
    private TextField txt_maas;
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    @FXML
    void btn_guncel_click(ActionEvent event) {
         sql="update  personel set  per_id=?, per_maas=?, per_adres=?,per_alan=? where per_id=?";
      
        
        try {
     	   sorguifadesi=baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, lbl_id.getText().trim()) ;
            sorguifadesi.setString(2, txt_maas.getText().trim());
            sorguifadesi.setString(3, txt_adres.getText().trim());
            sorguifadesi.setString(4, txt_alan.getText().trim());
            sorguifadesi.setString(5, lbl_id.getText());
            
            sorguifadesi.executeUpdate();
            AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Guncelleme Gerçekleþti...");
            
            
            
 		
 	} catch (Exception e) {
 		AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Guncelleme Gerçekleþmedi...\n"+e.getMessage().toString());
 		
 	}DegerleriGetir(table_personel);
    }

    @FXML
    void table_pers_clicked(MouseEvent event) {
    	PersonelBilgi kayit=new PersonelBilgi();
    	kayit=(PersonelBilgi) table_personel.getItems().get(table_personel.getSelectionModel().getSelectedIndex());
    	lbl_id.setText(String.valueOf(kayit.getId()));
    	ldl_ad.setText(kayit.getPerad());
    	txt_maas.setText(String.valueOf(kayit.getMaas()));
    	txt_adres.setText(kayit.getAdres());
    	txt_alan.setText(kayit.getAlan());
    }
    public void DegerleriGetir(TableView tablo) {
    	sql="select * from personel";
    	ObservableList<PersonelBilgi> KayitlarListe=FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen =sorguifadesi.executeQuery();
    	    while(getirilen.next()) {
    	  KayitlarListe.addAll(new PersonelBilgi(getirilen.getInt("per_id"),getirilen.getString("per_adSoy"),getirilen.getString("per_alan"),getirilen.getString("per_adres"),getirilen.getDouble("per_maas"),getirilen.getDate("per_tarih")));
    	  
    	    }
    	    per_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	    per_ad.setCellValueFactory(new PropertyValueFactory<>("perad"));
    	    per_alan.setCellValueFactory(new PropertyValueFactory<>("alan"));
    	    per_adres.setCellValueFactory(new PropertyValueFactory<>("adres"));
    	    per_maas.setCellValueFactory(new PropertyValueFactory<>("maas"));
    	    per_tarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
    	  
    	    table_personel.setItems(KayitlarListe);
    	   
    	    
    	    
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Hatalý Birþeyler Oldu...\n"+e.getMessage().toString());
 	 		
    	}
    }
    @FXML
    void initialize() {
        
DegerleriGetir(table_personel);
    }

}
