package dbhelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import model.Student;

public class ViewStudentBasicQuery {
	
	private Connection connection;
	private ResultSet results;
	
	/**
	 * @author Yi Jin, Sarah Fox, Jason Roberts, Erick Hollick
	 * 
	 */
	
	public ViewStudentBasicQuery (String dbName, String uname, String pwd) {
		
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
		
		String query = "select * from chemDB.studentbasic order by studentID;";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getHTMLTable() {
		String div = "";
		div += "<div class='table-block'>";
		div += "<table class='student_table'>";
		div += "<thead>";
		div += "<th>Student ID</th>";
		div += "<th>Name</th>";
		div += "<th>Ethnic</th>";
		div += "<th>Gender</th>";
		div += "<th>GRE Score</th>";
		div += "<th>Research</th>";
		div += "<th>Work</th>";
		div += "</tr>";
		div += "</thead>";
		div += "<tbody>";
		
		
		
		try {
			while(this.results.next()) {
			Student student = new Student();
			
			student.setStudentID(this.results.getInt("studentID"));
			student.setfName(this.results.getString("fName"));
			student.setmName(this.results.getString("mName"));
			student.setlName(this.results.getString("lName"));
			student.setEthnic(this.results.getString("ethnic"));
			student.setGender(this.results.getString("gender"));
			student.setNationality(this.results.getString("nationality"));
			student.setGreVerb(this.results.getInt("greVerb"));
			student.setGreQuan(this.results.getInt("greQuan"));
			student.setGreAW(this.results.getInt("greAW"));
			student.setInResearch(this.results.getString("inResearch"));
			student.setInWork(this.results.getString("inWork"));
			
			div += "<tr>";
			div += "<td>" + student.getStudentID() + "</td>";
			div += "<td>" + student.getlName() + ", " + student.getfName() + "</td>";
			div += "<td>" + student.getEthnic() + "</td>";
			div += "<td>" + student.getGender() + "</td>";
			div += "<td>V: " + student.getGreVerb() + ", Q: " + student.getGreQuan() + ", AW: " + student.getGreAW() + "</td>";
			div += "<td>" + student.getInResearch() + "</td>";
			div += "<td>" + student.getInResearch() + "</td>";
			
			}
		}  catch (SQLException e) {
			//TOO Autogenerate catch block
			e.printStackTrace();
		}
		
		div += "</tbody>";
		div += "</table>";
		div += "</div>";
		
		return div;
	}

}
