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
			student.setGreAW(this.results.getDouble("greAW"));
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
		
		div += "</tr>";
		div += "</tbody>";
		div += "</table>";
		div += "</div>";
		
		return div;
	}
	
	public String getNewHTMLTable() {
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
		div += "<th>Edit</th>";
		div += "<th>Delete</th>";
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
			student.setGreAW(this.results.getDouble("greAW"));
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
			div += "<td>";
			div += "<form name=updateStudent action=updatesbform method=post >";
			div += "<input class='notDisplay' name='studentID' type='text' readonly='readonly' value='" + student.getStudentID() + "' />";
			div += "<input class='icon' type=image src='_img/editimg.png' />";
			div += "</form>";
			div += "</td>";
			div += "<td>";
			div += "<form name=deleteStudent action=deleteSB method=post >";
			div += "<input class='notDisplay' name='studentID' type='text' readonly='readonly' value='" + student.getStudentID() + "' />";
		    div += "<input class='icon' type=image src='_img/deleteimg.png' />";
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
	
	
	public Student doReadOne(int studentID) {
		String query = "select * from chemDB.studentbasic where studentID = ?";

		Student student = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, studentID);
			ResultSet results = ps.executeQuery();

			results.next();

			student = new Student(
					results.getInt("studentID"),
					results.getString("fName"),
					results.getString("mName"),
					results.getString("lName"),
					results.getString("ethnic"),
					results.getString("gender"),
					results.getString("email"),
					results.getString("nationality"),
					results.getInt("greVerb"),
					results.getInt("greQuan"),
					results.getDouble("greAW"),
					results.getString("inResearch"),
					results.getString("inWork")
					);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return student;
	}
	
	public void doUpdate(Student student) {
		String query = "update chemDB.studentbasic set fName=?, mName=?, lName=?, ethnic=?, gender=?, email=?, nationality=?, greVerb=?, greQuan=?, greAW=?, inResearch=?, inWork=? where studentID=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, student.getfName());
			ps.setString(2, student.getmName());
			ps.setString(3, student.getlName());
			ps.setString(4, student.getEthnic());
			ps.setString(5, student.getGender());
			ps.setString(6, student.getEmail());
			ps.setString(7, student.getNationality());
			ps.setInt(8, student.getGreVerb());
			ps.setInt(9, student.getGreQuan());
			ps.setDouble(10, student.getGreAW());
			ps.setString(11, student.getInResearch());
			ps.setString(12, student.getInWork());
			ps.setInt(13, student.getStudentID());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void doDeleteStudent (int studentID) {
		
		String query = "delete from chemDB.studentbasic where studentID = ?";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			
			ps.setInt(1,studentID);
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void addStudent(Student student) {
		
		String query = "insert into chemDB.studentbasic (studentID, fName, mName, lName, ethnic, gender, email, nationality, greVerb, greQuan, greAW, inResearch, inWork) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, student.getStudentID());
			ps.setString(2, student.getfName());
			ps.setString(3, student.getmName());
			ps.setString(4, student.getlName());
			ps.setString(5, student.getEthnic());
			ps.setString(6, student.getGender());
			ps.setString(7, student.getEmail());
			ps.setString(8, student.getNationality());
			ps.setInt(9, student.getGreVerb());
			ps.setInt(10, student.getGreQuan());
			ps.setDouble(11, student.getGreAW());
			ps.setString(12, student.getInResearch());
			ps.setString(13, student.getInWork());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
