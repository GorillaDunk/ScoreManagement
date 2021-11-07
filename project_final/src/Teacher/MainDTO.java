package Teacher;

public class MainDTO {

	private String std_id;
	private String std_pw;
	private String std_name;
	private String join_date;
	
	
	
	public MainDTO(String std_id, String std_pw, String std_name, String join_date) {
		this.std_id = std_id;
		this.std_pw = std_pw;
		this.std_name = std_name;
		this.join_date = join_date;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public String getStd_pw() {
		return std_pw;
	}
	public void setStd_pw(String std_pw) {
		this.std_pw = std_pw;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	
}
	
	
	
	