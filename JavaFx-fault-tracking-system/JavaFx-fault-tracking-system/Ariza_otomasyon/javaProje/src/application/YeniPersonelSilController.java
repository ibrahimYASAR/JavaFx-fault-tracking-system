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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class YeniPersonelSilController {
	
		public  YeniPersonelSilController() {
			
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
    private Button btn_per;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private TableColumn<PersonelBilgi, String> perad;

    @FXML
    private TableColumn<PersonelBilgi, String> peradres;

    @FXML
    private TableColumn<PersonelBilgi, String> peralan;

    @FXML
    private TableColumn<PersonelBilgi, Integer> perid;

    @FXML
    private TableColumn<PersonelBilgi, Double> permaas;

    @FXML
    private TableColumn<PersonelBilgi, Date> pertarih;

    @FXML
    private TableView<PersonelBilgi> tablepersonel;
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    @FXML
    void btn_per_click(ActionEvent event) {
sql="delete from  personel where per_id=? and per_adSoy=?";
        
        try {
     	   sorguifadesi=baglanti.prepareStatement(sql);
            sorguifadesi.setString(1, (lbl1.getText().trim()));
            sorguifadesi.setString(2, lbl2.getText().trim());
            sorguifadesi.executeUpdate();
            AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Kullanýcý Silme Gerçekleþti...");
            
            
            
 		
 	} catch (Exception e) {
 		AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Kullanýcý Silme Gerçekleþmedi...\n"+e.getMessage().toString());
 		
 		
 	}
        DegerleriGetir(tablepersonel);
    }

    @FXML
    void table_clicked(MouseEvent event) {
    	PersonelBilgi kayit=new PersonelBilgi();
    	kayit=(PersonelBilgi) tablepersonel.getItems().get(tablepersonel.getSelectionModel().getSelectedIndex());
    	lbl2.setText(String.valueOf(kayit.getPerad()));
    	lbl1.setText(String.valueOf(kayit.getId()));
    	
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
    	    perid.setCellValueFactory(new PropertyValueFactory<>("id"));
    	    perad.setCellValueFactory(new PropertyValueFactory<>("perad"));
    	    peralan.setCellValueFactory(new PropertyValueFactory<>("alan"));
    	    peradres.setCellValueFactory(new PropertyValueFactory<>("adres"));
    	    permaas.setCellValueFactory(new PropertyValueFactory<>("maas"));
    	    pertarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
    	  
    	    tablepersonel.setItems(KayitlarListe);
    	    
    	    
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Hatalý Birþeyler Oldu...\n"+e.getMessage().toString());
    	 	
    	}
    }
    @FXML
    void initialize() {
       DegerleriGetir(tablepersonel);

    }

}