package webProject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import webProject.dao.impl.AddRobotInfoDAOImpl;
import webProject.dao.impl.DeleteRobotInfoDAOImpl;
import webProject.vo.RobotNewInfo;
import webProject.dao.*;
import webProject.servlet.*;

/**
 * Servlet implementation class DeletRobotInfoServlet
 */
@WebServlet("/DeletRobotInfoServlet")
public class DeleteRobotInfoServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RobotNewInfo robotdeleteinfo = new RobotNewInfo();
		robotdeleteinfo.setRobot_name(request.getParameter("robot_name"));
		robotdeleteinfo.setUsername(request.getParameter("username"));
		
		DeleteRobotInfoDAO dao = new DeleteRobotInfoDAOImpl();
		int flag = 0;
		try {
			flag = dao.queryByRobotDeleteInfo(robotdeleteinfo);
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(flag==1) {
			HttpSession session = request.getSession();
			session.setAttribute("robot_name", robotdeleteinfo.getRobot_name());
			response.sendRedirect("./addOrDeleteSuccess.jsp");
		} else {
			response.sendRedirect("./addOrDeleteError.jsp");
		}
	}

}
