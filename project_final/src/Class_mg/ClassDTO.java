package Class_mg;

public class ClassDTO {

	
	
	private String sub_id;
	private String std_id;
	private String std_name;
	
	
	
	public ClassDTO(String sub_id) {
		super();
		this.sub_id = sub_id;
	}
	

	public ClassDTO(String std_id, String std_name) {
		super();
		this.std_id = std_id;
		this.std_name = std_name;
	}
	
	
	public String getSub_id() {
		return sub_id;
	}



	public void setSub_id(String sub_id) {
		this.sub_id = sub_id;
	}



	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	public String getStd_name() {
		return std_name;
	}

	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	
}
