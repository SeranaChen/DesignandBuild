package webProject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webProject.dao.UserDAO;
import webProject.dao.impl.UserDAOImpl;
import webProject.vo.UserInfo;

public class UserRegisterServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
 

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String age = request.getParameter("Age");
		String tel = request.getParameter("Tel");
		String email = request.getParameter("Email");
		String gender = request.getParameter("Gender");
		String passwordagain = request.getParameter("passwordagain");
		
		//the indication when the register information appears some types wrong
		if(username==null||username.trim().isEmpty()){
			request.setAttribute("registError", "username cannot be empty");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		if(password==null||password.trim().isEmpty()){
			request.setAttribute("registError", "password cannot be empty");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		if(!password.equals(passwordagain)){
			request.setAttribute("registError", "password inconsistency");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		 UserDAO dao =  new UserDAOImpl();
		boolean res = dao.addUser(username, passwordagain, gender, age, tel, email);
		if(res){
			response.sendRedirect("login.jsp");
		}else {
			request.setAttribute("registError", "username already exists");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
		