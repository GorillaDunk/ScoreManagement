package GSP;

public class GSPDTO {
	
	private String std_id;
	private String std_name;
	private String essay;
	private String feedback;
	
	
	
	
	
	public GSPDTO(String std_id, String std_name, String essay, String feedback) {
		super();
		this.std_id = std_id;
		this.std_name = std_name;
		this.essay = essay;
		this.feedback = feedback;
	}
	
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_name = std_id;
	}
	
	public String getStd_name() {
		return std_name;
	}
	public void setStudent_name(String std_name) {
		this.std_name = std_name;
	}
	public String getEssay() {
		return essay;
	}
	public void setEssay_id(String essay) {
		this.essay = essay;
	}
	

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	
	

}
