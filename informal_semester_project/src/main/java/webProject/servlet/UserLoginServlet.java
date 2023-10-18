package webProject.servlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webProject.dao.UserDAO;
import webProject.vo.*;
import webProject.dao.impl.*;
import webProject.listener.*;

import java.io.IOException;

public class UserLoginServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
	}
	
public void doPost(HttpServletRequest req, HttpServletResponse res)
       throws IOException, ServletException{
	 
    
	     //obtain data from jsp and set variable
	  	 UserInfo userinfo = new UserInfo();
		 userinfo.setUsername(req.getParameter("username"));
		 userinfo.setPassword(req.getParameter("password"));
		 
		 UserDAO dao = new UserDAOImpl();   
	     int flag = 0;
	     try {
	    	 //obtain the consequence after operating the code with database
				flag = dao.queryByUserInfo(userinfo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
	     //if the result is ok, then return a user information to the jsp document
		 if(flag == 1){   
			 HttpSession session=req.getSession();   
	         session.setAttribute("username", userinfo.getUsername()); 
	         realTime_map_observer listener = new realTime_map_observer(500);
	         try {
				session.setAttribute("userinfo", dao.queryByUserInfo(userinfo.getUsername()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
	         res.sendRedirect("./welcome.jsp");
	        } else {   
	         res.sendRedirect("./error.jsp");
	        }
	 }


	         
	}

