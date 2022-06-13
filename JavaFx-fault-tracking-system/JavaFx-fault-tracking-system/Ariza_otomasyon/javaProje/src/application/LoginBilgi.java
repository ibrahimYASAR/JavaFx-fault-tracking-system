package application;

public class LoginBilgi {
	private int Kid;
	public int getKid() {
		return Kid;
	}
	public void setKid(int kid) {
		Kid = kid;
	}
	public String getKul_ad() {
		return kul_ad;
	}
	public void setKul_ad(String kul_ad) {
		this.kul_ad = kul_ad;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	private String kul_ad;
	private String sifre;
	
	LoginBilgi(){
		
	}
	public	LoginBilgi(int Kid,String kul_ad,String sifre) {
		this.Kid=Kid;
		this.kul_ad=kul_ad;
		this.sifre=sifre;
	}
}
