package webProject.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

//import org.apache.tomcat.util.http.fileupload.RequestContext;
//import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
//import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
//import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import cn.hutool.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import webProject.dao.AddRobotInfoDAO;
import webProject.dao.impl.AddRobotInfoDAOImpl;
import webProject.vo.RobotNewInfo;
import webProject.dao.*;
import webProject.dao.impl.AddRobotInfoDAOImpl;
import webProject.servlet.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



/**
 * Servlet implementation class AddRobotInfo
 */
@WebServlet("/AddRobotInfo")
public class AddRobotInfoServlet extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRobotInfoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RobotNewInfo robotnewinfo = new RobotNewInfo();
		String UPLOAD_DIRECTORY = "C:\\Users\\35177\\Desktop\\upload";
		String UPLOAD_DATABASE_DIRECTORY = "\\upload";
		
		AddRobotInfoDAO dao = new AddRobotInfoDAOImpl();
		int flag = 0;
		try {
			//as the multipart type, we need a special process to gain the image information
			List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			StringBuffer robot_name_Buffer = new StringBuffer("null");
			StringBuffer username_Buffer = new StringBuffer("null");
			StringBuffer name_Buffer = new StringBuffer();
            for (FileItem item : multiparts) {
            	//whether the same as the label on the website
                if ("robot_picture".equals(item.getFieldName())) {
                    String name = new File(item.getName()).getName();
                    System.out.println(name);
                    String extensionName=".jpg";
                    // Get the extension name
    				if ((name != null) && (name.length() > 0)) {   
    		            int dot = name.lastIndexOf('.');   
    		            if ((dot >-1) && (dot < (name.length() - 1))) {   
    		            	extensionName= name.substring(dot);   
    		            }   
    		        }
    				// add the information into the specified variable
    				name_Buffer.append(robot_name_Buffer);
    				name_Buffer.append(username_Buffer);
    				name_Buffer.append(extensionName);
                    item.write(new File(UPLOAD_DIRECTORY + File.separator + robot_name_Buffer + username_Buffer + extensionName));
                    robotnewinfo.setPicture(name_Buffer);
                    continue;
                }
                
                //add robot name
                else if("robot_name".equals(item.getFieldName())) {
            		String robot_name = item.getString();
            		robot_name_Buffer.replace(0, robot_name_Buffer.length(), robot_name);
            		System.out.println(robot_name);
            		robotnewinfo.setRobot_name(robot_name);
            		continue;
            	}
                //add username
            	else if("username".equals(item.getFieldName())) {
            		String username = item.getString();
            		username_Buffer.replace(0, username_Buffer.length(), username);
            		System.out.println(username);
            		robotnewinfo.setUsername(username);
            		continue;
            	}
                
            }
            //after the database operation, obtain the value of flag
			flag = dao.queryByRobotNewInfo(robotnewinfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag==1) {
			HttpSession session = request.getSession();
			session.setAttribute("robot_name", robotnewinfo.getRobot_name());
			response.sendRedirect("./addOrDeleteSuccess.jsp");
		} else {
			response.sendRedirect("./addOrDeleteError.jsp");
		}		
	}

}



