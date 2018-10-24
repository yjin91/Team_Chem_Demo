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
 * Servlet implementation class UpdateStudentBasicFormServlet
 */
@WebServlet({ "/UpdateStudentBasicFormServlet", "/updatesbform" })
public class UpdateStudentBasicFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentBasicFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		
		ViewStudentBasicQuery vsb = new ViewStudentBasicQuery("chemDB", "root", "123456");
		
		Student student = vsb.doReadOne(studentID);
		
		request.setAttribute("student", student);
		
		String username = (String) session.getAttribute("username");
		request.setAttribute("username", username);
		
		String url = "/updatestudentbasicform.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
