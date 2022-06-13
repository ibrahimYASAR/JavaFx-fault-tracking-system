package application;

public class TeslimatBilgi {
	private int id;
	private String personelAd;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersonelAd() {
		return personelAd;
	}

	public void setPersonelAd(String personelAd) {
		this.personelAd = personelAd;
	}

	public String getMusteriAd() {
		return musteriAd;
	}

	public void setMusteriAd(String musteriAd) {
		this.musteriAd = musteriAd;
	}

	public String getAlet() {
		return alet;
	}

	public void setAlet(String alet) {
		this.alet = alet;
	}

	public String getYapilanislem() {
		return yapilanislem;
	}

	public void setYapilanislem(String yapilanislem) {
		this.yapilanislem = yapilanislem;
	}

	private String musteriAd;
	private String alet;
	private String yapilanislem;
	
	
	TeslimatBilgi(){
		
	}
	
	public TeslimatBilgi(int id,String personelAd,String musteriAd,String alet,String yapilanislem) {
		
		this.id=id;
		this.personelAd=personelAd;
		this.musteriAd=musteriAd;
		this.alet=alet;
		this.yapilanislem=yapilanislem;
	}
	
}



