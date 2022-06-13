package application;

import java.sql.Date;

public class PersonelBilgi {
	 
	private int id;
	private String perad;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPerad() {
		return perad;
	}
	public void setPerad(String perad) {
		this.perad = perad;
	}
	public String getAlan() {
		return alan;
	}
	public void setAlan(String alan) {
		this.alan = alan;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public double getMaas() {
		return maas;
	}
	public void setMaas(double maas) {
		this.maas = maas;
	}
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	private String alan;
	private String adres;
	private double maas;
	private Date tarih;
	
	PersonelBilgi(){
		this.maas=0;
	}
	PersonelBilgi(int id, String perad, String alan, String adres,double maas, Date tarih){
		this.id=id;
		this.perad=perad;
		this.alan=alan;
		this.adres=adres;
		this.maas=maas;
		this.tarih=tarih;
	}
}
