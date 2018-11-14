package dbhelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Credential;
import model.Faculty;
import model.Student;

public class ViewFacultyBasicQuery {
	
	private Connection connection;
	private ResultSet results;
	
	/**
	 * @author Yi Jin, Sarah Fox, Jason Roberts, Erick Hollick
	 * 
	 */
	
	public ViewFacultyBasicQuery (String dbName, String uname, String pwd) {
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
;		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void doRead() {
		
		String query = "select * from chemDB.facultybasic order by l_name;";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public Credential readCredential(int facultyid) {
		
		String query = "SELECT credential_id,  l_name, f_name, degree_type, received_date, institution, major "
				     + "FROM chemDB.facultybasic, chemDB.facultycredential"
				     + "WHERE chemDB.facultycredential.facultyid = chemDB.facultybasic.faculty_id"
				     + "AND chemDB.facultycredential.facultyid = ?"
				     + "ORDER BY received_date;";
		
		Credential credential = null;
		
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			
			ps.setInt(1, facultyid);
			
			ResultSet results = ps.executeQuery();
			
			credential = new Credential(
					results.getInt("credential_id"),
					results.getString("l_name"),
					results.getString("f_name"),
					results.getString("degree_type"),
					results.getString("received_date"),
					results.getString("institution"),
					results.getString("major"),
					results.getInt("facultyid")
					);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return credential;
	}
	
    public String getHTMLTable() {
		String div = "";
		div += "<div class='table-block'>";
		div += "<table class='student_table'>";
		div += "<thead>";
		div += "<th>ID</th>";
		div += "<th>Name</th>";
		div += "<th>Ethnic</th>";
		div += "<th>Gender</th>";
		div += "<th>DOB</th>";
		div += "<th>Arrive Date</th>";
		div += "<th>Tenure Status</th>";
		div += "<th>Credential</th>";
		div += "</tr>";
		div += "</thead>";
		div += "<tbody>";	
		
		try {
			while(this.results.next()) {
			Faculty faculty = new Faculty();
			
			faculty.setFaculty_id(this.results.getInt("faculty_id"));
			faculty.setF_name(this.results.getString("f_name"));
			faculty.setM_name(this.results.getString("m_name"));
			faculty.setL_name(this.results.getString("l_name"));
			faculty.setEthnic(this.results.getString("ethnic"));
			faculty.setGender(this.results.getString("gender"));
			faculty.setEmail(this.results.getString("email"));
			faculty.setDob(this.results.getString("dob"));
			faculty.setTenure_effective_date(this.results.getString("tenure_effective_date"));
			faculty.setTenure_neg_decision_date(this.results.getString("tenure_neg_decision_date"));
			faculty.setArrive_date(this.results.getString("arrive_date"));
			faculty.setTenure_status(this.results.getString("tenure_status"));
			
			div += "<tr>";
			div += "<td>" + faculty.getFaculty_id() + "</td>";
			div += "<td>" + faculty.getL_name() + ", " + faculty.getF_name() + "</td>";
			div += "<td>" + faculty.getEthnic() + "</td>";
			div += "<td>" + faculty.getGender() + "</td>";
			div += "<td>" + faculty.getDob() + "</td>";
			div += "<td>" + faculty.getArrive_date() + "</td>";
			div += "<td>" + faculty.getTenure_status() + "</td>";
			div += "<td>";
			div += "<form name=updateStudent action= method=post >";
			div += "<input class='notDisplay' name='faculty_id' type='text' readonly='readonly' value='" + faculty.getFaculty_id() + "' />";
			div += "<input class='icon' type=image src='_img/information.png' />";
			div += "</form>";
			div += "</td>";
			
			}
		}  catch (SQLException e) {
			//TOO Autogenerate catch block
			e.printStackTrace();
		}
		
		div += "</tr>";
		div += "</tbody>";
		div += "</table>";
		div += "</div>";
		
		return div;
	}
	
}
