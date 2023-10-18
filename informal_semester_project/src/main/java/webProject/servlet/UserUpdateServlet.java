package webProject.servlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webProject.dao.UserDAO;
import webProject.dao.impl.UserDAOImpl;
import webProject.vo.UserInfo;

public class UserUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String age = request.getParameter("Age");
		String tel = request.getParameter("Tel");
		String email = request.getParameter("Email");
		String gender = request.getParameter("Gender");
		
		//the indication when the updating information appears some types wrong
		if(username==null||username.trim().isEmpty()){
			request.setAttribute("registError", "username cannot be empty");
			request.getRequestDispatcher("/update.jsp").forward(request, response);
			return;
		}
		if(password==null||password.trim().isEmpty()){
			request.setAttribute("registError", "password cannot be empty");
			request.getRequestDispatcher("/update.jsp").forward(request, response);
			return;
		}
		 UserDAO dao =  new UserDAOImpl();
		boolean res = dao.updateUser(username, password, gender, age, tel, email,Integer.valueOf(userid));
        if(res){
			try {
				request.setAttribute("userinfo", dao.queryByUserInfo(username));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			request.setAttribute("registError", "username already exists");
		}
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}
	
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
		

