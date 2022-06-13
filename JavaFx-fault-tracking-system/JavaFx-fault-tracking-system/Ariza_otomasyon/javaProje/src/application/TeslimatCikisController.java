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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TeslimatCikisController {
public  TeslimatCikisController() {
		
		baglanti=VeritabaniUtil.Baglan();
		 
		
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<musteriBilgi, String> admus;

   

    @FXML
    private Button btnkaydet;

    @FXML
    private Button btnper;

    @FXML
    private TableColumn<musteriBilgi, Integer> idmus;

    @FXML
    private TableColumn<musteriBilgi, String> ismus;

    @FXML
    private Label lbl_id;

    @FXML
    private Label lbl_idper;

    @FXML
    private TableColumn<PersonelBilgi, String> perad;

    @FXML
    private TableColumn<PersonelBilgi, String> peradres;

    @FXML
    private TableColumn<PersonelBilgi, String> peralan;

    @FXML
    private TableColumn<PersonelBilgi, Integer> perid;

    @FXML
    private TableColumn<musteriBilgi, String> soymus;

    @FXML
    private TableView<musteriBilgi> tablemusteri;

    @FXML
    private TableView<PersonelBilgi> tablepersonel;

    @FXML
    private TableView<TeslimatBilgi> tableteslimat;

    @FXML
    private TableColumn<TeslimatBilgi, String> tesalet;

    @FXML
    private TableColumn<TeslimatBilgi, Integer> tesid;

    @FXML
    private TableColumn<musteriBilgi, String> tesmus;

    @FXML
    private TableColumn<TeslimatBilgi, String> tesmusad;

    @FXML
    private TableColumn<TeslimatBilgi, String> tesperad;

    @FXML
    private TextField txt_arama;

    @FXML
    private TextField txtad;

    @FXML
    private TextField txtislem;

    @FXML
    private TextField txtperad;
    @FXML
    private Button btn_geri;

    @FXML
    private Button btn_kapat;
    @FXML
    private TextField txtsoyad;
    @FXML
    private TextField txtperalan;
    @FXML
    private TextField txturun;

    @FXML
    private TableColumn<musteriBilgi, String> urunmus;
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    
   
    
	  @FXML
	    void btn_geri1(ActionEvent event) {
		  Node  source = (Node)  event.getSource();
		    Stage stage = (Stage)source.getScene().getWindow();
		    stage.close();
		FormManager FormOpn =new FormManager();
		  FormOpn.FormOpen("Teslimat.fxml","Teslimat Ýþlemleri","teslim.png");
	    }

	    @FXML
	    void btn_kapat1(ActionEvent event) {
	    	Node  source = (Node)  event.getSource();
		    Stage stage = (Stage)source.getScene().getWindow();
		    stage.close();
	    }
    @FXML
    void btnkaydet1(ActionEvent event) {
    	 sql="insert into teslimatlar(personelAd,musteriAd,alet,yapilanislem) values(?,?,?,?)";
         
         try {
      	   sorguifadesi=baglanti.prepareStatement(sql);
             sorguifadesi.setString(1, txtperad.getText().trim());
             sorguifadesi.setString(2, txtad.getText().trim());
             sorguifadesi.setString(3, txturun.getText().trim());
             sorguifadesi.setString(4, txtislem.getText().trim());
             sorguifadesi.executeUpdate();
             AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Kullanýcý Ekleme iþlemi Gerçekleþti...");
             
             
  		
  	} catch (Exception e) {
  		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Kullanýcý Ekleme iþlemi Gerçekleþmedi...\n"+e.getMessage().toString());
   		
  	}DegerleriGetir2(tableteslimat);
    }

    @FXML
    void btnper1(ActionEvent event) {
    	Node  source = (Node)  event.getSource();
	    Stage stage = (Stage)source.getScene().getWindow();
	    stage.close();
    	FormManager FormOpn =new FormManager();
		  FormOpn.FormOpen("YeniPersonelArama.fxml","Teslimat Ýþlemleri","teslim.png");
	    
    }

    @FXML
    void table_clicked1(MouseEvent event) {
    	musteriBilgi kayit=new musteriBilgi();
    	kayit=(musteriBilgi) tablemusteri.getItems().get(tablemusteri.getSelectionModel().getSelectedIndex());
    	lbl_id.setText(String.valueOf(kayit.getM_id()));
    	txtad.setText(kayit.getM_ad());
    	txtsoyad.setText(String.valueOf(kayit.getM_soy()));
    	txturun.setText((kayit.getM_alet()));
        //txtperad.setText(String.valueOf(kayit.getM_tel()));
    	txtislem.setText(String.valueOf(kayit.getYapilanislem()));
    	//txtperalan.setText(String.valueOf(kayit.getM_tc()));
    }	

    @FXML
    void table_clicked2(MouseEvent event) {

    }

    @FXML
    void table_clicked3(MouseEvent event) {
    	PersonelBilgi kayit=new PersonelBilgi();
    	kayit=(PersonelBilgi) tablepersonel.getItems().get(tablepersonel.getSelectionModel().getSelectedIndex());
    	lbl_idper.setText(String.valueOf(kayit.getId()));
    	txtperad.setText(kayit.getPerad());
    	txtperalan.setText(String.valueOf(kayit.getAlan()));
    	
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
    
    
    
    
    
    public void DegerleriGetir2(TableView tablo) {
    	sql="select * from teslimatlar";
    	ObservableList<TeslimatBilgi> KayitlarListe=FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen =sorguifadesi.executeQuery();
    	    while(getirilen.next()) {
    	  KayitlarListe.addAll(new TeslimatBilgi(getirilen.getInt("id"),getirilen.getString("personelAd"),getirilen.getString("musteriAd"),getirilen.getString("alet"),getirilen.getString("yapilanislem")));
    	  
    	    }
    	    tesid.setCellValueFactory(new PropertyValueFactory<>("id"));
    	    tesperad.setCellValueFactory(new PropertyValueFactory<>("personelAd"));
    	    tesmusad.setCellValueFactory(new PropertyValueFactory<>("musteriAd"));
    	    tesalet.setCellValueFactory(new PropertyValueFactory<>("alet"));
    	    tableteslimat.setItems(KayitlarListe);
    	   
    	    
    	    
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Hatalý Birþeyler Oldu...\n"+e.getMessage().toString());
 	 		
    	}
    }
    
    
    
    
    
    
    public void DegerleriGetir1(TableView tablo) {
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
    	    //per_alan.setCellValueFactory(new PropertyValueFactory<>("alan"));
    	    peradres.setCellValueFactory(new PropertyValueFactory<>("adres"));
    	    //per_maas.setCellValueFactory(new PropertyValueFactory<>("maas"));
    	    peralan.setCellValueFactory(new PropertyValueFactory<>("alan"));
    	  
    	    tablepersonel.setItems(KayitlarListe);
    	   
    	    
    	    
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Hatalý Birþeyler Oldu...\n"+e.getMessage().toString());
 	 		
    	}
    }
    
    
    
    
    public void DegerleriGetir(TableView tablo, String sql) {
  	  sql="select * from musteri";
	ObservableList<musteriBilgi> KayitlarListe=FXCollections.observableArrayList();
	try {
		sorguifadesi=baglanti.prepareStatement(sql);
		ResultSet getirilen =sorguifadesi.executeQuery();
	    while(getirilen.next()) {
	    	KayitlarListe.add(new musteriBilgi(getirilen.getInt("M_id"),getirilen.getString("M_ad"),getirilen.getString("M_soy"),getirilen.getString("M_mail"), getirilen.getString("M_tel"), sql, sql, getirilen.getString("M_alet"), sql, sql, 0, getirilen.getString("M_tc"), sql, sql,  sql,getirilen.getString("yapilanislem"),getirilen.getString("teslimatdurum")));
	    }
	    admus.setCellValueFactory(new PropertyValueFactory<>("M_ad"));
	    idmus.setCellValueFactory(new PropertyValueFactory<>("M_id"));
	    soymus.setCellValueFactory(new PropertyValueFactory<>("M_soy"));
	    ismus.setCellValueFactory(new PropertyValueFactory<>("yapilanislem"));
	    tesmus.setCellValueFactory(new PropertyValueFactory<>("teslimatdurum"));
	    urunmus.setCellValueFactory(new PropertyValueFactory<>("M_alet"));
	  
	    tablemusteri.setItems(KayitlarListe);
	    
	    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 
		 AlertManager.Alert("HATTA!","Bilgilendirme Mesajý","Hatalý Birþeyler Oldu...\n"+e.getMessage().toString());
		
	}
}
    @FXML
    void initialize() {
    	lbl_id.setText("");
    	lbl_idper.setText("");
    	sql="select * from musteri";
       DegerleriGetir(tablemusteri, sql);
       
       DegerleriGetir1(tablepersonel);
       DegerleriGetir2(tablepersonel);
    }

}
