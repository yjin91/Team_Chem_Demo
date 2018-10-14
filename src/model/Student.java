package model;

public class Student {

	private int studentID;
	private String fName;
	private String mName;
	private String lName; 
	private String ethnic;
	private String gender;
	private String email;
	private String nationality; 
	private int greVerb;
	private int greQuan;
	private int greAW;
	private int inResearch;
	private int inWork;
	
	public Student () {
		this.studentID = 0;
		this.fName = "no first name";
		this.mName = "no middle name";
		this.lName = "no last name"; 
		this.ethnic = "no ethnic";
		this.gender = "no gender";
		this.email = "no email";
		this.nationality = "no nationality"; 
		this.greVerb = 0;
		this.greQuan = 0;
		this.greAW = 0;
		this.inResearch = 0;
		this.inWork = 0;
	}
	
	/**
	 * @param studentID
	 * @param fName
	 * @param mName
	 * @param lName
	 * @param ethnic
	 * @param gender
	 * @param email
	 * @param nationality
	 * @param greVerb
	 * @param greQuan
	 * @param greAW
	 * @param inResearch
	 * @param inWork
	 */
	
	public Student(int studentID, String fName, String mName, String lName, String ethnic, String gender, String email,
			String nationality, int greVerb, int greQuan, int greAW, int inResearch, int inWork) {
		this.studentID = studentID;
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.ethnic = ethnic;
		this.gender = gender;
		this.email = email;
		this.nationality = nationality;
		this.greVerb = greVerb;
		this.greQuan = greQuan;
		this.greAW = greAW;
		this.inResearch = inResearch;
		this.inWork = inWork;
	}

	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the mName
	 */
	public String getmName() {
		return mName;
	}

	/**
	 * @param mName the mName to set
	 */
	public void setmName(String mName) {
		this.mName = mName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
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
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the greVerb
	 */
	public int getGreVerb() {
		return greVerb;
	}

	/**
	 * @param greVerb the greVerb to set
	 */
	public void setGreVerb(int greVerb) {
		this.greVerb = greVerb;
	}

	/**
	 * @return the greQuan
	 */
	public int getGreQuan() {
		return greQuan;
	}

	/**
	 * @param greQuan the greQuan to set
	 */
	public void setGreQuan(int greQuan) {
		this.greQuan = greQuan;
	}

	/**
	 * @return the greAW
	 */
	public int getGreAW() {
		return greAW;
	}

	/**
	 * @param greAW the greAW to set
	 */
	public void setGreAW(int greAW) {
		this.greAW = greAW;
	}

	/**
	 * @return the inResearch
	 */
	public int getInResearch() {
		return inResearch;
	}

	/**
	 * @param inResearch the inResearch to set
	 */
	public void setInResearch(int inResearch) {
		this.inResearch = inResearch;
	}

	/**
	 * @return the inWork
	 */
	public int getInWork() {
		return inWork;
	}

	/**
	 * @param inWork the inWork to set
	 */
	public void setInWork(int inWork) {
		this.inWork = inWork;
	}

}
