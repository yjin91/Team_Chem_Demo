package model;

public class Credential {

	private int credential_id;
	private String f_name;
	private String l_name; 
	private String degree_type;
	private String received_date;
	private String institution;
	private String major;
	private int facultyid;
	
	
	public Credential () {
		this.credential_id = 0;
		this.f_name = "";
		this.l_name = "";
		this.degree_type = "";
		this.received_date = "";
		this.institution = "";
		this.major = "";
		this.facultyid = 0;
	}
	/**
	 * @param credential_id
	 * @param f_name
	 * @param l_name
	 * @param degree_type
	 * @param received_date
	 * @param institution
	 * @param major
	 * @param facultyid
	 */
	public Credential(int credential_id, String f_name, String l_name, String degree_type, String received_date,
			String institution, String major, int facultyid) {
		this.credential_id = credential_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.degree_type = degree_type;
		this.received_date = received_date;
		this.institution = institution;
		this.major = major;
		this.facultyid = facultyid;
	}
	/**
	 * @return the credential_id
	 */
	public int getCredential_id() {
		return credential_id;
	}
	/**
	 * @param credential_id the credential_id to set
	 */
	public void setCredential_id(int credential_id) {
		this.credential_id = credential_id;
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
	 * @return the degree_type
	 */
	public String getDegree_type() {
		return degree_type;
	}
	/**
	 * @param degree_type the degree_type to set
	 */
	public void setDegree_type(String degree_type) {
		this.degree_type = degree_type;
	}
	/**
	 * @return the received_date
	 */
	public String getReceived_date() {
		return received_date;
	}
	/**
	 * @param received_date the received_date to set
	 */
	public void setReceived_date(String received_date) {
		this.received_date = received_date;
	}
	/**
	 * @return the institution
	 */
	public String getInstitution() {
		return institution;
	}
	/**
	 * @param institution the institution to set
	 */
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * @return the facultyid
	 */
	public int getFacultyid() {
		return facultyid;
	}
	/**
	 * @param facultyid the facultyid to set
	 */
	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}

}
