


package application;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AnaSayfa2Controller {

    @FXML
    private ResourceBundle resources;
    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;
    @FXML
    private URL location;

    @FXML
    private AnchorPane anasayfaarka;

    @FXML
    private Text kayanyazitext;
    String a="  Arýza  Teknik  Servis  ";
    // private Object root;


        
      public void basla(){
         new java.util.Timer().schedule( 
         new java.util.TimerTask() {
             @Override
             public void run() {
               basla();
                a=a.substring(1)+a.charAt(0);
        kayanyazitext.setText(a);
             }
         }, 
         250                         
  );
         
        
       
      }
      @FXML
      private Button btn_geri;

      @FXML
      private Button btn_kapat;
      @FXML
      void personelSaglikbilgi_button(ActionEvent event) {
    	  AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Sadece Yöneticiler Eriþebilir...");
          
      }
      @FXML
      void btn_geri1(ActionEvent event) {
    	  Node  source = (Node)  event.getSource();
		    Stage stage = (Stage)source.getScene().getWindow();
		    stage.close();
		FormManager FormOpn =new FormManager();
		  FormOpn.FormOpen("giris.fxml","Teslimat Ýþlemleri","teslim.png");
      }

      @FXML
      void btn_kapat1(ActionEvent event) {
    	  Node  source = (Node)  event.getSource();
		    Stage stage = (Stage)source.getScene().getWindow();
		    stage.close();
      }
      
      @FXML
      void ArizaEkle_button(ActionEvent event) {
    	  FormManager FormOpn =new FormManager();
    	  FormOpn.FormOpen("ArizaEkle.fxml","Arýza Ekle","arýza.png");
    	  Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close();
      }
      @FXML
      void teslimat_button(ActionEvent event) {
    	  FormManager FormOpn =new FormManager();
    	  FormOpn.FormOpen("Teslimat.fxml","Teslimat Ýþlemleri","teslim.png");
    	  Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close();
      }
      @FXML
      void Atolye_button(ActionEvent event) {
    	  FormManager FormOpn =new FormManager();
    	  FormOpn.FormOpen("AtolyeDurum-Guncelle.fxml","Atölye","atolye.jpg");
    	  Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close();
      }
      @FXML
      void MusteriFinans_button(ActionEvent event) {
    	  AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Sadece Yöneticiler Eriþebilir...");
          
      }
      @FXML
      void sifre_kullanici_button(ActionEvent event) {
    	  AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Sadece Yöneticiler Eriþebilir...");
      }
      @FXML
      void MusteriGuncelleSil_button(ActionEvent event) {
    	  FormManager FormOpn =new FormManager();
    	  FormOpn.FormOpen("MusteriGuncelleSil.fxml","Müþteri Güncelle/Sil Ýþlemleri","musteri güncelle sil.png");
    	  Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close();
        	
      }
      @FXML
      void SikayetVeTalepler_button(ActionEvent event) {
    	  
    	  AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Sadece Yöneticiler Eriþebilir...");
          
    	 
      }
      @FXML
      void PersonelFinans_button(ActionEvent event) {
    	  AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Sadece Yöneticiler Eriþebilir...");
          
    	 
      }
    @FXML
    void MusteriKaydet_button(ActionEvent event) {
    	FormManager FormOpn =new FormManager();
    	FormOpn.FormOpen("MusteriKaydet.fxml","Müþteri Kaydet","musteri kaydet.png");
    	Node  source = (Node)  event.getSource();
  	    Stage stage = (Stage)source.getScene().getWindow();
  	    stage.close();
    }

    @FXML
    void hakkimizda_button(ActionEvent event) {
    	FormManager FormOpn =new FormManager();
    	FormOpn.FormOpen("hakkimizdafxml.fxml","Hakkýmýzda","hakkýmýzda.png");
    	Node  source = (Node)  event.getSource();
  	    Stage stage = (Stage)source.getScene().getWindow();
  	    stage.close();
    }

    @FXML
    void musteri_talep_sikayet_button(ActionEvent event) {
    	FormManager FormOpn =new FormManager();
    	FormOpn.FormOpen("Musteri_sikayet-talep.fxml","Müþteri Talep Ve Þikayet Ekle","musteriMemnuniyet.jpg");
    	Node  source = (Node)  event.getSource();
  	    Stage stage = (Stage)source.getScene().getWindow();
  	    stage.close();
    }

    @FXML
    void personelArama_button(ActionEvent event) {
    	AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Sadece Yöneticiler Eriþebilir...");
        
    }

    @FXML
    void personelGuncelle_button(ActionEvent event) {
    	AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Sadece Yöneticiler Eriþebilir...");
        
    }

    @FXML
    void personelKaydet_button(ActionEvent event) {
    	AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Sadece Yöneticiler Eriþebilir...");
        
    }

    

    @FXML
    void personelSil_button(ActionEvent event) {
    	AlertManager.Alert("DÝKKAT!","Bilgilendirme Mesajý","Sadece Yöneticiler Eriþebilir...");
        
    }

    @FXML
    void initialize() {
    	basla();

    }

}