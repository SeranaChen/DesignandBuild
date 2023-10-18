package webProject.dao.impl;

import webProject.dao.ShowRobotInfoDAO;
import webProject.vo.RobotNewInfo;
import webProject.db.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

/*
 * the class to select all the needed data about the given robot from the database
 */
public class ShowRobotInfoDAOImpl implements ShowRobotInfoDAO {

	@Override
	public String[][] queryByRobotShowInfo(RobotNewInfo robotshowinfo) throws Exception {
		String[][] information = new String[1000][4];//max = 1000
		String sql = "select * from robot where username=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		
		try {
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, robotshowinfo.getUsername());
			ResultSet rs = pstmt.executeQuery();
			int i = 0, j = 0;
			while(rs.next()) {//multiple data output method
				System.out.println("no data2");
				System.out.println(rs.getString("username"));
				information[i][0] = rs.getString("username");
				information[i][1] = rs.getString("robot_name");
				System.out.println(rs.getString("robot_name"));
				information[i][2] = rs.getString("robot_picture");
				information[i][3] = rs.getString("realTime_map");
				i++;
				j++;
				System.out.println("data");
			}
			if(j==0) {
				System.out.println("no data");
			}
			
			System.out.println("no enter");
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			dbc.close();
		}
		return information;
		
	}
}
