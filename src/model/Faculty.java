package model;

public class Faculty {
	
	private int faculty_id;
	private String f_name;
	private String m_name;
	private String l_name; 
	private String gender;
	private String email;
	private String dob;
	private String ethnic; 
	private String tenure_effective_date;
	private String tenure_neg_decision_date;
	private String arrive_date;
	private String tenure_status;
	

	public Faculty () {
		this.faculty_id = 0;
		this.f_name = "no first name";
		this.m_name = "no middle name";
		this.l_name = "no last name"; 
		this.gender = "no gender";
		this.email = "no email";
		this.dob = "";
		this.ethnic = ""; 
		this.tenure_effective_date = "";
		this.tenure_neg_decision_date = "";
		this.arrive_date = "";
		this.tenure_status = "";
	}


	/**
	 * @param faculty_id
	 * @param f_name
	 * @param m_name
	 * @param l_name
	 * @param gender
	 * @param email
	 * @param dob
	 * @param ethnic
	 * @param tenure_effective_date
	 * @param tenure_neg_effective_date
	 * @param arrive_date
	 * @param tenure_status
	 */
	public Faculty(int faculty_id, String f_name, String m_name, String l_name, String gender, String email, String dob,
			String ethnic, String tenure_effective_date, String tenure_neg_effective_date, String arrive_date,
			String tenure_status) {
		this.faculty_id = faculty_id;
		this.f_name = f_name;
		this.m_name = m_name;
		this.l_name = l_name;
		this.gender = gender;
		this.email = email;
		this.dob = dob;
		this.ethnic = ethnic;
		this.tenure_effective_date = tenure_effective_date;
		this.tenure_neg_decision_date = tenure_neg_effective_date;
		this.arrive_date = arrive_date;
		this.tenure_status = tenure_status;
	}


	/**
	 * @return the faculty_id
	 */
	public int getFaculty_id() {
		return faculty_id;
	}


	/**
	 * @param faculty_id the faculty_id to set
	 */
	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}


	/**
	 * @return the f_name
	 */
	public String getF_name() {
		return f_name;
	}


	/**
	 * @param f_name the f_name to set
	 */
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}


	/**
	 * @return the m_name
	 */
	public String getM_name() {
		return m_name;
	}


	/**
	 * @param m_name the m_name to set
	 */
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	/**
	 * @return the l_name
	 */
	public String getL_name() {
		return l_name;
	}


	/**
	 * @param l_name the l_name to set
	 */
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}


	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}


	/**
	 * @return the ethnic
	 */
	public String getEthnic() {
		return ethnic;
	}


	/**
	 * @param ethnic the ethnic to set
	 */
	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}


	/**
	 * @return the tenure_effective_date
	 */
	public String getTenure_effective_date() {
		return tenure_effective_date;
	}


	/**
	 * @param tenure_effective_date the tenure_effective_date to set
	 */
	public void setTenure_effective_date(String tenure_effective_date) {
		this.tenure_effective_date = tenure_effective_date;
	}


	/**
	 * @return the tenure_neg_effective_date
	 */
	public String getTenure_neg_decision_date() {
		return tenure_neg_decision_date;
	}


	/**
	 * @param tenure_neg_effective_date the tenure_neg_effective_date to set
	 */
	public void setTenure_neg_decision_date(String tenure_neg_decision_date) {
		this.tenure_neg_decision_date = tenure_neg_decision_date;
	}


	/**
	 * @return the arrive_date
	 */
	public String getArrive_date() {
		return arrive_date;
	}


	/**
	 * @param arrive_date the arrive_date to set
	 */
	public void setArrive_date(String arrive_date) {
		this.arrive_date = arrive_date;
	}


	/**
	 * @return the tenure_status
	 */
	public String getTenure_status() {
		return tenure_status;
	}


	/**
	 * @param tenure_status the tenure_status to set
	 */
	public void setTenure_status(String tenure_status) {
		this.tenure_status = tenure_status;
	}
	
	
}
