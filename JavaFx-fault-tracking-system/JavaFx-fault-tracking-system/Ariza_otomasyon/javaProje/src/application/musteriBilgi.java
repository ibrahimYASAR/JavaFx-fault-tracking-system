package application;



public class musteriBilgi {
	musteriBilgi(){
		this.M_soy="";
	}
public	musteriBilgi(int M_id, String M_ad, String M_soy, String m_mail,String M_tel,String M_sikayet,String M_aciklama,String M_alet,String M_Urun_bilgi,String M_talep,int M_masraf,String M_tc,String M_kod,String para, String personelAciklama,String yapilanislem,String teslimatdurum){
		this.M_id=M_id;
		this.M_ad=M_ad;
		this.M_soy=M_soy;
		this.m_mail=m_mail;
		this.M_tel=M_tel;
		this.M_sikayet=M_sikayet;
		this.M_aciklama=M_aciklama;
		this.M_alet=M_alet;
		this.M_Urun_bilgi=M_Urun_bilgi;
		this.M_talep=M_talep;
		this.M_masraf=M_masraf;
		this.M_tc=M_tc;
		this.para=para;
		this.M_kod=M_kod;
		this.personelAciklama=personelAciklama;
		this.teslimatdurum=teslimatdurum;
		this.yapilanislem=yapilanislem;
	}
	
	
public String getTeslimatdurum() {
	return teslimatdurum;
}
public void setTeslimatdurum(String teslimatdurum) {
	this.teslimatdurum = teslimatdurum;
}
public String getYapilanislem() {
	return yapilanislem;
}
public void setYapilanislem(String yapilanislem) {
	this.yapilanislem = yapilanislem;
}
public String getPersonelAciklama() {
		return personelAciklama;
	}
	public void setPersonelAciklama(String personelAciklama) {
		this.personelAciklama = personelAciklama;
	}
public int getM_id() {
		return M_id;
	}
	public void setM_id(int m_id) {
		M_id = m_id;
	}
	public String getM_ad() {
		return M_ad;
	}
	public void setM_ad(String m_ad) {
		M_ad = m_ad;
	}
	public String getM_soy() {
		return M_soy;
	}
	public void setM_soy(String m_soy) {
		M_soy = m_soy;
	}
	public String getM_mail() {
		return m_mail;
	}
	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}
	public String getM_tel() {
		return M_tel;
	}
	public void setM_tel(String m_tel) {
		M_tel = m_tel;
	}
	public String getM_sikayet() {
		return M_sikayet;
	}
	public void setM_sikayet(String m_sikayet) {
		M_sikayet = m_sikayet;
	}
	public String getM_aciklama() {
		return M_aciklama;
	}
	public void setM_aciklama(String m_aciklama) {
		M_aciklama = m_aciklama;
	}
	public String getM_alet() {
		return M_alet;
	}
	public void setM_alet(String m_alet) {
		M_alet = m_alet;
	}
	public String getM_Urun_bilgi() {
		return M_Urun_bilgi;
	}
	public void setM_Urun_bilgi(String m_Urun_bilgi) {
		M_Urun_bilgi = m_Urun_bilgi;
	}
	public String getM_talep() {
		return M_talep;
	}
	public void setM_talep(String m_talep) {
		M_talep = m_talep;
	}
	public int getM_masraf() {
		return M_masraf;
	}
	public void setM_masraf(int m_masraf) {
		M_masraf = m_masraf;
	}
	
	public String getM_tc() {
		return M_tc;
	}
	public void setM_tc(String m_tc) {
		M_tc = m_tc;
	}

	private String teslimatdurum;
	private String yapilanislem;
private int M_id;
private String M_ad;
private String M_soy;
private String m_mail;
private String M_tel;
private String M_sikayet;
private String M_aciklama;
private String M_alet;
private String M_Urun_bilgi;
private String M_talep;
private int M_masraf;
private String M_tc;
private String para;
public String getPara() {
	return para;
}
public void setPara(String para) {
	this.para = para;
}


private String M_kod;
private String personelAciklama;

public String getM_kod() {
	return M_kod;
}
public void setM_kod(String m_kod) {
	M_kod = m_kod;
}


}
