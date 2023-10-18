package webProject.dao.impl;

import webProject.dao.DeleteRobotInfoDAO;
import webProject.vo.RobotNewInfo;
import webProject.db.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * This class is used to delete the robot information including basic information and its image address in the database table of robot.
 * After the button is clicked on the website, then the one row information will be deleted.
 */
public class DeleteRobotInfoDAOImpl implements DeleteRobotInfoDAO {

	@Override
	public int queryByRobotDeleteInfo(RobotNewInfo robotdeleteinfo) throws Exception {
		int flag = 0;
		String sql = "delete from robot where robot_name=? AND username=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		
		try {
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, robotdeleteinfo.getRobot_name());
			pstmt.setString(2, robotdeleteinfo.getUsername());
			pstmt.executeUpdate();
			pstmt.close();
			flag = 1;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			dbc.close();
		}
		System.out.println(flag);
		return flag;
	}

}
