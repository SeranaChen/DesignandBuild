package webProject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import webProject.dao.impl.ShowMazeInfoDAOImpl;
import webProject.dao.*;
import webProject.servlet.*;

/*
 * class to create servlet while showing maze information
 */
public class ShowMazeInfoServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		ShowMazeInfoDAO dao = new ShowMazeInfoDAOImpl();
		String[][] maze_information = new String[1000][];
		try {
			//operate the programming with database operation and obtain the data
			maze_information = dao.queryByMazeShowInfo(request.getParameter("username"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		for(int i=0;i<1000;i++) {
			if(maze_information[i][0]!=null) {
				System.out.print(maze_information[i][1]);
				System.out.println();
				
			}
			
		}
		//set mazeinfo into session
		session.setAttribute("mazeInfo", maze_information);
		response.sendRedirect("./welcome.jsp");
	}
}
