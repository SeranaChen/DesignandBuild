package webProject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webProject.dao.UserDAO;
import webProject.dao.impl.UserDAOImpl;
import webProject.listener.*;
import webProject.vo.UserInfo;

import javax.servlet.http.HttpServlet;

/**
 * Servlet to add monitor or listener to the given folder
 */
public class current_listener extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException{
			}
			
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	       throws IOException, ServletException{
		realTime_map_observer fileMonitor = new realTime_map_observer(1000);
		String realTime_map_address = req.getParameter("realTime_map");
		System.out.println(realTime_map_address);
		//add monitor or listener to the given folder
		fileMonitor.monitor("C:/Users/35177/Desktop/upload/"+realTime_map_address, new realTime_map());
		try {
			//start the monitor or listener
			fileMonitor.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		         
		  	    
		res.sendRedirect("./welcome.jsp");
		        
	}
}
