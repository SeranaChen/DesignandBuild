package webProject.dao.impl;

import webProject.dao.ShowMazeInfoDAO;
import webProject.vo.MazeInfo;
import webProject.vo.RobotNewInfo;
import webProject.db.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;


/*
 * This class is used to select the maze information needed including username, robot name, path, exploring time and treasure image address
 * and put all these information into variable "information"
 */
public class ShowMazeInfoDAOImpl implements ShowMazeInfoDAO{
	public String[][] queryByMazeShowInfo(String username) throws Exception {
		String[][] information = new String[1000][5];//max=1000 types information
		String sql = "select * from showmaze where username=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		
		try {
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			int i = 0, j = 0;
			while(rs.next()) {
				information[i][0] = rs.getString("username");
				information[i][1] = rs.getString("robot_name");
				information[i][2] = rs.getString("path");
				information[i][3] = rs.getString("time_interval");
				System.out.println("这是information[i][3]"+information[i][3]);
				information[i][4] = rs.getString("treasure_picture");
				i++;
				j++;
			}
			if(j==0) {
				System.out.println("no data");
			}
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
