package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class YeniPersonelAramaController {
	
		
		public  YeniPersonelAramaController() {
			
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
    private Button Btn_Sorgula;

    @FXML
    private DatePicker DateBaslangic;

    @FXML
    private DatePicker DateBitis;

    @FXML
    private ComboBox<String> combo_user;

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

    @FXML
    private TextField txt_arama;
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    @FXML
    void Btn_sorgula_click(ActionEvent event) {
    	sql="select * from personel where per_tarih>'"+DateBaslangic.getValue()+"' and per_tarih<'"+DateBitis.getValue()+"'";
    	DegerleriGetir(tablepersonel, sql);
    }

    @FXML
    void combo_user_Action(ActionEvent event) {
    	sql="select * from personel where user ='"+combo_user.getValue().toString()+"'";
    	DegerleriGetir(tablepersonel, sql);
    	
    }

    @FXML
    void table_clicked(MouseEvent event) {

    }

    @FXML
    void txt_arama_action(ActionEvent event) {

    }
    
    @FXML
    void txt_arama_keyPressed(KeyEvent event) {
    	if(txt_arama.getText().equals("")) {
    		sql="select * from personel"; 
    	}else {
    		
    		
    		sql="select * from personel where per_alan like '%"+txt_arama.getText()+"%' or per_adSoy like '%"+txt_arama.getText()+"%' or per_adres like'%"+txt_arama.getText()+"%' ";
    		
		}
    	
         DegerleriGetir(tablepersonel, sql);
    }
    public void DegerleriGetir(TableView tablo, String sql) {
    	
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
       
        sql="select * from personel";
        DegerleriGetir(tablepersonel, sql);
        DateBitis.setValue(LocalDate.now());

    }

}
