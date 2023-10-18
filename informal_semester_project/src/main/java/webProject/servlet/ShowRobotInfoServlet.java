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
@WebServlet("/ShowRobotInfoServlet")
public class ShowRobotInfoServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RobotNewInfo showRobotInfo = new RobotNewInfo();
		showRobotInfo.setUsername(request.getParameter("username"));
		System.out.println(showRobotInfo.getUsername());
		
		ShowRobotInfoDAO dao = new ShowRobotInfoDAOImpl();
		String[][] robot_information = new String[1000][];
		try {
			//operate the code with database and obtain the return data
			robot_information = dao.queryByRobotShowInfo(showRobotInfo);
			System.out.println(robot_information[0][0]);
		} catch(Exception e) {
			e.printStackTrace();
		}
		//create the session
		HttpSession session = request.getSession();
		for(int i=0;i<1000;i++) {
			if(robot_information[i][0]!=null) {
				System.out.print(robot_information[i][1]);
				System.out.println();
				
			}
			
		}
		//set robot information into Array session
		session.setAttribute("Array", robot_information);
		response.sendRedirect("./SearchInfo.jsp");
	}

}
