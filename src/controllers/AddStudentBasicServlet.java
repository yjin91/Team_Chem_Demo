package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbhelpers.ViewStudentBasicQuery;
import model.Student;

/**
 * Servlet implementation class AddStudentBasicServlet
 */
@WebServlet({ "/AddStudentBasicServlet", "/addstudent" })
public class AddStudentBasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentBasicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		request.setAttribute("username", username);
		
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		String fName = request.getParameter("fName");
		String mName = request.getParameter("mName");
		String lName = request.getParameter("lName");
		String ethnic = request.getParameter("ethnic");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String nationality = request.getParameter("nationality");
		int greVerb = Integer.parseInt(request.getParameter("greVerb"));
		int greQuan = Integer.parseInt(request.getParameter("greQuan"));
		double greAW = Double.parseDouble(request.getParameter("greAW"));
		String inResearch = request.getParameter("inResearch");
		String inWork = request.getParameter("inWork");
		
		Student student = new Student();
		
		student.setStudentID(studentID);
		student.setfName(fName);
		student.setmName(mName);
		student.setlName(lName);
		student.setEthnic(ethnic);
		student.setGender(gender);
		student.setEmail(email);
		student.setNationality(nationality);
		student.setGreVerb(greVerb);
		student.setGreQuan(greQuan);
		student.setGreAW(greAW);
		student.setInResearch(inResearch);
		student.setInWork(inWork);
		
		ViewStudentBasicQuery vsb = new ViewStudentBasicQuery("chemDB", "root", "123456");
		vsb.addStudent(student);
		
		String url = "/successupdate.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
