package webProject.dao.impl;

import webProject.dao.AddRobotInfoDAO;

import java.io.File;
import webProject.vo.RobotNewInfo;
import webProject.db.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * This class is used to add the robot information including basic information and its image address into the database table of robot
 */
public class AddRobotInfoDAOImpl implements AddRobotInfoDAO {

	@Override
	public int queryByRobotNewInfo(RobotNewInfo robotnewinfo) throws Exception {
		int flag = 0;
		String sql2 = "select userid from userinfo where username=?";
		String sql = "insert into robot(robot_name, username, userinfoid, robot_picture, realTime_map)values(?,?,?,?,?)";
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt = null;
		DBConnect dbc2 = null;
		DBConnect dbc = null;
		
		try {
			dbc2 = new DBConnect();
			dbc = new DBConnect();
			pstmt2 = dbc2.getConnection().prepareStatement(sql2);
			pstmt2.setString(1, robotnewinfo.getUsername());
			ResultSet rs = pstmt2.executeQuery();//rs是匹配到的username的名字
			int user_id;
			if(rs.next()) {
				user_id = rs.getInt("userid");
				pstmt = dbc.getConnection().prepareStatement(sql);
				pstmt.setString(1, robotnewinfo.getRobot_name());
				pstmt.setString(2, robotnewinfo.getUsername());
				pstmt.setInt(3, user_id);
				pstmt.setString(4, robotnewinfo.getPicture().toString());
				pstmt.setString(5, robotnewinfo.getUsername()+"_"+robotnewinfo.getRobot_name()+"/data");
				pstmt.executeUpdate();
				pstmt.close();
				flag = 1;
			}
			File file = new File("C:\\Users\\35177\\Desktop\\upload", robotnewinfo.getUsername()+"_"+robotnewinfo.getRobot_name()+"\\data");
			file.mkdirs();
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			dbc.close();
		}
		
		return flag;
	}

}
