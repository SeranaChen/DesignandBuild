package webProject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import webProject.dao.ShowRobotInfoDAO;
import webProject.dao.impl.ShowRobotInfoDAOImpl;
import webProject.vo.RobotNewInfo;
import webProject.dao.*;
import webProject.servlet.*;

/**
 * Servlet implementation class ShowRobotInfoServlet
 */
@WebServlet("/BasicInfoServlet")
public class BasicInformation extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RobotNewInfo showRobotInfo1 = new RobotNewInfo();
		HttpSession session = request.getSession();
		showRobotInfo1.setUsername((String)session.getAttribute("username"));
		System.out.println("name is"+showRobotInfo1.getUsername());
		
		ShowRobotInfoDAO dao = new ShowRobotInfoDAOImpl();
		String[][] robot_information = new String[1000][];
		try {
			robot_information = dao.queryByRobotShowInfo(showRobotInfo1);
			System.out.println(robot_information[0][0]);
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(robot_information[0][0]!=null) {
			System.out.println("basic0"+robot_information[0][1]);
			System.out.println("basic1"+robot_information[0][2]);
		}
			
			
		//set the acquired robot information into session
		session.setAttribute("Array", robot_information);
		request.setAttribute("isEmptyAction", "false");
		request.getRequestDispatcher("./welcome.jsp").forward(request, response);
	}
}