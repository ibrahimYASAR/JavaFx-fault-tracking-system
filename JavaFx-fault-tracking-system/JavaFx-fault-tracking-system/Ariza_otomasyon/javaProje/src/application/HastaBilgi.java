package application;

import java.time.LocalDate;


import javafx.scene.control.Button;

public class HastaBilgi {
	
	String hastaAdiSoyadi;
	String memleket;
	String meslek;
	String cinsiyet;
	String hastaAtes;
	String teshis;
	LocalDate tarih;
	
	
	

	public HastaBilgi(String hastaAdiSoyadi,String memleket,String meslek,String cinsiyet,String hastaAtes,String teshis, LocalDate tarih) {
		
		this.hastaAdiSoyadi=hastaAdiSoyadi;
		this.memleket=memleket;
		this.meslek=meslek;
		this.cinsiyet=cinsiyet;
		this.hastaAtes=hastaAtes;
		this.teshis=teshis;
		this.tarih=tarih;
		
	}
	
	
	public LocalDate getTarih() {
		return tarih;
	}


	public void setTarih(LocalDate tarih) {
		this.tarih = tarih;
	}


	public String getHastaAdiSoyadi() {
		return hastaAdiSoyadi;
	}
	public void setHastaAdiSoyadi(String hastaAdiSoyadi) {
		this.hastaAdiSoyadi = hastaAdiSoyadi;
	}
	public String getMemleket() {
		return memleket;
	}
	public void setMemleket(String memleket) {
		this.memleket = memleket;
	}
	public String getMeslek() {
		return meslek;
	}
	public void setMeslek(String meslek) {
		this.meslek = meslek;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public String getHastaAtes() {
		return hastaAtes;
	}
	public void setHastaAtes(String hastaAtes) {
		this.hastaAtes = hastaAtes;
	}
	public String getTeshis() {
		return teshis;
	}
	public void setTeshis(String teshis) {
		this.teshis = teshis;
	}
	public Button getButon() {
		return buton;
	}
	public void setButon(Button buton) {
		this.buton = buton;
	}
	private Button buton;
}
	
	