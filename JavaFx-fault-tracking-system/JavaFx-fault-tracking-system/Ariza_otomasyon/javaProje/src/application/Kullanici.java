package application;

public class Kullanici {
	
	private int k_id;
	private String k_user;
	private String k_pass;
	
	
Kullanici(){
	
}
	
	public Kullanici(int k_id,String k_user,String k_pass) {
		this.k_id=k_id;
		this.k_user=k_user;
		this.k_pass=k_pass;
		
		
	}

	public int getK_id() {
		return k_id;
	}

	public void setK_id(int k_id) {
		this.k_id = k_id;
	}

	public String getK_user() {
		return k_user;
	}

	public void setK_user(String k_user) {
		this.k_user = k_user;
	}

	public String getK_pass() {
		return k_pass;
	}

	public void setK_pass(String k_pass) {
		this.k_pass = k_pass;
	}
	
}
