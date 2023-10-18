package webProject.dao.impl;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import webProject.dao.AddMazeInfoDAO;
import webProject.db.DBConnect;
import webProject.vo.MazeInfo;
import webProject.vo.RobotNewInfo;

/*
 * This class is used to add the path, time and final image of the treasure into the database table of showmaze
 */
public class AddMazeInfoDAOImpl implements AddMazeInfoDAO{
	@Override
	public int queryByMazeNewInfo(MazeInfo mazenewinfo) throws Exception{
		int flag = 0;
		String sql = "insert into showmaze(robot_name, username, path, time_interval, treasure_picture)values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		
		try {
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, mazenewinfo.getRobot_name());
			pstmt.setString(2, mazenewinfo.getUsername());
			pstmt.setString(3, mazenewinfo.getPath().toString());
			StringBuffer time_interval = mazenewinfo.getTime_interval();
			time_interval.insert(time_interval.length()-3, '.');
			time_interval.append(" seconds");
			pstmt.setString(4, time_interval.toString());
			pstmt.setString(5, mazenewinfo.getTreasure_picture());
			pstmt.executeUpdate();
			pstmt.close();
			flag = 1;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			dbc.close();
		}
		
		return flag;
	}

}
